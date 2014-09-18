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
     
           
         String coso = request.getParameter("Productos");
         out.println(coso);
        /*sacando los FileItem del ServletFileUpload en una lista */
        
           
            
//            DataFecha fechanac = new DataFecha();
//             conectar con=new conectar();
            

          
    
        
           
            
          
           
           
           
           
           
          
          
          
//            String nick = request.getParameter("Nick");
//            String nombre = request.getParameter("Nombre");
//            String apellido = request.getParameter("Apellido");
//            String email = request.getParameter("Email");
            
            
//            String contraseña = request.getParameter("Contrasena");
//            String verificar = request.getParameter("Verificar");
//            String dia = request.getParameter("day");
//            String mes = request.getParameter("month");
//            String año = request.getParameter("year");
//            String imagen = request.getParameter("file");
//            String tipo = request.getParameter("tipo");
//            String lp = request.getParameter("Sitio Web");
//            String nc = request.getParameter("Nombre Compania");
       
               
           
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
