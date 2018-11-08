package com.florianbuchner.library.model;

public class KeyValuePair<T extends Comparable<T>, D> {
	
	private T key;
	
	private D value;
	
	public KeyValuePair(T key, D value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public D getValue() {
		return value;
	}

	public void setValue(D value) {
		this.value = value;
	}
	
	
}
