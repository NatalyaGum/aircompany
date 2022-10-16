package by.air_ministry.aircompany.entity;

import by.air_ministry.aircompany.entity.classification.MilitaryPlaneType;
import by.air_ministry.aircompany.entity.plane.AbstractPlane;
import by.air_ministry.aircompany.entity.plane.ExperimentalPlane;
import by.air_ministry.aircompany.entity.plane.MilitaryPlane;
import by.air_ministry.aircompany.entity.plane.PassengerPlane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends AbstractPlane> planes;

    public Airport(List<? extends AbstractPlane> planes) {
        this.planes = planes;
    }

    public List<? extends AbstractPlane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream()
                .filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream().filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(), Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryPlaneType type) {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getMilitaryPlaneType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return planes.equals(airport.planes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planes);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}