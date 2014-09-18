/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.*;
import java.io.File;
import static java.lang.Boolean.valueOf;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Guilleeu
 */
public class DMServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
     
           
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
            FileItem   item = (FileItem) items.get(7);
            /*item.isFormField() false=input file; true=text field*/               
            if (! item.isFormField()){
                /*cual sera la ruta al archivo en el servidor*/
                File archivo_server = new File
        ("C:/Users/Guilleeu/Documents/NetBeansProjects/github/dm/dm/directmarket/DirectMarketWeb/img/"+item.getName());
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
           item = (FileItem) items.get(10);
           nombreCompania =item.getString();
            item = (FileItem) items.get(11);
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
            
           out.println(dia);
           out.println(mes);
           out.println(anio);
           out.println(nombre);
           out.println(apellido);
           out.println(email);
           out.println(contrasenia);
           out.println(verificar);
           out.println(imagen);
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
           
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        out.println("soy el servler");
        String nick = request.getParameter("Nick");
            String nombre = request.getParameter("Nombre");
            String apellido = request.getParameter("Apellido");
            String email = request.getParameter("Email");
            String contraseña = request.getParameter("Contraseña");
            String verificar = request.getParameter("Verificar");
            String dia = request.getParameter("day");
            String mes = request.getParameter("month");
            String año = request.getParameter("year");
            out.println(dia);
           /* if(fecha.isEmpty() == true)
                out.println("coso");
            out.println(fecha);*/
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String imagen = "-";
            Date fn = new Date();
//            try {
//                fn = df.parse(request.getParameter("datepicker"));            
//            } catch (ParseException pe) {
//        // Maneja la exception
//    }
            //String apellido[] = request.getParameterValues("Apellido");
//          String select = request.getParameter("pais");
//            for(int x = 0; x<=nombre.length -1;x++){
//            
//            out.println("<pre>("+x+")=>"+nombre[x]+"</pre>");
//            
//            
//            }
//           response.sendRedirect("../laotra.jsp?dato1="+nick+"&dato2="+nombre+"&dato3="+apellido+"&dato4="+email
//                   +"&dato5="+contraseña+"&dato6="+verificar+"&dato7="+fn);
           
           
            ControladorUsuario cont = new ControladorUsuario();
            //cont.RegistrarCliente(nick, nombre, apellido, email, null, imagen,contraseña);
            
//            if(cont.existeCliente(nick, email))
//                out.println("esta el cliente");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
            
            
            
//
//            out.println("soy el servler");
//        String nick = request.getParameter("Nick");
//            String nombre = request.getParameter("Nombre");
//            String apellido = request.getParameter("Apellido");
//            String email = request.getParameter("Email");
//            String contraseña = request.getParameter("Contraseña");
//            String verificar = request.getParameter("Verificar");
//            String dia = request.getParameter("day");
//            String mes = request.getParameter("month");
//            String año = request.getParameter("year");
//           System.out.println(dia);
//            //String apellido[] = request.getParameterValues("Apellido");
//          String select = request.getParameter("pais");
//            for(int x = 0; x<=nombre.length -1;x++){
//            
//            out.println("<pre>("+x+")=>"+nombre[x]+"</pre>");
//
//            
//            }
//           response.sendRedirect("../laotra.jsp?dato1="+nick+"&dato2="+nombre+"&dato3="+apellido+"&dato4="+email
//                   +"&dato5="+contraseña+"&dato6="+verificar+"&dato7="+fn);
            
            
            
            //   cont.RegistrarCliente(nick, nombre, apellido, email, fn, imagen,contraseña);
            
//            if(cont.existeCliente(nick, email))
//                out.println("esta el cliente");
        } catch (Exception ex) {
            Logger.getLogger(DMServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
