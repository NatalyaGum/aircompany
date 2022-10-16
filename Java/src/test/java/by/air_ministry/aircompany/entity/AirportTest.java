package by.air_ministry.aircompany.entity;

import by.air_ministry.aircompany.entity.classification.DisclosureLevel;
import by.air_ministry.aircompany.entity.classification.ExperimentalPlaneType;
import by.air_ministry.aircompany.entity.classification.MilitaryPlaneType;
import by.air_ministry.aircompany.entity.plane.AbstractPlane;
import by.air_ministry.aircompany.entity.plane.ExperimentalPlane;
import by.air_ministry.aircompany.entity.plane.MilitaryPlane;
import by.air_ministry.aircompany.entity.plane.PassengerPlane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AirportTest {
    public List<AbstractPlane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, DisclosureLevel.TOP_SECRET)
    );

    public List<AbstractPlane> expectedMilitaryPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneType.TRANSPORT));

    public List<AbstractPlane> expectedPassengerPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196));

    public List<AbstractPlane> expectedExperimentalPlanes = Arrays.asList(
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneType.HIGH_ALTITUDE, DisclosureLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneType.VTOL, DisclosureLevel.TOP_SECRET));
    public List<AbstractPlane> expectedBomberPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneType.BOMBER));

    public Airport airport = new Airport(planes);

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);


    @Test
    public void testGetPlanes() {
        List<? extends AbstractPlane> actualPlanes = airport.getPlanes();
        Assert.assertEquals(actualPlanes, planes);
    }

    @Test
    public void testGetPassengerPlanes() {
        List<PassengerPlane> actualPlanes = airport.getPassengerPlanes();
        Assert.assertEquals(actualPlanes, expectedPassengerPlanes);
    }

    @Test
    public void testGetMilitaryPlanes() {
        List<MilitaryPlane> actualPlanes = airport.getMilitaryPlanes();
        Assert.assertEquals(actualPlanes, expectedMilitaryPlanes);
    }

    @Test
    public void testGetExperimentalPlanes() {
        List<ExperimentalPlane> actualPlanes = airport.getExperimentalPlanes();
        Assert.assertEquals(actualPlanes, expectedExperimentalPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane actualPlane = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(actualPlane, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testGetMilitaryPlanesByType() {
        List<MilitaryPlane> actualPlanes = airport.getMilitaryPlanesByType(MilitaryPlaneType.BOMBER);
        Assert.assertEquals(actualPlanes, expectedBomberPlanes);
    }
}