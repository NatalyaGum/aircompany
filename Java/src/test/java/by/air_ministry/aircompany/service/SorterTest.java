package by.air_ministry.aircompany.service;

import by.air_ministry.aircompany.entity.Airport;
import by.air_ministry.aircompany.entity.classification.DisclosureLevel;
import by.air_ministry.aircompany.entity.classification.ExperimentalPlaneType;
import by.air_ministry.aircompany.entity.classification.MilitaryPlaneType;
import by.air_ministry.aircompany.entity.plane.AbstractPlane;
import by.air_ministry.aircompany.entity.plane.ExperimentalPlane;
import by.air_ministry.aircompany.entity.plane.MilitaryPlane;
import by.air_ministry.aircompany.entity.plane.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class SorterTest {

    Sorter sorter = new Sorter();
    public List<AbstractPlane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET));
    List<AbstractPlane> sortedPlanesByMaxFlightDistance = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER));

    List<AbstractPlane> sortedPlanesByMaxSpeed = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER));

    List<AbstractPlane> sortedPlanesByLoadCapacity = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT));
    public Airport airport = new Airport(planes);
    public Airport expectedAirportSortedByDistant = new Airport(sortedPlanesByMaxFlightDistance);
    public Airport expectedAirportSortedBySpeed = new Airport(sortedPlanesByMaxSpeed);
    public Airport expectedAirportSortedByCapacity = new Airport(sortedPlanesByLoadCapacity);

    @Test
    public void testSortPlanesByMaxFlightDistance() {
        sorter.sortPlanesByMaxFlightDistance(airport);
        Assert.assertEquals(airport, expectedAirportSortedByDistant);
    }

    @Test
    public void testSortPlanesByMaxLoadCapacity() {
        sorter.sortPlanesByMaxLoadCapacity(airport);
        Assert.assertEquals(airport, expectedAirportSortedByCapacity);
    }

    @Test
    public void testSortPlanesByMaxSpeed() {
        sorter.sortPlanesByMaxSpeed(airport);
        Assert.assertEquals(airport, expectedAirportSortedBySpeed);
    }
}