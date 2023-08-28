package Controller;

import DTO.Activity;
import DTO.Passenger;
import Service.PassengerService;

import java.util.Objects;

public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController() {
        this.passengerService = new PassengerService();
    }

    public Passenger createPassenger(Passenger passenger) throws Exception {
        return passengerService.createPassenger(passenger);
    }

    public Passenger getPassenger(String passengerNumber) throws Exception {
        return passengerService.getPassenger(passengerNumber);
    }

    public Passenger addActivityToPassengerItinerary(String passengerNumber, String activityName) throws Exception {
        return passengerService.addActivityToPassengerItinerary(passengerNumber, activityName);
    }

    public String getPassengerDetails(String passengerNumber) throws Exception {
        return passengerService.printPassengerDetails(passengerNumber);
    }
}
