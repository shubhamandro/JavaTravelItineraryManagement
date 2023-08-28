package Service;

import Dto.Activity;
import org.junit.jupiter.api.Test;

class ActivityServiceTest {


    ActivityService activityService = new ActivityService();

    @Test
    void createActivity() throws Exception {
        Activity activity = new Activity("a", "b", 1.0, "des", 10);
        Activity activity1 = activityService.createActivity(activity);
        assert activity1.equals(activity);
    }

    @Test
    void addActivityToDestination() {

    }
}