package Dto;

import java.util.List;

public class TravelPackage {
    private String name;
    private Integer passengerCapacity;


    private List<String> itinerary;
    private List<String> passengerList;

    public TravelPackage(String name, Integer capacity, List<String> itinerary, List<String> passengerList) {
        this.name = name;
        this.passengerCapacity = capacity;
        this.itinerary = itinerary;
        this.passengerList = passengerList;
    }

    public String getName() {
        return name;
    }

    public int getVacancy() {
        return passengerCapacity - passengerList.size();
    }

    public List<String> getItinerary() {
        return itinerary;
    }

    public List<String> getPassengerList(){
        return passengerList;
    }

    public synchronized boolean signUp(String passengerNumber) {
        if (this.getVacancy() > 0) {
            this.passengerList.add(passengerNumber);
            return true;
        }
        return false;
    }

    public StringBuilder printDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Details of package: ").append(this.name).append(System.lineSeparator());
        stringBuilder.append("This package include destination: ").append(System.lineSeparator());
        stringBuilder.append("Destination: Activities").append(System.lineSeparator());
        return stringBuilder;
    }

    public StringBuilder printPassengerDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Passenger Details of package: ").append(this.name).append(System.lineSeparator());
        stringBuilder.append("passenger capacity: ").append(this.passengerCapacity).append(System.lineSeparator());
        stringBuilder.append("Current passenger enrolled : ").append(this.passengerList.size()).append(System.lineSeparator());
        stringBuilder.append("passenger name and passenger number are below : ").append(System.lineSeparator());
        return stringBuilder;
    }

    public void addDestination(String destination){
        this.itinerary.add(destination);
    }

    public boolean addPassenger(String passenger){
        if(getVacancy() > 0) {
            this.passengerList.add(passenger);
            return true;
        }
        return false;
    }


}
