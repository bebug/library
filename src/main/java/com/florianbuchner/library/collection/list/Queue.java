package com.florianbuchner.library.collection.list;

public interface Queue<T> {

	int size();

	void enqueue(T item);
	
	T dequeue();
}
