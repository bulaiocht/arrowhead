package jdbc.test.dao;

import java.util.Optional;

public interface CrudDao<T, ID> {

    Optional<T> findById(ID id);

    <S extends T> S save(S entity);

    void deleteById(ID id);

    boolean existsById(ID id);

}
