<%-- 
    Document   : updatedb
    Created on : 27 Sep, 2019, 9:52:38 PM
    Author     : deshmukh_sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <body>
       
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver"
         url="jdbc:mysql://localhost:3306/sampledb"
         user="root" password=""/>
        <sql:update dataSource="${dbsource}" var="count">
            UPDATE product SET pname= ?, quantity=?
            WHERE id='${param.id}'
            <sql:param value="${param.pname}"/>
            <sql:param value="${param.qty}"/>
        </sql:update>
        <c:if test="${count>=1}">
            <font size="5" color='green'> Congratulations ! Data updated successfully.</font>
            <a href="index.html">Go Home</a>
        </c:if>
        
    </body>
</html>
