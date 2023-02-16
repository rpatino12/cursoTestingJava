package com.platzi.javaTests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void testRepeatOneTime() {
        assertEquals("Hello", StringUtil.repeat("Hello", 1));
    }
    @Test
    public void testRepeatMultipleTimes() {
        assertEquals("HelloHelloHello", StringUtil.repeat("Hello", 3));
    }
    @Test
    public void testRepeatZeroTimes() {
        assertEquals("", StringUtil.repeat("Hello", 0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRepeatNegativeTimes() {
        StringUtil.repeat("Hello", -1);
    }
    
    // Now we are going to test the isEmpty() method
    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtil.isEmpty("Any String"));
    }
    @Test
    public void testEmptyString() {
        assertTrue(StringUtil.isEmpty(""));
    }
    @Test
    public void testNullStringIsEmpty() {
        assertTrue(StringUtil.isEmpty(null));
    }
    @Test
    public void testStringWithSpacesIsEmpty() {
        assertTrue(StringUtil.isEmpty("    "));
    }
}