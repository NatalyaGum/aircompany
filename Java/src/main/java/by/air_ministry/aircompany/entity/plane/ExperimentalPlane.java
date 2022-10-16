package by.air_ministry.aircompany.entity.plane;

import by.air_ministry.aircompany.entity.classification.DisclosureLevel;
import by.air_ministry.aircompany.entity.classification.ExperimentalPlaneType;

import java.util.Objects;

public class ExperimentalPlane extends AbstractPlane {

    private ExperimentalPlaneType experimentalPlaneType;
    private DisclosureLevel disclosureLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance,
                             int maxLoadCapacity, ExperimentalPlaneType experimentalPlaneType,
                             DisclosureLevel disclosureLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.disclosureLevel = disclosureLevel;
    }

    public DisclosureLevel getDisclosureLevel() {
        return disclosureLevel;
    }

    public void setDisclosureLevel(DisclosureLevel disclosureLevel) {
        this.disclosureLevel = disclosureLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return experimentalPlaneType == that.experimentalPlaneType
                && disclosureLevel == that.disclosureLevel;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), experimentalPlaneType, disclosureLevel); }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", experimentalPlaneType=" + experimentalPlaneType +
                        ", disclosureLevel=" + disclosureLevel +
                        '}');
    }
}
