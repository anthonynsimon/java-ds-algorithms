package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.SinglyNode;

public class LinkedList<E> {

    protected int size;
    protected SinglyNode<E> head;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public LinkedList(E item) {
        append(item);
    }

    public void build(E[] items) {
        clear();
        for (int i = 0; i < items.length; i++) {
            append(items[i]);
        }
    }

    public int size() {
        return this.size;
    }

    public E peek() {
        if (size() == 0) {
            return null;
        }

        return this.head.getData();
    }

    public void append(E item) {
        SinglyNode<E> newNode = new SinglyNode<E>(item);
        // If list is empty, setup initial nodes
        if (size() == 0) {
            this.head = newNode;
        }
        // If the list is not empty, add as last element
        else {
            SinglyNode<E> lastNode = getNodeAtIndex(size() - 1);
            lastNode.setNext(newNode);
        }
        this.size++;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        SinglyNode<E> selectedNode = getNodeAtIndex(index);
        return selectedNode.getData();
    }

    public void set(int index, E item) throws IndexOutOfBoundsException {
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        SinglyNode<E> selectedNode = getNodeAtIndex(index);
        selectedNode.setData(item);
    }

    public void insert(int index, E item) throws IndexOutOfBoundsException {
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        SinglyNode<E> newNode = new SinglyNode<E>(item);

        // If it's first node, set as new head
        if (index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        // If not, find previous node to selected index and reconnect after it
        else {
            SinglyNode<E> previousNode = getNodeAtIndex(index - 1);
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
        }

        this.size++;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (isOutOfRange(index)) {
            throw new IndexOutOfBoundsException();
        }

        // If removing head node, simply set it's next one
        if (index == 0) {
            this.head = this.head.getNext();
        } else {
            // Find previous node
            SinglyNode<E> previousNode = getNodeAtIndex(index - 1);
            // If trying to remove last set it's previous node next connection to null
            if (index == size() - 1) {
                previousNode.setNext(null);
            }
            // If not, interconnect previous and next
            else {
                SinglyNode<E> selectedNode = previousNode.getNext();
                previousNode.setNext(selectedNode.getNext());
            }
        }

        this.size--;
    }

    public boolean contains(E item) {
        SinglyNode<E> current = this.head;
        while (current != null) {
            if (current.getData() == item) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public E pop() {
        if (size() == 0) {
            return null;
        }

        // Temporary variable to hold the data to be popped
        E temp;

        // If only one item is left, pop head
        if (size() == 1) {
            temp = this.head.getData();
            this.head = null;
        }
        // If not, then save the last node's data
        // and set the previous node's next connection to null
        else {
            SinglyNode<E> previous = getNodeAtIndex(size() - 2);
            SinglyNode<E> last = previous.getNext();
            temp = last.getData();
            previous.setNext(null);
        }

        this.size--;

        return temp;
    }

    public E getLast() {
        SinglyNode<E> selectedNode = getNodeAtIndex(size() - 1);
        return selectedNode != null ? selectedNode.getData() : null;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public E[] toArray() {
        // It is safe to suppress unchecked exception because the array we're creating
        // is of the same type as the one passed.
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[size()];

        SinglyNode<E> current = this.head;
        for (int i = 0; i < size(); i++) {
            result[i] = current.getData();
            current = current.getNext();
        }

        return result;
    }

    public String toString() {
        return toString(" ");
    }

    public String toString(String glue) {
        StringBuilder sb = new StringBuilder();

        SinglyNode<E> current = this.head;
        for (int i = 0; i < size(); i++) {
            sb.append(current.getData());
            if (i != size() - 1) {
                sb.append(glue);
            }
            current = current.getNext();
        }

        return sb.toString();
    }

    private boolean isOutOfRange(int index) {
        return index < 0 || size() <= index;
    }

    private SinglyNode<E> getNodeAtIndex(int index) {
        int i = 0;
        SinglyNode<E> current = this.head;
        while (current != null) {
            if (i == index) {
                return current;
            }
            current = current.getNext();
            i++;
        }

        return null;
    }
}