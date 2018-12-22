package com.florianbuchner.library.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IterativeMergesortTest {
	
	@Test
	public void testSort() {
		final Integer[] values = {Integer.valueOf(5),
				Integer.valueOf(3),
				Integer.valueOf(8),
				Integer.valueOf(1),
				Integer.valueOf(9),
				Integer.valueOf(4),
				Integer.valueOf(7),
				Integer.valueOf(2),
				Integer.valueOf(0)};
		final Integer[] result = IterativeMergeSort.sort(values);
		
		assertEquals(Integer.valueOf(0), result[0]);
		assertEquals(Integer.valueOf(1), result[1]);
		assertEquals(Integer.valueOf(2), result[2]);
		assertEquals(Integer.valueOf(3), result[3]);
		assertEquals(Integer.valueOf(4), result[4]);
		assertEquals(Integer.valueOf(5), result[5]);
		assertEquals(Integer.valueOf(7), result[6]);
		assertEquals(Integer.valueOf(8), result[7]);
		assertEquals(Integer.valueOf(9), result[8]);
		
	}
}
