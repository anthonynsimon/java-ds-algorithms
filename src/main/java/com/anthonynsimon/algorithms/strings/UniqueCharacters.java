package com.anthonynsimon.algorithms.strings;

public final class UniqueCharacters {

    // Returns if a string's characters are all unique
    // Time O(N)
    public static boolean hasUniqueChars(String str) {
        // Return false if string is empty or has more chars than what ASCII supports
        if (str.isEmpty() || str.length() > 128) {
            return false;
        }

        // Again, assuming it's regular ASCII
        boolean[] charSet = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);

            if (charSet[value]) {
                return false;
            }

            charSet[value] = true;
        }

        return true;
    }
}

