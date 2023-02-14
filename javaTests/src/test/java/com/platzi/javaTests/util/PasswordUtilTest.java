package com.platzi.javaTests.util;

import org.junit.Test;

import static com.platzi.javaTests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Characters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abc12!"));
    }

    @Test
    public void weakWhenHasOnlyNumbers() {
        assertEquals(WEAK, PasswordUtil.assessPassword("0123456789"));
    }

    @Test
    public void weakWhenHasOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void mediumWhenHasNumbersAndLetters() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strongWhenHasNumbersLettersAndSymbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd1234!"));
    }

}