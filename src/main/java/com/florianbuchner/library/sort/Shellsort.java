package com.florianbuchner.library.sort;

public class Shellsort {

	public static <T extends Comparable<T>>void sort(T[] source) {
		final int[] sequence = getSequence(source.length);
		for (int i = 0; i < sequence.length; i++) {
			for (int start = 0; start < sequence[i]; start++) {
				sort(source, start, sequence[i]);
			}
		}
	}
	
	private static <T extends Comparable<T>>void sort(T[] source, int start, int distance) {
		for (int i = start + distance; i < source.length; i+=distance) {
			for (int j = i; j >= distance && source[j].compareTo(source[j - distance]) <= 0; j-=distance) {
				T value = source[j];
				source[j] = source[j - distance];
				source[j - distance] = value;
			}
		}
	}
	
	private static int[] getSequence(int size) {
		int[] result = new int[Double.valueOf((Math.log(size/5) / Math.log(2L))).intValue() + 1];
		result[result.length - 1] = 1;
		for (int i = result.length - 2; i >= 0; i--) {
			result[i] = result[i+1] * 2;
		}
		
		return result;
	}
}
