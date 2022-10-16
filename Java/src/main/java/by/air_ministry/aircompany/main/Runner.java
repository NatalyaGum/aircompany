package by.air_ministry.aircompany.main;

import by.air_ministry.aircompany.entity.Airport;
import by.air_ministry.aircompany.entity.plane.AbstractPlane;
import by.air_ministry.aircompany.data.PlaneList;
import by.air_ministry.aircompany.service.Sorter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

    static Logger logger = Logger.getLogger(Runner.class.getName());
    static final List<AbstractPlane> planes = PlaneList.getPlaneList();

    public static void main(String[] args) {

        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());

        Sorter sorter = new Sorter();
        sorter.sortPlanesByMaxFlightDistance(militaryAirport);
        sorter.sortPlanesByMaxSpeed(passengerAirport);

        logger.log(Level.INFO, "Military airport sorted by max distance: {0}", militaryAirport);
        logger.log(Level.INFO, "Passenger airport sorted by max speed: {0}", passengerAirport);
        logger.log(Level.INFO, "Plane with max passenger capacity:{0}", passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
