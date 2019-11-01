package jdbs;

import java.util.Optional;

public class BasicUserDaoImpl implements BasicUserDao {
    @Override
    public Optional<BasicUser> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public <S extends BasicUser> Long save(S entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
