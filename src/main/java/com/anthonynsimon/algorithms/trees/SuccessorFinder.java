package com.anthonynsimon.algorithms.trees;

import com.anthonynsimon.datastructures.BinarySearchTree;
import com.anthonynsimon.datastructures.util.BinaryNode;

public final class SuccessorFinder<T extends Comparable<T>> {

    public T findSuccessorOf(T value, BinarySearchTree<T> tree) {
        BinaryNode<T> node = findNodeWithKey(value, tree);
        BinaryNode<T> result = null;

        // Case when requested node doesn't exist in tree
        if (node == null) {
            return null;
        }

        // If the node has a right child, get the leftmost child from that subtree
        if (node.hasRightChild()) {
            result = getLeftmostNode(node.getRight());
        }
        // If the node has no right child, then the successor is the first of the ancestors
        // that is not a right child
        else {
            // As long as the node is a right child (or root) keep moving up
            while (node.isRightChild()) {
                node = node.getParent();
            }
            // Here we have either the root or the left child of our target node
            // requesting the parent will return 'null' or the target node in the corresponding case
            // The reason why we want to 'nullify' the root as a result, is because if we got there it means that we
            // started on the last node of the tree, and this node has no successor.
            //
            // For example: in the tree below 'e' has no successor, and the algorithm kept going up until the root.
      /*
      *
      *        b
      *      /   \
      *     a     c
      *            \
      *             d
      *              \
      *               e
      *
      */
            result = node.getParent();
        }

        return result != null ? result.getData() : null;
    }

    // Binary Search for a node in the tree (if exists)
    private BinaryNode<T> findNodeWithKey(T key, BinarySearchTree<T> tree) {
        BinaryNode<T> root = tree.getRootNode();

        if (root == null) {
            return null;
        }

        BinaryNode<T> current = root;
        while (current != null) {
            int comparison = key.compareTo(current.getData());
            if (comparison == 0) {
                return current;
            } else if (comparison > 0) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        return null;
    }

    private BinaryNode<T> getLeftmostNode(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        while (node.hasLeftChild()) {
            node = node.getLeft();
        }

        return node;
    }
}