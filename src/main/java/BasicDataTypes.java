package main.java;
public class BasicDataTypes {

	public static void main(String[] args) {
		// demoBasicDataTypes();
		// demoDifferenceInPrimNums();
		// System.out.println();
		demoDifferenceInPrimPointNums();

	}

	public static void demoBasicDataTypes() {
		// Primitive data types

		// Primitive integer types
		byte byteNumber = 10;
		int number = 10;
		short shortNumber = 10;
		long longNumber = 10;

		// Primitive decimal types
		float floatNumber = 5.5f;
		double decimalNumber = 5.5;

		// Primitive boolean
		boolean isJavaFun = true;

		// Using operators
		int sum = byteNumber + shortNumber + number + 5;
		// int sum2 = longNumber + sum; // cannot convert from long to int
		long sum2 = longNumber + sum;
		// float division = decimalNumber / 2 * floatNumber; // cannot convert from
		// double to float
		double division = decimalNumber / 2 * floatNumber;
		boolean notJavaFun = !isJavaFun;

		// Output results
		System.out.println("Sum(s): " + sum + "; " + sum2);
		System.out.println("Division: " + division);
		System.out.println("Is Java fun? " + isJavaFun);
		System.out.println("Is Java not fun? " + notJavaFun);
	}

	public static void demoDifferenceInPrimNums() {

		// Declaration and initialization
		byte byteValue = 127; // maximum value of byte
		short shortValue = 127;
		short shortValue2 = 32767; // maximum value of short
		int intValue = 2147483647; // maximum value of int
		long longValue = 9223372036854775807L; // maximum value of long

		System.out.println("--- Original Values ---");
		System.out.println("byte value: " + byteValue);
		System.out.println("short value 1 (not max): " + shortValue);
		System.out.println("short value 2 (at max): " + shortValue2);
		System.out.println("int value: " + intValue);
		System.out.println("long value: " + longValue);

		// Trying to increment beyond their maximum values
		System.out.println("\n*** Adding 1 to all values... ***"); // And this overflows
		byteValue++;
		shortValue++;
		shortValue2++;
		intValue++;
		longValue++;

		// Output the values after incrementing
		System.out.println("\n--- Incremented Values ---");
		System.out.println("byte value: " + byteValue); // This will overflow and start from the minimum value
		System.out.println("short value 1: " + shortValue); // This won't overflow
		System.out.println("short value 2: " + shortValue2); // This will overflow as well
		System.out.println("int value: " + intValue); // This overflows too
		System.out.println("long value: " + longValue); // And this overflows

		// Displaying their sizes in bytes
		System.out.println("\n--- Values by BYTE Count ---");
		System.out.println("Byte size: " + Byte.BYTES + " bytes");
		System.out.println("Short size: " + Short.BYTES + " bytes");
		System.out.println("Int size: " + Integer.BYTES + " bytes");
		System.out.println("Long size: " + Long.BYTES + " bytes");

	}

	public static void demoDifferenceInPrimPointNums() {
		// Declaration and initialization
		float floatValue = 3.4028235E38f; // maximum value of float
		double doubleValue = 1.7976931348623157E308; // maximum value of double

		System.out.println("--- Original Values ---");
		System.out.println("float value: " + floatValue);
		System.out.println("double value: " + doubleValue);

		// Attempting to add a large value to both
		System.out.println("\n*** Adding 1E10 to both values... ***");
		floatValue += 1E10;
		doubleValue += 1E10;

		// Output the values after adding a large number
		System.out.println("\n--- Updated Values ---");
		System.out.println("float value: " + floatValue); // This might not change due to precision limits
		System.out.println("double value: " + doubleValue); // Likely to show an increase

		// Displaying their sizes and precision details
		System.out.println("\n--- Precision and Size ---");
		System.out.println("Float size: " + Float.BYTES + " bytes");
		System.out.println("Double size: " + Double.BYTES + " bytes");

		// Resetting values to 1.0 for precision test
		floatValue = 1.0f;
		doubleValue = 1.0;

		// Adding very small values
		System.out.println("\n*** Adding very small values... ***");
		floatValue += 1E-40;
		doubleValue += 1E-40;

		// Output the values after adding a very small number
		System.out.println("\n--- Precision Test ---");
		System.out.println("float value (after small addition): " + floatValue); // Likely unchanged due to precision
		System.out.println("double value (after small addition): " + doubleValue); // Shows increased precision
	}

}
