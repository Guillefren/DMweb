<%-- 
    Document   : uploadFile
    Created on : 14/09/2014, 10:08:36 PM
    Author     : Guilleeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="org.apache.commons.fileupload.FileItem" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 
<%@ page import="org.apache.commons.fileupload.disk.*" %> 
<%@ page import="org.apache.commons.fileupload.servlet.*" %> 
<%@ page import="org.apache.commons.io.*" %> 
<%@ page import="java.io.*" %> 

<%
String ubicacionArchivo = "C:/Users/Guilleeu/Documents/NetBeansProjects/github/dm/dm/directmarket/DirectMarketWeb/web/img";

DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setSizeThreshold(1024); 
factory.setRepository(new File(ubicacionArchivo));

ServletFileUpload upload = new ServletFileUpload(factory);

try
{
    List<FileItem> partes = upload.parseRequest(request);

        for(FileItem item : partes)
        {
        File file = new File( ubicacionArchivo, item.getName() );
        item.write(file);
        }
        out.write("El archivo se a subido correctamente") ;
        }
catch(FileUploadException ex)
{
    out.write("Error al subir archivo "+ex.getMessage());
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        <form action="uploadFile.jsp" method="post" enctype="multipart/form-data"> 
                    Imagen (*) <br/>
                <input type="file" name="file"/> 
                
               
                
                <br /> 
                //<input type="submit" value="Subir archivo" /> %>
                <br/>
                
                </form>
    </body>
</html>
