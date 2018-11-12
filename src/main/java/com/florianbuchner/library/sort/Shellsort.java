package com.florianbuchner.library.sort;

public class Shellsort {

	public static <T extends Comparable<T>>void sort(T[] source) {
		final int[] sequence = getSequence(source.length);
		for (int i = 0; i < sequence.length; i++) {
			int distance = sequence[i];
			for (int start = distance; start < source.length; start++) {
				for (int j = start; j >= distance && source[j].compareTo(source[j - distance]) <= 0; j-=distance) {
					T value = source[j];
					source[j] = source[j - distance];
					source[j - distance] = value;
				}
			}
		}
	}
	
	private static int[] getSequence(int size) {
		int[] result = new int[Double.valueOf((Math.log(size/5) / Math.log(2L))).intValue() + 1];
		result[result.length - 1] = 1;
		for (int i = result.length - 2; i >= 0; i--) {
			result[i] = (result[i+1] + 1)  * 2 - 1;
		}
		
		return result;
	}
}
