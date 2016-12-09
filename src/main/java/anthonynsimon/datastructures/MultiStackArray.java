package anthonynsimon.datastructures;

// Manages N stacks in an array, each with equal capacity
public class MultiStackArray {
    private int stackCount;
    private int stackCapacity;
    private int[] data;
    private int[] topIndeces;

    public MultiStackArray(int numberOfStacks, int stackCapacity) {
        if (numberOfStacks < 0 || stackCapacity < 0) {
            throw new IndexOutOfBoundsException("MultiStack must be of at least 1 stack with 1 slot capacity");
        }

        this.stackCount = numberOfStacks;
        this.stackCapacity = stackCapacity;
        this.data = new int[numberOfStacks * stackCapacity]; // Create the array that will hold as the stacks
        this.topIndeces = new int[numberOfStacks];
    }

    // Pushes new data to stack at given index if not full
    public void push(int stackIndex, int value) {
        if (isOutOfBounds(stackIndex)) {
            throw new IndexOutOfBoundsException("Provided stack index is out of bounds");
        }

        if (isStackFull(stackIndex)) {
            throw new IndexOutOfBoundsException("Stack with provided index is at full capacity");
        }

        // Place new data in next available slot
        this.data[getTopIndexForStack(stackIndex) + 1] = value;
        this.topIndeces[stackIndex]++;
    }

    // Returns data at top of stack with given index after removing it
    public int pop(int stackIndex) {
        if (isOutOfBounds(stackIndex)) {
            throw new IndexOutOfBoundsException("Provided stack index is out of bounds");
        }

        if (isStackEmpty(stackIndex)) {
            throw new IndexOutOfBoundsException("Stack with provided index is empty");
        }

        int topIndex = getTopIndexForStack(stackIndex);
        int temp = this.data[topIndex];
        this.data[topIndex] = 0;
        this.topIndeces[stackIndex]--;
        return temp;
    }

    // Returns data at top of stack with given index
    public int peek(int stackIndex) {
        return this.data[getTopIndexForStack(stackIndex)];
    }

    // Returns number of elements held by stack with given index
    public int sizeOfStack(int stackIndex) {
        return getTopIndexForStack(stackIndex) - (stackIndex * this.stackCapacity);
    }

    // Returns number of stacks being held in array
    public int stackCount() {
        return this.stackCount;
    }

    private int getTopIndexForStack(int stackIndex) {
        // Calculates the starting index for each stack and
        // adds the current top index for that stack as an offset
        //
        // For ex. if we have 2 stacks of each 256 slots, then stack '1'
        // starts at index "capacity * stack index"
        return this.topIndeces[stackIndex] + stackIndex * this.stackCapacity;
    }

    private boolean isStackFull(int stackIndex) {
        return this.topIndeces[stackIndex] >= this.stackCapacity;
    }

    private boolean isStackEmpty(int stackIndex) {
        return this.topIndeces[stackIndex] == 0;
    }

    private boolean isOutOfBounds(int stackIndex) {
        return stackIndex < 0 || stackIndex >= this.stackCapacity;
    }
}