package com.airline.service;

import com.airline.model.Booking;

public class EconomyBaggage extends BaggagePricing {
    @Override
    public double calculateBaggageFee(Booking booking){
        return booking.calculateTotalLuggageWeight() * 2.0;
    }

}
