package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年7月27日下午3:59:18
*/
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;
	public Employee(String name, String dept, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.subordinates = new ArrayList<Employee>();
	}
	
	public void add(Employee e){
		this.subordinates.add(e);
	}
	
	public void remove(Employee e){
		this.subordinates.remove(e);
	}
	public List<Employee> getSubordinates(){
		return this.subordinates;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
}
