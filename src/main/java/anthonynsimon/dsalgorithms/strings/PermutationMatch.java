package anthonynsimon.dsalgorithms.strings;

public class PermutationMatch {
  // Returns true if one string is a permutation of another
  public boolean isPermutation(String strA, String strB) {
    if (strA.length() != strB.length()) {
      return false;
    }

    // Assume it's regular ASCII
    int[] chars = new int[128];

    for (int i = 0; i < strA.length(); i++) {
      chars[strA.charAt(i)] += 1;
    }

    for (int i = 0; i < strB.length(); i++) {
      chars[strB.charAt(i)] -= 1;

      if (chars[strB.charAt(i)] < 0) {
        return false;
      }
    }

    return true;
  }
}
