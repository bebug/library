package com.florianbuchner.library.collection;

public interface List<T> {

	int size();
	
	T get(int index);
	
	void add(T item);
}
