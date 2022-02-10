package at.htl.readfile;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ApplicationScoped
public class InitBean {

    @Inject
    Logger log;

    @ConfigProperty(name = "file.name.csv")
    String fileName;

    void init(@Observes StartupEvent event) {

        // Einlesen eines einzelnen Wertes aus der Datei
        try (var s = Files.lines(Path.of(fileName))) {
            var location = s
                    .skip(4)
                    .findFirst()
                    .map(line -> {
                        var elements = line.split(":");
                        log.info(elements[1]);
                        return elements[1].trim();
                    })
                    .orElseThrow();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        // Einlesen aller Temperaturen und transponieren für Ausgabe von yyyy-mm/temperature
        try (var s = Files.lines(Path.of(fileName))) {
            s.skip(14)
                    .forEach(line -> {
                        var elements = line.split(";");
                        for (int i = 1; i < 13; i++) {
                            if (!elements[i].equals("999999")) {
                                log.infof("%s-%d/%s", elements[0], i, elements[i]);
                            }
                        }
                    });
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
