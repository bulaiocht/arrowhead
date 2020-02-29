package service;

import DB.DAO.impl.PictureDao;
import DB.connection.DataSourceFactory;
import DTO.PictureDTO;
import entity.Picture;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PictureService {

    private PictureDao pictureDao;

    public PictureService(PictureDao pictureDao) {
        this.pictureDao = pictureDao;
    }

    public void initialize() {
        pictureDao.initialize();
    }

    public boolean savePicture(InputStream is, String filename) {
      return pictureDao.savePicture(is, filename);
    }

    public InputStream getById(long id) {
        return pictureDao.get(id);
    }

    public List<PictureDTO> getAll() {
        return pictureDao.getAll();
    }

}
