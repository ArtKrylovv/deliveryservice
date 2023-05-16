package com.solvd.deliveryservice.reporting;

import com.solvd.deliveryservice.ifunctional.iFilterInvoice;
import com.solvd.deliveryservice.payment.Invoice;

import java.util.ArrayList;
import java.util.List;

public class ReportingInvoice {
    private static List<Invoice> invoiceList = new ArrayList<>();

    public static List<Invoice> getCustomerList() {
        return invoiceList;
    }

    public static void addInvoice(Invoice invoice){
        invoiceList.add(invoice);
    }


    public static ArrayList<Invoice> filterInvoiceBy(iFilterInvoice filter){
        ArrayList<Invoice> filteredInvoiceList = new ArrayList<>();
        for (Invoice i: invoiceList){
            if(filter.filter(i)){
                filteredInvoiceList.add(i);
            }
        }
        return filteredInvoiceList;
    }
}
