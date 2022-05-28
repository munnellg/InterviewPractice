package ie.munnellg.interview;

public class Pair<T, V> {
	
	private final T first;
	private final V second;
	
	public Pair(T first, V second) {
		this.first  = first;
		this.second = second;
	}

	public T getFirst() {
		return this.first;
	}

	public V getSecond() {
		return this.second;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append("Pair(")
			.append("first = ").append(first).append(", ")
			.append("second = ").append(second)
			.append(")")
			.toString();
	}

	protected boolean canEqual(Object other) {
		return other instanceof Pair;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) { return true; }
		if (!(o instanceof Pair)) return false;
		Pair<T,V> other = (Pair<T,V>) o;
		if (!other.canEqual((Object) this)) return false;
		if (this.getFirst() == null? other.getFirst() != null : !this.getFirst().equals(other.getFirst())) { return false; }
		if (this.getSecond() == null? other.getSecond() != null : !this.getSecond().equals(other.getSecond())) { return false; }
		return true;
	}
}