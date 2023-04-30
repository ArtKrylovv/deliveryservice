package com.solvd.deliveryservice.address;

public class ApartmentAddress extends Address {
    private int aptNumber;
    private int callBoxNumber;

    public int getAptNumber() {
        return aptNumber;
    }

    public int getCallBoxNumber() {
        return callBoxNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
    }

    public void setCallBoxNumber(int callBoxNumber) {
        this.callBoxNumber = callBoxNumber;
    }

    public ApartmentAddress(String street, int house, int apt, String city, String state) {
        // reduce arguments to 3 max
        super(street, state, house, city);
        this.aptNumber = apt;
    }

    @Override
    public String [] getFullAddress() {
        String [] fullAddress = new String[5];
        fullAddress[0] = getStreet();
        fullAddress[1] = Integer.toString(getAptNumber());
        fullAddress[2] = Integer.toString(getHouseNumber());
        fullAddress[3] = getCity();
        fullAddress[4] = getState();
        return fullAddress;
    }
}

