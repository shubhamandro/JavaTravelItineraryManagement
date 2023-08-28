package Dto;

public class Activity {
    private final String name;
    private String description;

    private Double cost;

    private String destinationName;
    private final Integer capacity;
    private Integer passengerAssigned;

    public Activity(String name, String description, Double cost, String destinationName, Integer capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.destinationName = destinationName;
        this.capacity = capacity;
        this.passengerAssigned = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getCost() {
        return cost;
    }

    public String getDestination() {
        return destinationName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setDestination(String destinationName) {
        this.destinationName = destinationName;
    }

    public Integer getPassengerAssigned(){
        return this.passengerAssigned;
    }

    public void updatePassengerAssigned(){
        this.passengerAssigned++;
    }

    public Integer getVacancy(){
        return getCapacity() - passengerAssigned;
    }

    public void assignActivityToDestination(String destinationName) {
        this.destinationName = destinationName;
    }
}
