package HomeTask.EleventhTask.server;

import HomeTask.EleventhTask.servlet.RegisterServlet;
import HomeTask.EleventhTask.servlet.UserServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Server {
    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir("temp");
        tomcat.setPort(8080);

        String contextPath = "";
        String docBase = ".";
        String docBasePath = new File(docBase).getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBasePath);

        String servletName = RegisterServlet.class.getSimpleName();
        String servletClassName = RegisterServlet.class.getName();
        String urlPattern = "/register";

        tomcat.addServlet(contextPath, servletName, servletClassName);
        context.addServletMapping(urlPattern, servletName);

        servletName = UserServlet.class.getSimpleName();
        servletClassName = UserServlet.class.getName();
        urlPattern = "/user";

        tomcat.addServlet(contextPath, servletName, servletClassName);
        context.addServletMapping(urlPattern, servletName);


        tomcat.start();
        tomcat.getServer().await();

    }
}
