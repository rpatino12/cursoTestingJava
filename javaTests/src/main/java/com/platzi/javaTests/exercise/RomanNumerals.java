package com.platzi.javaTests.exercise;

public class RomanNumerals {

    public static String arabicToRoman(int number){
        int i, thousands, hundreds, tens, ones;
        String roman = "";

        // Divide the number in units
        thousands = number / 1000;
        hundreds = number / 100 % 10;
        tens = number / 10 % 10;
        ones = number % 10;

        // Thousands
        for (i = 1; i <= thousands; i++) {
            roman += "M";
        }

        // Hundreds
        if (hundreds == 9) {
            roman += "CM";
        } else if (hundreds >= 5) {
            roman += "D";
            for (i = 6; i <= hundreds; i++) {
                roman += "C";
            }
        } else if (hundreds == 4) {
            roman += "CD";
        } else {
            for (i = 1; i <= hundreds; i++) {
                roman += "C";
            }
        }

        // Tens
        if (tens == 9) {
            roman += "XC";
        } else if (tens >= 5) {
            roman += "L";
            for (i = 6; i <= tens; i++) {
                roman += "X";
            }
        } else if (tens == 4) {
            roman += "XL";
        } else {
            for (i = 1; i <= tens; i++) {
                roman += "X";
            }
        }

        // Ones
        if (ones == 9) {
            roman += "IX";
        } else if (ones >= 5) {
            roman += "V";
            for (i = 6; i <= ones; i++) {
                roman += "I";
            }
        } else if (ones == 4) {
            roman += "IV";
        } else {
            for (i = 1; i <= ones; i++) {
                roman += "I";
            }
        }
        return roman;
    }
}
