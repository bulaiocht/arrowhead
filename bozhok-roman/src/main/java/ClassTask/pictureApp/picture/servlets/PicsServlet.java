package ClassTask.pictureApp.picture.servlets;



import ClassTask.pictureApp.picture.service.Service;

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
import java.util.Collection;

@WebServlet
@MultipartConfig
public class PicsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id==null){
            PrintWriter writer = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.write(Service.getJSONResponse());
            writer.flush();
            writer.close();


        }else {

            resp.setContentType("image/jpeg");
            ServletOutputStream outputStream = resp.getOutputStream();
            InputStream imagePartById = Service.getImagePartById(id);
            byte [] buff = new byte[1024];
            while (true) {
                int read = imagePartById.read(buff);
                if (read == -1) {
                    break;
                }
                outputStream.write(buff, 0, read);
            }



            imagePartById.close();
            outputStream.flush();
            outputStream.close();


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Collection<Part> parts = req.getParts();
        String file_name = req.getParameter("file_name");
        PrintWriter writer = resp.getWriter();
        try {
            Service.parts(parts,file_name);
            writer.write("Congratylation!!");
            writer.flush();

        }catch (IllegalArgumentException e){
            resp.sendError(400,"Error:"+e.toString().split(": ")[1]+"!!!");



        }writer.close();




    }
}
