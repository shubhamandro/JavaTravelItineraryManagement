package Service;

import Exception.DuplicateActivityException;
import Dto.Activity;
import Dto.Destination;
import Repository.*;
import Exception.*;

import java.util.List;
import java.util.Objects;

public class ActivityService {

    private final Repository<Activity> activityRepository;
    private final DestinationService destinationService;

    public ActivityService(){
        this.activityRepository = new ActivityRepository();
        this.destinationService = new DestinationService();
    }

    public Activity createActivity(Activity activity) throws DuplicateActivityException {
        Activity oldActivity = activityRepository.getValue(activity.getName());
        if (Objects.isNull(oldActivity)) {
            activityRepository.addKeyValue(activity.getName(), activity);
            return activity;
        }
        throw new DuplicateActivityException("Activity already exist");
    }

    public Destination addActivityToDestination(String activityName, String destinationName) throws Exception {
        Activity activity = activityRepository.getValue(activityName);
        Destination destination = destinationService.getDestination(destinationName);
        if (Objects.nonNull(activity)) {
            activity.setDestination(destination.getName());
            activityRepository.addKeyValue(activityName, activity);
            return destinationService.addActivityToDestination(activityName, destinationName);
        }
        throw new DestinationNotFoundException("Could not find any destination with name : " + destinationName);
    }

    public Activity getActivity(String activityName) throws ActivityNotFoundException {
        Activity activity = activityRepository.getValue(activityName);
        if(Objects.isNull(activity)){
            throw new ActivityNotFoundException("Could not find any activity with name : " + activityName);
        }
        return activity;
    }

    public String printAllAvailableActivities(){
        List<Activity> activityList = activityRepository.getAll();
        StringBuilder sb = new StringBuilder();
        sb.append("Activities available").append(System.lineSeparator());
        sb.append("Activity name : vacancy").append(System.lineSeparator());
        for(Activity activity : activityList){
            sb.append(activity.getName()).append(" : ").append(activity.getVacancy());
        }
        return sb.toString();
    }

}
