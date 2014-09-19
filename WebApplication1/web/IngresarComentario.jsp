<%-- 
    Document   : IngresarComentario
    Created on : 17/09/2014, 09:29:54 PM
    Author     : Guilleeu
--%>

<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="Logica.ControladorCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import= "Logica.*" %>

<% 
ControladorUsuario contU = new ControladorUsuario();
List<OrdenDeCompra> listacom = contU.getNumeroOrden();
OrdenDeCompra oc = listacom.get(5); // obtengo cualquier orden de compra para trabajar con los productos
//String[] arrayhojas = new String[20];
List<producto> lp = oc.getLproducto();
List<DataProducto> ldp = new LinkedList();

for(int i =0;i<lp.size();i++){

DataProducto dp = new DataProducto();
dp = lp.get(i).getDataProd();
ldp.add(dp);

}
// for(int i = 0;i<listahoja.size();i++){

//arrayhojas[i] = listahoja.get(i).getNombre();

//}
%>
<!DOCTYPE html>

<html>
    <head>
        <%! String funcion(String np) { 
            
    String coso = np;
return coso;
}; %> 
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Comentarios</title>
    </head>
    <body>
        <h1>Comentar Productos</h1>
        
        <form action = uploadFile.jsp method = "post"/>
        Ordenes de Compra 
        <br/>
            <select name="Productos" multiple="multiple" id="Productos" >
            <% for (int i=0; i<ldp.size(); i++) {

                    out.print("<option selected>");
                    out.print(ldp.get(i).getNombre());
                    out.print("</option selected>");
                    
              }
            
            
              %>
              
            </select>
             
              <select name="cliente" >
                 <%
                 
                 
                    out.print("<option selected>");
                    out.print( listacom.get(5).getCliente().getNick());
                    out.print("</option selected>");
                 
                 %> 
                  
                  
                  </select>
                 <input type="text" name="Comentario" size="50"/>
                 
             
              <input type="submit" value="Enviar"/>
        </form>
               
         
            
            
        
    </body>
</html>
