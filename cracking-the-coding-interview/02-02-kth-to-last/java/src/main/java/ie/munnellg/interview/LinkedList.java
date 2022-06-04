package ie.munnellg.interview;

public class LinkedList {
	private static class Distance<T> {
		public int index;
		public T data;
		public Distance(int index, T data) {
			this.index = index;
			this.data = data;
		}
		@Override
		public String toString() {
			return new StringBuilder("Distance(")
				.append("index = ").append(index).append(", ")
				.append("data = ").append(data)
				.append(")").toString();
		}
	}

	public static <T> T findKthToLast(Node<T> head, int k) {
		if (head == null) { throw new NullPointerException("Head cannot be null"); }
		return ((Distance<T>) LinkedList.find(head, 0, k)).data;
	}

	public static <T> Distance<T> find(Node<T> node, int current, int k) {
		if (node.next == null) {
			return new Distance(0, node.data);
		}

		Distance<T> nextDistance = find(node.next, current + 1, k);

		if (nextDistance.index == k) {
			return nextDistance;
		} else {
			return new Distance(nextDistance.index + 1, node.data);
		}
	}
}