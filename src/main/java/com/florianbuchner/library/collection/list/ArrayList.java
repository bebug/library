package com.florianbuchner.library.collection.list;

import java.lang.reflect.Array;

public class ArrayList<T> implements List<T> {

	public static int INCREMENT = 30;
	
	private int size;
	
	private T[] array;
	
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public ArrayList(Class<T> type) {
		this.type = type;
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
			this.array = (T[]) Array.newInstance(this.type, current.length + INCREMENT);
			for (int i = 0; i < current.length; i++) {
				this.array[i] = current[i];
			}
		}
		this.array[this.size] = item;
		this.size++;		
	}

	@Override
	public T remove(int index) {
		final T item = this.get(index);
		for (int i = index; i < size - 1; i++) {
			this.array[i] = this.array[i+1];
		}
		this.array[this.size -1] = null;
		this.size--;
		return item;
	}

	@Override
	public void clear() {
		this.size = 0;
	}

	@Override
	public void replace(int index, T value) {
		this.array[index] = value;
	}

}
