<%-- 
    Document   : laotra
    Created on : 11/09/2014, 09:25:44 PM
    Author     : Guilleeu
--%>
<%
String dato1 = request.getParameter("dato1");
String dato2 = request.getParameter("dato2");
String dato3 = request.getParameter("dato3");
String dato4 = request.getParameter("dato4");
String dato5 = request.getParameter("dato5");
String dato6 = request.getParameter("dato6");
String dato7 = request.getParameter("dato7");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br/>
        <h2><%=dato1%></h2>
        <br/>
        <h2><%=dato2%></h2>
        <br/>
        <h2><%=dato3%></h2>
        <br/>
        <h2><%=dato4%></h2>
        <br/>
        <h2><%=dato5%></h2>
        <br/>
        <h2><%=dato6%></h2>
        
        
    </body>
</html>
