package com.practical;

public class Price {
    private int localPricePerLb = 10;
    private int outOfStatePricePerLb = 15;
    private float customerDiscount;

    public Price(float discount) {
        this.customerDiscount = discount;
    }

    public void setCustomerDiscount(float customerDiscount){
        this.customerDiscount = customerDiscount;
    }

    public void setLocalPricePerLb(int localPricePerLb) {
        this.localPricePerLb = localPricePerLb;
    }

    public void setOutOfStatePricePerLb(int outOfStatePricePerLb) {
        this.outOfStatePricePerLb = outOfStatePricePerLb;
    }

    public float getCustomerDiscount(){
        return customerDiscount;
    }

    public int getLocalPricePerLb() {
        return localPricePerLb;
    }

    public int getOutOfStatePricePerLb() {
        return outOfStatePricePerLb;
    }

    // this method calculates and returns price based on weight, address, and customer discount
    public float getPrice(Order order){
        int weight = order.getParcel().getWeight();
        Boolean local = order.getDeliveryAddress().getLocalAddress();
        if (local){
            return weight*localPricePerLb*(1- customerDiscount);
        } else{
            return weight*outOfStatePricePerLb*(1- customerDiscount);
        }
    }

}

