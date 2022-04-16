package at.htl.embeddedid.control;

import at.htl.embeddedid.entity.Registration;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegistrationRepository implements PanacheRepository<Registration> {
}
