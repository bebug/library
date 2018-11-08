package com.florianbuchner.library.collection.list;

import com.florianbuchner.library.collection.list.LinkedList;
import com.florianbuchner.library.collection.list.List;

public class LinkedListTest extends AbstractListTest {

	@Override
	public List<Integer> createArray() {
		return new LinkedList<>();
	}

}
