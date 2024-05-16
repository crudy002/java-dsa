package test.java;

import main.java.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class ValidParenthesesTest {

    private ValidParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new ValidParentheses();
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "()[]{}", "{[()]}", "(((())))", "", "[]", "{}"})
    void testValidParentheses(String input) {
        assertTrue(solution.isValid(input), "Expected true for valid parentheses in: " + input);
    }

    
    //@ValueSource(strings = {"(]", "([)]", "(((", ")))", "{[]("})
    @ParameterizedTest
    @ValueSource(strings = {"()]", "[])", "{(])}", "()[]{})", "[({})]]", "[({})]}", "}"})
    void testInvalidParentheses(String input2) {
        assertFalse(solution.isValid(input2), "Expected false for invalid parentheses in: " + input2);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"{}", "{[]}", "{{{}}}", "{[(){}]}"})
    void testValidCurlyBraces(String input) {
        assertTrue(solution.isValid(input), "Expected true for valid input with curly braces: " + input);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"{}}", "{{}}}", "{}}{", "{[{]}{}}", "{[()]{}[{}]"})
    void testComplexInvalidCurlyBraces(String input) {
        assertFalse(solution.isValid(input), "Expected false for complex invalid curly braces in: " + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"{{{{{{{{}}}}}}}}", "{{{[{}]}}}", "{[({[{}]})]}"})
    void testComplexValidCurlyBraces(String input) {
        assertTrue(solution.isValid(input), "Expected true for complex valid curly braces in: " + input);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {
        "{[()]}{[]}",  // Nested and sequential valid
        "{[()]}",      // Nested valid inside
        "{[]}(())",    // Sequential valid separated by different types
        "{}()"        // Valid followed by valid different type  
    })
    void testComplexInterleavedCases(String input) {
        assertTrue(solution.isValid(input), "Expected true for valid interleaved cases in: " + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "{[}]}",
        "{[}]",
        "{}}}}",
        "{{{{",
        "{}}",         // Incorrect single closing brace
        "{{{}}{}",     // Properly nested but uneven groups
        "{}}{",        // Incorrect closing followed by correct sequence
        "{[}]"         // Incorrect interleaved closers
        
    })
    void testInvalidEdgeCases(String input) {
        assertFalse(solution.isValid(input), "Expected false for invalid edge cases in: " + input);
    }

	/*
	 * @Test void testNullInput() { assertThrows(NullPointerException.class, () ->
	 * solution.isValid(null), "Expected NullPointerException for null input."); }
	 */
    // This is an optional test for performance analysis, not normally included in unit tests
    // @Test
    // void testPerformance() {
    //     String largeInput = generateLargeValidInput(10000);
    //     assertTimeoutPreemptively(Duration.ofMillis(100), () -> assertTrue(solution.isValid(largeInput)));
    // }

    // Helper method for generating large valid input
    // private String generateLargeValidInput(int size) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < size; i++) {
    //         sb.append('(');
    //     }
    //     for (int i = 0; i < size; i++) {
    //         sb.append(')');
    //     }
    //     return sb.toString();
    // }
}