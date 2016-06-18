package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.TrieNode;

public class Trie<T> {

  protected TrieNode<T> root;
  protected int charOffset = 97; // ASCII offset for lowercase chars
  protected int ALPHABET_COUNT = 26;

  public Trie() {
    this.root = new TrieNode<>(ALPHABET_COUNT);
  }

  public void put(String word, T value) {
    if (word == null || word.length() <= 0) {
      return;
    }
    // For simplicity, treat everything as lowercase
    word = word.toLowerCase();

    // Starting from the root, find the right slot for each
    // charater in the word or create a new node if not initialized.
    // Once last character is reached, set last slot's value.
    TrieNode<T> current = this.root;
    for (int i = 0; i < word.length(); i++) {
      int index = charIndexAt(word, i);
      if (current.children[index] == null) {
        current.children[index] = new TrieNode<T>(ALPHABET_COUNT);
      }
      current = current.children[index];
    }
    current.value = value;
  }

  public void remove(String word) {
    if (word == null || word.length() <= 0) {
      return;
    }
    // Start the recursive call to remove the word if present
    removeWorker(word, this.root, 0);
  }

  public T get(String word) {
    if (word == null || word.length() <= 0) {
      return null;
    }

    word = word.toLowerCase();

    TrieNode<T> current = this.root;
    for (int i = 0; i < word.length(); i++) {
      int index = charIndexAt(word, i);
      if (current.children[index] == null) {
        return null;
      }
      current = current.children[index];
    }

    return current.value;
  }

  public boolean isEmpty() {
    for (int i = 0; i < this.root.children.length; i ++) {
      if (this.root.children[i] != null) {
        return false;
      }
    }
    return true;
  }

  public void clear() {
    this.root = new TrieNode<>(ALPHABET_COUNT);
  }

  protected int charIndexAt(String word, int index) {
    return (int)word.charAt(index) - charOffset;
  }

  protected void removeWorker(String word, TrieNode node, int i) {
    // Base case, we reached the end of the word
    if (i >= word.length()) {
      return;
    }
    
    // Map the ASCII char index to 0-25 range
    int charIndex = charIndexAt(word, i);

    // If no node for current char, then word has not been placed in trie
    if (node.children[charIndex] == null) {
      return;
    }

    // If node exists then start recursive call on it for the next char
    removeWorker(word, node.children[charIndex], i + 1);

    // Once we return from the recursive call, if we are at the end of the 
    // word then start the removal by setting the value to null
    if (i == word.length() - 1) {
      node.children[charIndex].value = null;
    }

    // if the current node is empty, then set it to null and propagate change up
    if (node.children[charIndex].isEmpty()) {
      node.children[charIndex] = null;
    }
  }
}