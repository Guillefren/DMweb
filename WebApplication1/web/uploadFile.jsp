<%-- 
    Document   : uploadFile
    Created on : 14/09/2014, 10:08:36 PM
    Author     : Guilleeu
--%>

<%@page import="Logica.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.apache.commons.fileupload.FileItem" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 
<%@ page import="org.apache.commons.fileupload.disk.*" %> 
<%@ page import="org.apache.commons.fileupload.servlet.*" %> 
<%@ page import="org.apache.commons.io.*" %> 
<%@ page import="java.io.*" %> 


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <%
       
        
         String Producto =request.getParameter("Productos");
        out.println(Producto);
        
        String nickcliente = request.getParameter("cliente");
        
        ControladorUsuario cu = new ControladorUsuario();
        ControladorProductoyEspecificaciones cpe = new ControladorProductoyEspecificaciones();
        
        cliente c = cu.SeleccionarCliente(nickcliente);
        producto p= cpe.SeleccionarProducto(Producto);
        
        Comentario com = new Comentario();
        
        com.setCliente(c);
        Date fecha = new Date(1,3,1992);
        com.setFecha(fecha);
        com.setId(1);
        com.setIdPadre(0);
        com.setProducto(p);
        com.setTexto(request.getParameter("Comentario"));
        
        c.ComentarProducto(com, p);
        
        
        out.println("se comento");
        
        %>
        
        <%--
        <form action="uploadFile.jsp" method="post" enctype="multipart/form-data"> 
                    Imagen (*) <br/>
                <input type="file" name="file"/> 
                
               
                
                <br /> 
                //<input type="submit" value="Subir archivo" /> %>
                <br/>
                
                </form>--%>
    </body>
</html>
