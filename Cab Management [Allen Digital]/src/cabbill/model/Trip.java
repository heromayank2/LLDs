package cabbill.model;

import cabbill.enums.TripStatus;
import cabbill.enums.TripType;

public class Trip {
    Cab cab;
    Long distance;
    TripStatus tripStatus;
    Long startTime;
    Long endTime;
    TripType tripType;


    public Trip(Cab cab, Long distance, TripStatus tripStatus, Long startTime, Long endTime, TripType tripType) {
        this.cab = cab;
        this.distance = distance;
        this.tripStatus = tripStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripType = tripType;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }
}
