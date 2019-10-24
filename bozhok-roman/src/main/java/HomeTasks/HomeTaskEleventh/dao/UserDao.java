package HomeTasks.HomeTaskEleventh.dao;

import java.util.List;

public interface UserDao extends Dao<User,String>{
    @Override
    void creatTable();

    @Override
    void insert(User user);

    @Override
    List<User> selectAll();

    @Override
    boolean selectType1WhereHaveType2(String s);



}
