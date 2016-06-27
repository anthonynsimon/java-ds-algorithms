package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.HeapNode;

public class PriorityQueue<T extends Comparable<T>> {

  protected HeapNode[] heap;
  protected int size;
  protected int initialCapacity;
  protected int capacity;
  protected int GROWTH_FACTOR = 2;
  protected int offset = 1;

  public PriorityQueue() {
    this(256);
  }

  public PriorityQueue(int[] priorities, T[] data) {
    this(data.length);
    for (int i = 0; i < data.length; i++) {
      insert(priorities[i], data[i]);
    }
  }

  public PriorityQueue(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    capacity = initialCapacity;
    heap = new HeapNode[capacity];
    size = 0;
  }

  public void insert(int priority, T item) {
    ensureCapacity();
    heap[getNextAvailableIndex()] = new HeapNode<T>(priority, item);
    size++;
    percolateUp(getIndexAtLast());
  }

  public T peekMin() {
    if (size() <= 0) {
      return null;
    }
    return (T)heap[getIndexAt(0)].data;
  }

  public T removeMin() {
    if (size() <= 0) {
      return null;
    }

    HeapNode min = heap[getIndexAt(0)];
    if (size() == 1) {
      heap[getIndexAt(0)] = null;
      size--;
    }
    else {
      HeapNode last = heap[getIndexAtLast()];
      heap[getIndexAtLast()] = null;
      size--;
      heap[getIndexAt(0)] = last;
      percolateDown(getIndexAt(0));
    }

    return min != null ? (T)min.data : null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    heap = new HeapNode[capacity];
    size = 0;
  }

  public Comparable[] toArray() {
    Comparable[] result = new Comparable[size];
    for (int i = 0; i < size; i++) {
      result[i] = (T)heap[getIndexAt(i)].data;
    }
    return result;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(heap[getIndexAt(i)].data);
      if (i < size - 1) {
        sb.append(", ");
      }
    }
    return sb.toString();
  }

  public int size() {
    return size;
  }

  protected int getIndexAtLast() {
    return getIndexAt(size - 1);
  }

  protected int getNextAvailableIndex() {
    return getIndexAt(size);
  }
  
  protected int getIndexAt(int i) {
    return i + offset;
  }

  protected void percolateUp(int index) {
    while (index / 2 > 0) {
      int parentIndex = getParentIndex(index);
      if (heap[index].priority < heap[parentIndex].priority) {
        swap(index, parentIndex);
      }
      else {
        return;
      }
      index /= 2;
    }
  }

  protected void percolateDown(int index) {
    while (index * 2 <= size()) {
      int minChildIndex = getMinChildIndex(index);
      if (heap[minChildIndex].priority < heap[index].priority) {
        swap(index, minChildIndex);
      }
      else {
        return;
      }
      index = minChildIndex;
    }
  }

  protected void swap(int indexA, int indexB) {
    HeapNode temp = heap[indexA];
    heap[indexA] = heap[indexB];
    heap[indexB] = temp;
  }

  protected int getParentIndex(int i) {
    return i / 2;
  }

  protected int getLeftChildIndex(int i) {
    return i * 2;
  }

  protected int getRightChildIndex(int i) {
    return i * 2 + 1;
  }

  protected int getMinChildIndex(int index) {
    int left = getLeftChildIndex(index);
    int right = getRightChildIndex(index);

    if (right >= getIndexAtLast()) {
      return left;
    }
    if (heap[left].priority < heap[right].priority) {
      return left;
    }
    else {
      return right;
    }
  }

  protected void ensureCapacity() {
    if (size() + 1 >= capacity) {
      capacity *= GROWTH_FACTOR;
      HeapNode[] newHeap = new HeapNode[capacity];
      for (int i = 0; i < heap.length; i++) {
        newHeap[i] = heap[i];
      }
      heap = newHeap;
    }
  }
}