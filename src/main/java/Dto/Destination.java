package Dto;

import java.util.List;

public class Destination {
    private String name;
    private List<String> activityList;

    public Destination(String name, List<String> activityList) {
        this.name = name;
        this.activityList = activityList;
    }

    public String getName() {
        return name;
    }

    public List<String> getActivityList() {
        return activityList;
    }

    public void addActivity(String activity) {
        this.activityList.add(activity);
//        activity.assignActivityToDestination(name);
    }
}
