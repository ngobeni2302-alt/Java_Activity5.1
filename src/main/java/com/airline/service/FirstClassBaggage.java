package com.airline.service;

import com.airline.model.Booking;

public class FirstClassBaggage extends BaggagePricing {
    @Override
    public double calculateBaggageFee(Booking booking) {
        double totalWeight = booking.calculateTotalLuggageWeight();

        // First 25.0 kg is free
        if (totalWeight <= 25.0) {
            return 0.0;
        } else {
            // $5.00 per excess kilogram above 25.0 kg
            return (totalWeight - 25.0) * 5.0;
        }
    }
}
