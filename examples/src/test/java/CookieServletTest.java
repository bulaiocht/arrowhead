import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import web.servlet.CookiesServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CookieServletTest {

    private Map<String, String> map;

    private CookiesServlet servlet;

    private HttpServletRequest mockHttpServletRequest;
    private HttpServletResponse mockHttpServletResponse;

    @BeforeEach
    public void initServlet() {
        servlet = new CookiesServlet();
        mockHttpServletRequest = Mockito.mock(HttpServletRequest.class);
        mockHttpServletResponse = Mockito.mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {

        Cookie [] cookies = new Cookie[]{new Cookie("key", "value")};

        Mockito.when(mockHttpServletRequest.getCookies()).thenReturn(cookies);
        Mockito.when(mockHttpServletRequest.getParameterMap()).thenReturn(new HashMap<>());

        servlet.doGet(mockHttpServletRequest, mockHttpServletResponse);

    }






}
