package com.practical;

public class Discount {
    // this discount should not be modified
    final static float BUSINESS_DISCOUNT = 0.1F;
    private float manualDiscount;

    public Discount(){
    }

    public Discount(float manualDiscount){
        this.manualDiscount = manualDiscount;
    }

    public float getBUSINESS_DISCOUNT() {
        return BUSINESS_DISCOUNT;
    }

    public float getManualDiscount() {
        return manualDiscount;
    }

    public void setManualDiscount(float manualDiscount) {
        this.manualDiscount = manualDiscount;
    }
}
