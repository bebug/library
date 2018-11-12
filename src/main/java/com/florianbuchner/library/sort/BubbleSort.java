package com.florianbuchner.library.sort;

public class BubbleSort {

	public static <T extends Comparable<T>> void sort(T[] source) {
		boolean change = true;
		while(change) {
			change = false;
			for (int i = 1; i < source.length; i++) {
				if (source[i-1].compareTo(source[i]) > 0) {
					T temp = source[i];
					source[i] = source[i-1];
					source[i-1] = temp;
					change = true;
				}
			}
		}
	}
}
