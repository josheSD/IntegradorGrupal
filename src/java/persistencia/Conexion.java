/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author josec
 */
public class Conexion {
    
    public Connection getConexion(){
        Connection cn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcompsell?user=root&password=");
        }catch(Exception ex){
            System.out.println(ex);
            cn=null;
        }
        
        return cn;
    }
    
}
