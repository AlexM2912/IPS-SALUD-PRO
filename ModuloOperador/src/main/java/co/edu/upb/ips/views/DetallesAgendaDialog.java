package co.edu.upb.ips.views;

import co.edu.upb.ips.models.CConexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetallesAgendaDialog extends JDialog {

    public DetallesAgendaDialog(String idMedicoSeleccionado, LocalDate currentWeekStart) {
        // Configuración del diálogo modal
        setModal(true);
        setTitle("Detalles de la Agenda");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        // Crear modelo de tabla para la agenda
        String[] columnas = {"Fecha", "Hora", "Motivo"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);

        // Consultar la base de datos para obtener la información de la agenda del médico
        try {
            Connection conn = CConexion.estableceConexion();
            String query = "SELECT fecha_hora, motivo FROM CitasMedicas WHERE id_medico = ? AND fecha_hora BETWEEN ? AND ? AND estado_cita = 'Programada'";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, idMedicoSeleccionado);
            statement.setObject(2, currentWeekStart.atStartOfDay());
            statement.setObject(3, currentWeekStart.plusDays(6).atTime(23, 59, 59));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                // Dentro del bucle while
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm"); // Formato de hora deseado
                String hora = rs.getTimestamp("fecha_hora").toLocalDateTime().format(formatterHora);
                String motivo = rs.getString("motivo");
                // Aquí agregamos una nueva fila a la tabla con los detalles de la cita médica programada
                modeloTabla.addRow(new Object[]{rs.getDate("fecha_hora"), hora, motivo});
            }

            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Error al consultar la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        // Agregar la tabla al panel
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10, 10, 460, 340);
        panel.add(scrollPane);
    }
}