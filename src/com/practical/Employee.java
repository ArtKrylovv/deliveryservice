package com.practical;

public class Employee {
    private String firstName;
    private String lastName;
    private Address address;
    private String position;

    public Employee(String firstName, String lastName, Address address, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String setPosition(){ return  position;}
}
