package Service;

import Dto.Destination;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DestinationServiceTest {

    private DestinationService destinationService= new DestinationService();

    @Test
    void addDestination() throws Exception {
        Destination destination = new Destination("test", new ArrayList<>(Arrays.asList("x")));
        Destination destination1 = destinationService.addDestination(destination);
        assert destination1.equals(destination);
    }

    @Test
    void addActivityToDestination() {
    }
}