package com.florianbuchner.library.sort;

public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] source) {
		
		for (int j = 0; j < source.length - 1; j++) {
			boolean change = false;
			for (int i = 1; i < source.length - j; i++) {
				if (source[i-1].compareTo(source[i]) > 0) {
					T temp = source[i];
					source[i] = source[i-1];
					source[i-1] = temp;
					change = true;
				}
			}
			if (!change) return;
		}
	}
}
