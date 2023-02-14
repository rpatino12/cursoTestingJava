package com.platzi.javaTests.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}