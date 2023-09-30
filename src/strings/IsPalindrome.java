package strings;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class IsPalindrome {

	public static void main(String[] args) {

		/*
		 * A phrase is a palindrome if, after converting all uppercase letters into
		 * lowercase letters and removing all non-alphanumeric characters, it reads the
		 * same forward and backward. Alphanumeric characters include letters and
		 * numbers.
		 * 
		 * Given a string s, return true if it is a palindrome, or false otherwise.
		 * 
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
		 * "amanaplanacanalpanama" is a palindrome. Example 2:
		 * 
		 * Input: s = "race a car" Output: false Explanation: "raceacar" is not a
		 * palindrome. Example 3:
		 * 
		 * Input: s = " " Output: true Explanation: s is an empty string "" after
		 * removing non-alphanumeric characters. Since an empty string reads the same
		 * forward and backward, it is a palindrome.
		 */


		
		
		boolean result;
		var str1 = "A man, a plan, a canal: Panama";
		result = isPalindrome(str1);
		printResult(result);
		
		var str2 = "race a car";
		result = isPalindrome(str2);
		printResult(result);
		
		var str3 = " ";
		result = isPalindrome(str3);
		printResult(result);
		

		
	
	}
	
	public static void printResult(boolean result) {
		if (result) {
			System.out.println("Is a Palindrome\n");
		}
		else {
			System.out.println("Is NOT a Palindrome\n");
		}
	}

	public static boolean isPalindrome(String s) {
		
		// convert all letters to lowercase
		//var lowerS = s.toLowerCase();
		
		// remove all alphanumeric characters
		var nonAlphanumericText = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println("Input: " + s);
		System.out.println("After Conversion: " + nonAlphanumericText);
		
		var charArray = nonAlphanumericText.toCharArray();
		var reverseIndex = charArray.length-1;
		for (var forwardIncex = 0; forwardIncex < charArray.length; forwardIncex++) {
			
			if (!(Character.toLowerCase(charArray[forwardIncex]) == Character.toLowerCase(charArray[reverseIndex]))) {
				return false;
			}
			
			reverseIndex--;
		}
		
		
		return true;
	}

}
