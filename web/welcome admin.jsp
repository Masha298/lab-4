<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 06.05.2024
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome admin</title>
</head>
<body>
<h1>Welcome admin!</h1>
<%
  ResultSet RS;
  Statement stmt;
  try{
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();}
  catch(Exception e)
  {System.err.println("Unable to load driver:"+ e);}
  Connection conn = DriverManager.getConnection(                                      "jdbc:mysql://localhost:3305/users", "User1", "Mashuta.2023");
  if (conn==null){System.out.println("Нет соединения с БД!");
    System.exit(0);}
  stmt = conn.createStatement();
  RS = stmt.executeQuery("select *from users;");

%><table users>
  <tr><td>ID</td><td>Имя</td><td>Пароль</td><td>Почта</td><td>Роль</td></tr>
  <% while (RS.next()) { %>
  <tr>
    <td><%= RS.getString("id") %></td>
    <td><%= RS.getString("name") %></td>
    <td><%= RS.getString("pass") %></td>
    <td><%= RS.getString("mail") %></td>
    <td><%= RS.getString("role") %></td>
  </tr>
  <% }stmt.close(); %>

</table>
</body>
</html>
