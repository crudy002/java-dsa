package com.ruediger.java.strings;

import java.util.HashMap;
import java.util.Map;

public class SubString {
	public static int longestSubstringWithoutRepeatingChars(String s) {
	    if (s == null) {
	        return 0;
	    }
	    
	    Map<Character, Integer> charIndexMap = new HashMap<>();
	    int maxCount = 0;
	    int count = 0;
	    
        for (int index = 0; index < s.length(); index++) {    
        	
        	if (charIndexMap.get(s.charAt(index)) != null) {
        		maxCount = Math.max(maxCount, count);
        		count = 0;
        	}
        	
        	// at each encountered character add it at the char index map
        	charIndexMap.put(s.charAt(index), index);
        	count++;
        	
        	
        }
		return maxCount;
	}

	public static void main(String[] args) {
	    String input = "abcabcbb";
	    int longestSubstring = longestSubstringWithoutRepeatingChars(input);
	    System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring);
	}



}
