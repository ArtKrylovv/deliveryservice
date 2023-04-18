package com.practical;

public class Order {
    private Parcel parcel;
    private Customer customer;
    private Recipient recipient;
    private Address deliveryAddress;

    public Order(Parcel parcel, Customer customer, Recipient recipient, Address deliveryAddress) {
        this.parcel = parcel;
        this.customer = customer;
        this.recipient = recipient;
        this.deliveryAddress = deliveryAddress;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setParcel(Parcel parcel){
        this.parcel = parcel;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Parcel getParcel(){
        return parcel;
    }
}