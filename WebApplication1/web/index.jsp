<%-- 
    Document   : index
    Created on : 09/09/2014, 08:41:44 PM
    Author     : Guilleeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%  String tipo= (String) session.getAttribute("Tipo");
    String nombre= (String) session.getAttribute("Nombre");
    String nick = (String) session.getAttribute("Nick");
       
    %>
<html>
    <%
    HttpSession sesion = request.getSession();
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div id="Imagen">
            <img src="DirectMarket.png">
        </div> 
        <div>   
            <a href="./RU.jsp">Registrar usuario</a>
            <br/>
            <a href="./IngresarComentario.jsp">Ingresar comentarios</a>
        </div>
    
       
        
        
        <div id ="Login">     
				  <%     
					if(sesion.getAttribute("Nombre")!=null ){
						%>
						<form action="ServletLogout" method="POST">
							<h3><%=nombre%></h3>
							<h3><%=nick%></h3>
							<input style="right:inherit" type="submit" value="Cerrar Sesion">
						</form>
							<strong>Nombre:</strong> <input type="text" name="nombre"><br>
							<strong>Contraseña:</strong> <input type="password" name="pswd"><br>
							<input type="submit" value="Enviar">

						<%
						}
								
					else{%>  
						<form action="ServletLogin" method="POST">
                                                    
						</form>
										
						<%}
						%>
      </div>
      
      <div id="Contenedor">
          
      </div>
        
        
        
        
        
    
    </body>
    
</html>
