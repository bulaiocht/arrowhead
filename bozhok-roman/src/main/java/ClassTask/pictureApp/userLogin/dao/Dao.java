package ClassTask.pictureApp.userLogin.dao;

public interface Dao<ID,T> {

    void createTable();

    ID insert(T t);

    T selectByPassword(T t);


}
