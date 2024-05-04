/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.ips.models;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alexd
 */
public class CConexion {
    
    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "Alexdan29122005";
    String bd = "ips_salud_pro";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+ e.toString());
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+ e.toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos, error: "+ e.toString());
        }
        return conectar;
    }
}
