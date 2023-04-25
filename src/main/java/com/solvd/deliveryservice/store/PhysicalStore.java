package com.solvd.deliveryservice.store;

import com.solvd.deliveryservice.address.Address;

public class PhysicalStore extends Store{
    Address address;

    public PhysicalStore(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String workingTodayChecker(String currentDayOfTheWeek) {
        if(currentDayOfTheWeek.equals("Sunday")) {
            return "Sorry we are closed till 8 am tomorrow";
        } else {
            return "We are open!";
        }
    }
}
