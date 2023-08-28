package Controller;


import DTO.Activity;
import DTO.Destination;
import Service.ActivityService;

public class ActivityController {

    private final ActivityService activityService;

    public ActivityController() {
        this.activityService = new ActivityService();
    }

    public Activity createActivity(Activity activity) throws Exception {
        return activityService.createActivity(activity);
    }

    public Destination addActivityToDestination(String activityName, String destinationName) throws Exception {
        return activityService.addActivityToDestination(activityName, destinationName);
    }

    public Activity getActivity(String activityName) throws Exception {
        return activityService.getActivity(activityName);
    }

    public String printAllAvailableActivities(){
        return activityService.printAllAvailableActivities();
    }


}
