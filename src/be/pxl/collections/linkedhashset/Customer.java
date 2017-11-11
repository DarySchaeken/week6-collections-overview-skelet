package be.pxl.collections.linkedhashset;

public class Customer {
    private String name;
    private int points;
    private int customerNumber;

    public String getName() {
		return name;
	}

	public Customer(int customerNumber, String name) {
        this.name = name;
        this.customerNumber = customerNumber;
        points = 0;
    }

    public int addPoints(int pointsToAdd) {
        points += pointsToAdd;
        return points;
    }

    public int getPoints() {
        return points;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerNumber != other.customerNumber)
			return false;
		return true;
	}
}
