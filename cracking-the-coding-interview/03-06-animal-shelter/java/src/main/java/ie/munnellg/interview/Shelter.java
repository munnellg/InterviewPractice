package ie.munnellg.interview;

import java.util.LinkedList;

public class Shelter {
	LinkedList<Cat> cats;
	LinkedList<Dog> dogs;

	public Shelter() {
		this.cats = new LinkedList<>();
		this.dogs = new LinkedList<>();
	}

	public void enqueue(Dog dog) {
		dog.number = nextNumber();
		this.dogs.addFirst(dog);
	}

	public void enqueue(Cat cat) {
		cat.number = nextNumber();
		this.cats.addFirst(cat);
	}

	public Animal dequeueAny() {
		int n1 = (dogs.size() <= 0)? 0 : dogs.peekLast().number;
		int n2 = (cats.size() <= 0)? 0 : cats.peekLast().number;

		if (n1 > n2) {
			return dogs.pollLast();
		}

		return cats.pollLast();
	}

	public Dog dequeueDog() {
		return dogs.pollLast();
	}

	public Cat dequeueCat() {
		return cats.pollLast();
	}

	private int nextNumber() {
		int n1 = (dogs.size() <= 0)? 0 : dogs.peekFirst().number;
		int n2 = (cats.size() <= 0)? 0 : cats.peekFirst().number;
		return Math.max(n1, n2) + 1;
	}

	private int newestNumber(LinkedList<Animal> l) {
		return l.size() <= 0 ? 0 : l.peek().number;
	}

	public static abstract class Animal {
		protected String name;
		protected int number;

		protected Animal(String name) {
			this.name   = name;
			this.number = 0;
		}
	}

	public static class Dog extends Animal {
		public Dog(String name) {
			super(name);
		}

		@Override
		public String toString() {
			return new StringBuilder("Dog(")
				.append("number = ").append(this.number).append(", ")
				.append("name = ").append(this.name)
				.append(")")
				.toString();
		}
	}

	public static class Cat extends Animal {
		public Cat(String name) {
			super(name);
		}

		@Override
		public String toString() {
			return new StringBuilder("Cat(")
				.append("number = ").append(this.number).append(", ")
				.append("name = ").append(this.name)
				.append(")")
				.toString();
		}
	}
}
