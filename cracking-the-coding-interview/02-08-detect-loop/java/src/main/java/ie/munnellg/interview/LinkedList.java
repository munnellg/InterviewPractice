package ie.munnellg.interview;

public class LinkedList {
	public static boolean containsLoop(Node list) {
		Node slow = list;
		Node fast = list;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static Node findLoop(Node list) {
		Node slow = list;
		Node fast = list;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (fast == null || slow == null) {
			return null;
		}

		while (list != slow) {
			slow = slow.next;
			list = list.next;
		}

		return list;
	}
}
