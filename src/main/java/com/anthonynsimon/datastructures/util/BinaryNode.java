package com.anthonynsimon.datastructures.util;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
    private BinaryNode<T> parent;

    public BinaryNode(T data, BinaryNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryNode<T> newNode) {
        this.left = newNode;
    }

    public BinaryNode<T> getRight() {
        return this.right;
    }

    public void setRight(BinaryNode<T> newNode) {
        this.right = newNode;
    }

    public BinaryNode<T> getParent() {
        return this.parent;
    }

    public void setParent(BinaryNode<T> newParent) {
        this.parent = newParent;
    }

    public boolean hasAnyChildren() {
        return this.left != null || this.right != null;
    }

    public boolean hasBothChildren() {
        return this.left != null && this.right != null;
    }

    public boolean hasLeftChild() {
        return this.left != null;
    }

    public boolean hasRightChild() {
        return this.right != null;
    }

    public boolean isLeftChild() {
        if (this.parent != null) {
            return this.parent.getLeft() == this;
        }
        return false;
    }

    public boolean isRightChild() {
        if (this.parent != null) {
            return this.parent.getRight() == this;
        }
        return false;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public int getMaxHeight() {
        if (!hasAnyChildren()) {
            return 0;
        } else {
            int leftMaxHeight = 0;
            int rightMaxHeight = 0;

            if (hasLeftChild()) {
                leftMaxHeight = this.left.getMaxHeight();
            }

            if (hasRightChild()) {
                rightMaxHeight = this.right.getMaxHeight();
            }

            return 1 + (leftMaxHeight > rightMaxHeight ? leftMaxHeight : rightMaxHeight);
        }
    }
}