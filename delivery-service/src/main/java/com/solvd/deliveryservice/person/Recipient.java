package com.solvd.deliveryservice.person;

import java.util.Random;

public class Recipient extends Person {
    private String id;

    public Recipient(String firstName, String lastName, long phone) {
        super(firstName, lastName, phone);
        this.id = generateId();

    }

    public void setId(String id) {
        this.id = generateId();
    }

    public String getId() {
        return id;
    }

    @Override
    public String generateId() {
        Random random = new Random();
        long currentTime = System.currentTimeMillis();
        int randomInt = random.nextInt(10000);
        return "R" + currentTime + randomInt;
    }
}