package jdbs;

import java.util.Optional;

public interface BasicUserDao extends BasicDao<Long,BasicUser> {

    @Override
    public Optional<BasicUser> findById(Long aLong);

    @Override
    public <S extends BasicUser> Long save(S entity);

    @Override
    public void deleteById(Long aLong);
}
