package com.solvd.deliveryservice.address;

public abstract class Address {
    final public static String LOCAL_STATE = "CA";
    private String street;
    private String state;
    private int houseNumber;

    public Address(String street, String state, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        if (stateChecker(state)) {
            this.state = state;
        } else {
            // update to raise exception
            System.out.println("State must be a string of 2 characters");
        }
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        if (stateChecker(state)) {
            this.state = state;
        } else {
            System.out.println("State must be a string of 2 characters");
        }
    }

    // checks if state length == 2
    private boolean stateChecker (String state) {
        if (state.length() != 2) {
            return false;
        } else {
            return true;
        }
    }



    public boolean checkIfLocalAddress(String state){
        if (state.equals(LOCAL_STATE)) {
            return true;
        } else{
            return false;
        }
    }
    // abstract
    public abstract String[] getFullAddress();
}

