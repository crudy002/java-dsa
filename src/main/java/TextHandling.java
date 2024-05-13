package main.java;
public class TextHandling {

	public static void main(String[] args) {
		concatUsingString();
		System.out.println();
		concatUsingStringBuilder();
	}

	public static void concatUsingString() {
		
		System.out.println("The following is using the Java String Wrapper: ");

		System.out.println("\tAssign *greeting* variable...");
		String greeting = "Hello, ";
		System.out.println("\tAssign *name* variable...");
		String name = "Java Developer";
		
		System.out.println("\tConcat *greeting* with *name* variable and assign to *welcomeMessage*...");
		String welcomeMessage = greeting + name;
		
		System.out.println("\tPrint *welcomeMessage* variable...");
		System.out.println(welcomeMessage + "using String Objects");
	}
	
	public static void concatUsingStringBuilder() {
		
		System.out.println("The following is using the String Builder Class: ");

		System.out.println("\tCreate a new StringBuilder object...");
		StringBuilder sb = new StringBuilder();

		System.out.println("\tAppend greeting components to the StringBuilder...");
		sb.append("Hello, ").append("Java Developer");
		
		System.out.println("\tPrint sb product...");
		// Implicitly calls to string when printing
		//System.out.println(sb);
		
		System.out.println(sb.toString());
		
	}
}
