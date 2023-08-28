package Repository;

import java.util.List;

public interface Repository<T> {

    T getValue(String key);

    T addKeyValue(String key, T value);

    List<T> getAll();
}
