package com.task.exercise12;

import com.task.exercise12.*;
public class CurrencyConverter {
    public String processPayment(Payment payment, Currency currency){
        return switch(currency){
            case USD usd -> String.format("Converting %.2f %s to USD",payment.amount(),payment.currency());
            case EUD eud -> String.format("Converting %.2f %s to EUD",payment.amount(),payment.currency());
            case GBP gbp -> String.format("Converting %.2f %s to GBP",payment.amount(),payment.currency());
        };
    }

    public static void main(String[] arg){
        Payment payment = new Payment(10,"USD");
        String result = new CurrencyConverter().processPayment(payment,new GBP());
        System.out.println(result);
    }
}
