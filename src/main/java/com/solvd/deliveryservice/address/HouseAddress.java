package com.solvd.deliveryservice.address;

import java.util.ArrayList;
import java.util.LinkedList;

public class HouseAddress extends Address{

    public HouseAddress(String street, int house,String city, String state) {
        super(street, state, house, city);
    }
}
