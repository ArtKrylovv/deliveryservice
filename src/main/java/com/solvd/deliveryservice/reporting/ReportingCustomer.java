package com.solvd.deliveryservice.reporting;

import com.solvd.deliveryservice.ifunctional.iFilterCustomer;
import com.solvd.deliveryservice.person.Customer;

import java.util.ArrayList;
import java.util.List;

public class ReportingCustomer {
    private static List<Customer> customerList = new ArrayList<>();

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public static ArrayList<Customer> filterCustomersBy(iFilterCustomer filter){
        ArrayList<Customer> filteredCustomerList = new ArrayList<>();
        customerList.forEach((Customer customer)-> {
            if(filter.filter(customer)){
                filteredCustomerList.add(customer);
            }});
        return filteredCustomerList;
    }
}
