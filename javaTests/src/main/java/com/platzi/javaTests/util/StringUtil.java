package com.platzi.javaTests.util;

public class StringUtil {

    public static String repeat(String str, int times){
        if (times<0){
            throw new IllegalArgumentException("Negative times not allowed");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static boolean isEmpty(String str){
        if (str == null){
            return true;
        }
        str = str.trim();
        return str.length() == 0;
    }
}
