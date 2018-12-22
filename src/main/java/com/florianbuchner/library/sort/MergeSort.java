package com.florianbuchner.library.sort;

import java.lang.reflect.Array;

import com.florianbuchner.library.tools.ArrayTools;

public class MergeSort {
	
	public static <T extends Comparable<T>> T[] sort(T[] source) {
		if (source.length <= 1) {
			return source;
		}
		T[] left = ArrayTools.copy(source, 0, source.length/2 - 1);
		T[] right = ArrayTools.copy(source, source.length/2, source.length - 1);
		return merge(sort(right), sort(left));
	}
	
	@SuppressWarnings("unchecked")
	protected static <T extends Comparable<T>> T[] merge(T[] left, T[] right) {
		T[] result = (T[]) Array.newInstance(left[0].getClass(), left.length + right.length);
		int posLeft = 0, arrayPos = 0, posRight = 0;
		while (arrayPos < result.length) {
			if (posLeft < left.length && (posRight >= right.length ||
					left[posLeft].compareTo(right[posRight]) <= 0)) {
				result[arrayPos] = left[posLeft];
				posLeft++;
			}
			else {
				result[arrayPos] = right[posRight];
				posRight++;
			}
			arrayPos++;
		}
		
		return result;
	}
}
