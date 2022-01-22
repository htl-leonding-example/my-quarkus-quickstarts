package at.htl.fileupload;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.InputStream;

/**
 * https://howtodoinjava.com/resteasy/jax-rs-resteasy-file-upload-html-form-example/
 */
public class UploadForm {



    public UploadForm() {
    }

    @FormParam("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    private InputStream fileInputStream;


    public InputStream getFileInputStream() {
        return fileInputStream;
    }
}
