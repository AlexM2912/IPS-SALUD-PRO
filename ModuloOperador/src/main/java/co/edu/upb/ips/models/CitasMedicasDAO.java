package co.edu.upb.ips.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import co.edu.upb.ips.clases.CitaMedica;
public class CitasMedicasDAO {

    public static List<CitaMedica> obtenerCitasPorPaciente(int idPaciente) throws SQLException {
        List<CitaMedica> citas = new ArrayList<>();
        String query = "SELECT * FROM CitasMedicas WHERE id_paciente = ?";
        try (Connection conn = CConexion.estableceConexion();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, idPaciente);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Crear objeto CitaMedica y agregarlo a la lista de citas
                    CitaMedica cita = new CitaMedica(
                            resultSet.getInt("id_cita"),
                            resultSet.getInt("id_paciente"),
                            resultSet.getInt("id_medico"),
                            resultSet.getTimestamp("fecha_hora"),
                            resultSet.getString("motivo")
                    );
                    citas.add(cita);
                }
            }
        }
        return citas;
    }

    // Otros métodos DAO para insertar, actualizar, eliminar citas, etc. según tus necesidades
}
