package ClassTask.pictureApp.picture.service;

import ClassTask.pictureApp.picture.connection.ConnectionManagerFactory;
import ClassTask.pictureApp.picture.dao.PictDaoImpl;
import ClassTask.pictureApp.picture.dao.Picture;
import ClassTask.pictureApp.picture.dao.PictureDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

public class Service {


    public static final int MAX_IMG_SIZE_KB = 2000000;

    public static String getJSONResponse() {

        PictDaoImpl pictDao = new PictDaoImpl(ConnectionManagerFactory.getH2ConnectionManager());
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat dF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(dF);

        List<PictureDto> pictureDtos = pictDao.selectAll();
        pictureDtos.forEach(pictureDto -> System.out.println(pictureDto.toString()));
        try {
            return objectMapper.writeValueAsString(pictureDtos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static InputStream getImagePartById(String id) {
        PictDaoImpl pictDao = new PictDaoImpl(ConnectionManagerFactory.getH2ConnectionManager());

        InputStream inputStream = pictDao.selectByID(Long.parseLong(id));

        return inputStream;

    }

    public static void parts(Collection<Part> parts, String fileName) {
        parts.forEach(part -> {

            String contentType = part.getContentType();
            PictDaoImpl pictDao = new PictDaoImpl(ConnectionManagerFactory.getH2ConnectionManager());
            if ("image/jpeg".equals(contentType)) {
                long sizePict = part.getSize();
                System.out.println(sizePict);
                if (sizePict > MAX_IMG_SIZE_KB) {
                    throw new IllegalArgumentException("So tall");
                }
                String name = part.getName();
                int size = (int) part.getSize();
                byte[] data = new byte[size];
                try {

                    Picture picture = Picture.newBuilder()
                            .setFileName(fileName)
                            .setData(part.getInputStream())
                            .build();

                    pictDao.insert(picture);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
