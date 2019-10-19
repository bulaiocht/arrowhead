package HomeTasks.HomeTaskEleventh.dao;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static List<User> userList = new ArrayList<>();

    public static List<User> getUserList() {
        return userList;
    }

    public static void addUser (User user){
        userList.add(user);
    }


//    private static DataBase dataBase = new DataBase();
//
//    private DataBase() {
//        this.userList = new ArrayList<>();
//    }
//
//    public static DataBase getInstance(){
//        return dataBase;
//    }
}
