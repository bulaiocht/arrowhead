package HomeTask.EleventhTask.servlet;

import HomeTask.EleventhTask.error.ErrorMessage;
import HomeTask.EleventhTask.srevice.Service;
import HomeTask.EleventhTask.utilities.Utilities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

@WebServlet(
        name = "registerServlet",
        urlPatterns = "/register"
)
public class RegisterServlet extends HttpServlet {

    private static final int MIN_AGE = 18;
    public static final String HTML_PAGE = "html_page";
    private Service service = new Service();
    private String htmlPage;


    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(HTML_PAGE);
        htmlPage = resourceBundle.getString("page");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String age = req.getParameter("age");
        PrintWriter writer = resp.getWriter();

        if (email == null) {
            writeForm(writer, ErrorMessage.NO_ERROR);
        }
        if (email!=null && !Utilities.isValidEmail(email)) {
            writeForm(writer, ErrorMessage.INVALID_EMAIL);
        }
        if (age != null && Integer.parseInt(age) < MIN_AGE) {
            writeForm(writer, ErrorMessage.INVALID_AGE);
        }
        if (email!=null && service.isEmailAlreadyExists(email)) {
            writeForm(writer, ErrorMessage.IS_REGISTERED);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(!Utilities.isValidEmail(email) || Integer.parseInt(age) < MIN_AGE || service.isEmailAlreadyExists(email)){
            doGet(req, resp);
        }

        if (Utilities.isValidEmail(email) && Integer.parseInt(age) >= MIN_AGE && !service.isEmailAlreadyExists(email)) {
            service.saveIntoDB(firstName, lastName, age, email, password);
            writer.println("<h2>Successful registration!</h2>");
            writer.flush();
            writer.close();
            System.out.println(firstName + " " + lastName + ", " + age + ", " + email + ", " + password);
        }
    }
    //TODO вынести в проперти
    private void writeForm(PrintWriter writer, ErrorMessage errorMessage) {
        String message = String.format(htmlPage, errorMessage.getMessage());
        writer.println(message);


        writer.flush();
        writer.close();
    }
}
