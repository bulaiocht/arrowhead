package ClassTask.pictureApp.picture.dao;

import java.util.List;

public interface Dao <ID,T1,P,T2> {

    void create();
    void insert(P p);

    T2 selectByID(ID id);

    List<T1> selectAll();

}
