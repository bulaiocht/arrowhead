package DB.DAO.impl;

import DB.DAO.BasicPictureDao;
import DB.connection.DataSourceFactory;
import DTO.PictureDTO;
import entity.Picture;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PictureDao implements BasicPictureDao {

    private static final String MAIN_EXCEPTION_MESSAGE = "Exception occurred";

    private DataSource dataSource;

    public PictureDao() {
        dataSource = DataSourceFactory.getH2();
    }

    public void initialize(){
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS PICTURE " +
                            "(ID LONG PRIMARY KEY AUTO_INCREMENT," +
                            "FILE_NAME VARCHAR(250)," +
                            "TIME_CREATION DATE," +
                            "IMAGE BLOB);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean savePicture(InputStream is, String filename) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement("INSERT INTO PICTURE (FILE_NAME,TIME_CREATION,IMAGE) values (?,?,?)")) {

            Date date = new Date(System.currentTimeMillis());
            pst.setString(1, filename);
            pst.setDate(2, date);
            pst.setBinaryStream(3, is);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Picture create(Picture picture) {

        return null;
    }

    @Override
    public void create(List<Picture> list) {

    }

    @Override
    public InputStream get(long id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement("SELECT IMAGE FROM PICTURE WHERE ID=?;", Statement.RETURN_GENERATED_KEYS);
        ) {
            pst.setLong(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()){
                return resultSet.getBinaryStream("IMAGE");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<PictureDTO> getAll() {

        List<PictureDTO> pictures = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pst = connection.prepareStatement("SELECT * FROM PICTURE;", Statement.RETURN_GENERATED_KEYS);
        ) {
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                pictures.add(toPictureDTO(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pictures;
    }

    private PictureDTO toPictureDTO(ResultSet rs) throws SQLException {
        return new PictureDTO(
                rs.getInt("ID"),
                rs.getString("FILE_NAME"),
                rs.getDate("TIME_CREATION")
        );

    }

    @Override
    public boolean update(Picture picture) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
