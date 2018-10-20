package com.florianbuchner.library.collection.list;

public interface List<T> {

	int size();
	
	T get(int index);
	
	T remove(int index);
	
	void replace(int index, T value);
	
	void add(T item);
	
	void clear();
}
