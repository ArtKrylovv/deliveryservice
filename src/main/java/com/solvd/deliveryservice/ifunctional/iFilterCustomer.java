package com.solvd.deliveryservice.ifunctional;

import com.solvd.deliveryservice.person.Customer;

@FunctionalInterface
public interface iFilterCustomer {
    boolean filter(Customer customer);
}
