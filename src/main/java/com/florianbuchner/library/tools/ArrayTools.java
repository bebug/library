package com.florianbuchner.library.tools;

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
	
}
