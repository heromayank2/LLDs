package cabbill.strategy;

import cabbill.model.Trip;

public class LuxuryBillingStrategy implements BillingStrategy{

    @Override
    public long calculateBill(Trip trip) {
        return 15 * trip.getDistance();
    }
}
