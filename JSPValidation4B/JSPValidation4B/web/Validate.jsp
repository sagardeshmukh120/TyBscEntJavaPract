<%-- 
    Document   : Validate
    Created on : 25 Sep, 2019, 5:41:14 PM
    Author     : deshmukh_sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="mypack.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Validation JSP</h1>
        <jsp:useBean id="obj" scope="request" class="mypack.CheckerBean" >
        <jsp:setProperty name="obj" property="*"/>
        </jsp:useBean>
        <%if (obj.validate())
            { %>
        <jsp:forward page="successful.jsp"/>
            <% }
            else {%>
            <jsp:include page="index.html"/>
            <%}%>
        <%=obj.getError() %>
    </body>
</html>
