package com.florianbuchner.library.collection.tree;

import java.lang.IllegalArgumentException;
import com.florianbuchner.library.collection.list.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {

	private ArrayList<T> values;
	
	private HeapType heapType;
	
	public BinaryHeap(Class<T> classType, HeapType heapType) {
		this.values = new ArrayList<>(classType);
		this.heapType = heapType;
	}
	
	private int nextLeftIndex(int index) {
		return index * 2 + 1;
	}
	
	private int nextRightIndex(int index) {
		return index * 2 + 2;
	}
	
	private int previousIndex(int index) {
		return (index - 1) / 2;
	}
	
	public void insert(T value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.values.add(value);
		this.bubbleUp(this.values.size() - 1);
	}
	
	public T remove() {
		if (this.values.size() == 0) {
			return null;
		}
		
		final T value = this.values.get(0);
		this.values.replace(0, this.values.remove(this.values.size() - 1));
		if (this.values.size() != 0) {
			this.bubbleDown(0);
		}
		return value;
	}
	
	private void bubbleUp(int index) {
		while(!this.valideHeapAtIndex(index) && index > 0) {
			final int previousIndex = this.previousIndex(index);
			this.swapValue(index, previousIndex);
			index = previousIndex;
		}
	}
	
	private void bubbleDown(int index) {
		int nextLeftIndex = this.nextLeftIndex(index);
		
		while(!this.valideHeapAtIndex(index) && nextLeftIndex <= this.values.size() - 1) {
			final int nextRightIndex = this.nextRightIndex(index);

			final int nextChoosenIndex;
			if (nextRightIndex > this.values.size() - 1) {
				nextChoosenIndex = nextLeftIndex;
			}
			else if (this.heapType == HeapType.MAX_HEAP) {
				nextChoosenIndex = (this.values.get(nextLeftIndex).compareTo(this.values.get(nextRightIndex)) >= 0 ) ?
						nextLeftIndex : nextRightIndex;
			}
			else {
				nextChoosenIndex = (this.values.get(nextLeftIndex).compareTo(this.values.get(nextRightIndex)) <= 0 ) ?
						nextLeftIndex : nextRightIndex;
			}
			
			this.swapValue(index, nextChoosenIndex);
			index = nextChoosenIndex;
			nextLeftIndex = this.nextLeftIndex(index);
		}
	}
	
	private boolean valideHeapAtIndex(int index) {
		final T value = this.values.get(index);
		final int previousIndex = this.previousIndex(index);
		final int nextLeftIndex = this.nextLeftIndex(index);
		final int nextRightIndex = this.nextRightIndex(index);
		
		if (this.heapType == HeapType.MAX_HEAP) {
			return (previousIndex < 0 || value.compareTo(this.values.get(previousIndex)) <= 0) &&
					(nextLeftIndex > this.values.size() - 1 || value.compareTo(this.values.get(nextLeftIndex)) >= 0) &&
					(nextRightIndex > this.values.size() - 1 || value.compareTo(this.values.get(nextRightIndex)) >= 0);
		}
		else {
			return (previousIndex < 0 || value.compareTo(this.values.get(previousIndex)) >= 0) &&
					(nextLeftIndex > this.values.size() - 1 || value.compareTo(this.values.get(nextLeftIndex)) <= 0) &&
					(nextRightIndex > this.values.size() - 1 || value.compareTo(this.values.get(nextRightIndex)) <= 0);
		}
	}
	
	public void swapValue(int index1, int index2) {
		T value = this.values.get(index1);
		this.values.replace(index1, this.values.get(index2));
		this.values.replace(index2, value);
	}
	
	public enum HeapType{
		MAX_HEAP,
		MIN_HEAP
	}
}
