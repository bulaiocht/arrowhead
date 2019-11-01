package HomeTasks.SimpleRegistration.DB.DAO;

import java.util.List;

public interface BasicDao<ID, T> {

    T create(T t); // C - create

    void saveAll(List<T> list); // C - create

    T get(long id); //R - read

    List<T> getAll(); //R - read

    boolean update(T t); //U - update

    boolean delete(long id); // D - delete
}
