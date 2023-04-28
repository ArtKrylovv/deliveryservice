package com.solvd.deliveryservice;

import com.solvd.deliveryservice.address.ApartmentAddress;
import com.solvd.deliveryservice.address.HouseAddress;
import com.solvd.deliveryservice.delivery.Delivery;
import com.solvd.deliveryservice.order.Order;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.payment.Discount;
import com.solvd.deliveryservice.payment.Invoice;
import com.solvd.deliveryservice.payment.Price;
import com.solvd.deliveryservice.payment.Processing;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Employee;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.OnlineStore;
import com.solvd.deliveryservice.store.PhysicalStore;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    // creates logger
    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        LOGGER.info("Starting service");


        // creating addresses
        HouseAddress senderOneAddress = new HouseAddress("Main", "CA", 1);
        HouseAddress senderTwoAddress = new HouseAddress("Lincoln", "NY", 1);
        ApartmentAddress recipientOneAddress = new ApartmentAddress("Main", "CA", 1, 100, 100);
        ApartmentAddress recipientTwoAddress = new ApartmentAddress("Lincoln", "NY", 1, 100, 100);
        HouseAddress storeOneAddress = new HouseAddress("Washington", "CA", 1);
        HouseAddress storeTwoAddress = new HouseAddress("Washington", "CA", 1);

        // creating store
        PhysicalStore store1 = new PhysicalStore(storeOneAddress);
        OnlineStore store2 = new OnlineStore("delivery.com/onlinestore");


        //Printing if store is working today, Polymorphism with interfaces
        System.out.println(store1.workingTodayChecker("Tuesday"));
        //Throws error
//        System.out.println(store2.workingTodayChecker("Moonday"));


        // polymorphism, abstract method
        System.out.println(Arrays.toString(senderOneAddress.getFullAddress()));
        System.out.println(Arrays.toString(recipientTwoAddress.getFullAddress()));

        // custom method
        System.out.println(senderOneAddress.checkIfLocalAddress("CA")+ " local address");
        System.out.println(senderOneAddress.checkIfLocalAddress("NY")+ " local address");

        // creating customers
        Customer customerOne = new Customer("Art", "Krylov", 11111111111L, false);
        Customer customerTwo = new Customer("George", "Patton", 11111111111L, true);

        //creating recipients
        Recipient recipientOne = new Recipient("Oxana", "Krylov", 11111111111L);
        Recipient recipientTwo = new Recipient("Harry", "Truman", 11111111111L);

        //creating employees
        Employee employeeOne = new Employee("Elon", "Musk", 11111111111L);
        Employee employeeTwo = new Employee("Jeff", "Bezos", 11111111111L);

        // polymorphism, abstract method
        System.out.println(customerOne.getId()+ " id");
        System.out.println(recipientOne.getId()+ " id");
        System.out.println(employeeOne.getId()+ " id");

        //creating parcel
        int[] dimensions1 = {5,5,5};
        Parcel parcel1 = new Parcel("flowers", 1, dimensions1);

        int[] dimensions2 = {6,6,6};
        Parcel parcel2 = new Parcel("book", 1, dimensions2);


        int[] dimensions3 = {0,6,6};
        //Throws error
//        Parcel parcel3 = new Parcel("book", 1, dimensions3);

        System.out.println(parcel1.calculateVolume()+ " parcel volume");
        System.out.println(parcel2.calculateVolume()+ " parcel volume");


        // creating orders
        Order order1 = new Order(customerOne, recipientOne, recipientOneAddress, parcel1, store1, false);
        Order order2 = new Order(customerTwo, recipientTwo, recipientTwoAddress, parcel2, store2, true);

        // creating delivery
        Delivery delivery1 =new Delivery();
        Delivery delivery2 =new Delivery();

        // getting lead time
        System.out.println(delivery1.getLeadTime(order1)+ " leadtime");
        System.out.println(delivery2.getLeadTime(order2)+ " leadtime");

        //creating discounts
        Discount discount1 = new Discount(0,customerOne.isVeteranStatus());
        Discount discount2 = new Discount(0.05F,customerTwo.isVeteranStatus());

        System.out.println(discount1.getTotalDiscount()+ " total discount");
        System.out.println(discount2.getTotalDiscount()+ " total discount");

        // creating prices
        Price price1 = new Price(discount1, order1);
        Price price2 = new Price(discount2, order2);

        System.out.println(price1.getTotalPrice()+ " total price");
        System.out.println(price2.getTotalPrice()+ " total price");

        // creating invoices
        Invoice invoice1 = new Invoice(price1);
        Invoice invoice2 = new Invoice(price2);

        System.out.println(invoice1.generateInvoice(order1)+ " invoice");
        System.out.println(invoice2.generateInvoice(order2)+ " invoice");

        // payment processing
        Processing.processPayment(1111111111111111L, invoice1);
        // throws exception
//        Processing.processPayment(111111111111111L, invoice2);

        // validating new invoice payment status
        System.out.println(invoice1.generateInvoice(order1)+ " invoice");
        System.out.println(invoice2.generateInvoice(order2)+ " invoice");
    }
}
