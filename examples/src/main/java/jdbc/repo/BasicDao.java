package jdbc.repo;

import java.util.Optional;

public interface BasicDao<ID, T> {

    Optional<T> findById(ID id);

    <S extends T> ID save(S entity);

    void deleteById(ID id);

}
