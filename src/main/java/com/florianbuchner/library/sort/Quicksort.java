package com.florianbuchner.library.sort;

import com.florianbuchner.library.tools.ArrayTools;

public class Quicksort {

	public static <T extends Comparable<T>>void sort(T[] source) {
		sort(source, 0, source.length - 1);
	}
	
	public static <T extends Comparable<T>>void sort(T[] source, final int start, final int end) {
		if (start < end) {
			final int pivot = divide(source, start, end);
			sort(source, start, pivot - 1);
			sort(source, pivot + 1, end);
		}
	}
	
	protected static <T extends Comparable<T>>int divide(T[] source, final int start, final int end) {
		T pivot = source[end];
		int right = end - 1;
		int left = start;
		
		do {
			while(source[left].compareTo(pivot) < 0 && left < end -1) {
				left++;
			}
			while(source[right].compareTo(pivot) >= 0 && right > start) {
				right--;
			}
			if (left < right) {
				ArrayTools.swap(source, left, right);
			}
		}
		while (left < right);
		
		if (source[left].compareTo(pivot) >= 0) {
			ArrayTools.swap(source,  left, end);
			return left;
		}
		
		return end;
	}
}
