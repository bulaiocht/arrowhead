package servlet;

import DB.DAO.impl.PictureDao;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.PictureService;
import validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(
        name = "BasicServlet",
        urlPatterns = {"/api"}
)
@MultipartConfig
public class BasicServlet extends HttpServlet {

    public static final String ID_KEY = "id=";
    private final static Logger log = LoggerFactory.getLogger(BasicServlet.class);
    private static Gson gson = new Gson();
    PictureService pictureService = new PictureService(new PictureDao());


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("image/jpg");
        String queryString = req.getQueryString();

        if (queryString == null || queryString.isEmpty()) {
            String json = gson.toJson(pictureService.getAll());
            final PrintWriter writer = resp.getWriter();
            writer.write(json);
            writer.flush();
            writer.close();

        }

        if (queryString.contains(ID_KEY)) {

            String id = req.getParameter("id");
            InputStream byId = pictureService.getById(Integer.parseInt(id));
            ServletOutputStream outputStream = resp.getOutputStream();

            while (true) {
                final int read = byId.read();
                if (read == -1) {
                    break;
                }
                outputStream.write(read);
            }
            outputStream.flush();
            outputStream.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part file = req.getPart("file");
        InputStream is = file.getInputStream();
        String fname = req.getParameter("fname");
        String contentType = file.getContentType();

        final long size = file.getSize();

        if (Validator.checkImage(contentType)) {
            throw new IllegalArgumentException("Not image");
        }

        if (Validator.checkMaxSize(size)) {
            throw new IllegalArgumentException("No!");
        }

        log.info("Saving image is {}", pictureService.savePicture(is, fname));

    }

}
