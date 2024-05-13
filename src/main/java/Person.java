package main.java;

public class Person {
	
	private String name;
	private int age;
	
	public static void main(String args[]) {
		Person person = new Person("Charles", 15);
		Person person2 = new Person("Nate", 21);
		
		
		System.out.println(person);
		String person2String = person2.toString();
		System.out.println(person2String);
	}
	
	public Person(String nameInput, int ageInput) {
		name = nameInput;
		age = ageInput;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// This overrides the inherent java object toString method
	// which normally just prints the name of the class and id of the instance
	public String toString() {
		return "This person is named: " + "\"" + this.name + "\" and is " + this.age + " year(s) old!";
	}

}
