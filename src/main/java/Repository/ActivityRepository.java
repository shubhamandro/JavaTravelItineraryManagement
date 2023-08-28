package Repository;

import Dto.Activity;

import java.util.*;

public class ActivityRepository implements Repository<Activity> {

    private static final Map<String, Activity> activityMap = new HashMap<>();

    @Override
    public Activity getValue(String key) {
        return activityMap.getOrDefault(key, null);
    }

    @Override
    public Activity addKeyValue(String key, Activity value) {
        return activityMap.put(key, value);
    }

    @Override
    public List<Activity> getAll() {
        return new ArrayList<>(activityMap.values());
    }


}
