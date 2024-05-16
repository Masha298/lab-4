import model.UserEntity;
import java.sql.*;


public class DBA {
ResultSet RS;
static String role;
static int ans=0;
    Statement stmt;
    public DBA(String name, String pass) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();}
        catch(Exception e)
        {System.err.println("Unable to load driver:"+ e);}
        Connection conn = DriverManager.getConnection(                                      "jdbc:mysql://localhost:3305/users", "User1", "root");
        if (conn==null){System.out.println("Нет соединения с БД!");
            System.exit(0);}
        stmt = conn.createStatement();
        RS = stmt.executeQuery("select *from users;");
        ans=0;
        role="null";
        while(RS.next()){
            if(name.equals(RS.getString("name")) && pass.equals(RS.getString("pass"))){
                ans= 1;
                role=RS.getString("role");
            }
        }
        stmt.close();
        }
        public static void SaveUser(String name, String password, String email) throws SQLException {
            int id = 0;
            Connection conn = DriverManager.getConnection(                                      "jdbc:mysql://localhost:3305/users", "User1", "root");
            if (conn==null){System.out.println("Нет соединения с БД!");
                System.exit(0);}
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT max(id) AS max_id FROM users");
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                id=maxId+1;
            }
            stmt.executeUpdate("INSERT users("+"id"+","+"name"+","+"pass"+","+"mail"+")VALUES("+id+",'"+name+"','"+password+"','"+email+"')");
            UserEntity user = new UserEntity();
            user.setIdUser(id);
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
    }
}
