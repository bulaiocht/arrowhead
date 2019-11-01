package DB.DAO;

import DTO.PictureDTO;

import java.io.InputStream;
import java.util.List;

public interface BasicDao<ID, T> {

    T create(T t); // C - create

    void create(List<T> list); // C - create

    InputStream get(long id); //R - read

    List<PictureDTO> getAll(); //R - read

    boolean update(T t); //U - update

    boolean delete(long id); // D - delete
}
