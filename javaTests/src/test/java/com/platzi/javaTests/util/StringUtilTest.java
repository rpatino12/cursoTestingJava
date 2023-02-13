package com.platzi.javaTests.util;

public class StringUtilTest {
    public static void main(String[] args) {
        // Now we are going to create what is called a Unit testing without using junit
        // Here we are going to create a function to test the function repeat()
        String result = StringUtil.repeat("Hello", 3);
        assertEquals(result, "HelloHelloHello");

        assertEquals(StringUtil.repeat("Ricardo", 1), "Ricardo");
    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal to expected: " + expected);
        }
    }
}