package com.practical;

public class Store {
    private static int numberOfStores = 0;
    private Address address;

    public Store(Address address) {
        this.address = address;

        // this expression increments numberOfStores each time a new store is created
        numberOfStores ++;
    }

    public Address getAddress() {
        return address;
    }

    public static int getNumberOfStores(){
        return numberOfStores;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}


