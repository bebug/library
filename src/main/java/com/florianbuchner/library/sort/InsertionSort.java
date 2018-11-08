package com.florianbuchner.library.sort;

public class InsertionSort {

	static <T extends Comparable<T>>void sort(T[] source) {
		
		for (int i = 1; i < source.length; i++) {
			for (int j = i; j > 0 && source[j].compareTo(source[j - 1]) <= 0; j--) {
				T value = source[j];
				source[j] = source[j - 1];
				source[j - 1] = value;
			}
		}
	}
}
