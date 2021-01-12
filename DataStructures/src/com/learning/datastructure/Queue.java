package com.learning.datastructure;

public class Queue<T> {
	private T[] arr;
	private int front;
	private int rear;
	private int capacity;	// maximum capacity of the queue
	private int count;		// current of the queue
	
	@SuppressWarnings("unchecked")
	//constructor to initialize queue
	Queue(int size){
		arr = (T[]) new Object [size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;		
	}
	
	 // Utility function to remove front element from the queue
    public void dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Removing " + arr[front]);
 
        front = (front + 1) % capacity;
        count--;
    }
    
    // Utility function to add an item to the queue
    public void enqueue(T item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("OverFlow\nProgram Terminated");
            System.exit(1);
        }
 
        System.out.println("Inserting " + item);
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // Utility function to check if the queue is full or not
    public Boolean isFull()
    {
        return (size() == capacity);
    }
    
    // Utility function to return the size of the queue
    public int size()
    {
        return count;
    }
    
    // Utility function to check if the queue is empty or not
    public Boolean isEmpty()
    {
        return (size() == 0);
    }
    
    // Utility function to return front element in the queue
    public T peek()
    {
        if (isEmpty()) 
        {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }
        return arr[front];
    }
    
 // Queue implementation in java
    public static void main (String[] args)
    {
        // create a queue of capacity 5
        Queue q = new Queue(5);
 
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        
        System.out.println("Front element is: " + q.peek());
        q.dequeue();
        System.out.println("Front element is: " + q.peek());
 
        System.out.println("Queue size is " + q.size());
 
        q.dequeue();
        q.dequeue();
        
        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");
    }
}
