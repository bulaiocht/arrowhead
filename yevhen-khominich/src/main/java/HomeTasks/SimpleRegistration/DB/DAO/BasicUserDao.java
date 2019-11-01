package HomeTasks.SimpleRegistration.DB.DAO;

import HomeTasks.SimpleRegistration.entity.User;


import java.util.List;

public interface BasicUserDao extends BasicDao<Long, User> {

    @Override
    User create(User user);

    @Override
    void saveAll(List<User> list);

    @Override
    User get(long id);

    @Override
    List<User> getAll();

    @Override
    boolean update(User user);

    @Override
    boolean delete(long id);
}
