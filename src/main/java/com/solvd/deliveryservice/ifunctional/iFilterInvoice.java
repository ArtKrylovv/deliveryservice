package com.solvd.deliveryservice.ifunctional;

import com.solvd.deliveryservice.payment.Invoice;

@FunctionalInterface
public interface iFilterInvoice {
    boolean filter(Invoice i);
}

