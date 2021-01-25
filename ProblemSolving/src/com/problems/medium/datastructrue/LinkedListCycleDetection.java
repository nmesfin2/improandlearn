package com.problems.medium.datastructrue;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {
	public static void main(String [] args) {
		
	}
	
    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> linkedListSet = new HashSet<SinglyLinkedListNode>();
        if(head == null){
            return false;
        }
        return hasCycleHelper(head, linkedListSet);
    }

    static boolean hasCycleHelper(SinglyLinkedListNode current, Set<SinglyLinkedListNode> linkedListSet){
        
        
        while(current != null){

            if(!linkedListSet.contains(current)){

                linkedListSet.add(current);   
                            


            }else{
                return true;
            }
            return hasCycleHelper(current.next, linkedListSet);
        }
        
        return false;
    }
}

class SinglyLinkedListNode{
	int data;
	SinglyLinkedListNode next;
}
