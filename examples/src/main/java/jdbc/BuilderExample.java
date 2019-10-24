package jdbc;

import jdbc.repo.BasicDaoFactory;
import jdbc.repo.BasicUserDao;

public class BuilderExample {
    public static void main(String[] args) {

        BasicUserDao userDao = BasicDaoFactory.getUserDao();

        userDao.findById(1L);
        userDao.save(new BasicUser());
        userDao.deleteById(2L);

    }
}
