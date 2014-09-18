/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexionbd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * 
 * 
 * @author Agustin
 */
public class conexion {
   public ResultSet resultado;
   public Statement sentencia;
  public Connection conexion;
    public void conectarBase(){
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conexion=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/directmarket", "sa", "");
            sentencia=conexion.createStatement();
                      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error carga de driver");
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error creacion de statement");
        }

    }
     public void desconectarBaseDeDatos(){
        //metodo de desconexion
        try{
            if(conexion !=null){
                if (sentencia !=null){
                    //si la conexion devuelve valores nulos
                    sentencia.close();
                }
                conexion.close();
            }
        }
        catch (SQLException ex){
          
        }
    }
     
}
