package com.anthonynsimon.algorithms.trees;

import com.anthonynsimon.datastructures.Trie;
import com.anthonynsimon.datastructures.util.TrieNode;

import java.util.ArrayList;

public final class WordAutocompletion extends Trie<String> {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public WordAutocompletion() {
        super();
    }

    public String[] autocomplete(String prefix) {
        ArrayList<String> results = new ArrayList<>();

        TrieNode<String> lastChar = getNodeAtLast(prefix);
        depthFirstSearch(prefix, lastChar, results);

        return results.toArray(new String[]{});
    }

    private void depthFirstSearch(String prefix, TrieNode<String> node, ArrayList<String> results) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < node.getChildren().length; i++) {
            TrieNode<String> child = node.getChild(i);
            if (child != null) {
                String str = prefix + ALPHABET.charAt(i);
                if (child.getValue() != null) {
                    results.add(str);
                }
                depthFirstSearch(str, child, results);
            }
        }
    }
}