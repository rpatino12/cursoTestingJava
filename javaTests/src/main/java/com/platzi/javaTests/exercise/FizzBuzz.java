package com.platzi.javaTests.exercise;

public class FizzBuzz {

    public static String fizzBuzz(int num) {
        String result = "";
        if (num % 3 == 0) result += "Fizz";
        if (num % 5 == 0) result += "Buzz";
        return result.isEmpty() ? String.valueOf(num) : result;
    }
}
