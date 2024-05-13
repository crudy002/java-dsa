package test.java;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import main.java.ValidParentheses;

class ValidParenthesesTest {

    private ValidParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new ValidParentheses();
    }

    @ParameterizedTest
    @ValueSource(strings = {"()", "()[]{}", "{[()]}", "(((())))", ""})
    void testValidParentheses(String input) {
        assertTrue(solution.isValid(input), "Expected true for valid parentheses in: " + input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(]", "([)]", "(((", ")))", "{[]("})
    void testInvalidParentheses(String input) {
        assertFalse(solution.isValid(input), "Expected false for invalid parentheses in: " + input);
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> solution.isValid(null), "Expected NullPointerException for null input.");
    }

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