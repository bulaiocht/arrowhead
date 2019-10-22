package jdbc.service;

import jdbc.SavePictureRequest;

import java.util.List;

public interface PictureService {

    long savePicture(SavePictureRequest request);

    List<Object> getAllPictures();

}
