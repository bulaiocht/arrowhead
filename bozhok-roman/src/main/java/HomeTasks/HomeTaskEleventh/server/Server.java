package HomeTasks.HomeTaskEleventh.server;

import HomeTasks.HomeTaskEleventh.dao.UserDaoInit;
import HomeTasks.HomeTaskEleventh.propertyLoader.PropertyLoader;
import HomeTasks.HomeTaskEleventh.servlets.GetAllUsersServlet;
import HomeTasks.HomeTaskEleventh.servlets.LoginServlet;
import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

public class Server {
    private static final String APP_BASE = new File(PropertyLoader.APP_BASE).getAbsolutePath();
    private static final String DOC_BASE = new File(PropertyLoader.DOC_BASE).getAbsolutePath();
    private static final String CONTEXT_PATH = PropertyLoader.CONTEXT_PATH;
    private static final int PORT = PropertyLoader.PORT;
    private static final Tomcat tomcat = new Tomcat();

    private static void serverConnectionFreeVersion () throws LifecycleException {


        tomcat.setPort(PORT);

        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        new UserDaoInit().creatTable();
        String name = LoginServlet.class.getName();

        tomcat.addServlet(ctx,name,name);

        ctx.addServletMapping("/login",name);
        name = GetAllUsersServlet.class.getName();

        tomcat.addServlet(ctx,name,name);

        ctx.addServletMapping("/list",name);

        tomcat.start();
        tomcat.getServer().await();
    }

    private static void serverConnectionFullVersion() throws ServletException, LifecycleException {


        tomcat.setPort(PORT);

        Host host = tomcat.getHost();
        host.setAppBase(APP_BASE);

        Context context = tomcat.addWebapp(CONTEXT_PATH, DOC_BASE);
        context.setDocBase(DOC_BASE);
        new UserDaoInit().creatTable();
        String name = LoginServlet.class.getName();

        tomcat.addServlet(context,name,name);

        context.addServletMapping("/login",name);
        name = GetAllUsersServlet.class.getName();

        tomcat.addServlet(context,name,name);

        context.addServletMapping("/list",name);

        tomcat.start();
        tomcat.getServer().await();
    }
    public static void main(String[] args) throws LifecycleException, ServletException {
        serverConnectionFullVersion();

    }

}
