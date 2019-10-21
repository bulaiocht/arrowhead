package web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(
        name = "BasicServlet",
        urlPatterns = {"/api"}
)
@MultipartConfig
public class BasicServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
//        ServletInputStream inputStream = req.getInputStream();
//        BufferedReader reader = req.getReader();

//        String method = req.getMethod();
//        String requestURI = req.getRequestURI();
//        String queryString = req.getQueryString();
//        String contextPath = req.getContextPath();
//        HttpSession session = req.getSession();
//        session.setMaxInactiveInterval(3);
//        log.info("Session ID: {}", session.getId());
//        Enumeration<String> attributeNames = session.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            log.info("Session attribute name: {}", attributeNames.nextElement());
//        }
//
//        session.setAttribute("test", new Date());
//
//        Enumeration<String> headerNames = req.getHeaderNames();
//
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            String header = req.getHeader(name);
//            log.info("Header name: {} Header content: {}", name, header);
//        }
//
//        log.info("HTTP Method: {}", method);
//        log.info("Context path : {}", contextPath);
//        log.info("Request URI: {}", requestURI);
//        log.info("Query string: {}", queryString);
//
//        String remoteAddr = req.getRemoteAddr();
//
//        log.info("Remote addr: {}", remoteAddr);

        resp.setContentType("image/jpeg");
        ServletOutputStream outputStream = resp.getOutputStream();
        Path path = Paths.get("/home/horsey/Downloads/arrowhead.jpg");
        FileInputStream fis = new FileInputStream(path.toFile());
        byte [] buff = new byte[1024];
        while (true) {
            int read = fis.read(buff);
            if (read == -1) {
                break;
            }
            outputStream.write(buff, 0, read);
        }



        fis.close();
        outputStream.flush();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Part> parts = req.getParts();
        parts
                .forEach(part -> {
                    String contentType = part.getContentType();
                    log.info("Content-type: {}", contentType);
                    long size = part.getSize();
                    log.info("Size: {}", size);
                    try (InputStream inputStream = part.getInputStream()){
                        Path tempFile = Files.createTempFile("some-file", ".jpg");
                        Path path = tempFile.toAbsolutePath();
                        log.info("Path: {}", path.toString());
                        FileOutputStream fos = new FileOutputStream(tempFile.toFile());
                        byte [] buff = new byte[1024];
                        while (true) {
                            int read = inputStream.read(buff);
                            if (read == -1) {
                                break;
                            }
                            fos.write(buff, 0, read);
                        }

                        fos.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    protected void doPut(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doDelete(HttpServletRequest req,
                            HttpServletResponse resp) throws ServletException, IOException {


    }
}
