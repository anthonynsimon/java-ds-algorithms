package anthonynsimon.algorithms.trees;

import anthonynsimon.datastructures.Trie;
import anthonynsimon.datastructures.util.TrieNode;

import java.util.ArrayList;

public class WordAutocompleter extends Trie {

  private String ALPHABET = "abcdefghijklmnopqrstuvwxyz"; 

  public WordAutocompleter() {
    super();
  }

  public String[] autocomplete(String prefix) {
    ArrayList<String> results = new ArrayList<>();
    
    TrieNode lastChar = getNodeAtLast(prefix);
    depthFirstSearch(prefix, lastChar, results);

    return results.toArray(new String[]{});
  }

  private void depthFirstSearch(String prefix, TrieNode node, ArrayList results) {
    if (node == null) {
      return;
    }

    for (int i = 0; i < node.children.length; i++) {
      TrieNode child = node.children[i];
      if (child != null) {
        String str = prefix + ALPHABET.charAt(i);
        if (child.value != null) {
          results.add(str);
        }
        depthFirstSearch(str, child, results);
      }
    }
  }

  private TrieNode getNodeAtLast(String prefix) {
    if (prefix == null || prefix.length() == 0) {
      return null;
    }

    TrieNode current = this.root;
    for (int i = 0; i < prefix.length(); i++) {
      int index = charIndexAt(prefix, i);
      if (current.children[index] == null) {
        return null;
      }
      current = current.children[index];
    }

    return current;
  }
}