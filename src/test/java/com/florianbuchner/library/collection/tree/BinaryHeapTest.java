package com.florianbuchner.library.collection.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.florianbuchner.library.collection.tree.BinaryHeap.HeapType;

public class BinaryHeapTest {

	@Test
	public void testInsertRemoveMinHeap() {
		final BinaryHeap<Integer> heap = new BinaryHeap<>(Integer.class, HeapType.MIN_HEAP);
		
		heap.insert(Integer.valueOf(5));
		heap.insert(Integer.valueOf(8));
		heap.insert(Integer.valueOf(3));
		heap.insert(Integer.valueOf(16));
		heap.insert(Integer.valueOf(4));
		heap.insert(Integer.valueOf(9));
		heap.insert(Integer.valueOf(2));
		
		assertEquals(Integer.valueOf(2), heap.remove());
		assertEquals(Integer.valueOf(3), heap.remove());
		assertEquals(Integer.valueOf(4), heap.remove());
		assertEquals(Integer.valueOf(5), heap.remove());
		assertEquals(Integer.valueOf(8), heap.remove());
		assertEquals(Integer.valueOf(9), heap.remove());
		assertEquals(Integer.valueOf(16), heap.remove());
	}
	
	@Test
	public void testInsertRemoveMaxHeap() {
		final BinaryHeap<Integer> heap = new BinaryHeap<>(Integer.class, HeapType.MAX_HEAP);
		
		heap.insert(Integer.valueOf(5));
		heap.insert(Integer.valueOf(8));
		heap.insert(Integer.valueOf(3));
		heap.insert(Integer.valueOf(16));
		heap.insert(Integer.valueOf(4));
		heap.insert(Integer.valueOf(9));
		heap.insert(Integer.valueOf(2));
		
		assertEquals(Integer.valueOf(16), heap.remove());
		assertEquals(Integer.valueOf(9), heap.remove());
		assertEquals(Integer.valueOf(8), heap.remove());
		assertEquals(Integer.valueOf(5), heap.remove());
		assertEquals(Integer.valueOf(4), heap.remove());
		assertEquals(Integer.valueOf(3), heap.remove());
		assertEquals(Integer.valueOf(2), heap.remove());
	}
}
