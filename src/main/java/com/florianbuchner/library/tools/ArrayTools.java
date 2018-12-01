package com.florianbuchner.library.tools;

import java.lang.reflect.Array;

public class ArrayTools {

	public static <T extends Comparable<T>> int binarySearch(T[] array, T item) {
		int low = 0;
		int high = array.length - 1;
		
		while(low <= high) {
			int mid = (high - low)/2 + low;
			int compare = item.compareTo(array[mid]);
	
			if (compare == 0) {
				return mid;
			}
			else if (compare < 0) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] copy(T[] array, int start, int end) {
		T[] newArray = (T[]) Array.newInstance(array[0].getClass(), end-start + 1);
		System.arraycopy(array, start, newArray, 0, newArray.length);
		return newArray;
	}
}
