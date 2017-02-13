package com.anthonynsimon.algorithms.strings;

public final class StringCompressor {

    public static String compress(String str) {
        int inputLength = str.length();
   
    /*
    * If the string is < 2 characters long, we can't reduce it
    * aa -> a2 (same length)
    * aab -> a2b1 BUT aaa -> a3, so we need at least 3 characters
    */
        if (inputLength < 2) {
            return str;
        }

        // Pre-initialize to 1 as we know we have at least one appearance of the current char
        int appearanceCount = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputLength; i++) {
            // If current and next char don't match, append the consecutive group
            // Or if we reached the end of the string, just append what we have
            if (i + 1 >= inputLength || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(appearanceCount);
                appearanceCount = 1;
            } else {
                // If they do match, then keep counting the number of appearances
                appearanceCount += 1;
            }
        }

        String result = sb.toString();

        if (result.length() < inputLength) {
            return result;
        }

        return str;
    }
}