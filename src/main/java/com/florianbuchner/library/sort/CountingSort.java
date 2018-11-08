package com.florianbuchner.library.sort;

import java.util.function.Function;

public class CountingSort {

	public static <T> void sort(T[] source, T[] result, Function<T, Integer> indexer, int maxIndices) {
		Integer[] hist = new Integer[maxIndices];
		for (int i = 0; i < hist.length; i++) {
			hist[i] = Integer.valueOf(0);
		}
		
		for (int i = 0; i < source.length; i++) {
			hist[indexer.apply(source[i])]++;
		}
		
		for (int i = 1; i < hist.length; i++) {
			hist[i] = hist[i] + hist[i-1];
		}
		
		for (int i = 0; i < source.length; i++) {
			final int index = indexer.apply(source[i]);
			result[hist[index] - 1] = source[i];
			hist[index]--;
		}
	}
	
	public interface Indexer<T> {
		public int getIndex(T value);
	}
}
