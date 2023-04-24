package com.solvd.deliveryservice.address;

public class HouseAddress extends Address{

    public HouseAddress(String street, String state, int house) {
        super(street, state, house);
    }

    @Override
    public String [] getFullAddress() {
        String [] fullAddress = new String[3];
        fullAddress[0] = getStreet();
        fullAddress[1] = Integer.toString(getHouseNumber());
        fullAddress[2] = getState();
        return fullAddress;
    }
}
