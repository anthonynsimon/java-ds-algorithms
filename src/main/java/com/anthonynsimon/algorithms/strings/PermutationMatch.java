package com.anthonynsimon.algorithms.strings;

public final class PermutationMatch {

    // Returns true if one string is a permutation of another
    // Time O(N)
    public static boolean isPermutation(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;
        }

        // Assume it's regular ASCII
        int[] chars = new int[128];

        // Count chars in A (case sensitive)
        for (int i = 0; i < strA.length(); i++) {
            chars[strA.charAt(i)] += 1;
        }

        // Count chars in B
        for (int i = 0; i < strB.length(); i++) {
            chars[strB.charAt(i)] -= 1;

            if (chars[strB.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
