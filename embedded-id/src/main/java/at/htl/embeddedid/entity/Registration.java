package at.htl.embeddedid.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDate;

@Entity
public class Registration {

    @EmbeddedId
    private RegistrationId registrationId;

    @ManyToOne
    @MapsId("personId")
    private Person person;

    @ManyToOne
    @MapsId("vehicleId")
    private Vehicle vehicle;

    private String registrationPlate;
    private LocalDate startDate;
    private LocalDate endDate;

    //region constructors
    public Registration() {
    }

    public Registration(Person person, Vehicle vehicle, String registrationPlate, LocalDate startDate) {
        this.person = person;
        this.vehicle = vehicle;
        this.registrationPlate = registrationPlate;
        this.startDate = startDate;
        this.registrationId = new RegistrationId(vehicle.getId(), person.getId());
    }
    //endregion

    //region getter and setter
    public RegistrationId getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(RegistrationId registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    //endregion
}
