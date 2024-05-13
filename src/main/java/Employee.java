package main.java;
public class Employee extends Person{
	
	public static void main(String args[]) {
		Employee emp1 = new Employee("Charles", 15, "1234");
		Employee emp2 = new Employee("Nate", 21, "5678");
		
		System.out.println(emp1);
		String person2String = emp2.toString();
		System.out.println();
		System.out.println(person2String);
	}
	
	
	String employeeId;
	
	public Employee(String nameInput, int ageInput, String employeeIdIn) {
		super(nameInput, ageInput);
		employeeId = employeeIdIn;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	// This overrides the inherent java object toString method
	// which normally just prints the name of the class and id of the instance
	@Override
	public String toString() {
		return "This Person is an Employee\nTheir name is: " + 
				"\"" + 
				super.getName() + 
				"\"\nThey are " + 
				super.getAge() + 
				" year(s) old\n" +
				"and their employeeId is: " +
				this.employeeId;
	}

}
