package be.pxl.collections.priorityqueue;

public class Customer {
	private String name;
	private int points;
	private int customerNumber;

	public Customer(int customerNumber, String name) {
		this.name = name;
		this.customerNumber = customerNumber;
		points = 0;
	}

	public int addPoints(int pointsToAdd) {
		points += pointsToAdd;
		return points;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	@Override
	public String toString() {
		return name;
	}

	public int compareTo(Customer other) {
		if (this.getPoints() > other.getPoints()) {
			return -1;
		} else if (this.getPoints() < other.getPoints()) {
			return 1;
		}
		return 0;
	}
}
