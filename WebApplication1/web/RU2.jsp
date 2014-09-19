<%-- 
    Document   : RU2
    Created on : 16/09/2014, 08:46:46 PM
    Author     : Guilleeu
--%>

<%@page import="java.util.Date"%>
<%@page import="Logica.ControladorUsuario"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Usuario</h1>
        
        
       <%  
           
           FileItemFactory file_factory = new DiskFileItemFactory();
        /*ServletFileUpload esta clase convierte los input file a FileItem*/
        ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
        /*sacando los FileItem del ServletFileUpload en una lista */
//            DataFecha fechanac = new DataFecha();
//             conectar con=new conectar();
        List items = servlet_up.parseRequest(request);
            
        
            String nick ="";
            String imagen ="";
            String nombre =""; 
            String apellido ="";
            String contrasenia="";
            String verificar="";
            String email ="";
            String tipo ="";
            String fechanacimiento ="";
            String linkPagina ="";
            String nombreCompania ="";
            String dia="";
            String mes="";
            String anio="";
            
            
             
        
           
            /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
            FileItem   item = (FileItem) items.get(13);
            /*item.isFormField() false=input file; true=text field*/               
            if (!item.isFormField()){
                out.println("entro en el if ");
                /*cual sera la ruta al archivo en el servidor*/
                File archivo_server = new File("C:/imgproyecto/"+item.getName());
                /*y lo escribimos en el servidor*/
              item.write(archivo_server);     
             imagen =item.getName();
            }
           //id del Juego 
   
     
            
            item = (FileItem) items.get(0);
            nick =item.getString();
              item = (FileItem) items.get(1);
             email =item.getString();
              item = (FileItem) items.get(2);
             dia =item.getString();
             item = (FileItem) items.get(3);
             mes =item.getString();
             item = (FileItem) items.get(4);
             anio =item.getString();
             item = (FileItem) items.get(5);
             nombre =item.getString();
             item = (FileItem) items.get(6);
            apellido =item.getString();
             item = (FileItem) items.get(7);
             contrasenia =item.getString();
             item = (FileItem) items.get(8);
           verificar =item.getString();
           item = (FileItem) items.get(9);
           tipo =item.getString();
           item = (FileItem) items.get(11);
           nombreCompania =item.getString();
            item = (FileItem) items.get(12);
           linkPagina =item.getString();
           
           
           
          ControladorUsuario cu = new ControladorUsuario();
//            String nick = request.getParameter("Nick");
//            String nombre = request.getParameter("Nombre");
//            String apellido = request.getParameter("Apellido");
//            String email = request.getParameter("Email");
            
            if(cu.existeCliente(nick, email)){
            
                    out.println("<script>"); 
                    out.println("alert('Nick o Email ya ingresado')"); 
                    out.println("</script>"); 
            
            }else{
                
//            String contraseña = request.getParameter("Contrasena");
//            String verificar = request.getParameter("Verificar");
//            String dia = request.getParameter("day");
//            String mes = request.getParameter("month");
//            String año = request.getParameter("year");
//            String imagen = request.getParameter("file");
//            String tipo = request.getParameter("tipo");
//            String lp = request.getParameter("Sitio Web");
//            String nc = request.getParameter("Nombre Compania");
            out.println(nick);
            out.println(email);
           out.println(dia);
           
           out.println(mes);
           out.println(anio);
           
           out.println(nombre);
           out.println(apellido);
           
           
           out.println(contrasenia);
           out.println(verificar);
           out.println(tipo);
           out.println("sfas");
           out.println(imagen);
           out.println("sfas");
           out.println(nombreCompania);
           out.println(linkPagina);
           
           int d = Integer.valueOf(dia);
           int m = Integer.valueOf(mes);
           int a = Integer.valueOf(anio);
           Date fecha = new Date(d,m,a);
           
           
           
           
           
           if(contrasenia.equals(verificar)){
               if(tipo.equals("Cliente")){
                cu.RegistrarCliente(nick, nombre, apellido, email, fecha, imagen, contrasenia);
               }
               else{
               cu.RegistrarProveedor(nick, nombre, apellido, email, fecha, imagen, nombreCompania, linkPagina, contrasenia);
               }
                
           }  
                
           else{
                   out.println("<script>"); 
                    out.println("alert('Error al Enviar')"); 
                    out.println("</script>"); 
                   }
            }    
           %>
        
        
        <img src="C:/imgproyecto/<%=imagen%>"/>
        
        
    </body>
</html>
