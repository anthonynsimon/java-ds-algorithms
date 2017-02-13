package com.anthonynsimon.datastructures.util;

public class HashTableNode<K, V> {

    private K key;
    private V value;
    private HashTableNode<K, V> next;

    public HashTableNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashTableNode<K, V> getNext() {
        return this.next;
    }

    public void setNext(HashTableNode<K, V> node) {
        this.next = node;
    }
}