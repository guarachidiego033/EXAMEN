/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DIEGO
 */
public class Conexion {
    String bd ="usuarios";
    String url ="jdbc:mysql://localhost:3306/";
    String user ="diego";
    String password ="d2+k222333";
    String driver ="com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd) {
        this.bd=bd;
       
    }
    public Connection conectar(){
  
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,user,password);
            System.out.println("SE CONECTO A LA BASE DE DATOS "+bd);
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    System.out.println("NO SE CONECTO A LA BASE DE DATOS "+bd);
    
    }
    return cx;
    
    
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public static void main(String[] args){
   Conexion conexion=new Conexion("usuarios");
   conexion.conectar();
   
   } 
    
}
