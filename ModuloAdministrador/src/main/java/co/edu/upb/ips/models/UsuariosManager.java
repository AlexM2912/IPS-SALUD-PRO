package co.edu.upb.ips.models;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosManager {

    public static boolean iniciarSesion(String numeroDocumento, String contrasena) {
        String query = "SELECT contrasena FROM Administradores WHERE numero_documento = ?";
        try (Connection conn = new CConexion().estableceConexion();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, numeroDocumento);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String contrasenaDB = resultSet.getString("contrasena");
                    return contrasena.equals(contrasenaDB); // Comparar contraseñas
                } else {
                    return false; // No se encontró el administrador
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }
}
