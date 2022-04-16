package at.htl.embeddedid.control;

import at.htl.embeddedid.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
}
