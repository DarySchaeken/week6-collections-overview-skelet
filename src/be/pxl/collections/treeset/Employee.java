package be.pxl.collections.treeset;

public class Employee{
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + salary;
    }
    
    public int compareto(Employee e){
		if(this.getSalary() > e.getSalary()){
			return 1;
		} else if (this.getSalary() < e.getSalary()) {
			return -1;
		}
		return 0;
    }
}
