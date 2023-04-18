package com.practical;

public class Address {
    private String street;
    private String state;
    private Boolean deliveryAddress;
    private Boolean localAddress;

    public Address(String street, String state, Boolean deliveryAddress) {
        this.street = street;

        // checks if state length equals to 2
        if(state.length() == 2){
            this.state = state;
        } else {
            System.out.println("State must be a string of 2 characters");
        }
        this.deliveryAddress = deliveryAddress;

        // initializes localAddress as true if state is "CA"
        if(this.state.equals("CA")){
            this.localAddress = true;
        }
        else{
            this.localAddress = false;
        }
    }

    public String getStreet() {
        return street;
    }

    public String getState(){
        return state;
    }

    public Boolean getDeliveryAddress(){
        return deliveryAddress;
    }

    public Boolean getLocalAddress(){
        return localAddress;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setState(String state) {
        if(state.length() == 2){
            this.state = state;
        } else {
            System.out.println("State must be a string of two characters");
        }
    }

    public void setDeliveryAddress(Boolean deliveryAddress){
        this.deliveryAddress = deliveryAddress;
    }
}

