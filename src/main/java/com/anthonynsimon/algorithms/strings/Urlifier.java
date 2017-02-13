package com.anthonynsimon.algorithms.strings;

public final class Urlifier {

    public static String urlify(String url) {
        // Count how many spaces are there
        int numberOfSpaces = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == ' ') {
                numberOfSpaces += 1;
            }
        }

        if (numberOfSpaces > 0) {
            // Prepare a new Char[] with enough space for the new chars
            char[] newUrl = new char[url.length() + (numberOfSpaces * 2)];

            int copyIndex = 0;
            for (int i = 0; i < url.length(); i++) {
                char currentChar = url.charAt(i);

                if (currentChar == ' ') {
                    newUrl[copyIndex++] = '%';
                    newUrl[copyIndex++] = '2';
                    newUrl[copyIndex++] = '0';
                } else {
                    newUrl[copyIndex++] = currentChar;
                }
            }

            url = String.copyValueOf(newUrl);
        }

        return url;
    }
}