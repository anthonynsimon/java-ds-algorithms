package anthonynsimon.datastructures;

import anthonynsimon.datastructures.util.TrieNode;

public class Trie<T> {

  TrieNode<T> root;
  int charOffset = 97;
  int ALPHABET_COUNT = 26;

  public Trie() {
    this.root = new TrieNode<>(ALPHABET_COUNT);
  }

  public void put(String word, T value) {
    if (word == null || word.length() <= 0) {
      return;
    }

    word = word.toLowerCase();

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

  private int charIndexAt(String word, int index) {
    return (int)word.charAt(index) - charOffset;
  }
}