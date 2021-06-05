package com.florianbuchner.library.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testBinarySearch() {
		Integer[] array = {Integer.valueOf(1),
				Integer.valueOf(2),
				Integer.valueOf(4),
				Integer.valueOf(5),
				Integer.valueOf(7),
				Integer.valueOf(9),
				Integer.valueOf(11),
				Integer.valueOf(15),
				Integer.valueOf(18)};
		assertEquals(0, BinarySearch.binarySearch(array, Integer.valueOf(1)));
		assertEquals(3, BinarySearch.binarySearch(array, Integer.valueOf(5)));
		assertEquals(7, BinarySearch.binarySearch(array, Integer.valueOf(15)));
		assertEquals(8, BinarySearch.binarySearch(array, Integer.valueOf(18)));
		assertEquals(-1, BinarySearch.binarySearch(array, Integer.valueOf(8)));
	}
}
