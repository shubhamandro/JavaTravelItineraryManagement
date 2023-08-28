package Dto;

import java.util.List;

public class SimplePassenger extends NonPremiumPassenger {

    public SimplePassenger(String name, String passengerNumber, List<String> activityList, Double balance) {
        super(name, passengerNumber, activityList, balance);
    }

    @Override
    public Double activityCost(Double cost) {
        return cost;
    }

    @Override
    public void addActivity(String activityName, Double cost) {
        balance -= activityCost(activityCost(cost));
    }

    @Override
    public boolean canSignUp(String activity, Double cost, Integer activityVacancy) {
        if (activityVacancy > 0 && activityCost(cost) <= this.balance) {
            this.getActivitiesChosen().add(activity);
            this.balance = this.balance - activityCost(cost);
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
