package com.florianbuchner.library.sort;

import java.lang.reflect.Array;

import com.florianbuchner.library.collection.stack.LinkedStack;
import com.florianbuchner.library.collection.stack.Stack;
import com.florianbuchner.library.tools.ArrayTools;

public class MergeSort {
	
	static <T extends Comparable<T>> T[] sort(T[] source) {
		if (source.length <= 1) {
			return source;
		}
		T[] left = ArrayTools.copy(source, 0, source.length/2 - 1);
		T[] right = ArrayTools.copy(source, source.length/2, source.length - 1);
		return merge(sort(right), sort(left));
	}
	
	static <T extends Comparable<T>> T[] iterativeSort(T[] source) {
		final Stack<T[]> divideStack = new LinkedStack<>();
		final Stack<T[]> mergeStack = new LinkedStack<>();
		divideStack.push(source);
		
		do {
			T[] item = divideStack.pop();
			if (item.length <= 1) {
				T[] itemToMerge = item;
				while(mergeStack.size() > 0 && (itemToMerge.length - mergeStack.peak().length >= 0 || divideStack.size() <= 0)) {
					itemToMerge = merge(mergeStack.pop(), itemToMerge);
				}
				
				mergeStack.push(itemToMerge);
			}
			else {
				divideStack.push(ArrayTools.copy(item, 0, item.length/2 - 1));
				divideStack.push(ArrayTools.copy(item, item.length/2, item.length - 1));
			}
		}
		while(divideStack.size() > 0);
		
		return (T[]) mergeStack.pop();
	}
	
	@SuppressWarnings("unchecked")
	static <T extends Comparable<T>> T[] merge(T[] left, T[] right) {
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
