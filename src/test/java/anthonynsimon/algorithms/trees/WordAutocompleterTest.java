package anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

public class WordAutocompleterTest {
  
  private WordAutocompleter autocompleter;
  
  @Before
  public void setUp() {
    autocompleter = new WordAutocompleter();

    String[] memberWords = new String[]{
      "hello",
      "Germany",
      "mountains",
      "alps",
      "germ",
      "MOUNTAIN",
      "hold",
      "hair",
      "marathon",
      "mars",
      "he"
    };

    for (String word : memberWords) {
      autocompleter.put(word, word.length());
    }
  }
  
  @Test
  public void testEmptyString() {
    for (String suggestion : autocompleter.autocomplete("ha")) {
      System.out.println(suggestion);
    }
  }
}