package ClassWorkTest.pictureAppTest;

import ClassTask.pictureApp.picture.dao.PictDao;
import ClassTask.pictureApp.picture.service.Service;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;



public class TestServicePictureApp {

    private String ID = "1";
    private String fail_ID = "qwe";
    private String contentTypeJpeg = "image/jpeg";
    private long shortPictureSize = 1900000;
    private long tallPictureSize = 20000000;
    private String fileName = "123";



    private static Collection<Part> parts ;


    private static Part part;

    @BeforeAll
    public static void init(){
        parts = new ArrayList<>();
        part = Mockito.mock(Part.class);
        parts.add(part);



    }


    @Test
    void testParts() {

        Mockito.when(part.getContentType()).thenReturn(contentTypeJpeg);
        Mockito.when(part.getSize()).thenReturn(tallPictureSize);
        Assertions.assertThrows(IllegalArgumentException.class,()->Service.parts(parts,fileName),"So tall");


        Mockito.when(part.getSize()).thenReturn(shortPictureSize);
        Assertions.assertDoesNotThrow(()->Service.parts(parts,fileName));



    }

    @Test
    void testSelectByID() {

        Assertions.assertThrows(NumberFormatException.class,()->Service.getImagePartById(fail_ID));

        Assertions.assertThrows(NullPointerException.class,()->Service.getImagePartById(ID));


    }

    @Test
    void testGetJSON() {

        Assertions.assertThrows(NullPointerException.class,()->Service.getJSONResponse());

    }
}
