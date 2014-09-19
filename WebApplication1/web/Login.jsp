<%-- 
    Document   : Login
    Created on : 19-sep-2014, 15:39:27
    Author     : Herobrine
--%>

<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/Login/CSS/Estilo.css"/>
<!DOCTYPE html>
<%  String tipo= (String) session.getAttribute("Tipo");
    String nombre= (String) session.getAttribute("Nombre");
    String nick = (String) session.getAttribute("Nick");
       
    %>
    
<html>
        <%
    HttpSession sesion = request.getSession();
    
    
    %>
    <link rel="stylesheet" type="text/css" href="Estilo.css">
    <head>
        <title>DM</title>
        
       
    </head>
    
    <body>
        <div align=center> 
            <img src="DirectMarket.png">
        </div>   
        
        
        <div align="center">     
      <%     
        if(sesion.getAttribute("Nombre")!=null ){
                %>
                <form action="ServletLogout" method="POST">
                    <h4>Usuario logueado:<%=nombre%></h4>
                    <input style="right:inherit" type="submit" value="Cerrar Sesion">
                    
                </form>
                    <a href="index.jsp"><input type="submit" value="Inicio" </a>
                <%
                }
                    
        else{%>  
                <form action="ServletLogin" method="POST">
                    <strong>Nombre:</strong> <input type="text" name="nombre"><br>
                    <strong>Contraseña:</strong> <input type="password" name="pswd"><br>
                        <input type="submit" value="Iniciar sesion">
                </form>
                    
            
    <%}
    %>
      </div>
      
      <div id="Contenedor">
          
      </div>
      
      
      
      
      
      
    </body>
</html>
 