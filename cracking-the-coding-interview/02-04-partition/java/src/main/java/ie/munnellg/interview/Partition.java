package ie.munnellg.interview;

public class Partition<T extends Comparable> {
	public Node<T> left;
	public Node<T> right;
	
	public Partition() {
		left  = null;
		right = null;
	}

	public static <T extends Comparable> Partition<T> of(Node<T> head, T pivot) {
		Partition<T> result = new Partition();
		Node<T> ptr = head;

		Node<T> pl = null;
		Node<T> pr = null;

		while (ptr != null) {
			if (ptr.data.compareTo(pivot) < 0) {
				if (result.right == null) {
					result.right = ptr;
					pr = result.right;
				} else {
					pr.next = ptr;
					pr = pr.next;
				}
			} else {
				if (result.left == null) {
					result.left = ptr;
					pl = result.left;
				} else {
					pl.next = ptr;
					pl = pl.next;
				}
			}

			ptr = ptr.next;
		}

		return result;
	}
}
