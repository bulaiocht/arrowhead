package jdbc.test.dao.impl;

import jdbc.test.BankUser;
import jdbc.test.dao.CrudDao;

import java.util.Optional;

public interface UserDao extends CrudDao<BankUser, Long> {

    @Override
    Optional<BankUser> findById(Long id);

    @Override
    <S extends BankUser> S save(S entity);

    @Override
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);
}
