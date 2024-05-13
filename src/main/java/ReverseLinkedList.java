package main.java;
import java.util.Stack;

public class ReverseLinkedList {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        // TODO: Implement the reverseList method
    	ListNode curNode = head;
    	
    	Stack<ListNode> encounteredNodes = new Stack<>();
    	
    	while (curNode != null) {
    		encounteredNodes.push(curNode);
    		
    		curNode = curNode.next;
    	}
    	
    	if (encounteredNodes.isEmpty() == false) {
    		head = encounteredNodes.peek();
    	}
    	else {
    		head = null;
    	}
    	
    	while (encounteredNodes.isEmpty() == false) {
    		curNode = encounteredNodes.pop();
    		if (encounteredNodes.isEmpty() == false) 
    			curNode.next = encounteredNodes.peek();
    		else 
    			curNode.next = null;
    		
    		
    	}
    	
    	
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test cases
        ListNode list1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Original list: ");
        printLinkedList(list1);
        ListNode reversed1 = solution.reverseList(list1);
        System.out.print("Reversed list: ");
        printLinkedList(reversed1);

        ListNode list2 = createLinkedList(new int[]{5, 4, 3, 2, 1});
        System.out.print("Original list: ");
        printLinkedList(list2);
        ListNode reversed2 = solution.reverseList(list2);
        System.out.print("Reversed list: ");
        printLinkedList(reversed2);
    }

    // Utility method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Utility method to print a linked list
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

