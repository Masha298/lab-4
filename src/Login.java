import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "/Login", urlPatterns = "/Login")
public class Login extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ans;
        String role;
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        try {
            new DBA(name,pass);
            ans = DBA.ans;
            role=DBA.role;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(role);
        if (ans==1){
            if(role.equals("admin")){
                System.out.println(role);
                response.sendRedirect("welcome admin.jsp");
            }else {
                response.sendRedirect("welcome.jsp");
            }
        }
        else {response.sendRedirect("index.jsp");}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
