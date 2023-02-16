package com.platzi.javaTests.payment;

import org.junit.Test;
import org.mockito.Mockito;

import static com.platzi.javaTests.payment.PaymentResponse.*;
import static org.junit.Assert.*;

public class PaymentProcessorTest {
    @Test
    public void testPaymentIsCorrect() {
        // We cannot create a payment gateway because we don't have the implementation
        // So we are going to simulate it with mockito
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        // And we are going to simulate that the gateway is going to return an "OK" response, with any request
        // So we used Mockito.any to simulate any request, and thenReturn to simulate an "OK" response
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentStatus.OK));

        // And then we pass the mocked PaymentGateway to the processor
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        // We are going to check if my payment processor is working correctly
        // So we are going to validate that the result of the method makePayment() is true, so the payment is correct
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void testPaymentIsWrong() {
        // Here we can see the three parts for a typical test case:
        // 1. Preparation for the test (Declare the objects needed)
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        Mockito.when(paymentGateway.requestPayment(Mockito.any())).
                thenReturn(new PaymentResponse(PaymentStatus.ERROR));
        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

        // 2. Call the method that we want to test
        boolean result = paymentProcessor.makePayment(1000);

        // 3. Check the expected result
        assertFalse(result);
    }
}