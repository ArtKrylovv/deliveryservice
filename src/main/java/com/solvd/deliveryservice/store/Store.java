package com.solvd.deliveryservice.store;

import com.solvd.deliveryservice.address.Address;
import com.solvd.deliveryservice.address.HouseAddress;

public class Store {
    private Address address;

    public Store(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

