Implement the Java source structures inside their respective packages to make the pre-written unit test suite inside `src/test/java/com/airline/AirlineTest.java` pass completely.

### Package 1: The Domain Models (`src/main/java/com/airline/model/`)

#### 1. Complete `Passenger.java`
* **Instance Variables (Private):**
    * `name` (String)
    * `luggageWeightKg` (double)
* **Constructor:**
    * `public Passenger(String name, double luggageWeightKg)`: Initialize fields. Protect instantiation by filtering the weight parameter through your setter.
* **Encapsulation Requirements:**
    * Create standard public getters for both fields (`getName()` and `getLuggageWeightKg()`).
    * Create a public setter for weight: `public void setLuggageWeightKg(double weight)`. If the incoming value is negative (`< 0.0`), clamp it to `0.0`. Otherwise, assign the valid value.

#### 2. Complete `Booking.java`
* **Instance Variables (Private):**
    * `flightNumber` (String)
    * `passengers` (List<Passenger>)
* **Constructor:**
    * `public Booking(String flightNumber)`: Map the flight number field and initialize the `passengers` list as a `new ArrayList<>()` to prevent `NullPointerException` bugs.
* **Composition Core Methods:**
    * `public void addPassenger(Passenger p)`: Append the passenger object to your collection list.
    * `public List<Passenger> getPassengers()`: Return the list of passengers.
    * `public double calculateTotalLuggageWeight()`: Iterate through the passenger collection, accumulate every individual's luggage weight using their getter, and return the combined total.

---

### Package 2: The Service Layers (`src/main/java/com/airline/service/`)

#### 3. Complete `BaggagePricing.java`
* **Method:** `public double calculateBaggageFee(Booking booking)`
* **Logic:** Return a basic baseline double value of `0.0`.

#### 4. Complete `EconomyBaggage.java` (Inherits from `BaggagePricing`)
* **Polymorphic Method Override (Mark with `@Override`):**
    * Calculate the total baggage fee as a flat **$2.00 per kilogram** of total combined luggage weight found inside the booking.
    * *Hint:* Pull the total weight directly from `booking.calculateTotalLuggageWeight()` and multiply it by `2.0`.

#### 5. Complete `FirstClassBaggage.java` (Inherits from `BaggagePricing`)
* **Polymorphic Method Override (Mark with `@Override`):**
    * First-class bookings receive **25.0 kg of free total luggage capacity**.
    * If the booking's combined total luggage weight is less than or equal to `25.0`, return a fee of `0.0`.
    * For any excess weight *above* 25.0 kg, charge a surcharge fee of **$5.00 per excess kilogram**.
    * *Formula:* `(totalWeight - 25.0) * 5.0`

---

## 🏆 Verification Target

1. Code out your classes in your source folder directory.
2. Open `src/test/java/com/airline/AirlineTest.java` in IntelliJ.
3. Click the green play icon next to the class name to execute the assertions.
4. Your goal is to achieve 3 green passes:
    * `testPassengerWeightEncapsulation()`
    * `testBookingComposition()`
    * `testPolymorphicBaggagePricing()`