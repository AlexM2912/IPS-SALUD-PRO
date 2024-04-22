package co.edu.upb.ips.models;

import javax.swing.*;
import java.sql.*;

public class DatabaseManager {
    public static String[] consultarPaciente(String numeroDocumento) {
        String[] paciente = null;

        try {
            CConexion conexion = new CConexion();
            Connection conn = conexion.estableceConexion();

            if (conn != null) {
                String query = "SELECT primer_nombre, primer_apellido, tipo_documento, estado_afiliacion, telefono FROM Pacientes WHERE numero_documento = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, numeroDocumento);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    paciente = new String[5];
                    paciente[0] = resultSet.getString("primer_nombre");
                    paciente[1] = resultSet.getString("primer_apellido");
                    paciente[2] = resultSet.getString("tipo_documento");
                    paciente[3] = resultSet.getString("estado_afiliacion");
                    paciente[4] = resultSet.getString("telefono");
                }

                conn.close(); // Cerrar la conexión después de usarla
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo establecer conexión a la base de datos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
        }

        return paciente;
    }
}
