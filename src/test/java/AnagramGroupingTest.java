package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.AnagramGrouping;

class AnagramGroupingTest {

    private AnagramGrouping solution;
    private String[] strs;

    @BeforeEach
    void setUp() {
        solution = new AnagramGrouping();
        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    }

    @Test
    void testGroupAnagrams() {
        List<List<String>> expected = Arrays.asList(
            Arrays.asList("eat", "tea", "ate"),
            Arrays.asList("tan", "nat"),
            Arrays.asList("bat")
        );
        List<List<String>> result = solution.groupAnagrams(strs);
        assertEquals(expected.size(), result.size(), "Should have the same number of groups");

        // Add more sophisticated checks here, perhaps comparing sorted versions of each group
    }

    @Test
    void testEmptyInput() {
        assertEquals(0, solution.groupAnagrams(new String[]{}).size(), "Empty input should result in empty output");
    }

    @Test
    void testNoAnagram() {
        String[] input = new String[]{"cat", "dog", "bird"};
        List<List<String>> result = solution.groupAnagrams(input);
        assertEquals(input.length, result.size(), "Each string should be in its own group when there are no anagrams");
    }
}
