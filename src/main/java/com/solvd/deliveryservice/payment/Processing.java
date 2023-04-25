package com.solvd.deliveryservice.payment;

public class Processing {

    private static boolean cardChecker(long cardNumber) {
        int cardNumberLength = Long.toString(cardNumber).length();
        return cardNumberLength == 16;
    }

    public static void processPayment(long cardNumber, Invoice invoice) {
        if (cardChecker(cardNumber)) {
            invoice.setPaid(true);
            System.out.println("Thank you for your payment");
        } else {
            System.out.println("Please provide valid credit card");
        }
    }
}
