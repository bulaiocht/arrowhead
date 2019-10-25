package HomeTask.EleventhTask.dao;

import HomeTask.EleventhTask.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<Integer, User> {

    @Override
    void createTable();

    @Override
    boolean findByEmail(String email);

    @Override
    <S extends User> void save(S entity);

    @Override
    List<User> selectAll();
}
