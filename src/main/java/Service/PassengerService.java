package Service;

import Dto.Activity;
import Dto.Destination;
import Dto.Passenger;
import Repository.Repository;
import Exception.DuplicatePassengerException;
import Exception.*;
import Repository.*;

import java.util.Objects;

public class PassengerService {

    private final Repository<Passenger> passengerRepository;

    private final ActivityService activityService;

    private final DestinationService destinationService;

    public PassengerService(){
        this.passengerRepository = new PassengerRepository();
        this.activityService = new ActivityService();
        this.destinationService = new DestinationService();
    }

    public Passenger createPassenger(Passenger passenger) throws Exception {
        Passenger persistedPassenger = passengerRepository.getValue(passenger.getPassengerNumber());
        if (Objects.isNull(persistedPassenger)) {
            passengerRepository.addKeyValue(passenger.getPassengerNumber(), passenger);
            return passenger;
        }
        throw new DuplicatePassengerException("Passenger with this passengerNumber already exist");
    }

    public Passenger getPassenger(String passengerNumber) throws Exception {
        Passenger passenger = passengerRepository.getValue(passengerNumber);
        if(Objects.isNull(passenger)){
            throw new PassengerNotFoundException("Could not find any passenger with this passengerNumber: "+ passengerNumber);
        }
        return passenger;
    }

    public Passenger addActivityToPassengerItinerary(String passengerNumber, String activityName) throws Exception {
        Activity activity = activityService.getActivity(activityName);
        Passenger passenger = getPassenger(passengerNumber);
        boolean canSignUp = passenger.canSignUp(activityName, activity.getCost(), activity.getVacancy());
        if(!canSignUp) {
            throw new PassengerLowBalanceException("Insufficient balance");
        }
        passenger.addActivity(activityName,activity.getCost());
        passengerRepository.addKeyValue(passengerNumber, passenger);
        activity.updatePassengerAssigned();
        return passenger;
    }

    public String printPassengerDetails(String passengerNumber) throws Exception {
        Passenger passenger = getPassenger(passengerNumber);
        StringBuilder sb = passenger.printDetails();
        for (String activityName : passenger.getActivitiesChosen()) {
            Activity activity = activityService.getActivity(activityName);
            Destination destination = destinationService.getDestination(activity.getDestination());
            System.out.println("You are doing " + activity.getName() + " activity at " + destination.getName() + " destination and it cost you " + passenger.activityCost(activity.getCost()));
        }
        return sb.toString();
    }
}
