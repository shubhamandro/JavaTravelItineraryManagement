package Repository;

import Dto.Destination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationRepository implements Repository<Destination> {

    private static final Map<String, Destination> destinationMap = new HashMap<>();

    @Override
    public Destination getValue(String key) {
        return destinationMap.get(key);
    }

    @Override
    public Destination addKeyValue(String key, Destination value) {
        return destinationMap.put(key, value);
    }

    @Override
    public List<Destination> getAll() {
        return new ArrayList<>(destinationMap.values());
    }


}
