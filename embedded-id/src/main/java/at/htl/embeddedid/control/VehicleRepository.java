package at.htl.embeddedid.control;

import at.htl.embeddedid.entity.Vehicle;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {
}
