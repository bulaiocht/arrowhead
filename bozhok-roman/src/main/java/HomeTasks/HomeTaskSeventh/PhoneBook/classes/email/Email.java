package HomeTasks.HomeTaskSeventh.PhoneBook.classes.email;

import HomeTasks.HomeTaskSeventh.PhoneBook.classes.readerConfig.PropertiesLoader;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Email {
    private static final Properties EMAILCONFIG = loader();


    private static Properties loader (){
        try {
            FileInputStream in = new FileInputStream(
                    String.format("bozhok-roman" +
                                    "%ssrc" +
                                    "%smain" +
                                    "%sresources" +
                                    "%sconfigurationPhoneBook" +
                                    "%EmailConfig.properties",
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator,
                            File.separator));
            Properties properties = new Properties();
            properties.load(in);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }

    public static void sendEmail(String email) throws MessagingException {
        Session mailSession = Session.getDefaultInstance(EMAILCONFIG);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("myemail"));
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
        message.setSubject("PhoneBook");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("PhoneBook");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(PropertiesLoader.PATHPHONEBOOK);

        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(PropertiesLoader.PATHPHONEBOOK);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);


        Transport tr = mailSession.getTransport();
        tr.connect(null,"roma1998+++");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();




    }

}
