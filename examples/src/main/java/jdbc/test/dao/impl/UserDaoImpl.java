package jdbc.test.dao.impl;

import jdbc.test.BankUser;
import jdbc.test.ConnectionManager;

import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private final ConnectionManager connectionManager;

    public UserDaoImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Optional<BankUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public <S extends BankUser> S save(S entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
