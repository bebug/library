package com.florianbuchner.library.collection.stack;

public interface Stack<T> {

	T pop();
	
	void push(T item);
	
	T peak();
	
	int size();
}
