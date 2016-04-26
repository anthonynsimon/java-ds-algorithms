package anthonynsimon.algorithms.strings;

public class Sanitizer {
  
  public String sanitize(String str, char[] blacklist) {
    int strLength = str.length();
    StringBuilder sb = new StringBuilder();
    
    for (int i = 0; i < strLength; i++) {
      char currentChar = str.charAt(i);
      if (!charInArray(currentChar, blacklist)) {
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