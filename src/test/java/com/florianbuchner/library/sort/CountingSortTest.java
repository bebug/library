package com.florianbuchner.library.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountingSortTest {

	@Test
	public void testSort() {
		final Integer[] source = new Integer[10];
		final Integer[] result = new Integer[10];
		
		source[0] = 5;
		source[1] = 1;
		source[2] = 3;
		source[3] = 5;
		source[4] = 6;
		source[5] = 3;
		source[6] = 7;
		source[7] = 8;
		source[8] = 5;
		source[9] = 1;
		
		CountingSort.sort(source, result, (x) -> x , 10);
		
		assertEquals(Integer.valueOf(1), result[0]);
		assertEquals(Integer.valueOf(1), result[1]);
		assertEquals(Integer.valueOf(3), result[2]);
		assertEquals(Integer.valueOf(3), result[3]);
		assertEquals(Integer.valueOf(5), result[4]);
		assertEquals(Integer.valueOf(5), result[5]);
		assertEquals(Integer.valueOf(5), result[6]);
		assertEquals(Integer.valueOf(6), result[7]);
		assertEquals(Integer.valueOf(7), result[8]);
		assertEquals(Integer.valueOf(8), result[9]);
	}
}
