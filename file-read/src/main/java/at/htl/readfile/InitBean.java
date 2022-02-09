package at.htl.readfile;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@ApplicationScoped
public class InitBean {

    @ConfigProperty(name = "file.name.csv")
    String fileName;

    void init(@Observes StartupEvent event) {

        try {
            // Einlesen eines einzelnen Wertes aus der Datei
            String location = Files.lines(Path.of(fileName))
                    .skip(4)
                    .findFirst()
                    .map(line -> {
                        var elements = line.split(":");
                        System.out.println(elements[1]);
                        return elements[1].trim();
                    })
                    .get();

            // Einlesen aller Temperaturen und transponieren für Ausgabe von yyyy-mm/temperature
            Files.lines(Path.of(fileName))
                    .skip(14)
                    .forEach(line -> {
                        var elements = line.split(";");
                        for (int i = 1; i < 13; i++) {
                            if (!elements[i].equals("999999")) {
                                System.out.printf("%s-%d/%s\n", elements[0], i, elements[i]);
                            }
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
