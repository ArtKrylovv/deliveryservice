package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.utilities.Utilities;

import java.util.*;

public class Invoice implements Document {
    public static float SALES_TAX = 0.10F;
    private float totalPriceBeforeTax;
    private float taxAmount;
    private float totalAfterTax;
    private String id;

    private boolean paid;

    public Invoice(Price price) {
        this.totalPriceBeforeTax = price.getTotalPrice();
        this.taxAmount = calculateTaxAmount(price.getTotalPrice());
        // after tax
        this.totalAfterTax = calculateTotalPriceAfterTax(totalPriceBeforeTax, taxAmount);
        this.paid = false;
        this.id = generateId();
    }

    public void setId(String id) {
        this.id = id;
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

    public static float getSalesTax() {
        return SALES_TAX;
    }

    public String getId() {
        return id;
    }

    public boolean isPaid() {
        return paid;
    }

    private float calculateTaxAmount(float totalAfterBeforeTax) {
        return totalAfterBeforeTax * SALES_TAX;
    }

    private float calculateTotalPriceAfterTax(float totalPriceBeforeTax, float taxAmount) {
        return totalPriceBeforeTax + taxAmount;
    }

    public HashMap<String, String> generateInvoice(Order order) {
        HashMap<String, String> invoice = new HashMap<>();
        invoice.put("Price before tax (usd)", Float.toString(getTotalPriceBeforeTax()));
        invoice.put("Tax amount (usd)", Float.toString(getTaxAmount()));
        invoice.put("Total after tax (usd)", Float.toString(getTotalAfterTax()));
        invoice.put("Invoice paid", Boolean.toString(isPaid()));
        invoice.put("Invoice ID", getId());
        Address address = order.getAddress();
        String fullAddress = address.getHouseNumber()+" "+address.getStreet()+" "+ address.getCity()+" "+address.getState();
        invoice.put("Delivery address", fullAddress);
        return invoice;
    }

    @Override
    public String convertNumericToText(float numeric) {
        return "Will be implemented later";
    }

    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "I" + currentTime + randomInt;
    }

    @Override
    public String toString(){
        return "Invoice {"+
                "ID "+id+" "+
                "Total before tax "+totalPriceBeforeTax+" "+
                "Total after tax " + totalAfterTax +"}";
    }
}