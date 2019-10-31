package ClassTask.pictureApp.userLogin.dao;

public interface DaoUser extends Dao<Long,User> {

    @Override
    void createTable();

    @Override
    Long insert(User user);

    @Override
    User selectByPassword(User user);
}
