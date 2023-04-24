package com.solvd.deliveryservice.payment;

public class Processing {
    private long cardNumber;
    private Invoice invoice;

    public Processing(long cardNumber, Invoice invoice) {
        if(cardChecker(cardNumber)) {
            this.cardNumber = cardNumber;
        }else {
            System.out.println("Please provide valid credit card");
        }
        this.invoice = invoice;
    }

    private boolean cardChecker(long cardNumber) {
        int cardNumberLength = Long.toString(cardNumber).length();
        if (cardNumberLength == 16) {
            return true;
        } else {
            return false;
        }
    }

    public void processPayment() {
        invoice.setPaid(true);
        System.out.println("Thank you for your payment");
    }
}
