package anthonynsimon.datastructures;

import org.junit.*;
import static org.junit.Assert.*;

public class TrieTest {

  private Trie<Integer> trie;

  @Before
  public void setUp() {
    trie = new Trie<>();
  }

  @Test
  public void testPut() {/*
    trie.put("hello", 7);
    trie.put("GOOD", 64);
    trie.put(null, 5);*/
  }

  @Test
  public void testRemove() {

  }

  @Test
  public void testGet() {/*
    String[] memberWords = new String[]{
      "hello",
      "Germany",
      "mountains",
      "ab",
      "w",
      "ger",
      "mountAINS"
    };

    String[] nonMemberWords = new String[]{
      "hallo",
      "fiji",
      "sea",
      "b",
      "z",
      "ountAINS"
    };

    for (String word : memberWords) {
      trie.put(word, word.length());
    }

    for (String word : memberWords) {
      assertTrue(trie.get(word) == word.length());
    }

    for (String word : nonMemberWords) {
      assertFalse(trie.get(word) == word.length());
    }*/
  }

  @Test
  public void testGetAutoComplete() {

  }

  @Test
  public void testClear() {

  }

  @Test
  public void testIsEmpty() {

  }

  @Test
  public void testSize() {

  }
}