package DTO;

import java.util.List;

public abstract class Passenger {
    private String name;
    private String passengerNumber;
    private List<String> activitiesChosen;

    public Passenger(String name, String passengerNumber, List<String> activityList) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.activitiesChosen = activityList;
    }

    public String getName() {
        return name;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public abstract void addActivity(String activityName, Double cost);

    public List<String> getActivitiesChosen() {
        return activitiesChosen;
    }

    public abstract Double activityCost(Double cost);

    public abstract boolean canSignUp(String activity, Double cost, Integer ActivityVacancy);

    public abstract StringBuilder printDetails();
}
