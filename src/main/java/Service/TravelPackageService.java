package Service;

import Dto.Destination;
import Dto.Passenger;
import Dto.TravelPackage;
import Repository.Repository;
import Exception.TravelPackageNotFoundException;
import Exception.DuplicateTravelPackageException;
import Repository.*;

import java.util.Objects;

public class TravelPackageService {

    private final Repository<TravelPackage> travelPackageRepository;

    private final DestinationService destinationService;

    private final PassengerService passengerService;

    public TravelPackageService(){
        this.travelPackageRepository = new TravelPackageRepository();
        this.destinationService = new DestinationService();
        this.passengerService = new PassengerService();
    }

    public TravelPackage addTravelPackage(TravelPackage travelPackage) throws DuplicateTravelPackageException {
        TravelPackage persistedTravelPackage = travelPackageRepository.getValue(travelPackage.getName());
        if(Objects.isNull(persistedTravelPackage)){
            travelPackageRepository.addKeyValue(travelPackage.getName(), travelPackage);
            return travelPackage;
        }
        throw new DuplicateTravelPackageException("Found another travel package with same name " + travelPackage.getName());
    }

    public TravelPackage addDestinationToTravelPackage(Destination destination, String travelPackageName) throws TravelPackageNotFoundException {
        TravelPackage travelPackage = travelPackageRepository.getValue(travelPackageName);
        if(Objects.nonNull(travelPackage)){
            travelPackage.addDestination(destination.getName());
            travelPackageRepository.addKeyValue(travelPackageName, travelPackage);
            return travelPackage;
        }
        throw new TravelPackageNotFoundException("Could not find travel package with name : " + travelPackageName);
    }

    public TravelPackage getTravelPackage(String travelPackageName) throws TravelPackageNotFoundException {
        TravelPackage travelPackage = travelPackageRepository.getValue(travelPackageName);
        if(Objects.isNull(travelPackage)) throw new TravelPackageNotFoundException("Could not find any travel package with name " + travelPackageName);
        return travelPackage;
    }

    public TravelPackage addPassengerToTravelPackage(String passengerNumber, String travelPackage) throws Exception {
        TravelPackage persistedTravelPackage = travelPackageRepository.getValue(travelPackage);
        Passenger passenger = passengerService.getPassenger(passengerNumber);
        if(Objects.isNull(persistedTravelPackage)) {
             throw new TravelPackageNotFoundException("could not find any travel package with name +" + travelPackage);
        }
        boolean isAdded = persistedTravelPackage.addPassenger(passenger.getPassengerNumber());
        travelPackageRepository.addKeyValue(travelPackage, persistedTravelPackage);
        if(isAdded){
            return persistedTravelPackage;
        }
        throw new Exception("Could not add passenger to travelPackage because of unavailable slot");
    }

    public String printItinerary(String travelPackageName) throws Exception {
        TravelPackage travelPackage = travelPackageRepository.getValue(travelPackageName);
        StringBuilder sb = travelPackage.printDetails();

        for (String d : travelPackage.getItinerary()) {
            Destination destination = destinationService.getDestination(d);
            sb.append(destination.getName()).append(" : ").append(destination.getActivityList()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String printPassengerList(String travelPackageName) throws Exception {
        TravelPackage travelPackage = travelPackageRepository.getValue(travelPackageName);
        StringBuilder sb = travelPackage.printPassengerDetails();

        for (String p : travelPackage.getPassengerList()) {
            Passenger passenger = passengerService.getPassenger(p);
               sb.append(passenger.getName()).append(" ").append(passenger.getPassengerNumber()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
