package com.florianbuchner.library.sort;

import com.florianbuchner.library.collection.list.FifoQueue;
import com.florianbuchner.library.collection.list.Queue;

public class IterativeQuicksort {

	public static <T extends Comparable<T>>void sort(T[] source) {
		final Queue<QuicksortPair> queue = new FifoQueue<>();
		queue.enqueue(new QuicksortPair(0, source.length - 1));
		
		while(queue.size() > 0) {
			final QuicksortPair pair = queue.dequeue();
			if (pair.getStart() < pair.getEnd()) {
				final int pivot = Quicksort.divide(source, pair.getStart(), pair.getEnd());
				queue.enqueue(new QuicksortPair(pair.getStart(), pivot - 1));
				queue.enqueue(new QuicksortPair(pivot + 1, pair.end));
			}
		}
	}
	
	protected static class QuicksortPair {
		int start;
		int end;
		
		public QuicksortPair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}
		
	}
}
