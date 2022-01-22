package at.htl.fileupload;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;


@Path("/upload")
public class UploadsResourceMultipartFormDataInput {

    /**
     * https://www.findbestopensource.com/article-detail/resteasy-advanced-file-upload
     *
     * @param uploadForm
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload(
            @MultipartForm MultipartFormDataInput uploadForm
    ) {

        Map<String, List<InputPart>> formDataMap = uploadForm.getFormDataMap();

        String contentDisposition = formDataMap.get("file").get(0).getHeaders().toString();
        System.out.println(contentDisposition);
        String[] elements = contentDisposition.split("\"");
        System.out.println(elements[3]);
        String fileName = elements[3];


        List<InputPart> inputParts = formDataMap.get("file");
        for (InputPart inputPart : inputParts) {
            try (InputStream is = inputPart.getBody(InputStream.class, null)) {
                Files.copy(is, Paths.get("file-upload", fileName), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("finished");
    }
}