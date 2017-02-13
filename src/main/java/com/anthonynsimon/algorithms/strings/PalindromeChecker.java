package com.anthonynsimon.algorithms.strings;

public final class PalindromeChecker {

    public static boolean isPalindrome(String str) {
        int strLength = str.length();

        for (int i = 0; i < strLength / 2; i++) {
            if (str.charAt(i) != str.charAt(strLength - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String str, char[] omittableChars) {
        Sanitizer sanitizer = new Sanitizer();
        str = sanitizer.sanitize(str, omittableChars);

        return isPalindrome(str);
    }

    public static boolean isPalindromeIgnoreCase(String str, char[] omittableChars) {
        Sanitizer sanitizer = new Sanitizer();
        str = sanitizer.sanitize(str, omittableChars);

        return isPalindrome(str.toLowerCase());
    }
}