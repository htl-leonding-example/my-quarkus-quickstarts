package at.htl.fileupload;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;


@Path("/upload2")
public class UploadsResourceMultipartForm {

    @Inject
    Logger LOG;

    /**
     * https://www.findbestopensource.com/article-detail/resteasy-advanced-file-upload
     *
     * @param uploadForm
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload(
            @MultipartForm UploadForm uploadForm,
            String filename
    ) {


//        try(ByteArrayOutputStream targetStream = new ByteArrayOutputStream()){
//            is.transferTo(new FileOutputStream(Paths.get("file-upload", filename).toFile()));
//        }
//
//        int read = 0;
//        byte[] bytes = new byte[1024];
//
//        try (OutputStream os = new FileOutputStream(Paths.get("file-upload", filename).toFile())) {
//            while ((read = is.read(bytes)) != -1) {
//                os.write(bytes, 0, read);
//            }
//            os.flush();
//        }


        try (InputStream is = uploadForm.getFileInputStream()) {
            Files.copy(is, Paths.get("file-upload", filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            LOG.error(ex.getMessage());
        }





        System.out.println("finished");
    }
}