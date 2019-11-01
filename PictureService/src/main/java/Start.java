import DB.DAO.impl.PictureDao;
import DB.connection.DataSourceFactory;
import org.apache.catalina.Context;
import org.apache.catalina.Host;
import org.apache.catalina.startup.Tomcat;
import service.PictureService;
import java.io.File;

public class Start {
    public static void main(String[] args) throws Exception {

        String contextPath="";
        String appBasePath=new File("src/main/java/servlet").getAbsolutePath();
        String docBasePath=new File("src/main/webapp").getAbsolutePath();


        new PictureService(new PictureDao()).initialize();

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9095);

        Host host = tomcat.getHost();
        host.setAppBase(appBasePath);

        Context context = tomcat.addWebapp(contextPath,docBasePath);
        context.setDocBase(docBasePath);

        tomcat.start();
        tomcat.getServer().await();
    }
}
