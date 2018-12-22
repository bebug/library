package com.florianbuchner.library.sort;

import com.florianbuchner.library.collection.stack.LinkedStack;
import com.florianbuchner.library.collection.stack.Stack;
import com.florianbuchner.library.tools.ArrayTools;

public class IterativeMergeSort {

	public static <T extends Comparable<T>> T[] sort(T[] source) {
		final Stack<T[]> divideStack = new LinkedStack<>();
		final Stack<T[]> mergeStack = new LinkedStack<>();
		divideStack.push(source);
		
		do {
			T[] item = divideStack.pop();
			if (item.length <= 1) {
				T[] itemToMerge = item;
				while(mergeStack.size() > 0 && (itemToMerge.length - mergeStack.peak().length >= 0 || divideStack.size() <= 0)) {
					itemToMerge = MergeSort.merge(mergeStack.pop(), itemToMerge);
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
}
