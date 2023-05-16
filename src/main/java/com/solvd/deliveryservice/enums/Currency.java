package com.solvd.deliveryservice.enums;

public enum Currency {
    USD(1),
    EUR(0.9F),
    JPY(130.1F);

    float rate;

    Currency(float rate){
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
