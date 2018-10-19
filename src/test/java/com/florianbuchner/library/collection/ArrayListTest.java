package com.florianbuchner.library.collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testAdd() {
		final ArrayList<Integer> arrayList = createArray(120);
		assertEquals(Integer.valueOf(20), arrayList.get(20));
		assertEquals(Integer.valueOf(119), arrayList.get(arrayList.size() - 1));
	}
	
	@Test
	public void testSize() {
		final ArrayList<Integer> arrayList = new ArrayList<>(Integer.class);
		assertEquals(0, arrayList.size());
		for (int i = 0; i < 5; i++) {
			arrayList.add(Integer.valueOf(i));
		}
		assertEquals(5, arrayList.size());
	}
	
	@Test
	public void testRemove() {
		final ArrayList<Integer> arrayList = createArray(20);
		arrayList.remove(10);
		assertEquals(Integer.valueOf(9), arrayList.get(9));
		assertEquals(Integer.valueOf(11), arrayList.get(10));
		assertEquals(19, arrayList.size());
	}
	
	@Test
	public void testRemoveLast() {
		final ArrayList<Integer> arrayList = createArray(20);
		arrayList.remove(19);
		assertEquals(19, arrayList.size());
		assertEquals(Integer.valueOf(18), arrayList.get(18));
	}
	
	@Test
	public void testRemoveFirst() {
		final ArrayList<Integer> arrayList = createArray(20);
		arrayList.remove(0);
		assertEquals(19, arrayList.size());
		assertEquals(Integer.valueOf(1), arrayList.get(0));
	}
	
	private static ArrayList<Integer> createArray(int size) {
		final ArrayList<Integer> arrayList = new ArrayList<>(Integer.class);
		for (int i = 0; i < size; i++) {
			arrayList.add(Integer.valueOf(i));
		}
		return arrayList;
	}
}
