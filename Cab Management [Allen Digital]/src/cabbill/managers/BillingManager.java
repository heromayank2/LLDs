package cabbill.managers;

import cabbill.model.Trip;
import cabbill.strategy.BillingStrategy;
import cabbill.enums.TripStatus;
import cabbill.enums.TripType;

public class BillingManager {

    Long billAmount;
    BillingStrategy billingStrategy;

    public BillingManager(BillingStrategy billingStrategy){
        this.billingStrategy = billingStrategy;
        this.billAmount = 0L;
    }

    public void addTrip(Trip trip){
        if(trip.getTripStatus()== TripStatus.CANCELLED_BY_USER){
            billAmount +=10;
        }else if(trip.getTripStatus()== TripStatus.CANCELLED_BY_DRIVER){
            billAmount -=10;
        }else{
            // completed trip
            long bill = billingStrategy.calculateBill(trip);
            if(trip.getTripType()== TripType.OUTSTATION){
                bill*=2;
            }
            billAmount += bill;
        }
    }

    public long getDriverBill()  {
       return billAmount;
    }
}
