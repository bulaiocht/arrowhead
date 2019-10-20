package HomeTasks.HomeTaskEleventh.dao;

import java.util.List;

public interface UserDao {

    void creatTableUser ();

    void insertUser(User user);

    List<User> selectAllUser();

    boolean isUserByEmailPresent(String email);

}
