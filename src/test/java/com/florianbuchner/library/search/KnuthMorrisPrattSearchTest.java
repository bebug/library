package com.florianbuchner.library.search;

import org.junit.Assert;
import org.junit.Test;

public class KnuthMorrisPrattSearchTest {

    @Test
    public void generatePrefixMapTest() {
        int[] prefixes = KnuthMorrisPrattSearch.generatePrefixMap("ababaca");
        Assert.assertEquals(6, prefixes.length);
        Assert.assertEquals(0, prefixes[0]);
        Assert.assertEquals(0, prefixes[1]);
        Assert.assertEquals(1, prefixes[2]);
        Assert.assertEquals(2, prefixes[3]);
        Assert.assertEquals(3, prefixes[4]);
        Assert.assertEquals(0, prefixes[5]);
    }

    @Test
    public void searchTest() {
        Assert.assertEquals(4, KnuthMorrisPrattSearch.search("aaabaab", "aaabaaabaab"));
        Assert.assertEquals(6, KnuthMorrisPrattSearch.search("ababac", "abababababacaab"));
        Assert.assertEquals(6, KnuthMorrisPrattSearch.search("ababaca", "bacbabababacaab"));
        Assert.assertEquals(8, KnuthMorrisPrattSearch.search("ababa", "ababcabcababacab"));
        Assert.assertEquals(13, KnuthMorrisPrattSearch.search("aaaaa", "aaaabaabaaaabaaaaabaaaaa"));
    }
}
