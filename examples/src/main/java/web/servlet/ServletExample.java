package web.servlet;

import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class ServletExample {

    public static void main(String[] args) throws LifecycleException, ServletException {

        String contextPath = "";
        String appBase = new File("src/main/java/web").getAbsolutePath();
        String docBase = new File("src/main/webapp").getAbsolutePath();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Host host = tomcat.getHost();
        host.setAppBase(appBase);

        Context context = tomcat.addWebapp(contextPath, docBase);
        context.setDocBase(docBase);

        tomcat.start();
        tomcat.getServer().await();

//        String contextPath = "/";
//        String appBase = new File("src/main/java/web/servlet").getAbsolutePath();
//        String docBase = new File("src/main/webapp").getAbsolutePath();
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8081);
//
//        Host host = tomcat.getHost();
//        host.setAppBase(appBase);
//
//        Context context = tomcat.addWebapp(contextPath, docBase);
//        context.setDocBase(docBase);
//        context.setAllowCasualMultipartParsing(true);
//
//        File classes = new File("build/classes");
//
//        WebResourceRoot resourceRoot = new StandardRoot(context);
//
//        DirResourceSet resourceSet = new DirResourceSet();
//
//        resourceSet.setRoot(resourceRoot);
//        resourceSet.setBase(classes.getAbsolutePath());
//        resourceSet.setInternalPath("/");
//        resourceSet.setWebAppMount("/WEB-INF/classes");
//
//        resourceRoot.addPreResources(resourceSet);
//        context.setResources(resourceRoot);
//
//        tomcat.start();
//        tomcat.getServer().await();

    }

}
