/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.ips.models;

import java.sql.SQLException;

/**
 *
 * @author alexd
 */
public class Main {
    
    public static void main (String[] args) throws SQLException {
        CConexion objetoConexion = new CConexion();
        objetoConexion.estableceConexion();
    }
}
