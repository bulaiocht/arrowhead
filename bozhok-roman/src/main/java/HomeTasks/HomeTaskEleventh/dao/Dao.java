package HomeTasks.HomeTaskEleventh.dao;

import java.util.List;

public interface Dao <T1, T2> {
    void creatTable ();

    void insert(T1 t1);

    List<T1> selectAll();

    boolean selectType1WhereHaveType2(T2 t2);
}
