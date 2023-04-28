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

    public ApartmentAddress(String street, String state, int house, int apt, int callBoxNumber) {
        // reduce arguments to 3 max
        super(street, state, house);
        this.aptNumber = apt;
        this.callBoxNumber = callBoxNumber;
    }

    @Override
    public String [] getFullAddress() {
        String [] fullAddress = new String[5];
        fullAddress[0] = getStreet();
        fullAddress[1] = Integer.toString(getHouseNumber());
        fullAddress[2] = getState();
        fullAddress[3] = Integer.toString(getAptNumber());
        fullAddress[4] = Integer.toString(getCallBoxNumber());
        return fullAddress;
    }
}

