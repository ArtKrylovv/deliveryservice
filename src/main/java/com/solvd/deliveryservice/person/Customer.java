package com.solvd.deliveryservice.person;

import java.util.HashMap;
import java.util.Random;

public class Customer extends Person {
    private String id;
    private boolean veteranStatus;

    public Customer(String firstName, String lastName, long phone, boolean veteranStatus) {
        super(firstName, lastName, phone);
        this.id = generateId();
        this.veteranStatus= veteranStatus;
    }

    public String getId() {
        return id;
    }

    public boolean isVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public void setId(String id) {
        this.id = generateId();
    }

    @Override
    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "C" + currentTime + randomInt;
    }

    @Override
    public HashMap<String, Object> getInfo() {
        HashMap<String, Object> info = new HashMap<>();
        info.put("fist name", getFirstName());
        info.put("last name", getLastName());
        info.put("phone", getPhone());
        info.put("id", getId());
        info.put("veteran status", isVeteranStatus());
        return info;
    }
}
