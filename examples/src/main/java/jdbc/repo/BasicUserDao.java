package jdbc.repo;

import jdbc.BasicUser;

import java.util.Optional;

public interface BasicUserDao extends BasicDao<Long, BasicUser> {

    @Override
    Optional<BasicUser> findById(Long aLong);

    @Override
    <S extends BasicUser> Long save(S entity);

    @Override
    void deleteById(Long aLong);

}
