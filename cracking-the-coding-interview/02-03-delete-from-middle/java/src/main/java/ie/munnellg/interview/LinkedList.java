package ie.munnellg.interview;

import java.util.Iterator;

public class LinkedList {
	public static void delete(Node n) {
		if (n == null)      { return; }
		if (n.next == null) { return; }

		n.data = n.next.data;
		n.next = n.next.next;
	}
}
