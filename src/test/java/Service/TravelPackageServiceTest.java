package Service;

import Dto.TravelPackage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageServiceTest {

    private TravelPackageService travelPackageService = new TravelPackageService();

    @Test
    void addTravelPackage() throws Exception {
        TravelPackage travelPackage= new TravelPackage("t1", 10, new ArrayList<>(), new ArrayList<>());
        TravelPackage travelPackage1 = travelPackageService.addTravelPackage(travelPackage);
        assert travelPackage1.equals(travelPackage);
    }

    @Test
    void addDestinationToTravelPackage() {
    }

    @Test
    void addPassengerToTravelPackage() {
    }
}