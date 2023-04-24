package com.solvd.deliveryservice.order;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.parcel.Parcel;
import com.solvd.deliveryservice.person.Customer;
import com.solvd.deliveryservice.person.Recipient;
import com.solvd.deliveryservice.store.Store;

import java.util.Random;

public class Order {
    private Customer customer;
    private Recipient recipient;
    private Address address;
    private Parcel parcel;
    private Store store;
    private long id;
    private boolean express;
    private boolean delivered;

    public Customer getCustomer() {
        return customer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Address getAddress() {
        return address;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public Store getStore() {
        return store;
    }


    public boolean isExpress() {
        return express;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public long getId() {
        return id;
    }


    public void setExpress(boolean express) {
        this.express = express;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    private long generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return currentTime + randomInt;
    }

    public Order(Customer customer, Recipient recipient, Address address, Parcel parcel, Store store, boolean express) {
        this.customer = customer;
        this.recipient = recipient;
        this.address = address;
        this.parcel = parcel;
        this.store = store;
        this.id = generateId();
        this.express = express;
        this.delivered = false;
    }
}
