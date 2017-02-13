package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.BinaryNode;

public class BinarySearchTree<T extends Comparable<T>> {

    protected BinaryNode<T> root;
    protected int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    // Helper function for some algorithms that operate on the tree
    public BinaryNode<T> getRootNode() {
        return this.root;
    }

    // Inserts data while keeping the BST property
    public void insert(T data) {
        insertWorker(data, this.root);
    }

    // Returns given data if node with matching data was found in tree
    public T find(T data) {
        BinaryNode<T> result = findWorker(data, this.root);
        return result != null ? result.getData() : null;
    }

    // Removes node with matching data if found
    public void remove(T data) {
        removeWorker(data, this.root);
    }

    // Returns the number of nodes in tree
    public int size() {
        return this.size;
    }

    // Deletes all nodes in tree
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    // Returns true if tree has no nodes
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getHeight() {
        if (isEmpty()) {
            return 0;
        }

        return this.root.getMaxHeight();
    }

    // Returns the contents of tree as string
    // In-order traversal with default glue string between elements
    public String toString() {
        return toString(", ");
    }

    // Returns the contents of tree as string with separator (glue) string
    public String toString(String separator) {
        if (isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        stringBuilder = toStringWorker(this.root, separator, stringBuilder);
        stringBuilder.setLength(stringBuilder.length() - separator.length());
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    // Recursive function for finding the right spot and inserting a new node
    private void insertWorker(T data, BinaryNode<T> node) {
        // If node is null, we are at root, create new root
        if (node == null) {
            this.root = new BinaryNode<T>(data, null);
            this.size++;
        }
        // If new data is larger than the current node's data, then it belongs to the right side
        else if (node.getData().compareTo(data) < 0) {
            // If node already has a right child, call insert function on it
            if (node.hasRightChild()) {
                insertWorker(data, node.getRight());
            }
            // If node has no right child, then setup new node with new data as right child
            else {
                node.setRight(new BinaryNode<T>(data, node));
                this.size++;
            }
        }
        // If new data is smaller than the current node's data, then it belongs to the left side
        // Repeat same steps as if it was the right side but inversed
        else {
            if (node.hasLeftChild()) {
                insertWorker(data, node.getLeft());
            } else {
                node.setLeft(new BinaryNode<T>(data, node));
                this.size++;
            }
        }
    }

    // Recursively search for node with given data using Binary Search
    private BinaryNode<T> findWorker(T data, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.getData() == data) {
            return node;
        } else if (node.getData().compareTo(data) < 0) {
            return findWorker(data, node.getRight());
        } else {
            return findWorker(data, node.getLeft());
        }
    }

    // Recursively search for node to remove and decide on how to remove it based on specific case
    private void removeWorker(T data, BinaryNode<T> root) {
        // Do binary search recursively until node to delete is found
        BinaryNode<T> node = findWorker(data, root);

        // Return if no matching node was found
        if (node == null) {
            return;
        }

        // If node has any children, then decide on what specific case are we dealing with
        if (node.hasAnyChildren()) {
            // If node has both children, look for max child on the left side and replace
            // node to delete with it
            if (node.hasBothChildren()) {
                BinaryNode<T> maxChildLeft = findMaxChild(node.getLeft());
                removeWorker(maxChildLeft.getData(), node.getLeft());
                node.setData(maxChildLeft.getData());
            }
            // If node has only one child...
            else {
                // If child is on the left, reconnect parent and child to eliminate current node
                if (node.hasLeftChild()) {
                    if (node.isRoot()) {
                        this.root = node.getLeft();
                    } else if (node.isLeftChild()) {
                        node.getParent().setLeft(node.getLeft());
                    } else {
                        node.getParent().setRight(node.getLeft());
                    }
                }
                // If child is on the right, reconnect nodes same as above but inversed
                else {
                    if (node.isRoot()) {
                        this.root = node.getRight();
                    } else if (node.isLeftChild()) {
                        node.getParent().setLeft(node.getRight());
                    } else {
                        node.getParent().setRight(node.getRight());
                    }
                }
            }
        }
        // If node has no children simply set to null accordingly
        else {
            if (node.isRoot()) {
                this.root = null;
            } else if (node.isLeftChild()) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        }

        this.size--;
    }

    // Find child with max value of provided node (right-most)
    private BinaryNode<T> findMaxChild(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.hasRightChild()) {
            return findMaxChild(node.getRight());
        }

        return node;
    }

    // Traverse in-order and build string out of tree data
    private StringBuilder toStringWorker(BinaryNode<T> node, String separator, StringBuilder stringBuilder) {
        if (node == null) {
            return stringBuilder;
        }

        if (node.getLeft() != null) {
            stringBuilder = toStringWorker(node.getLeft(), separator, stringBuilder);
        }

        stringBuilder.append(node.getData());
        stringBuilder.append(separator);

        if (node.getRight() != null) {
            stringBuilder = toStringWorker(node.getRight(), separator, stringBuilder);
        }

        return stringBuilder;
    }
}