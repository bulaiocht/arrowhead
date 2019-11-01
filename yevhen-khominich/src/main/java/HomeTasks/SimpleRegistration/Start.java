package HomeTasks.SimpleRegistration;

import HomeTasks.SimpleRegistration.DB.DAO.impl.UserDao;
import HomeTasks.SimpleRegistration.service.UserService;
import HomeTasks.SimpleRegistration.servlet.BasicServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Start {
    public static void main(String[] args) throws LifecycleException, ServletException {

        String docBasePath = new File("yevhen-khominich/src/main/webapp").getAbsolutePath();

        new UserService(new UserDao()).initialize();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9095);

        Context context = tomcat.addWebapp("", docBasePath);
        tomcat.addServlet(context, BasicServlet.class.getName(),BasicServlet.class.getName());
        context.addServletMapping("/api",BasicServlet.class.getName());


        tomcat.start();
        tomcat.getServer().await();


    }
}
