<%-- 
    Document   : Register
    Created on : 25 Sep, 2019, 6:39:18 PM
    Author     : deshmukh_sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <h1>Registration JSP Page</h1>
        <%
            String uname=request.getParameter("txtName");
            String pass1 = request.getParameter("txtPass1");
            String pass2 = request.getParameter("txtPass2");
            String email = request.getParameter("txtEmail");
            String ctry = request.getParameter("txtCon");
            if(pass1.equals(pass2))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb","root","");
                    PreparedStatement stmt = con.prepareStatement("insert into user values (?,?,?,?)");
                    stmt.setString(1, uname); stmt.setString(2, pass1);
                    stmt.setString(3, email); stmt.setString(4, ctry);
                    int row = stmt.executeUpdate();
                    if(row==1) 
                    { 
                        out.println("Registration Successful");
                    } 
                    else 
                    {
                        out.println("Registration FFFFFAAAIIILLLL !!!!");
                        %><jsp:include page="Register.html" ></jsp:include>
                        <%
                    }
                }
                catch(Exception e){out.println(e);}
            }
            else
            {
                   out.println("<h1>Password Mismatch</h1>");
        
                %>
            <jsp:include page="Register.html" ></jsp:include>
         <% }
        %>

    </body>
</html>
