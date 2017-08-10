package CollectionInJava;

public class Employee {
	String name, designation;
	int salary;
	public Employee(String name, String designation, int salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String toString(){
		  return " Name is : "+name+"\n Designation is:"+ designation+"\n Salary is:"+salary+"\n";
	  }

}
