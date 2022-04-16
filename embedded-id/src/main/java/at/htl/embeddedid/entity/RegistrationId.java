package at.htl.embeddedid.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RegistrationId implements Serializable {

    @Column(name = "VEHICLE_ID")
    private Long vehicleId;

    @Column(name = "PERSON_ID")
    private Long personId;

    public RegistrationId() {
    }

    public RegistrationId(Long vehicleId, Long personId) {
        this.vehicleId = vehicleId;
        this.personId = personId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationId that = (RegistrationId) o;
        return vehicleId.equals(that.vehicleId) && personId.equals(that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, personId);
    }
}
