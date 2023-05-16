package com.solvd.deliveryservice.parcel;

import com.solvd.deliveryservice.exceptions.ParcelDimensionsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class Parcel {
    private String description;
    private int weight;
    private List<Integer> dimensionsList;
    private final static Logger LOGGER = LogManager.getLogger(Parcel.class);

    public Parcel(String description, int weight, List<Integer> dimensions) {
        this.description = description;
        this.weight = weight;
        if(dimensionsChecker(dimensions)) {
            this.dimensionsList = dimensions;
        }else {
            LOGGER.error("All dimensions must be positive integers");
            throw new ParcelDimensionsException("All dimensions must be positive integers");

        }
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public List<Integer> getDimensionsList() {
        return dimensionsList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDimensionsList(List<Integer> dimensionsList) {
        if(dimensionsChecker(dimensionsList)) {
            this.dimensionsList = dimensionsList;
        }else{
            LOGGER.error("All dimensions must be positive integers");
            throw new ParcelDimensionsException("All dimensions must be positive integers");
        }
    }

    // utilizes stream reduce()
    public int calculateVolume(){
        return dimensionsList.stream().reduce((accumulator, x)->accumulator*x).get();
    }

    // utilizes stream filter()
    private boolean dimensionsChecker (List<Integer> dimensionsList){
        List<Integer> filteredList = dimensionsList.stream().filter((el-> el<0)).collect(Collectors.toList());
        boolean status = filteredList.size()==0;
        return status;
    }
}