package com.anthonynsimon.algorithms.strings;

public final class DiffChecker {

    // Returns if the the strings are just one edit away
    // It could be a character replacement, insertion or removal difference
    public static boolean areOneEditAway(String strA, String strB) {
        String shorterStr = strA.length() < strB.length() ? strA : strB;
        String largerStr = strA.length() < strB.length() ? strB : strA;

        // Return false if the difference in length between them is larger than 1
        if (largerStr.length() - shorterStr.length() > 1) {
            return false;
        }

        if (largerStr.length() == shorterStr.length()) {
            // Check for number of differences in chars
            return hasOneDiff(strA, strB);
        } else {
            // Check for a diff, besides the additional char somewhere in the larger string
            return hasNoDiff(shorterStr, largerStr);
        }
    }

    private static boolean hasOneDiff(String strA, String strB) {
        boolean alreadyHasDiff = false;
        for (int i = 0; i < strA.length(); i++) {
            // If there is a diff and it's the first one, continue
            // if not, return
            if (strA.charAt(i) != strB.charAt(i)) {
                if (alreadyHasDiff) {
                    return false;
                }
                alreadyHasDiff = true;
            }
        }
        return true;
    }

    private static boolean hasNoDiff(String shorterStr, String largerStr) {
        int indexShorter = 0;
        boolean hasDiff = false;
        for (int i = 0; i < largerStr.length(); i++) {
            if (indexShorter >= shorterStr.length()) {
                // We reached the end of the shorter string, we're done
                // The remaining char in the larger string is the diff
                break;
            }
            // If there is a diff, and we have no other diff as active, continue but
            // keep the shorterIndex in place until resolved
            if (shorterStr.charAt(indexShorter) != largerStr.charAt(i)) {
                if (hasDiff) {
                    return false;
                }
                hasDiff = true;
            } else {
                hasDiff = false;
                indexShorter++;
            }
        }
        return true;
    }
}