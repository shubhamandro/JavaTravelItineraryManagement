package Dto;

import java.util.List;

public abstract class NonPremiumPassenger extends Passenger {
    protected Double balance;

    public NonPremiumPassenger(String name, String passengerNumber, List<String> activityList, Double balance) {
        super(name, passengerNumber, activityList);
        this.balance = balance;
    }

    public abstract Double activityCost(Double cost);
}
