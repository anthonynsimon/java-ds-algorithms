package anthonynsimon.algorithms.stacksqueues;

import anthonynsimon.datastructures.Stack;

// Sorts a Stack with the constraint of using only one additional Stack
// For exercise purposes, no other data structure is used
// For that reason this algorithm is of O(N2) time complexity
public class StackSorter {

    public void sort(Stack<Integer> originalStack) {
        Stack<Integer> helperStack = new Stack<>();

        // Move elements to helper stack while sorting them
        // Will move elements back and forth between the original stack
        // and the helper stack
        while (originalStack.size() > 0) {
            // Hold the current element to sort
            int temp = originalStack.pop();

            // Push into our original stack any items from the helper stack that
            // are larger than the current one
            while (helperStack.size() > 0 && helperStack.peek() > temp) {
                originalStack.push(helperStack.pop());
            }

            // Place the current element where it belongs
            helperStack.push(temp);
        }

        // Move the now ordered elements back to original stack
        // Reverses the order, top of original stack has smallest element
        while (helperStack.size() > 0) {
            originalStack.push(helperStack.pop());
        }
    }
}