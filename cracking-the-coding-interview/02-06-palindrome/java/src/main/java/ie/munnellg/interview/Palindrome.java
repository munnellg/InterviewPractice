package ie.munnellg.interview;

import java.util.Stack;

public class Palindrome {
	public static boolean isPalindrome(Node head) {
		Stack<Node> stack = new Stack();

		Node slow = head;
		Node fast = head;

		// find midpoint of list and push first half of stack to list
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			stack.push(slow);
			slow = slow.next;
		}

		// if the list is of odd length, middle element doesn't matter
		if (fast != null) {
			slow = slow.next;
		}

		// compare second half of list to first
		while (slow != null && !stack.empty()) {
			Node p = stack.pop();

			if (!p.data.equals(slow.data)) {
				return false;
			}

			slow = slow.next;
		}

		return true;
	}

	public static boolean destructiveIsPalindrome(Node head) {
		Node prev = null;
        Node slow = head;
        Node fast = head;
                
        while (fast != null && fast.next != null) {            
            // race to the end of the list so we know
            // when slow is at the midway point
            fast = fast.next.next;
            
            // turn the first half of the linked list around
            // so that it points backwards
            Node tmp = slow.next;
            slow.next    = prev;
            prev         = slow;
            slow         = tmp;
        }
        
        Node p1 = prev;
        Node p2 = slow;
        
        if (fast != null && p2 != null) {
            p2 = p2.next;
        }
        
        while (p1 != null && p2 != null) {
            if (!p1.data.equals(p2.data)) {
                return false;
            }
            
            p1 = p1.next;
            p2 = p2.next;
        }
                        
        return p1 == p2 && p2 == null;
	}
}
