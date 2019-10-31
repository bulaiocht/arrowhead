package ClassTask.pictureApp.picture.dao;

import java.io.InputStream;
import java.util.List;

public interface PictDao extends Dao<Long,PictureDto,Picture, InputStream> {
    @Override
    default void create() {

    }

    @Override
    default void insert(Picture picture) {

    }

    @Override
    default InputStream selectByID(Long aLong) {
        return null;
    }

    @Override
    default List<PictureDto> selectAll() {
        return null;
    }
}
