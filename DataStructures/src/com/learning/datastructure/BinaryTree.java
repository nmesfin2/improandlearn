package com.learning.datastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BinaryTree<T>  {
	private Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	// add 
	public void add(T value){
		root = addRecursive(root, value);
	}
	
	private Node addRecursive(Node current, T value) {		
		
		if(current == null) {
			return new Node((Comparable) value);		
		}
		
		if(current.getValue().compareTo(value) > 0) {
			current.setLeft(addRecursive(current.getLeft(), value));
		}else if(current.getValue().compareTo(value) < 0){
			current.setRight(addRecursive(current.getRight(), value));
		}else {
			return current;
		}
		return current;
	}
	
	// find node
	public boolean find(T value) {
		return findHelper(root, value);
	}
	
	private boolean findHelper(Node current, T value) {
		if(current == null) {
			return false;
		}
		if(current.getValue() == value) {
			return true;
		}
		
		if(current.getValue().compareTo(value) > 0) {
			return findHelper(current.getLeft(), value);
		}else{
			return findHelper(current.getRight(), value);
		}
	}
	
	public void delete(T value) {
		root = deleteElement(root, value);
	}
	// Deleting an element Helper
	private Node deleteElement(Node current, T value) {
		if(current == null) {
			return null;
		}
		
		if(value == current.getValue()) {
			if(current.getLeft() == null && current.getRight() == null) {
				return null;
			}
			
			if(current.getRight() == null) {
				return current.getLeft();
			}
			
			if(current.getLeft() == null) {
				return current.getRight();
			}
			
			T smallestValue = findSmallestValue(current.getRight());
			current.setValue((Comparable) smallestValue);
			current.setRight(deleteElement(current.getRight(), smallestValue));
			return current;
		}
		
		if(current.getValue().compareTo(value) > 0) {
			current.setLeft(deleteElement(current.getLeft(), value));
			return current;
		}
		
		current.setRight(deleteElement(current.getRight(), value));
		return current;
	}
	
	// find smallest for deleting
	private T findSmallestValue(Node root) {
		return root.getLeft() == null ? (T) root.getValue() : findSmallestValue(root.getLeft());
	}
	
	public int countLeaves() {
		return countLeavesHelper(root);
	}
	//count leaves
	private int countLeavesHelper(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.getLeft() == null && root.getRight() == null) {
			return 1;
		}
		
		return countLeavesHelper(root.getLeft()) + countLeavesHelper(root.getRight());
	}
	
	// In order traversal
	public static void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.getLeft());
	        System.out.print(" " + node.getValue());
	        traverseInOrder(node.getRight());
	    }
	}
	
	// pre order traversal
	public static void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.getValue());
	        traversePreOrder(node.getLeft());
	        traversePreOrder(node.getRight());
	    }
	}
	
	
	// post order traversal
	public static void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.getLeft());
	        traversePostOrder(node.getRight());
	        System.out.print(" " + node.getValue());
	    }
	}
	
	// traverse level order
	public void traverseLevelOrder() {
		if(root == null) {
			return;
		}
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			
			
			System.out.print(" " + node.getValue());
			
			if(node.getLeft() != null) {
				nodes.add(node.getLeft());
			}
			
			if(node.getRight() != null) {
				nodes.add(node.getRight());
			}
		}
	}
	
	
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(6);
		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		
		System.out.println(bt.countLeaves());
		
		System.out.print("traversal in order: "); 
		traverseInOrder(bt.root);
		System.out.println();
		
		System.out.print("traversal pre order: ");
		traversePreOrder(bt.root);
		System.out.println();
		
		System.out.print("traversal post order: ");
		traversePostOrder(bt.root);
		System.out.println();
		
		System.out.print("traversal Level Order (Breadth first): "); 
		bt.traverseLevelOrder();
	}
}

class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
	private T value;
	private Node<?> left;
	private Node<?> right;
	
	public Node() {
		value = null;
		left = null;
		right = null;
	}
	
	public Node(T value2) {
		this.value = value2;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T data) {
		this.value = data;
	}
	public Node<?> getLeft() {
		return left;
	}
	public void setLeft(Node<?> left) {
		this.left = left;
	}
	public Node<?> getRight() {
		return right;
	}
	public void setRight(Node<?> right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Node<T> o) {
		// TODO Auto-generated method stub
		return this.getValue().compareTo(o.getValue());
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	
	
}