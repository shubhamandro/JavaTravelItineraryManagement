package DTO;

import java.util.List;

public class GoldPassenger extends NonPremiumPassenger {

    public GoldPassenger(String name, String passengerNumber, List<String> activityList, Double balance) {
        super(name, passengerNumber, activityList, balance);
    }

    @Override
    public Double activityCost(Double cost) {
        return (cost * 9) / 10;
    }

    @Override
    public void addActivity(String activityName, Double cost) {
        balance -= activityCost(cost);
    }

    @Override
    public boolean canSignUp(String activity, Double activityCost, Integer activityVacancy) {
        if (activityVacancy > 0 && activityCost(activityCost) <= this.balance) {
            this.getActivitiesChosen().add(activity);
            this.balance = this.balance - activityCost(activityCost);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public StringBuilder printDetails() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name : ").append(this.getName()).append(System.lineSeparator());
        stringBuilder.append("Passenger Number: ").append(this.getPassengerNumber()).append(System.lineSeparator());
        stringBuilder.append("Activities count: ").append(this.getActivitiesChosen().size()).append(System.lineSeparator());
        return stringBuilder;
    }
}
