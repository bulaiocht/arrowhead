package HomeTask.EleventhTask.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<ID, T> {

    void createTable();

    boolean findByEmail(String email);

    <S extends T> void save(S entity);

    List<T> selectAll();

}
