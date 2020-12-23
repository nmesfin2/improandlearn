package com.learning.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinaryTree {

	@Test
	public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
	    BinaryTree bt = createBinaryTree();
	    assertTrue(bt.find(6));
	    assertTrue(bt.find(4));
	 
	    assertFalse(bt.find(1));
	}
	
	@Test
	public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
	    BinaryTree bt = createBinaryTree();

	    assertTrue(bt.find(9));
	    bt.delete(9);
	    assertFalse(bt.find(9));
	}
	
	private BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		return bt;
	}

}
