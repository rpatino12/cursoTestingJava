package com.platzi.javaTests.payment;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        // We have to get the response of the payment gateway
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        // And if the response it's "OK" return true and for other responses return false
        if (response.getStatus() == PaymentResponse.PaymentStatus.OK){
            return true;
        }else{
            return false;
        }
    }
}
