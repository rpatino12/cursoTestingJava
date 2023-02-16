package com.platzi.javaTests.exercise;

public class RomanNumerals {

    private final static String[] ROMAN_NUMERAL = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private final static int[] NUMBERS = {1000,900,500,400,100,90,50,40,10,9,5,4,1};


    public static String arabicToRoman(int num){

        if(num <= 0){
            throw new IllegalArgumentException(num + " It's not possible to convert the decimal number to roman numeral");
        }

        String roman = "";

        for (int i = 0; i < NUMBERS.length; i++) {
            while(num >= NUMBERS[i]){
                roman += ROMAN_NUMERAL[i];
                num -= NUMBERS[i];
            }
        }
        return roman;
    }
}
