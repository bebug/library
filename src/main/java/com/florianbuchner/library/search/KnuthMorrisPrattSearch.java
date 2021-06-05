package com.florianbuchner.library.search;

public class KnuthMorrisPrattSearch {

    protected static int[] generatePrefixMap(final String pattern) {
        int[] result = new int[pattern.length()-1];
        result[0] = 0;
        for (int i = 1; i<pattern.length()-1; i++) {
            result[i] = pattern.charAt(i) == pattern.charAt(result[i-1]) ? 1 + result[i-1] : 0;
        }
        return result;
    }

    protected static int search(final String pattern, final String text) {
        int[] prefixes = generatePrefixMap(pattern);
        int prefixPos = 0;
        for (int i = 0; i< text.length(); i++) {
            do {
                if (text.charAt(i) == pattern.charAt(prefixPos)) {
                    prefixPos++;
                    break;
                } else if (prefixPos != 0) {
                    prefixPos = prefixes[prefixPos-1];
                }
            } while (prefixPos != 0);
            if (prefixPos == pattern.length()) return i - (pattern.length()-1);
        }

        return -1;
    }

}
