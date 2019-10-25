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

@WebServlet(
        name = "registerServlet",
        urlPatterns = "/register"
)
public class RegisterServlet extends HttpServlet {

    Service service = new Service();

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
        if (age != null && Integer.parseInt(age) < 18) {
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

        if(!Utilities.isValidEmail(email) || Integer.parseInt(age) < 18 || service.isEmailAlreadyExists(email)){
            doGet(req, resp);
        }

        if (Utilities.isValidEmail(email) && Integer.parseInt(age) >= 18 && !service.isEmailAlreadyExists(email)) {
            service.saveIntoDB(firstName, lastName, age, email, password);
            writer.println("<h2>Successful registration!</h2>");
            writer.flush();
            writer.close();
            System.out.println(firstName + " " + lastName + ", " + age + ", " + email + ", " + password);
        }
    }
    //TODO вынести в проперти
    private void writeForm(PrintWriter writer, ErrorMessage errorMessage) {
        String message = String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h2>Register Forms</h2>\n" +
                "\n" +
                "<form method=\"POST\">\n" +
                "  First name:<br>\n" +
                "  <input type=\"text\" name=\"first_name\" value=\"Billy\">\n" +
                "  <br>\n" +
                "  Last name:<br>\n" +
                "  <input type=\"text\" name=\"last_name\" value=\"Bob\">\n" +
                "  <br>\n" +
                "  Age:<br>\n" +
                "  <input type=\"text\" name=\"age\" value=\"18\">\n" +
                "  <br>\n" +
                "  Email:<br>\n" +
                "  <input type=\"text\" name=\"email\" value=\"billybob18@email.com\">\n" +
                "  <br>\n" +
                "  Password:<br>\n" +
                "  <input type=\"password\" name=\"password\" value=\"\">\n" +
                "  <br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "  <br><br>" +
                "  <font style=\"color:red\">%s</font>" +
                "</form> \n" +
                "\n" +
                "</body>\n" +
                "</html>", errorMessage.getMessage());
        writer.println(message);


        writer.flush();
        writer.close();
    }
}
