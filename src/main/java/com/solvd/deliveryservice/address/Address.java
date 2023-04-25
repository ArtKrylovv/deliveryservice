package com.solvd.deliveryservice.address;

import com.solvd.deliveryservice.utilities.Utilities;

public abstract class Address {
    final public static String LOCAL_STATE = "CA";
    private String street;
    private String state;
    private int houseNumber;

    public Address(String street, String state, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        // using Utilities final class with static methods
        if (Utilities.stateChecker(state)) {
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
        if (Utilities.stateChecker(state)) {
            this.state = state;
        } else {
            System.out.println("State must be a string of 2 characters");
        }
    }
    // final class
    public final boolean checkIfLocalAddress(String state){
        return state.equals(LOCAL_STATE);
    }
    // abstract
    public abstract String[] getFullAddress();
}

