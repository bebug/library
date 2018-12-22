package com.florianbuchner.library.collection.list;

public class FifoQueue<T> implements Queue<T> {

	final LinkedList<T> list = new LinkedList<>();
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void enqueue(T item) {
		list.add(item);
	}

	@Override
	public T dequeue() {
		final T element = list.get(0);
		list.remove(0);
		return element;
	}

}
