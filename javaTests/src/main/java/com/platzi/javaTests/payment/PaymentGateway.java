package com.platzi.javaTests.payment;
// Here we create an interface because, we don't have the implementation of the PaymentGateway class
// Usually you get the gateway for payments from a library
public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
