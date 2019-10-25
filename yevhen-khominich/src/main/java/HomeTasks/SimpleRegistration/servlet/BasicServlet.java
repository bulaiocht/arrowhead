package HomeTasks.SimpleRegistration.servlet;

import HomeTasks.SimpleRegistration.entity.User;
import HomeTasks.SimpleRegistration.service.UserService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(
        name = "BasicServlet",
        urlPatterns = {"/api"}
)
public class BasicServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(BasicServlet.class);
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        final List<User> users = UserService.getAll();
        final PrintWriter out = resp.getWriter();

        String responce = gson.toJson(users);
        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(responce);
        out.flush();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (UserService.isUserWithEmail(req.getParameter("email"))) {
            try {throw new IllegalArgumentException("Already exist");}
            catch (IllegalArgumentException e){
                resp.getWriter().write("Email is already exist");
            }
        }

        User user = new User(req.getParameter("firstname"),
                req.getParameter("lastname"),
                req.getParameter("email"),
                req.getParameter("password"),
                Integer.parseInt(req.getParameter("age")));

        UserService.saveUser(user);
        resp.getWriter().write("User is saved successfully");
        req.getRequestDispatcher("menu.html").forward(req, resp);

    }


//        long size = file.getSize();
//        log.info("Size: {}", size);
//
//        try (InputStream inputStream = file.getInputStream()) {
//
//            Path tempFile = Files.createTempFile("img", ".jpg");
//            Path path = tempFile.toAbsolutePath();
//            log.info("Path: {}", path.toString());
//
//            FileOutputStream fos = new FileOutputStream(tempFile.toFile());
//
//            byte[] buff = new byte[1024];
//
//            while (true) {
//                int read = inputStream.read(buff);
//                if (read == -1) {
//                    break;
//                }
//                fos.write(buff, 0, read);
//            }
//
//            fos.close();
//
//
//            System.out.println(contentType);


//        String file_name = req.getParameter("fname");
//       `String parameter = req.getParameter("file");
//        String contextPath = req.getContextPath();
//        System.out.println(contextPath);
//        PrintWriter writer = resp.getWriter();
//        writer.write(file_name+"\n");
//        writer.flush();
//        writer.close();
}


