package be.pxl.collections.treeset;

import java.util.TreeSet;

public class HRApp {
	public static void main(String[] args) {
		TreeSet<Employee> ourEmployees = new TreeSet<>((e1, e2) -> e1.compareto(e2));

		ourEmployees.add(new Employee("Tom", 80000));
		ourEmployees.add(new Employee("Jack", 35000));
		ourEmployees.add(new Employee("Jim", 62500));
		ourEmployees.add(new Employee("Peter", 58200));
		ourEmployees.add(new Employee("Mary", 77000));
		ourEmployees.add(new Employee("Jane", 69500));
		ourEmployees.add(new Employee("David", 54000));
		ourEmployees.add(new Employee("Sam", 82000));

		ourEmployees.stream().forEach(System.out::println);

		System.out.println("Employee with salary > 70000");
		// toon de eerste employee die meer dan 70000 heeft
		System.out.println(ourEmployees.stream().filter(e -> e.getSalary() > 70000).findFirst().get());

		// wat is de betekenis van de volgende methoden
		// geef ook telkens een voorbeeld
		// lower, ceiling, floor, tailSet, headSet, subSet

		// lower
		// Returns the greatest element in this set strictly less than the given
		// element, or null if there is no such element. How it decides which is
		// lower than the given element is based on the comparator used at
		// construction.
		// Since my .compareto function ranks employees on salary, the biggest
		// earner beneath the salary of the parameter employee is given. If that
		// employee earns 60000, Peter would be the result.
		Employee tester = new Employee("Tester", 60000);
		System.out.println(ourEmployees.lower(tester));

		// ceiling
		// Returns the least element in this set greater than or equal to the
		// given element, or null if there is no such element.
		// In other words the lowest element after or equal to the entered value
		// according to the given comparator.
		// If we use our same tester employee, the result will be Jim.
		System.out.println(ourEmployees.ceiling(tester));

		// floor
		// Returns the greatest element in this set less than or equal to the
		// given element, or null if there is no such element. Floor is the same
		// as lower except that the values could be equal.
		// With our tester employee the same result as lower will be given. An
		// employee with a salary equal to another would result in that other
		// employee, which will be Tom in our testing.
		System.out.println(ourEmployees.floor(tester));
		System.out.println(ourEmployees.floor(new Employee("tester2", 80000)));

		// tailSet
		// Returns a view of the portion of this set whose elements are greater
		// than or equal to fromElement. The returned set is backed by this set,
		// so changes in the returned set are reflected in this set, and
		// vice-versa. The returned set supports all optional set operations
		// that this set supports.
		// tailSet creates a subset with all elements that are bigger than or
		// equal to the the given parameter according to the comparator in the
		// constructor.
		// if we use our tester employee, the resulting subset will consist of
		// Jim, Jane, Mary, Tom and Sam.
		ourEmployees.tailSet(tester).forEach(System.out::println);

		// headSet
		// Returns a view of the portion of this set whose elements are strictly
		// less than toElement. The returned set is backed by this set, so
		// changes in the returned set are reflected in this set, and
		// vice-versa. The returned set supports all optional set operations
		// that this set supports.
		// Basically the opposite of tailSet, with exception that it is strictly
		// smaller, and can't be equal to. With our tester employee the subset
		// will consist of Jack, David and Peter.
		ourEmployees.headSet(tester).forEach(System.out::println);

		// subSet
		// Returns a view of the portion of this set whose elements range from
		// fromElement to toElement. If fromElement and toElement are equal, the
		// returned set is empty unless fromInclusive and toInclusive are both
		// true. The returned set is backed by this set, so changes in the
		// returned set are reflected in this set, and vice-versa. The returned
		// set supports all optional set operations that this set supports.
		// Our example will use our tester employee and tester2 defined in an
		// earlier example. This subset will consist of Jim, Jane, Mary, but
		// also Tom if we set the toInclusive boolean to true.
		ourEmployees.subSet(tester, false, new Employee("tester2", 80000), true).forEach(System.out::println);
	}
}
