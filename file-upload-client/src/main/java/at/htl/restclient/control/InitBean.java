package at.htl.restclient.control;

import at.htl.restclient.boundary.FileUploadService;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;

@ApplicationScoped
public class InitBean {

    @Inject
    @RestClient
    FileUploadService fileUploadService;

    void init(@Observes StartupEvent event) {

        File file = new File("timmy-modern-art.jpg");
        System.out.println(file.getName());
        System.out.println(fileUploadService.uploadFile(file, file.getName()));
    }

}
