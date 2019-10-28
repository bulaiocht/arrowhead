package web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

@WebServlet(
        name = "CookiesServlet",
        urlPatterns = {"/cookie"}
)
public class CookiesServlet extends HttpServlet {

    private static final Logger log
            = LoggerFactory.getLogger(CookiesServlet.class);

    @Override
    public void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        log.info("Received cookies:");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie != null){
                    log.info("name: {}, value: {}", cookie.getName(), cookie.getValue());
                }
            }
        }

        Map<String, String[]> parameterMap = req.getParameterMap();



        String dateString = Instant.now().toString();
        log.info("Setting new date: {}", dateString);
        Cookie cookie1 = new Cookie("date", dateString);
        Cookie cookie2 = new Cookie("name", "bill");
        cookie1.setMaxAge(20);
        cookie2.setMaxAge(20);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);

    }


}
