package Service;

import DTO.Activity;
import DTO.Destination;
import Exception.DestinationNotFoundException;
import Repository.Repository;
import Exception.*;
import Repository.*;

import java.util.Objects;

public class DestinationService {

    private final Repository<Destination> destinationRepository;

    public DestinationService(){
        this.destinationRepository = new DestinationRepository();
    }

    public Destination addDestination(Destination destination) throws Exception {
        Destination persistedDestination = destinationRepository.getValue(destination.getName());
        if(Objects.nonNull(persistedDestination)){
            throw new DuplicateDestinationException("Destination with name " + destination.getName()+ " already exist");
        }
        destinationRepository.addKeyValue(destination.getName(), destination);
        return destination;
    }

    public Destination addActivityToDestination(String activityName, String destination) throws Exception {
        Destination persistedDestination = destinationRepository.getValue(destination);
        if (Objects.nonNull(persistedDestination)) {
            persistedDestination.addActivity(activityName);
            destinationRepository.addKeyValue(destination, persistedDestination);
            return persistedDestination;
        }
        throw new DestinationNotFoundException("Destination not found");
    }

    public Destination getDestination(String destinationName) throws Exception {
        Destination destination = destinationRepository.getValue(destinationName);
        if(Objects.nonNull(destination)){
            return destination;
        }
        throw new DestinationNotFoundException("Destination not found");
    }
}
