package Repository;

import Dto.TravelPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPackageRepository implements Repository<TravelPackage> {

    private static final Map<String, TravelPackage> travelPackageMap = new HashMap<>();

    @Override
    public TravelPackage getValue(String key) {
        return travelPackageMap.get(key);
    }

    @Override
    public TravelPackage addKeyValue(String key, TravelPackage value) {
        return travelPackageMap.put(key, value);
    }

    @Override
    public List<TravelPackage> getAll() {
        return new ArrayList<>(travelPackageMap.values());
    }

}
