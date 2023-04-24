package com.solvd.deliveryservice.parcel;

public class Parcel {
    private String description;
    private int weight;
    private int[] dimensions;

    public Parcel(String description, int weight, int[] dimensions) {
        this.description = description;
        this.weight = weight;
        if(dimensionsChecker(dimensions)) {
            this.dimensions = dimensions;
        }else{
           System.out.println("All dimensions must be positive integers");
        }
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDimensions(int[] dimensions) {
        if(dimensionsChecker(dimensions)) {
            this.dimensions = dimensions;
        }else{
            System.out.println("All dimensions must be positive integers");
        }
    }

    // this method calculates parcel physical volume
    public int calculateVolume() {
        int volume = 1;
        for (int i : dimensions) {
            volume *= i;
        }
        return volume;
    }

    private boolean dimensionsChecker (int[] dimensions) {
        for (int dimension : dimensions) {
            if (dimension <= 0) {
                return false;
                }
            }
        return true;
    }
}