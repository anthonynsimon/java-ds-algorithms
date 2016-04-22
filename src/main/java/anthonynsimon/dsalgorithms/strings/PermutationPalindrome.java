package anthonynsimon.dsalgorithms.strings;

public class PermutationPalindrome {
  
  // Optimized solution
  public boolean isPermutationOfPalindrome(String str) {
    // Remove punctuation, whitespace, make all lowercase...
    str = cleanUp(str);
    
    if (str.length() == 0) {
      return false;
    }
    
    // Assume ASCII
    char[] charFrequencies = new char[128];
    
    // Count the number of times each char appears
    for (int i = 0; i < str.length(); i++) {
      charFrequencies[(int)str.charAt(i)] += 1;
    }
    
    boolean hasMultipleOddChars = false;
    for (int i = 0; i < charFrequencies.length; i++) {
      // If there is more than one char with odd counts,
      // string cannot form a palindrome
      if (charFrequencies[i] % 2 != 0) {
        if (hasMultipleOddChars) {
          return false;
        }
        else {
          hasMultipleOddChars = true;
        }
      }
    }
    
    return true;
  }
  
  // Brute force solution
  public boolean isPermutationOfPalindromeBruteForce(String str) {
    // Remove punctuation, whitespace, make all lowercase...
    str = cleanUp(str);
    
    if (str.length() == 0) {
      return false;
    }
    
    // Generate and check all permutations until palindrome found
    if (permutateUntilFound("", str)) {
      return true;
    }
    
    return false;
  }
  
  private boolean permutateUntilFound(String prefix, String str) {
    int strLength = str.length();
    
    // If we reached base case, check if it's palindrome
    if (strLength == 0) {
      if (PalindromeChecker.isPalindrome(prefix)) {
        return true;
      }
      return false;
    }
    else {
      // Keep generating permutations
      for (int i = 0; i < strLength; i++) {
        // If one of the permutations is a palindrome, return true
        if (permutateUntilFound(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, strLength))) {
          return true;
        }
      }
      return false;
    }
  }
  
  private String cleanUp(String str) {
    Sanitizer sanitizer = new Sanitizer();
    char[] backlist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
    String sanitizedStr = sanitizer.sanitize(str, backlist);
    
    return sanitizedStr.toLowerCase();
  }
}