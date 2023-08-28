package Controller;

import Dto.Destination;
import Service.DestinationService;

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
