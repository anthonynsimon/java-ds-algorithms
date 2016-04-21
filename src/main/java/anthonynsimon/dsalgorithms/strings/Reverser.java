package anthonynsimon.dsalgorithms.strings;

public class Reverser {
  
  public String reverse(String str) {
    if (str.length() > 0) {
        char[] charArray = str.toCharArray();
        int lengthOfArray = charArray.length;
        
        for (int i = 0; i < lengthOfArray/2; i++) {
          swap(charArray, i, lengthOfArray -1 -i);
        }
        
        str = String.copyValueOf(charArray);
    }
    return str;
  }
  
  private void swap(char[] charArray, int a, int b) {
    char temp = charArray[a];
    charArray[a] = charArray[b];
    charArray[b] = temp;
  }
}