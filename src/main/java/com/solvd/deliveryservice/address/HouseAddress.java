package com.solvd.deliveryservice.address;

public class HouseAddress extends Address{

    public HouseAddress(String street, int house,String city, String state) {
        super(street, state, house, city);
    }

    @Override
    public String [] getFullAddress() {
        String [] fullAddress = new String[4];
        fullAddress[0] = getStreet();
        fullAddress[1] = Integer.toString(getHouseNumber());
        fullAddress[2] = getCity();
        fullAddress[3] = getState();

        return fullAddress;
    }
}
