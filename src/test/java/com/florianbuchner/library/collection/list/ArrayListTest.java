package com.florianbuchner.library.collection.list;

import com.florianbuchner.library.collection.list.ArrayList;
import com.florianbuchner.library.collection.list.List;

public class ArrayListTest extends AbstractListTest {

	@Override
	public List<Integer> createArray() {
		return new ArrayList<>();
	}

}
