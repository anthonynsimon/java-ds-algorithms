package anthonynsimon.algorithms.stacksqueues;

import anthonynsimon.datastructures.Stack;

public class MinStack {
  
  // Keep two stacks, one for the data and one for the current min
  // Keeps a history of min elements so we always have O(1) time complexity
  // for the push, pop and min methods as we don't have to search for the next
  // min every time we pop a data element which is also a min.
  private Stack<Integer> dataStack;
  private Stack<Integer> minStack;
  
  public MinStack() {
    this.dataStack = new Stack<Integer>();
    this.minStack = new Stack<Integer>();
  }
  
  public void push(int item) {
    dataStack.push(item);
    // If the new item is <= to previous min push it to minStack
    if (item <= min()) {
      minStack.push(item);
    }
  }
  
  public int pop() {    
    int temp = dataStack.pop();
    
    // If the popped data element is the current min element, then
    // pop from the minStack to sync them 
    if (min() == temp) {
      minStack.pop();
    }
    
    return temp;
  }
  
  public int min() {
    return minStack.size() > 0 ? minStack.peek() : Integer.MAX_VALUE;
  }
}