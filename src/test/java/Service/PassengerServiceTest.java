package Service;

import Dto.Passenger;
import Dto.SimplePassenger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceTest {

    private PassengerService passengerService = new PassengerService();

    @Test
    void createPassenger() throws Exception {
        Passenger passenger = new SimplePassenger("a", "b", new ArrayList<>(), 10.0);
        Passenger passenger1 = passengerService.createPassenger(passenger);
        assert passenger1.equals(passenger);
    }

    @Test
    void addActivityToPassengerItinerary() {
    }

}