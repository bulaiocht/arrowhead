package HomeTask.EleventhTask.utilities;

import HomeTask.EleventhTask.dao.BasicDaoFactory;
import HomeTask.EleventhTask.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

//    public static boolean isEmailAlreadyExists(String email) {
//        UserDao userDao = BasicDaoFactory.getUserDao();
//        return userDao.findByEmail(email);
//    }

}
