package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.HeapNode;

public class PriorityQueue<T> {

  protected HeapNode[] heap;
  protected int size;
  protected int maxCapacity;

  public PriorityQueue() {
    this(256);
  }

  public PriorityQueue(int[] priorities, T[] data) {
    this(data.length);
    for (int i = 0; i < data.length; i++) {
      insert(priorities[i], data[i]);
    }
  }

  public PriorityQueue(int maxCapacity) {
    this.maxCapacity = maxCapacity;
    heap = new HeapNode[maxCapacity];
    size = 0;
  }

  public void insert(int priority, T item) {
    if (size() >= maxCapacity) {
      return;
    }

    heap[size()] = new HeapNode<T>(priority, item);
    size++;
    percolateUp(getIndexAtLast());
  }

  public T peekMin() {
    if (size() <= 0) {
      return null;
    }
    return (T)heap[0].data;
  }

  public T removeMin() {
    if (size() <= 0) {
      return null;
    }

    HeapNode min = heap[0];
    if (size() == 1) {
      heap[0] = null;
      size--;
    }
    else {
      HeapNode last = heap[getIndexAtLast()];
      heap[getIndexAtLast()] = null;
      size--;
      heap[0] = last;
      percolateDown(0);
    }

    return min != null ? (T)min.data : null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void clear() {
    heap = new HeapNode[maxCapacity];
    size = 0;
  }

  public T[] toArray() {
    T[] result = (T[]) new Object[size];
    for (int i = 0; i < size; i++) {
      result[i] = (T)heap[i].data;
    }
    return result;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(heap[i].data);
      if (i < size - 1) {
        sb.append(", ");
      }
    }
    return sb.toString();
  }

  protected void percolateUp(int index) {
    while (true) {
      int parentIndex  = getParentIndex(index);
      if (heap[index].priority < heap[parentIndex].priority) {
        swap(index, parentIndex);
      }
      else {
        return;
      }
      index = getParentIndex(index);
    }
  }

  protected void percolateDown(int index) {
    while (index * 2 + 1 < size) {
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

  protected int getIndexAtLast() {
    return size - 1;
  }

  protected int getParentIndex(int i) {
    return (i - 1) / 2;
  }

  protected int getLeftChildIndex(int i) {
    return i * 2 + 1;
  }

  protected int getRightChildIndex(int i) {
    return i * 2 + 2;
  }

  protected int getMinChildIndex(int index) {
    int left = getLeftChildIndex(index);
    int right = getRightChildIndex(index);

    if (right > getIndexAtLast()) {
      return left;
    }
    if (heap[left].priority < heap[right].priority) {
      return left;
    }
    else {
      return right;
    }
  }
}