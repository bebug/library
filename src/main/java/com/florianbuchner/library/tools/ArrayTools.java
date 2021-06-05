package com.florianbuchner.library.tools;

import java.lang.reflect.Array;

public class ArrayTools {
	
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] copy(T[] array, int start, int end) {
		T[] newArray = (T[]) Array.newInstance(array[0].getClass(), end-start + 1);
		System.arraycopy(array, start, newArray, 0, newArray.length);
		return newArray;
	}
	
	public static <T>void swap(T[] source, int pos1, int pos2) {
		final T tmp = source[pos1];
		source[pos1] = source[pos2];
		source[pos2] = tmp;
	}
}
