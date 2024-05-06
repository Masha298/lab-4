import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "/Register", urlPatterns = "/Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String email = request.getParameter("mail");

        try {
            DBA.SaveUser(name,password,email);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("welcome.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
