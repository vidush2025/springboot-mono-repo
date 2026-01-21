package com.learningSpringBoot.internalWorkingOfSpring;

import org.springframework.stereotype.Component;

@Component
public class RazorPayPaymentService {
    public  String pay(){
        String payment = "RazorPay payment";
        System.out.println("Payment done via: " + payment);
        return payment;
    }
}