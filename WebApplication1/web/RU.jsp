<%--
    Document   : RU
    Created on : 11/09/2014, 09:54:55 PM
   
 Author     : Guilleeu
--%>


<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="Logica.*"%>
<%@page import="java.util.List"%>
<%@page import="Logica.ControladorCategoria"%>
<%@page import="Logica.ControladorUsuario"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script src="jquery-1.7.1.min.js"></script>
    <script src="js/superfish.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/jquery.cycle.all.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src ="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"> </script>
    
    
    
            
            
<%!
  /** The names of the months */
ControladorUsuario cont = new ControladorUsuario();
 String[] tipo = {
                  
                  "Cliente","Proveedor"
              
              }; 
                  String[] months = {
                    "1", "2", "3", "4",
                    "5", "6", "7", "8",
                    "9", "10", "11", "12"
                  };

                  String[] dias = {
                    "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19",
                      "20","21","22","23","24","25","26","27","28","29","30","31"
                  };
                  /** The days in each month. */
                  int dom[] = {
                      31, 28, 31, 30,  /* jan feb mar apr */
                      31, 30, 31, 31, /* may jun jul aug */
                      30, 31, 30, 31  /* sep oct nov dec */
                  };
                %>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="jquery-ui.min.js"></script>
<script type="text/javascript">
    
    
                 $(document).ready(function () {
                    $('#Cliente').click(function () {
                       $('#Proveedores').hide('fast');
                       $('#div1').show('fast');
                });
                $('#Proveedor').click(function () {
                      $('#div1').hide('fast');
                      $('#Proveedores').show('fast');
                 });
               });
</script>
<script>
    
function displayResultado(Tipo)
{
document.getElementById("tipo").value=Tipo
}
</script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         
        
        <title>Registrar Usuario</title>
                <meta charset="utf-8" />
       
    </head>
    <body>
        
 <%       
 // First get the month and year from the form.
                 
            boolean yyok = false;  // -1 is a valid year, use boolean
                  int yy = 0, mm = 0, dd=0;
                  String yyString = request.getParameter("year");
                  if (yyString != null && yyString.length(  ) > 0) {
                    try {
                      yy = Integer.parseInt(yyString);
                      yyok = true;
                    } catch (NumberFormatException e) {
                      out.println("Year " + yyString + " invalid");
                    }
                  }
                  Calendar c = Calendar.getInstance(  );
                  if (!yyok)
                    yy = c.get(Calendar.YEAR);

                  String ddString = request.getParameter("day");
                  if (ddString == null) {
                    mm = c.get(Calendar.DAY_OF_MONTH);
                  } else {
                    for (int i=0; i<dias.length; i++)
                      if (dias[i].equals(ddString)) {
                        dd = i;
                        break;
                      }
                  }

                  String mmString = request.getParameter("month");
                  if (mmString == null) {
                    mm = c.get(Calendar.MONTH);
                  } else {
                    for (int i=0; i<months.length; i++)
                      if (months[i].equals(mmString)) {
                        mm = i;
                        break;
                      }
                  }
%>
        
        
        <form action = RU2.jsp method = "post"  enctype="MULTIPART/FORM-DATA" />
        
        
            Nick(*)
            <input type = "text" name="Nick"/> 
            <br/>
            Email(*)
            <input type = "email" name="Email"/> 
            <br/>
            
            Fecha de nacimiento(*)  <br/>
            
            Dia: <select  name = day>
                <% for (int i=0; i<dias.length; i++) {
                    if (i==dd)
                      out.print("<option selected>");
                    else
                      out.print("<option>");
                    out.print(dias[i]);
                    out.println("</option>");
              }
              %>
               
              
            </select>
              Mes: <select  name=month>
              <% for (int i=0; i<months.length; i++) {
                if (i==mm)
                  out.print("<option selected>");
                else
                  out.print("<option>");
                out.print(months[i]);
                out.println("</option>");
              }
              %>
              </select>
              Año (4-digit): 
                <input type="text" size="5" name="year" value="<%= yy %>"></input>
             
            <br/>
            Nombre
              <input type ="text" name ="Nombre"/>
              <br/>
              Apellido
              <input type = "text" name="Apellido"/>
              <br/>
              
              Contraseña(*)
              <input type = "password" name="Contrasena"/> 
              <br/>
              
              Verificar (*)
              <input type = "password" name="Verificar"/> 
              <br/>
              
              Tipo de Usuario (*)
            
              Tipo: <br>
<input type="radio" name="Tipo" onclick="displayResultado(this.value)" id="Cliente" value="Cliente"  > Cliente  <br>
<input type="radio" name="Tipo" onclick="displayResultado(this.value)" id="Proveedor" value="Proveedor"> Proveedor<br>                      
      
<input type="hidden"  id="tipo" name="tipo"/>
 

<div  id="Proveedores"> 
    
    Sitio Web: <input type="text" name ="Sitio Web" /> 
    <br/>
    
    Nombre de Compañia: <input type="text" name="Nombre Compania"/>
               
            <br/>
                    
                    
               </div>
                
               Imagen (*) <br/>
                <input type="file" id="Imagen" name="file"/> 
                <br /> 
               <%-- <input type="submit" value="Subir archivo" /> --%>
                <br/>
                
                
                <input type ="submit" value ="Aceptar"/> 
        </form>
        
       
              
          <%--     <form action="DMServlet/dementira.jsp" method="post" "> --%>
                    
                
                </form>
       
        
    </body>
</html>
