/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dengue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Higor
 */
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/dengue","root","");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
}
