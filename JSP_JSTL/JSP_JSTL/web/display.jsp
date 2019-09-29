<%-- 
    Document   : display
    Created on : 27 Sep, 2019, 9:23:51 PM
    Author     : deshmukh_sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SELECT Operation</title>
        <script>
            function confirmGo(m,u) 
            {
                if ( confirm(m) ) 
                {
                    window.location = u;
                }
            }
        </script> 
        
    </head>
    <body>
       
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
         url="jdbc:mysql://localhost:3306/sampledb"
        user="root" password=""/>
        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from product;
        </sql:query>
    <center>
        <form>
        <table border="1" width="40%">
        <caption>Product List</caption>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.pname}"/></td>
            <td><c:out value="${row.quantity}"/></td>
            <td><a href="update.jsp?id=<c:out value="${row.id}"/>">Update</a></td>
            <td><a href="javascript:confirmGo('Sure to delete this record?','deletedb.jsp?id=<c:out value="${row.id}"/>')">Delete</a></td>
        </tr>
        </c:forEach>
        </table>
    </form>
    <a href="index.html">Go Home</a>
</center>
        
    </body>
</html>
