package com.solvd.deliveryservice.person;

import com.solvd.deliveryservice.utilities.Utilities;

import java.util.HashMap;

public abstract class Person implements Id {
    private String firstName;
    private String lastName;
    private long phone;

    public Person(String firstName, String lastName, long phone) {
        if (Utilities.nameChecker(firstName)) {
            this.firstName = firstName;
        } else {
            System.out.println("First Name must contain characters only");
        }

        if (Utilities.nameChecker(lastName)) {
            this.lastName = lastName;
        } else {
            System.out.println("Last Name must contain characters only");
        }

        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
    // abstract method
    public abstract HashMap<String, Object> getInfo();

}






