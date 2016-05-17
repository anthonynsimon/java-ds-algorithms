package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.HashTableNode;
import anthonynsimon.datastructures.LinkedList;

public class HashTable<K, V> {
  
  protected int size;
  protected int CAPACITY;
  protected HashTableNode<K, V>[] buckets;
  
  public HashTable() {
    // Default constructor
    this(1024);
  }
  
  // Initialize with desired capacity
  public HashTable(int capacity) {
    this.size = 0;
    this.CAPACITY = capacity;
    this.buckets = new HashTableNode[CAPACITY];
  }
  
  // Returns the value stored under the given key, if found
  public V get(K key) {
    HashTableNode<K, V> result = getNodeWithKey(key);
    return result != null ? result.getValue() : null;
  }
  
  // Inserts a Key, Value pair into the table
  public void put(K key, V value) {
    // No support for null as key
    if (key == null) {
      return;
    }
    
    // Hash the key and get the bucket index
    int bucketIndex = getBucketIndex(key);
    
    HashTableNode<K, V> newNode = new HashTableNode<>(key, value);
    HashTableNode<K, V> current = buckets[bucketIndex];

    // If the first node in the bucket is null, then place new node as first
    if (current == null) {
      buckets[bucketIndex] = newNode;
      this.size++;
    }
    else {
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
  }
  
  // Removes the Key, Value pair based on the provided Key
  public void remove(K key) {
    if (size() == 0 || key == null) {
      return;
    }
    
    int bucketIndex = getBucketIndex(key);
    
    HashTableNode<K, V> current = buckets[bucketIndex];
    HashTableNode<K, V> previous = null;
    
    // Traverse the list inside the bucket until match is found or end of list reached
    while (current != null) {
      if (current.getKey().equals(key)) {
        // Handle case when node is first in bucket
        if (previous == null) {
          // If there is a next node, set next node as first in bucket
          if (current.getNext() != null) {
            buckets[bucketIndex] = current.getNext();
          }
          // If there is no other node in list, simply set bucket to null
          else {
            buckets[bucketIndex] = null;
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
    V[] values = (V[]) new Object[size()];
    
    if (size() > 0) {
      int index = 0;
      for (int i = 0; i < buckets.length; i++) {
        HashTableNode<K, V> current = buckets[i];
        
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
    K[] keys = (K[]) new Object[size()];
    
    if (size() > 0) {
      int index = 0;
      for (int i = 0; i < buckets.length; i++) {
        HashTableNode<K, V> current = buckets[i];
        
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
    this.size = 0;
    this.buckets = new HashTableNode[CAPACITY];
  }
  
  // Hash the key and find the appropiate bucket index
  private int getBucketIndex(K key) {
    return Math.abs(key.hashCode() % this.CAPACITY);
  }
  
  // Returns the node with the matching key, if any
  // Searches only inside the appropiate bucket
  private HashTableNode<K, V> getNodeWithKey(K key) {
    if (size() == 0 || key == null) {
      return null;
    }
    
    int bucketIndex = getBucketIndex(key);
    HashTableNode<K, V> current = buckets[bucketIndex];
    
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
    
    for (int i = 0; i < buckets.length; i++) {
      HashTableNode<K, V> current = buckets[i];
      
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