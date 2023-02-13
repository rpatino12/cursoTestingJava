package com.platzi.javaTests.util;

public class StringUtilTest {
    public static void main(String[] args) {
        String result = StringUtil.repeat("Hello", 3);
        if (!result.equals("HelloHelloHello")){
            System.out.println("ERROR");
        }

        String result2 = StringUtil.repeat("Ricardo", 1);
        if (!result2.equals("Ricardo")){
            System.out.println("ERROR");
        }
    }
}