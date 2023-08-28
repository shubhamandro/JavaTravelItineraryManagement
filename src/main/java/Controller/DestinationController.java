package Controller;

import DTO.Activity;
import DTO.Destination;
import Service.DestinationService;

import java.util.Objects;

public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController() {
        this.destinationService = new DestinationService();
    }


    public Destination addDestination(Destination destination) throws Exception {
        return destinationService.addDestination(destination);
    }

    public Destination getDestination(String destinationName) throws Exception {
        return destinationService.getDestination(destinationName);
    }
}
