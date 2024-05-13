package main.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
    	
    	List<List<String>> result = new ArrayList<>();
    	List<String> temp;
        
        HashMap<String, List<String>> groups = new HashMap<>();
        
        // iterate through the list of strings
        for (String str : strs) {
        	
            // Sort the characters in the string to use as a key for the HashMap
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            if (groups.get(sortedStr) == null) {
            	temp = new ArrayList<>();
            	temp.add(str);
            	groups.put(sortedStr, temp);
            }
            else {
            	groups.get(sortedStr).add(str);
            }
        }
        
        result = new ArrayList<>(groups.values());
        
        return result;
    	
    }

    public static void main(String[] args) {
        AnagramGrouping solution = new AnagramGrouping();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}