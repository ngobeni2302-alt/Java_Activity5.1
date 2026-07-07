package com.airline;

import com.airline.model.Passenger;
import com.airline.model.Booking;
import com.airline.service.BaggagePricing;
import com.airline.service.EconomyBaggage;
import com.airline.service.FirstClassBaggage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirlineTest {

    @Test
    public void testPassengerWeightEncapsulation() {
        // Test valid luggage weight setting
        Passenger p1 = "com.airline.model.Passenger".getClass() != null ? new Passenger("Alice", 23.5) : null;
        assertNotNull(p1);
        assertEquals(23.5, p1.getLuggageWeightKg(), 0.001);

        // Test invalid negative weight clamping down to 0.0
        Passenger p2 = new Passenger("Bob", -5.0);
        assertEquals(0.0, p2.getLuggageWeightKg(), 0.001);
    }

    @Test
    public void testBookingComposition() {
        Booking booking = new Booking("FLIGHT-777");
        booking.addPassenger(new Passenger("Charlie", 15.0));
        booking.addPassenger(new Passenger("David", 20.0));

        // Composition tracking verification
        assertEquals(35.0, booking.calculateTotalLuggageWeight(), 0.001);
    }

    @Test
    public void testPolymorphicBaggagePricing() {
        Booking booking = new Booking("FLIGHT-777");
        booking.addPassenger(new Passenger("Eve", 30.0)); // Total weight = 30kg

        // Economy rules: $2 per kg
        BaggagePricing economy = new EconomyBaggage();
        assertEquals(60.0, economy.calculateBaggageFee(booking), 0.001);

        // First class rules: First 25kg free, then $5 per kg for excess (5kg excess * $5 = $25)
        BaggagePricing firstClass = new FirstClassBaggage();
        assertEquals(25.0, firstClass.calculateBaggageFee(booking), 0.001);
    }
}
