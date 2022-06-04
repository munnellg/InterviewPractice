package ie.munnellg.interview;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	
	// O(N)
	public static <T> Node<T> removeDuplicates(Node<T> head) {
		if (head == null) {
			return head;
		}
		
		Set<T> seen = new HashSet<T>();
		Node<T> curr = head;

		while (curr.getNext() != null) {
			seen.add(curr.getData());
			Node next = curr.getNext();

			if (seen.contains(next.getData())) {
				curr.setNext(next.getNext());
			} else {
				curr = next;	
			}
		}
		
		return head;
	}

	// O(N^2)
	public static <T> Node<T> removeDuplicatesNoBuffer(Node<T> head) {
		if (head == null) {
			return head;
		}

		Node p1 = head;

		while (p1 != null) {
			Node p2 = p1;
			
			while (p2.getNext() != null) {
				Node next = p2.getNext();

				if (p1.getData().equals(next.getData())) {
					p2.setNext(next.getNext());
				} else {
					p2 = next;	
				}
			}

			p1 = p1.getNext();
		}

		return head;
	}
}
