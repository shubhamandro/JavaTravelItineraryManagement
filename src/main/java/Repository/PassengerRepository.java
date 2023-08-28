package Repository;

import Dto.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengerRepository implements Repository<Passenger> {

    private static final Map<String, Passenger> passengerMap = new HashMap<>();

    @Override
    public Passenger getValue(String key) {
        return passengerMap.get(key);
    }

    @Override
    public Passenger addKeyValue(String key, Passenger value) {
        return passengerMap.put(key, value);
    }

    @Override
    public List<Passenger> getAll() {
        return new ArrayList<>(passengerMap.values());
    }

}
