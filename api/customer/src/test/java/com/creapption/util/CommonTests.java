package com.creapption.util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class CommonTests {

    @Test
    void givenDigits_whenCalculateModule11_thenReturnModule11(){
        var digits = "1234";
        var module11 = Common.getModule11(digits);
        var expectedModule11 = 3;
        assertEquals(String.format("The module 11 for %s", digits), expectedModule11, module11);
    }
}
