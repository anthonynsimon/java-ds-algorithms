package anthonynsimon.datastructures.util;

public class TrieNode<T> {

    public TrieNode[] children;
    public T value;

    public TrieNode(int size) {
        this.children = new TrieNode[size];
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i] != null) {
                return false;
            }
        }
        return this.value == null;
    }
}