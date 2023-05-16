package com.solvd.deliveryservice.payment;

import com.solvd.deliveryservice.exceptions.CardException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class Processing {
    private final static Logger LOGGER = LogManager.getLogger(Processing.class);
    long cardNumber;
    Invoice invoice;

    public Processing(long cardNumber, Invoice invoice) {
        this.cardNumber = cardNumber;
        this.invoice = invoice;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void processPayment(Predicate<Long> cardChecker)  {
        if (cardChecker.test(cardNumber)) {
            invoice.setPaid(true);
        } else {
            // logging error
            try {
                throw new CardException("Invalid credit card number");
            } catch (CardException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
