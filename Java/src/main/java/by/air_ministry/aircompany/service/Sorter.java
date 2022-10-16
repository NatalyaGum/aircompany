package by.air_ministry.aircompany.service;

import by.air_ministry.aircompany.entity.Airport;
import by.air_ministry.aircompany.entity.plane.AbstractPlane;

import java.util.Comparator;

public class Sorter {

    public void sortPlanesByMaxFlightDistance(Airport airport) {
        airport.getPlanes().sort(Comparator.comparingInt(AbstractPlane::getMaxFlightDistance));
    }
    public void sortPlanesByMaxSpeed(Airport airport) {
        airport.getPlanes().sort(Comparator.comparingInt(AbstractPlane::getMaxSpeed));
    }
    public void sortPlanesByMaxLoadCapacity(Airport airport) {
        airport.getPlanes().sort(Comparator.comparingInt(AbstractPlane::getMinLoadCapacity));
    }
}
