package com.solvd.deliveryservice.payment;

public class Discount {
    final public static float VETERAN_DISCOUNT = 0.15F;
    private float manualDiscount;
    private float totalDiscount;

    public Discount(float manualDiscount, boolean veteranStatus) {
        this.manualDiscount = manualDiscount;
        this.totalDiscount = calculateTotalDiscount(veteranStatus);
    }

    public Discount(boolean veteranStatus) {
        this.totalDiscount = calculateTotalDiscount(veteranStatus);
    }

    public float getManualDiscount() {
        return manualDiscount;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void setManualDiscount(float manualDiscount) {
        this.manualDiscount = manualDiscount;
    }

    private float calculateTotalDiscount(boolean veteranStatus) {
        if(veteranStatus) {
            return manualDiscount + VETERAN_DISCOUNT;
        } else{
            return manualDiscount;
            }
        }
}


