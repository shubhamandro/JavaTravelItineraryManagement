import Controller.ActivityController;
import Controller.DestinationController;
import Controller.PassengerController;
import Controller.TravelPackageController;
import DTO.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ActivityController activityController = new ActivityController();
        DestinationController destinationController = new DestinationController();
        PassengerController passengerController = new PassengerController();
        TravelPackageController travelPackageController = new TravelPackageController();

        TravelPackage travelPackage = new TravelPackage("Uttarakhand", 10, new ArrayList<>(), new ArrayList<>());
        travelPackage = travelPackageController.addTravelPackage(travelPackage);

        Passenger passenger = new SimplePassenger("Shubham", "1" , new ArrayList<>(), 1000.0);
        passenger = passengerController.createPassenger(passenger);
        travelPackageController.addPassengerToTravelPackage(passenger.getPassengerNumber(), travelPackage.getName());

        Destination destination = new Destination("Nainital", new ArrayList<>());
        destination = destinationController.addDestination(destination);

        Activity activity = new Activity("paraGliding", "Para gliding from top of x mountain", 10.0, null, 10);
        activity = activityController.createActivity(activity);

        activityController.addActivityToDestination(activity.getName(), destination.getName());
        passengerController.addActivityToPassengerItinerary(passenger.getPassengerNumber(), activity.getName());



        Destination destination2 = new Destination("Dehradun", new ArrayList<>());
        destination2 = destinationController.addDestination(destination2);

        Activity activity2 = new Activity("riverRafting", "river rafting near dehradun", 15.0, null, 20);
        activity2 = activityController.createActivity(activity2);

        //Duplicate activity example
//        activityController.addActivityToDestination(activity.getName(), destination.getName());

        activityController.addActivityToDestination(activity2.getName(), destination2.getName());

        System.out.println(travelPackageController.printItinerary(travelPackage.getName()));
        System.out.println(travelPackageController.printPassengerList(travelPackage.getName()));
        System.out.println(passengerController.getPassengerDetails(passenger.getPassengerNumber()));
        System.out.println(activityController.printAllAvailableActivities());


    }
}