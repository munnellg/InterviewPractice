package ie.munnellg.interview;

public class LinkedList {
	public static <T> Node<T> findIntersection(Node<T> l1, Node<T> l2) {
		// base case - empty lists do not intersect
		if (l1 == null || l2 == null) { return null; }
		
		// start lengths at 1 because we already know there is at least
		// one node in each list, and we're going to be counting based on
		// value of Node.next
		int len1 = 1; Node<T> p1 = l1;
		int len2 = 1; Node<T> p2 = l2;
		while (p1.next != null) { len1++; p1 = p1.next; }
		while (p2.next != null) { len2++; p2 = p2.next; }

		// Both pointers are now at tails. If tails are not equal, lists don't intersect
		if (p1 != p2) { return null; }

		// advance list heads by difference in length 
		int diff = len1 - len2;
		while (diff > 0) { l1 = l1.next; diff--; }
		while (diff < 0) { l2 = l2.next; diff++; }

		// now traverse lists in parallel to find point of intersection
		while (l1 != l2) {
			l1 = l1.next; l2 = l2.next;
		}

		return l1;
	}
}
