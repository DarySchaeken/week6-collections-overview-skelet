package be.pxl.collections.linkedhashset;

import java.util.LinkedHashSet;

public class LoyaltyApp {

	public static void main(String[] args) {
		LinkedHashSet<Customer> myCustomers = new LinkedHashSet<>();

		myCustomers.add(new Customer(101, "Alice"));
		myCustomers.add(new Customer(103, "Peter"));
		myCustomers.add(new Customer(105, "Tim"));
		myCustomers.add(new Customer(108, "Bea"));
		myCustomers.add(new Customer(105, "Sam"));
		myCustomers.add(new Customer(102, "Vera"));

		// Hoe zorg je ervoor dat de klantnummers uniek zijn
		// Override .equals and .hashCode

		System.out.println("Number of customers: " + myCustomers.size());

		for (Customer customer : myCustomers) {
			System.out.println(customer.getName());
		}

		// voeg nog 100 klanten toe in de lijst 201 customer1, 202 customer2,...
		for (int i = 0; i < 100; i++) {
			myCustomers.add(new Customer(100 + i, "customer" + i));
		}

		// zoek de klant met klantnummer 101 en ken 10 punten toe
		// geef klant met klantnummer 300 20 punten
		// toon ook hoeveel tijd het kost om de klanten te zoeken adhv het
		// klantnummer
		System.out.println("Time for customer number 101:");
		long startTime = System.currentTimeMillis();
		Customer customer101 = findCustomerByCustomerNumber(101, myCustomers);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime + " milliseconds.");
		customer101.addPoints(10);

		System.out.println("Time for customer number 300:");
		long startTime2 = System.currentTimeMillis();
		Customer customer300 = findCustomerByCustomerNumber(101, myCustomers);
		long endTime2 = System.currentTimeMillis();
		System.out.println(endTime2 - startTime2 + " milliseconds.");
		customer300.addPoints(20);

		// maak een lambda expressie om totaal gespaarde punten te tonen
		System.out.println(myCustomers.stream().map(Customer::getPoints)
				.reduce(0, (accumulator, element) -> accumulator + element).intValue());
	}

	private static Customer findCustomerByCustomerNumber(int customerNumber, LinkedHashSet<Customer> customers) {
		for (Customer customer : customers) {
			if (customer.getCustomerNumber() == customerNumber) {
				return customer;
			}
		}
		return null;
	}
}
