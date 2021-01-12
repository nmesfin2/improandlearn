package com.learning.datastructure;

public class StackArray<T> {
	private T[] array;
	private int counter;
	private int size;
	private int top;
	
	public StackArray(int size) {
		array = (T[]) new Object [size];
		top = -1;
		size = 0;
		counter = 0;
	}
	
	public boolean push(T val) {
		try {
			top++;
			array[top] = val;
			size++;
			counter++;
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}
	
	public T pull() {
		try {
			T t = array[top];
			top--;
			size--;
			counter--;
			return t;
			
		}catch (Exception ex) {
			return null;
		}
	}
	
	public int size() {
		return size;
	}
	
	public T peek() {
		try {
			if (isEmpty()) {
				System.out.println("UnderFlow\nProgram Terminated");
				System.exit(1);
			}
			return array[top];
		}catch(Exception ex) {
			return null;
		}
	}
	
	public Boolean isFull()
    {
        return (size() == size);
    }
	
	public Boolean isEmpty()
    {
        return (size() == 0);
    }
	
	public static void main (String[] args)
    {
        // create a queue of capacity 5
        StackArray s = new StackArray(5);
 
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println("Top element is: " + s.peek());
        s.pull();
        System.out.println("Top element is: " + s.peek());
 
        System.out.println("Stack size is " + s.size());
 
        s.pull();
        //s.pull();
        System.out.println("Top element is: " + s.peek());
        
        if (s.isEmpty())
            System.out.println("Top Is Empty");
        else
            System.out.println("Top Is Not Empty");
    }
}
