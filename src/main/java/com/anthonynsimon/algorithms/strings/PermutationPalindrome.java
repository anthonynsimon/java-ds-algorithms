package com.anthonynsimon.algorithms.strings;

public final class PermutationPalindrome {

    public static boolean isPermutationOfPalindrome(String str) {
        // Remove punctuation, whitespace, make all lowercase...
        str = cleanUp(str);

        if (str.length() == 0) {
            return false;
        }

        // Assume ASCII
        char[] charFrequencies = new char[128];

        // Count the number of times each char appears
        for (int i = 0; i < str.length(); i++) {
            charFrequencies[(int) str.charAt(i)] += 1;
        }

        boolean hasMultipleOddChars = false;
        for (int i = 0; i < charFrequencies.length; i++) {
            // If there is more than one char with odd counts,
            // string cannot form a palindrome
            if (charFrequencies[i] % 2 != 0) {
                if (hasMultipleOddChars) {
                    return false;
                } else {
                    hasMultipleOddChars = true;
                }
            }
        }

        return true;
    }

    private static String cleanUp(String str) {
        Sanitizer sanitizer = new Sanitizer();
        char[] blacklist = {',', '-', '!', '.', ' ', ';', '\'', ':', '"', '?'};
        String sanitizedStr = sanitizer.sanitize(str, blacklist);

        return sanitizedStr.toLowerCase();
    }
}