package com.platzi.javaTests.payment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.platzi.javaTests.payment.PaymentResponse.*;
import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    // Now we can identify we fall in a common error of repeating parts of the code
    // So we apply the DRY paradigm and extract that code to a function
    // And mark it with the @Before annotation so this method runs before every test case
    @Before
    public void setup(){
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void testPaymentIsCorrect() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void testPaymentIsWrong() {
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}