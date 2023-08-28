package Dto;

import java.util.List;

public class PremiumPassenger extends Passenger {

    public PremiumPassenger(String name, String passengerNumber, List<String> activityList) {
        super(name, passengerNumber, activityList);
    }

    @Override
    public void addActivity(String activityName, Double cost) {
        getActivitiesChosen().add(activityName);
    }

    @Override
    public Double activityCost(Double cost) {
        return 0.0;
    }

    @Override
    public boolean canSignUp(String activity, Double cost, Integer activityVacancy) {
        return activityVacancy > 0;
    }

    @Override
    public StringBuilder printDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name : ").append(this.getName()).append(System.lineSeparator());
        stringBuilder.append("Passenger Number: ").append(this.getPassengerNumber()).append(System.lineSeparator());
        return stringBuilder;
    }
}
