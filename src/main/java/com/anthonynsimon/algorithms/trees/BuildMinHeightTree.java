package com.anthonynsimon.algorithms.trees;

import com.anthonynsimon.datastructures.BinarySearchTree;

import java.util.Arrays;

public final class BuildMinHeightTree<T extends Comparable<T>> {

    // Returns a minimum height tree
    public BinarySearchTree<T> build(T[] data) {
        BinarySearchTree<T> tree = new BinarySearchTree<>();

        // Only add nodes to the tree if data array is not empty
        if (data.length > 0) {
            Arrays.sort(data);

            buildWorker(data, tree, 0, data.length - 1);
        }

        return tree;
    }

    // Build the minimum height tree using a divide and conquer strategy
    // Recursively partition data array and insert middle element to tree
    private void buildWorker(T[] data, BinarySearchTree<T> tree, int min, int max) {
        // Base case, nothing else to partition/add
        if (min > max) {
            return;
        }

        // Calculate partition middle index
        int middle = (min + max) / 2;
        // Insert data at middle index
        tree.insert(data[middle]);

        // Recursively partition the data...
        buildWorker(data, tree, min, middle - 1);
        buildWorker(data, tree, middle + 1, max);
    }
}