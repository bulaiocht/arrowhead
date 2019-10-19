package HomeTasks.HomeTaskEleventh.server;

import HomeTasks.HomeTaskEleventh.servlets.BasicServlet;
import HomeTasks.HomeTaskEleventh.servlets.PostServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Server {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);


        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());


        String name = PostServlet.class.getName();

        tomcat.addServlet(ctx,name,name);

        ctx.addServletMapping("/",name);
        name = BasicServlet.class.getName();

        tomcat.addServlet(ctx,name,name);

        ctx.addServletMapping("/list",name);

        tomcat.start();
        tomcat.getServer().await();

    }

}
