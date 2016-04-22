package anthonynsimon.dsalgorithms.strings;

public class Sanitizer {
  
  public String sanitize(String str, char[] backlist) {
    int strLength = str.length();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < strLength; i++) {
      char currentChar = str.charAt(i);
      if (!charInArray(currentChar, backlist)) {
        sb.append(currentChar);
      }
    }
    
    return sb.toString();
  }
  
  private boolean charInArray(char c, char[] charArray) {
    for (char currentChar : charArray) {
      if (currentChar == c) {
        return true;
      }
    }
    return false;
  }
}