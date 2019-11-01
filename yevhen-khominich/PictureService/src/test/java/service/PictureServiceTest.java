package service;

import DB.DAO.impl.PictureDao;
import DTO.PictureDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PictureServiceTest {


    private PictureDao mockPictureDao = Mockito.mock(PictureDao.class);
    private PictureService pictureService = new PictureService(mockPictureDao);
    private FileInputStream fileInputStream;
    private final int INDEX = 1;

    @BeforeEach
    void init() throws IOException {
        fileInputStream = new FileInputStream("D:\\Projects\\ProjectOne\\src\\test\\resources\\picture.jpg");
    }

    @Test
    void whenGetByIdShouldReturnPictureTest() {

        InputStream expected = fileInputStream;

        when(mockPictureDao.get(INDEX)).thenReturn(expected);

        InputStream actual = pictureService.getById(INDEX);

        assertEquals(expected,actual);

    }

    @Test
    void whenSavePictureShouldReturnTrueTest() {
        String name = "picture";

        when(mockPictureDao.savePicture(fileInputStream, name)).thenReturn(true);

        assertTrue(pictureService.savePicture(fileInputStream, name));
    }

    @Test
    void whenSavePictureShouldReturnFalseTest() {
        String name = "picture";

        when(mockPictureDao.savePicture(fileInputStream, name)).thenReturn(false);

        assertFalse(pictureService.savePicture(fileInputStream, name));
    }

    @Test
    void whenGetAllShouldReturnListOfPicturesTest() {

        List<PictureDTO> expected = new ArrayList<>();
        expected.add(new PictureDTO(1, "Adas", new Date(1212)));

        when(mockPictureDao.getAll()).thenReturn(expected);


        List<PictureDTO> actual = pictureService.getAll();

        assertEquals(expected,actual);

    }

}
