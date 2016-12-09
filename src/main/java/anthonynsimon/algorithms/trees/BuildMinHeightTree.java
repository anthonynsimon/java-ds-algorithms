package anthonynsimon.algorithms.trees;

import anthonynsimon.datastructures.BinarySearchTree;

import java.util.Arrays;

public class BuildMinHeightTree {

    // Returns a minimum height tree
    public BinarySearchTree<Integer> build(int[] data) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Only add nodes to the tree if data array is not empty
        if (data.length > 0) {
            Arrays.sort(data);

            buildWorker(data, tree, 0, data.length - 1);
        }

        return tree;
    }

    // Build the minimum height tree using a divide and conquer strategy
    // Recursively partition data array and insert middle element to tree
    private void buildWorker(int[] data, BinarySearchTree<Integer> tree, int min, int max) {
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