/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.ips.models;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alexd
 */
import javax.swing.*;
import java.sql.*;

public class CConexion {

    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "Alexdan29122005";
    private static final String BD = "ips_salud_pro";
    private static final String IP = "localhost";
    private static final String PUERTO = "3306";
    private static final String CADENA = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + BD;

    // Establecer la conexión a la base de datos
    public static Connection estableceConexion() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CADENA, USUARIO, CONTRASENIA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Error al establecer la conexión a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}
