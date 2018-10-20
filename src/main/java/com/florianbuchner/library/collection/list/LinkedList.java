package com.florianbuchner.library.collection.list;

public class LinkedList<T> implements List<T> {

	private ListNode firstNode;
	
	private ListNode lastNode;
	
	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public T get(int index) {
		return this.getNode(index).value;
	}
	
	private ListNode getNode(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index - size < 0) {
			int pos = 0;
			ListNode node = this.firstNode;
			while(pos != index) {
				node = node.rightNode;
				pos++;
			}
			return node;
		}
		else {
			int pos = this.size - 1;
			ListNode node = this.lastNode;
			while(pos != index) {
				node = node.leftNode;
				pos--;
			}
			return node;
		}
	}

	@Override
	public T remove(int index) {
		ListNode node = this.getNode(index);
		if (node.rightNode != null) {
			node.rightNode.leftNode = node.leftNode;
		}
		if (node.leftNode != null) {
			node.leftNode.rightNode = node.rightNode;
		}
		
		if (this.size <= 1) {
			this.firstNode = null;
		}
		else if (index == 0) {
			this.firstNode = this.firstNode.rightNode;
		}
		
		if (this.size <= 2) {
			this.lastNode = null;
		}
		else if (index == size -1) {
			this.lastNode = this.lastNode.leftNode;
		}
		
		this.size--;
		return node.value;
	}

	@Override
	public void add(T item) {
		if (this.firstNode == null) {
			this.firstNode = new ListNode(null, null, item);
		}
		else {
			final ListNode node = new ListNode(this.lastNode != null ? this.lastNode : this.firstNode, null, item);
			(this.lastNode != null ? this.lastNode : this.firstNode).rightNode = node;
			this.lastNode = node;
		}
		this.size++;
	}

	@Override
	public void clear() {
		this.firstNode = null;
		this.lastNode = null;
		this.size = 0;
	}

	class ListNode {
		
		public ListNode(ListNode leftNode, ListNode rightNode, T value) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
			this.value = value;
		}
		
		ListNode leftNode;
		ListNode rightNode;
		T value;
	}

	@Override
	public void replace(int index, T value) {
		this.getNode(index).value = value;
	}
}
