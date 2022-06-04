package ie.munnellg.interview;

public class Sum {
	public static Node sum(Node l1, Node l2) {
		Integer carry = 0;
		Node result = null;
		Node ptr    = result;

		while (l1 != null && l2 != null) {
			Integer digit = l1.digit + l2.digit + carry;
			carry = digit / 10;
			digit = digit % 10;

			if (result == null) {
				result = new Node(digit);
				ptr = result;
			} else {
				ptr.next = new Node(digit);
				ptr = ptr.next;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			ptr.next = new Node(l1.digit + carry);
			carry = 0;
			ptr = ptr.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			ptr.next = new Node(l2.digit + carry);
			carry = 0;
			ptr = ptr.next;
			l2 = l2.next;
		}

		if (carry > 0) {
			ptr.next = new Node(carry);
		}

		return result != null ? result : new Node(0);
	}

	public static Node sumForward(Node l1, Node l2) {
		if (l1 == null || l2 == null) { return new Node(0); }
		
		// start lengths at 1 because we already know there is at least
		// one node in each list, and we're going to be counting based on
		// value of Node.next
		int len1 = 1; Node p1 = l1;
		int len2 = 1; Node p2 = l2;
		while (p1.next != null) { len1++; p1 = p1.next; }
		while (p2.next != null) { len2++; p2 = p2.next; }

		// pad shorter list with leading zeroes
		int diff = len2 - len1;
		while (diff > 0) { l1 = new Node(0, l1); diff--; }
		while (diff < 0) { l2 = new Node(0, l2); diff++; }

		SumState state = sumForwardR(l1, l2);

		if (state.carry != 0) {
			state.push(0, state.carry);
		}

		return state.head;
	}

	private static SumState sumForwardR(Node l1, Node l2) {
		if (l1.next == null) {
			int digit = l1.digit + l2.digit;
			return new SumState(digit / 10, new Node(digit % 10));
		}

		SumState state = sumForwardR(l1.next, l2.next);
		int digit = l1.digit + l2.digit + state.carry;
		state.push(digit / 10, digit % 10);
		return state;
	}

	private static class SumState {
		private int carry;
		private Node head;

		public SumState(int carry, Node head) {
			this.carry = carry;
			this.head  = head;
		}

		public void push(int carry, int digit) {
			this.carry = carry;
			this.head  = new Node(digit, this.head);
		}
	}
}
