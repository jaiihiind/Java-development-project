import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    private static int numberOfVisits = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Increment the number of visits
        numberOfVisits++;

        out.println("<html><head><title>Welcome Page</title></head><body>");
        out.println("<h1>Welcome to Our Website!</h1>");
        out.println("<p>You are visitor number: " + numberOfVisits + "</p>");
        out.println("</body></html>");
    }
}
