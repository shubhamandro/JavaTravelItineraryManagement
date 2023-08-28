package Controller;

import DTO.Destination;
import DTO.Passenger;
import DTO.TravelPackage;
import Service.TravelPackageService;
import Exception.*;

public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    public TravelPackageController() {
        this.travelPackageService = new TravelPackageService();
    }

    public TravelPackage addTravelPackage(TravelPackage travelPackage) throws Exception {
      return travelPackageService.addTravelPackage(travelPackage);
    }

    public TravelPackage addDestinationToTravelPackage(Destination destination, String travelPackageName) throws Exception {
        return travelPackageService.addDestinationToTravelPackage(destination, travelPackageName);
    }

    public TravelPackage getTravelPackage(String travelPackageName) throws TravelPackageNotFoundException {
        return travelPackageService.getTravelPackage(travelPackageName);
    }

    public TravelPackage addPassengerToTravelPackage(String passengerNumber, String travelPackage) throws Exception {
        return travelPackageService.addPassengerToTravelPackage(passengerNumber, travelPackage);
    }

    public String printItinerary(String travelPackageName) throws Exception {
        return travelPackageService.printItinerary(travelPackageName);
    }

    public String printPassengerList(String travelPackageName) throws Exception {
        return travelPackageService.printPassengerList(travelPackageName);
    }
}
