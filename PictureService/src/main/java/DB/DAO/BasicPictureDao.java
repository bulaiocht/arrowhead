package DB.DAO;

import DTO.PictureDTO;
import entity.Picture;

import java.io.InputStream;
import java.util.List;

public interface BasicPictureDao extends BasicDao<Long, Picture> {

    @Override
    Picture create(Picture picture);

    @Override
    void create(List<Picture> list);

    @Override
    InputStream get(long id);

    @Override
    List<PictureDTO> getAll();

    @Override
    boolean update(Picture picture);

    @Override
    boolean delete(long id);
}
