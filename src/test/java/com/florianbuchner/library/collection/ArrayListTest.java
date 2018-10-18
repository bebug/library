package com.florianbuchner.library.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testAddItem() {
		final ArrayList<Integer> arrayList = new ArrayList<>(Integer.class);
		for (int i = 0; i < 120; i++) {
			arrayList.add(Integer.valueOf(i));
		}
		assertEquals(Integer.valueOf(20), arrayList.get(20));
		assertEquals(Integer.valueOf(119), arrayList.get(arrayList.size() - 1));
		assertEquals(120, arrayList.size());
	}
}
