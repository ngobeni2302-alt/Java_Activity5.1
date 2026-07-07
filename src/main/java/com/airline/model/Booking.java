package com.airline.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private String flightNumber;
    private List<Passenger> passengers;

    public Booking(String flightNumber){
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger p){this.passengers.add(p);}

    public List<Passenger> getPassengers(){return  this.passengers;}

    public double calculateTotalLuggageWeight(){
        double total = 0.0;
        for (Passenger passenger: passengers){
             total = total +passenger.getLuggageWeightKg();
        }
        return total;
    }

}
