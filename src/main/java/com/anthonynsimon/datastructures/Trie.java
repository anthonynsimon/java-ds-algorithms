package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.TrieNode;

public class Trie<T> {

    protected static final int CHAR_OFFSET = 97; // ASCII offset for lowercase chars
    protected static final int ALPHABET_COUNT = 26;

    protected TrieNode<T> root;

    public Trie() {
        this.root = new TrieNode<>(ALPHABET_COUNT);
    }

    public void put(String word, T value) throws IllegalArgumentException {
        if (word == null) {
            throw new IllegalArgumentException();
        }
        // For simplicity, treat everything as lowercase
        word = word.toLowerCase();

        // Starting from the root, find the right slot for each
        // character in the word or create a new node if not initialized.
        // Once last character is reached, set last slot's value.
        TrieNode<T> current = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = charIndexAt(word, i);
            TrieNode<T> child = current.getChild(index);
            if (child == null) {
                child = new TrieNode<>(ALPHABET_COUNT);
                current.setChild(index, child);
            }
            current = child;
        }
        current.setValue(value);
    }

    public void remove(String word) {
        if (word == null || word.length() <= 0) {
            return;
        }
        // Start the recursive call to remove the word if present
        removeWorker(word, this.root, 0);
    }

    public T get(String word) {
        TrieNode<T> result = getNodeAtLast(word);
        return result != null ? result.getValue() : null;
    }

    public boolean isEmpty() {
        return this.root.isEmpty();
    }

    public void clear() {
        this.root = new TrieNode<>(ALPHABET_COUNT);
    }

    // Map the ASCII char index to the range of the 26 english letters
    protected int charIndexAt(String word, int index) {
        return (int) word.charAt(index) - CHAR_OFFSET;
    }

    protected void removeWorker(String word, TrieNode<T> node, int i) {
        // Base case, we reached the end of the word
        if (i >= word.length()) {
            return;
        }

        // Map the ASCII char index to 0-25 range
        int charIndex = charIndexAt(word, i);

        // If no node for current char, then word has not been placed in trie
        if (node.getChild(charIndex) == null) {
            return;
        }

        // If node exists then start recursive call on it for the next char
        removeWorker(word, node.getChild(charIndex), i + 1);

        // Once we return from the recursive call, if we are at the end of the
        // word then start the removal by setting the value to null
        if (i == word.length() - 1) {
            node.getChild(charIndex).setValue(null);
        }

        // if the current node is empty, then set it to null and propagate change up
        if (node.getChild(charIndex).isEmpty()) {
            node.setChild(charIndex, null);
        }
    }

    protected TrieNode<T> getNodeAtLast(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }

        // For simplicity only deal with lowercase chars
        prefix = prefix.toLowerCase();

        // Traverse tree nodes by char index until we reach
        // the last char for the prefix or reach into null node
        TrieNode<T> current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = charIndexAt(prefix, i);
            TrieNode<T> child = current.getChild(index);
            if (child == null) {
                return null;
            }
            current = child;
        }

        // Last node reached is the last char in the prefix
        return current;
    }
}