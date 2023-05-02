package com.solvd.deliveryservice.address;

import java.util.ArrayList;
import java.util.LinkedList;

public class HouseAddress extends Address{

    public HouseAddress(String street, int house,String city, String state) {
        super(street, state, house, city);
    }

    @Override
    public ArrayList<String> getFullAddress() {
        ArrayList<String> fullAddress = new ArrayList<>();
        fullAddress.add(Integer.toString(getHouseNumber()));
        fullAddress.add((getStreet()));
        fullAddress.add(getCity());
        fullAddress.add(getState());
        return fullAddress;
    }
}
