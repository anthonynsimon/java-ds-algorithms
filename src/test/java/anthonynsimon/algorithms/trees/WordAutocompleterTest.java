package anthonynsimon.algorithms.trees;

import org.junit.*;
import static org.junit.Assert.*;

public class WordAutocompleterTest {
  
  private WordAutocompleter autocompleter;
  private String[] emptyStringArray;
  
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

    emptyStringArray = new String[]{};
  }
  
  @Test
  public void testEmptyString() {
    assertEquals(autocompleter.autocomplete(""), emptyStringArray);
  }

  @Test
  public void testNonMemberWord() {
    assertEquals(autocompleter.autocomplete("x"), emptyStringArray);
    assertEquals(autocompleter.autocomplete("germo"), emptyStringArray);
  }

  @Test
  public void testMemberWordWithSuggestions() {
    assertEquals(autocompleter.autocomplete("ger"), new String[] {
      "germ",
      "germany"
    });
  }

  @Test
  public void testMemberWordWithoutSuggestions() {
    assertEquals(autocompleter.autocomplete("hair"), emptyStringArray);
  }
}