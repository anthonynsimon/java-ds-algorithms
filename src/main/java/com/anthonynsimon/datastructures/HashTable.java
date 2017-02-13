package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.HashTableNode;

import java.util.ArrayList;

public class HashTable<K, V> {

    protected final double maxLoadFactor = 0.75d;
    protected final int capacityGrowth = 2;
    protected final int initialCapacity;
    protected int size;
    protected int currentCapacity;
    protected ArrayList<HashTableNode<K, V>> buckets;

    public HashTable() {
        this(16);
    }

    // Initialize with desired initial number of buckets
    public HashTable(int initialCapacity) {
        this.initialCapacity = nearestPowerOfTwo(initialCapacity);
        resetHashTable();
    }

    protected static int nearestPowerOfTwo(int value) {
        int pow = 0;
        while (value >> 1 > 0) {
            value >>= 1;
            pow++;
        }
        return 1 << pow;
    }

    protected void resetHashTable() {
        this.size = 0;
        this.currentCapacity = this.initialCapacity;
        this.buckets = new ArrayList<>(this.initialCapacity);
        // Initialize all buckets to null
        for (int i = 0; i < this.currentCapacity; i++) {
            this.buckets.add(null);
        }
    }

    // Returns the value stored under the given key, if found
    public V get(K key) {
        HashTableNode<K, V> result = getNodeWithKey(key);
        return result != null ? result.getValue() : null;
    }

    protected void ensureCapacity(int intendedCapacity) {
        double loadFactor = (double) intendedCapacity / (double) currentCapacity;
        // If we're within the load limit, return early, it's all good.
        if (loadFactor < maxLoadFactor) {
            return;
        }

        // Otherwise, ensure we will be within limits
        int newCapacity = currentCapacity * capacityGrowth;
        buckets.ensureCapacity(newCapacity);

        // Initialize buckets
        for (int i = this.currentCapacity; i < newCapacity; i++) {
            this.buckets.add(null);
        }

        currentCapacity = newCapacity;
    }

    // Inserts a Key, Value pair into the table
    public void put(K key, V value) throws IllegalArgumentException {
        // No support for null as key
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        ensureCapacity(size() + 1);

        // Hash the key and get the bucket index
        int bucketIndex = getBucketIndex(key);

        HashTableNode<K, V> newNode = new HashTableNode<>(key, value);
        HashTableNode<K, V> current = buckets.get(bucketIndex);

        // If bucket is empty, set as first node and we're done
        if (current == null) {
            buckets.set(bucketIndex, newNode);
            this.size++;
            return;
        }

        // Traverse the list within the bucket until match or end found
        while (current != null) {
            // When a key match is found, replace the value it stores and break
            if (current.getKey().equals(key)) {
                current.setValue(value);
                break;
            }
            // When the last node of the list is reached, append new node here and break
            else if (current.getNext() == null) {
                current.setNext(newNode);
                this.size++;
                break;
            }
            current = current.getNext();
        }
    }

    // Removes the Key, Value pair based on the provided Key
    public void remove(K key) {
        if (size() == 0 || key == null) {
            return;
        }

        int bucketIndex = getBucketIndex(key);

        HashTableNode<K, V> current = buckets.get(bucketIndex);
        HashTableNode<K, V> previous = null;

        // Traverse the list inside the bucket until match is found or end of list reached
        while (current != null) {
            if (current.getKey().equals(key)) {
                // Handle case when node is first in bucket
                if (previous == null) {
                    // If there is a next node, set next node as first in bucket
                    if (current.getNext() != null) {
                        buckets.set(bucketIndex, current.getNext());
                    }
                    // If there is no other node in list, simply set bucket to null
                    else {
                        buckets.set(bucketIndex, null);
                    }
                }
                // Handle case when node is not in first position
                else {
                    // If it's the last node in the list, set previous's next as null
                    if (current.getNext() == null) {
                        previous.setNext(null);
                    }
                    // If it's anywhere else in the list, connect previous and next
                    else {
                        previous.setNext(current.getNext());
                    }
                }

                // We're done removing the node, diminish size and return
                this.size--;
                return;
            }

            previous = current;
            current = current.getNext();
        }
    }

    // Returns array of all values in table
    // Traverse each bucket and add value to results
    public V[] values() {
        // It is safe to suppress unchecked exception because the array we're creating
        // is of the same type as the one passed.
        @SuppressWarnings("unchecked")
        V[] values = (V[]) new Object[size()];

        if (size() > 0) {
            int index = 0;
            for (int i = 0; i < buckets.size(); i++) {
                HashTableNode<K, V> current = buckets.get(i);

                while (current != null) {
                    values[index] = current.getValue();
                    index++;
                    current = current.getNext();
                }
            }
        }

        return values;
    }

    // Returns array of all keys in table
    // Traverse each bucket and add key to results
    public K[] keys() {
        // It is safe to suppress unchecked exception because the array we're creating
        // is of the same type as the one passed.
        @SuppressWarnings("unchecked")
        K[] keys = (K[]) new Object[size()];

        if (size() > 0) {
            int index = 0;
            for (int i = 0; i < buckets.size(); i++) {
                HashTableNode<K, V> current = buckets.get(i);

                while (current != null) {
                    keys[index] = current.getKey();
                    index++;
                    current = current.getNext();
                }
            }
        }

        return keys;
    }

    // Returns if some node in table contains provided key
    public boolean containsKey(K key) {
        HashTableNode<K, V> result = getNodeWithKey(key);
        return result != null;
    }

    // Returns if some node in table contains provided value
    public boolean containsValue(V value) {
        HashTableNode<K, V> result = getNodeWithValue(value);
        return result != null;
    }

    // Returns the total number of Key, Value pairs in the table
    public int size() {
        return this.size;
    }

    // Empty out the table
    public void clear() {
        resetHashTable();
    }

    // Hash the key and find the appropriate bucket index
    protected int getBucketIndex(K key) {
        // Rehash to protect against poor hash functions
        int rehashed = hash(key.hashCode());
        // Capacity is always a power of two, use fast modulo operation
        return rehashed & (this.currentCapacity - 1);
    }

    protected int hash(int h) {
        h ^= (h >> 20) ^ (h >> 12);
        return h ^ (h >> 7) ^ (h >> 4);
    }

    // Returns the node with the matching key, if any
    // Searches only inside the appropriate bucket
    private HashTableNode<K, V> getNodeWithKey(K key) {
        if (size() == 0 || key == null) {
            return null;
        }

        int bucketIndex = getBucketIndex(key);
        HashTableNode<K, V> current = buckets.get(bucketIndex);

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    // Returns the node with the matching value, if any
    // Must search the entire table since the value doesn't give us
    // a clue about a possible bucket
    private HashTableNode<K, V> getNodeWithValue(V value) {
        if (size() == 0) {
            return null;
        }

        for (int i = 0; i < buckets.size(); i++) {
            HashTableNode<K, V> current = buckets.get(i);

            while (current != null) {
                if (current.getValue().equals(value)) {
                    return current;
                }
                current = current.getNext();
            }
        }

        return null;
    }
}