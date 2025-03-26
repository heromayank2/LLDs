package cabbill.strategy;

import cabbill.model.Trip;

public interface BillingStrategy {
    long calculateBill(Trip trip);
}
