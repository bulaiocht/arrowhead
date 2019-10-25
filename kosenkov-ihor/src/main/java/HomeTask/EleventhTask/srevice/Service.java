package HomeTask.EleventhTask.srevice;

import HomeTask.EleventhTask.dao.BasicDaoFactory;
import HomeTask.EleventhTask.dao.UserDao;
import HomeTask.EleventhTask.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Service {

    private UserDao userDao;
    private ObjectMapper objectMapper;

    public Service() {
        userDao = BasicDaoFactory.getUserDao();
        objectMapper = new ObjectMapper();
    }

    public void saveIntoDB(String firstName, String lastName, String age, String email, String password) {
        User user = User.newBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAge(Integer.parseInt(age))
                .setEmail(email)
                .setPassword(password)
                .build();

        userDao.save(user);
    }

    public String getUserJson() {

        List<User> users = userDao.selectAll();
        try {
            return objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }

    }

    public boolean isEmailAlreadyExists(String email) {
        return userDao.findByEmail(email);
    }

}
