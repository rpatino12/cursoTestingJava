package com.platzi.javaTests.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtilTest {
    @Test
    public void testRepeat() {
        // Now using junit4 we can create a Unit testing easily
        // The method assertEquals of the class Assert for junit has the parameters (expected, actual)
        assertEquals("HelloHelloHello", StringUtil.repeat("Hello", 3));
        assertEquals("Ricardo", StringUtil.repeat("Ricardo", 1));
    }
}