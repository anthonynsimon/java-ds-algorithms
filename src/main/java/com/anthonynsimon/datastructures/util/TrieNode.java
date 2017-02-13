package com.anthonynsimon.datastructures.util;

public class TrieNode<T> {

    private TrieNode<T>[] children;
    private T value;

    public TrieNode(int size) {
        // It is safe to suppress warning because it is of the same time as passed.
        @SuppressWarnings("unchecked")
        TrieNode<T>[] children = (TrieNode<T>[]) new TrieNode[size];
        this.children = children;
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i] != null) {
                return false;
            }
        }
        return this.value == null;
    }

    public TrieNode<T>[] getChildren() {
        if (children == null) {
            // It is safe to suppress warning because it is of the same time as passed.
            @SuppressWarnings("unchecked")
            TrieNode<T>[] result = (TrieNode<T>[]) new TrieNode[]{};
            return result;
        }
        return children;
    }

    public TrieNode<T> getChild(int index) {
        if (index < 0 || index >= children.length) {
            return null;
        }
        return children[index];
    }

    public void setChild(int index, TrieNode<T> child) {
        if (index < 0 || index >= children.length) {
            return;
        }
        children[index] = child;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}