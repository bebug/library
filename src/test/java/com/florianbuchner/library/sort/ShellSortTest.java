package com.florianbuchner.library.sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShellSortTest {
	
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
				Integer.valueOf(3),
				Integer.valueOf(8),
				Integer.valueOf(1),
				Integer.valueOf(9),
				Integer.valueOf(4),
				Integer.valueOf(7),
				Integer.valueOf(2),
				Integer.valueOf(3),
				Integer.valueOf(8),
				Integer.valueOf(1),
				Integer.valueOf(9),
				Integer.valueOf(4),
				Integer.valueOf(7),
				Integer.valueOf(2),
				Integer.valueOf(0)};
		Shellsort.sort(values);
		
		assertEquals(Integer.valueOf(0), values[0]);
		assertEquals(Integer.valueOf(1), values[1]);
		assertEquals(Integer.valueOf(2), values[5]);
		assertEquals(Integer.valueOf(4), values[10]);
		assertEquals(Integer.valueOf(7), values[15]);
		assertEquals(Integer.valueOf(9), values[20]);
		assertEquals(Integer.valueOf(9), values[21]);
	}
}
