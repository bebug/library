package com.florianbuchner.library.collection.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.florianbuchner.library.collection.list.List;

public abstract class AbstractListTest {

	@Test
	public void testAdd() {
		final List<Integer> List = createArray(120);
		assertEquals(Integer.valueOf(20), List.get(20));
		assertEquals(Integer.valueOf(119), List.get(List.size() - 1));
	}
	
	@Test
	public void testSize() {
		final List<Integer> List = this.createArray();
		assertEquals(0, List.size());
		for (int i = 0; i < 5; i++) {
			List.add(Integer.valueOf(i));
		}
		assertEquals(5, List.size());
	}
	
	@Test
	public void testRemove() {
		final List<Integer> List = createArray(20);
		List.remove(10);
		assertEquals(Integer.valueOf(9), List.get(9));
		assertEquals(Integer.valueOf(11), List.get(10));
		assertEquals(19, List.size());
	}
	
	@Test
	public void testRemoveLast() {
		final List<Integer> List = createArray(20);
		List.remove(19);
		assertEquals(19, List.size());
		assertEquals(Integer.valueOf(18), List.get(18));
	}
	
	@Test
	public void testRemoveFirst() {
		final List<Integer> List = createArray(20);
		List.remove(0);
		assertEquals(19, List.size());
		assertEquals(Integer.valueOf(1), List.get(0));
	}
	
	private List<Integer> createArray(int size) {
		final List<Integer> List = this.createArray();
		for (int i = 0; i < size; i++) {
			List.add(Integer.valueOf(i));
		}
		return List;
	}
	
	public abstract List<Integer> createArray(); 
}
