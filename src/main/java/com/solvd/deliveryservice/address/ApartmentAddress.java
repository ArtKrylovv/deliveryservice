package com.solvd.deliveryservice.address;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApartmentAddress extends Address {
    private int aptNumber;


    public ApartmentAddress(String street, int house, String city, String state) {
        // reduce arguments to 3 max
        super(street, state, house, city);
    }

    public int getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
    }
}

