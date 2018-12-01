package com.florianbuchner.library.collection.stack;

import com.florianbuchner.library.collection.list.LinkedList;

public class LinkedStack<T> implements Stack<T> {

	final LinkedList<T> stack = new LinkedList<>();

	@Override
	public T pop() {
		final T item = this.peak();
		stack.remove(stack.size() - 1);
		return item;
	}

	@Override
	public void push(T item) {
		stack.add(item);
	}

	@Override
	public T peak() {
		return stack.get(stack.size() - 1);
	}

	@Override
	public int size() {
		return stack.size();
	}
}
