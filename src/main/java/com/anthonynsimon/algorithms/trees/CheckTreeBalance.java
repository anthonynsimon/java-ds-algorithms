package com.anthonynsimon.algorithms.trees;

import com.anthonynsimon.datastructures.BinarySearchTree;
import com.anthonynsimon.datastructures.util.BinaryNode;

public final class CheckTreeBalance<T extends Comparable<T>> {

    // Solution is O(N) becase the height of the subtree is calculated at the same time
    // that the balance is checked, so the tree is traversed only once.
    public boolean isTreeBalanced(BinarySearchTree<T> tree) {
        // Recursively check the balance per level
        int balance = checkBalance(tree.getRootNode());


        // If return is special value, that means that there was an unbalanced section
        // and special value was propagated up the recursion
        if (balance == Integer.MIN_VALUE) {
            return false;
        }

        // Otherwise tree is balanced
        return true;
    }

    // Recursively traverse the tree checking difference in heights
    // If unbalanced section is found, propagate special return to the top
    // In this case Integer.MIN_VALUE is the special value
    private int checkBalance(BinaryNode<T> node) {
        // Base case
        if (node == null) {
            return -1;
        }

        int balanceLeft = checkBalance(node.getLeft());
        int balanceRight = checkBalance(node.getRight());

        // Continue propagating if special value was returned
        if (balanceLeft == Integer.MIN_VALUE || balanceRight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int heightDiff = Math.abs((1 + balanceLeft) - (1 + balanceRight));

        // Start the propagation if unbalanced found
        if (heightDiff > 1) {
            return Integer.MIN_VALUE;
        }

        // If all is good, return balance
        return heightDiff;
    }
}