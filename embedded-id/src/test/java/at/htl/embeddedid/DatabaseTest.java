package at.htl.embeddedid;

import at.htl.embeddedid.control.PersonRepository;
import at.htl.embeddedid.control.RegistrationRepository;
import at.htl.embeddedid.control.VehicleRepository;
import at.htl.embeddedid.entity.Person;
import at.htl.embeddedid.entity.Registration;
import at.htl.embeddedid.entity.Vehicle;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;

@QuarkusTest
public class DatabaseTest {

    @Inject
    PersonRepository personRepository;

    @Inject
    VehicleRepository vehicleRepository;

    @Inject
    RegistrationRepository registrationRepository;

    @Transactional
    @Test
    void createInstances() {
        Person hans = new Person("Hans", "Huber");
        Vehicle opel = new Vehicle("Opel", "Kapitaen");
        Registration registration = new Registration(hans, opel, "ABC-123", LocalDate.now());
        registrationRepository.persist(registration);
    }
}
