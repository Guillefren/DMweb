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
        <h1>Lista de comentarios</h1>
        
         <%
       
        
       //  String[] Productos = request.getParameterValues("Productos");
       String produ = request.getParameter("Productos");
        
        String nickcliente = request.getParameter("cliente");
        
        ControladorUsuario cu = new ControladorUsuario();
        ControladorProductoyEspecificaciones cpe = new ControladorProductoyEspecificaciones();
        
        producto p = cpe.SeleccionarProducto(produ);
        List<DataComentario> listcoment = cu.getListaComentariosProd(p);
        
        for(int i = 0; i<listcoment.size(); i++){
        
        //indicando número, texto, cliente y fecha de cada uno  
           
        
        
        }
        
        
        %>
        <div>
            <select name="Comentarios">
            <%
            for(int i=0; i<listcoment.size();i++){
            
            out.print("<option selected>");
                    out.print(listcoment.get(i).getId());
                   out.print(listcoment.get(i).getTexto());
                   out.print(listcoment.get(i).getNickCliente());
                   out.print(listcoment.get(i).getFecha());
                    out.print("</option selected>");
            
            }
            
            
            %>
            
            </select>
            Comentar
            
            Ingrese id padre (0 si no es respuesta)
            <input type="number" name="id">
            <br/>
            Ingrese texto
            <input type="text" name="texto comentario">
            <br/>
            
        </div>
        
		
        
        <%
            Comentario coment = new Comentario();
            
            
            
            
        /*    
            En caso de que sea posible crearlo, se deberá ingresar el texto 
            del comentario, el identificador
                    del comentario padre, en caso de que sea una respuesta, 
            utilizando la fecha actual del Sistema.
            
            
        producto pr = new producto();
            pr.setNombre(request.getParameter("prod"));
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
        
        */
        
        
        
        
        
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
