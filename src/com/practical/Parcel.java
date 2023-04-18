package com.practical;

public class Parcel {
    private String description;
    private int weight;
    private int[] dimensions;

    public Parcel(String description, int weight, int[] dimensions){
     this.description = description;
     this.weight = weight;

     // this method validates dimensions values
     Boolean dimensionValidity = true;
     for(int dimension : dimensions){
         if(dimension <=0){
             dimensionValidity = false;
             break;
         }
     if(dimensionValidity){
         this.dimensions = dimensions;
     } else{
         System.out.println("Each dimension must be a positive integer greater than 0");
     }
        }

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDimensions(int[] dimensions) {
        Boolean dimensionValidity = true;
        for (int dimension : dimensions) {
            if (dimension == 0) {
                dimensionValidity = false;
                break;
            }
            if (dimensionValidity) {
                this.dimensions = dimensions;
            } else {
                System.out.println("Each dimension must be a positive integer greater than 0");
            }
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

    // this method calculates parcel/package volume
    public int getVolume(){
        int volume=1;
        for(int i: dimensions){
           volume*=i;
        }
        return volume;
    }
}
