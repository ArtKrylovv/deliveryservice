package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.order.Order;

import java.util.Arrays;
import java.util.HashMap;

public class Invoice {
    public static float SALES_TAX = 0.10F;
    private float totalPriceBeforeTax;
    private float taxAmount;
    private float totalAfterTax;
    private boolean paid;

    public Invoice(Price price) {
        this.totalPriceBeforeTax = price.getTotalPrice();
        this.taxAmount = calculateTaxAmount(price.hashCode());
        this.totalAfterTax =totalPriceBeforeTax+taxAmount;
        this.paid = false;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public float getTotalPriceBeforeTax() {
        return totalPriceBeforeTax;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public float getTotalAfterTax() {
        return totalAfterTax;
    }

    public boolean isPaid() {
        return paid;
    }

    private float calculateTaxAmount(float totalAfterBeforeTax) {
        return totalAfterBeforeTax*SALES_TAX;
    }

    public HashMap<String, Object> generateInvoice (Order order) {
        HashMap<String, Object> invoice = new HashMap<>();
        invoice.put("price before tax", getTotalPriceBeforeTax());
        invoice.put("tax amount", getTaxAmount());
        invoice.put("total after tax", getTotalAfterTax());
        invoice.put("paid", isPaid());
        // polymorphism in getFullAddress()
        invoice.put("customer address", Arrays.toString(order.getAddress().getFullAddress()));
        return invoice;
    }
}
