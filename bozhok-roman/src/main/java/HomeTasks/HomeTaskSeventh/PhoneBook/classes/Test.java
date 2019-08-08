package HomeTasks.HomeTaskSeventh.PhoneBook.classes;


import HomeTasks.HomeTaskSeventh.PhoneBook.classes.email.Email;

import javax.mail.MessagingException;


public class Test {
    public static void main(String[] args) {
        try {
            Email.sendEmail("ntcb10@mail.ru");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
