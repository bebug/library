package com.florianbuchner.library.collection.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FifoQueueTest {

	@Test
	public void testQueue() {
		final Queue<Integer> queue = new FifoQueue<>();
		queue.enqueue(Integer.valueOf(10));
		queue.enqueue(Integer.valueOf(6));
		queue.enqueue(Integer.valueOf(55));
		queue.enqueue(Integer.valueOf(17));
		assertEquals(4, queue.size());
		assertEquals(Integer.valueOf(10), queue.dequeue());
		assertEquals(Integer.valueOf(6), queue.dequeue());
		assertEquals(Integer.valueOf(55), queue.dequeue());
		assertEquals(Integer.valueOf(17), queue.dequeue());
		assertEquals(0, queue.size());
	}
}
