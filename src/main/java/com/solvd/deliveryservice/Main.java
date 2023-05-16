package com.solvd.deliveryservice;


import com.solvd.deliveryservice.reporting.ReportingCustomer;
import com.solvd.deliveryservice.reporting.ReportingInvoice;
import com.solvd.deliveryservice.address.HouseAddress;
import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.payment.Discount;
import com.solvd.deliveryservice.payment.Invoice;
import com.solvd.deliveryservice.payment.Price;
import com.solvd.deliveryservice.payment.Processing;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.PhysicalStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    // creates logger
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Starting service");

        // stores
        HouseAddress storeOneAddress = new HouseAddress("Lincoln", 1000, "Los Angeles", "CA");
        HouseAddress storeTwoAddress = new HouseAddress("Main", 2000, "San Diego", "CA");

        PhysicalStore store1 = new PhysicalStore(storeOneAddress);
        PhysicalStore store2 = new PhysicalStore(storeTwoAddress);

        // customer
        Customer customer1 = new Customer("Art", "Krylov", 3233336877L);
        customer1.setVeteranStatus(false);

        Customer customer2 = new Customer("Oleg", "Krylov", 3233336811L);
        customer1.setVeteranStatus(false);

        Customer customer3 = new Customer("Jack", "London", 3233336811L);
        customer1.setVeteranStatus(false);

        Customer customer4 = new Customer("Winston", "Churchill", 3233336800L);
        customer1.setVeteranStatus(false);

        // recipient
        Recipient recipient = new Recipient("Ilan", "Gavrilov", 3233336888L);

        // delivery address
        HouseAddress deliveryAddress = new HouseAddress("Lincoln", 1000, "Los Angeles", "CA");

        // parcel

        int[] dimensions = {5, 5, 5};
        Parcel parcel1 = new Parcel("Box", 5, dimensions);

        Parcel parcel2 = new Parcel("Box", 15, dimensions);

        // order, discount2, price, invoice
        Order order1 = new Order(customer1, recipient, deliveryAddress);
        order1.setParcel(parcel1);
        order1.setExpress(false);
        Discount discount1 = new Discount(0F, customer1.isVeteranStatus());
        Price price1 = new Price(discount1, order1);
        Invoice invoice1 = new Invoice(price1);

        Order order2 = new Order(customer1, recipient, deliveryAddress);
        order2.setParcel(parcel2);
        order2.setExpress(true);
        Discount discount2 = new Discount(0F, customer1.isVeteranStatus());
        Price price2 = new Price(discount2, order2);
        Invoice invoice2 = new Invoice(price2);


        // payment, Predicate interface
        Processing processing1 = new Processing(7777777777777777L, invoice1);
        Processing processing2 = new Processing(777777777777777L, invoice1);

        //checking inf card number is correct
        processing1.processPayment((Long cardNumber)->{
            int cardNumberLength = Long.toString(cardNumber).length();
            return cardNumberLength == 16;
        });

        processing2.processPayment((Long cardNumber)->{
            int cardNumberLength = Long.toString(cardNumber).length();
            return cardNumberLength == 16;
        });

        // checking if the invoice was paid
        LOGGER.info(invoice1.generateInvoice(order1));
        LOGGER.info(invoice2.generateInvoice(order2));


        // iFilterCustomer interface
        ReportingCustomer.addCustomer(customer1);
        ReportingCustomer.addCustomer(customer2);
        ReportingCustomer.addCustomer(customer3);
        ReportingCustomer.addCustomer(customer4);



        // filtering customers by last name
        ArrayList<Customer> filteredCustomers = ReportingCustomer.filterCustomersBy((Customer customer)->{
            if(customer.getLastName()=="Krylov") {
                return true;
            } else {
                return  false;
            }
        });

        LOGGER.info(filteredCustomers);

        // iFilterInvoice interface
        ReportingInvoice.addInvoice(invoice1);
        ReportingInvoice.addInvoice(invoice2);


        // filtering invoices by amount
        ArrayList<Invoice> filteredInvoices = ReportingInvoice.filterInvoiceBy((Invoice invoice)->{
            if(invoice.getTotalAfterTax()>=50){
                return true;
            } else {
                return false;
            }
        });

       LOGGER.info(filteredInvoices);
    }
}