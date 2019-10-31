package ClassTask.pictureApp.picture.dao;



import ClassTask.pictureApp.picture.connection.ConnectionManager;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PictDaoImpl implements PictDao{

    private static final String INSERT_PICTURE_SQL =
            "INSERT INTO PICTURE(" +
            "FILE_NAME, " +
            "IMAGE," +
            "DATE) " +
            "VALUES (?,?,?);";

    private static final String CREATE_TABLE_PICTURE_SQL =
            "CREATE TABLE IF NOT EXISTS PICTURE(" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "FILE_NAME VARCHAR(45)," +
            "IMAGE BLOB," +
            "DATE DATE);";

    private static final String SELECT_WHERE_ID_SQL =
            "SELECT *" +
            " FROM PICTURE" +
            " WHERE ID = ?;";

    private static final String SELECT_FROM_PICTURE =
            "SELECT * FROM PICTURE;";


    private final ConnectionManager connectionManager;

    public PictDaoImpl(ConnectionManager connectionManager) {

        this.connectionManager = connectionManager;
    }

    @Override
    public void create() {
        Connection connection = connectionManager.getConnection();
        try {


            Statement statement = connection.createStatement();

            statement.execute(CREATE_TABLE_PICTURE_SQL);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void insert(Picture picture) {
        Connection connection = connectionManager.getConnection();
        try {

            PreparedStatement preparedStatement =
                    connection.prepareStatement(INSERT_PICTURE_SQL);


            preparedStatement.setString(1,picture.getFileName());
            preparedStatement.setBlob(2,picture.getData());
            preparedStatement.setDate(3,new Date(System.currentTimeMillis()));



            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public InputStream selectByID(Long aLong) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    connection.prepareStatement(SELECT_WHERE_ID_SQL);

            preparedStatement.setLong(1,aLong);

            ResultSet resultSet = preparedStatement.executeQuery();
            Blob image = null;
            while (resultSet.next()) {
                 image = resultSet.getBlob("IMAGE");
            }


            return image.getBinaryStream();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }finally {
            try {
                connection.close ();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<PictureDto> selectAll() {
        Connection connection = connectionManager.getConnection();
        List<PictureDto> pictureDtos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SELECT_FROM_PICTURE);


            ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            PictureDto pictureDto = PictureDto
                    .newBuilder()
                    .setId(resultSet.getLong("ID"))
                    .setFileName(resultSet.getString("FILE_NAME"))
                    .setDate(resultSet.getDate("DATE")).build();

            pictureDtos.add(pictureDto);
        }
            connection.close();
            return  pictureDtos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}
