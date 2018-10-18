package com.florianbuchner.library.collection;

import java.lang.reflect.Array;

public class ArrayList<T> implements List<T> {

	public static int INCREMENT = 30;
	
	private int size;
	
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayList(Class<T> type) {
		this.array = (T[]) Array.newInstance(type, INCREMENT);
	}
	
	public ArrayList(T[] source) {
		this.array = source;
		this.size = source.length;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return array[index];
	}

	@Override
	@SuppressWarnings("unchecked")
	public void add(T item) {
		if (this.size >= this.array.length) {
			final T[] current = this.array;
			this.array = (T[]) Array.newInstance(item.getClass(), current.length + INCREMENT);
			for (int i = 0; i < current.length; i++) {
				this.array[i] = current[i];
			}
		}
		this.array[this.size] = item;
		this.size++;		
	}

}
