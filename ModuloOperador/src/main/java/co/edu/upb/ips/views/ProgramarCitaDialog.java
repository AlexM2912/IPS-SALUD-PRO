package co.edu.upb.ips.views;

import co.edu.upb.ips.models.CConexion;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat; // Importar SimpleDateFormat
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProgramarCitaDialog extends JDialog {

    private JPanel panel;
    private JComboBox<String> pacienteComboBox;
    private JDateChooser fechaChooser;
    private JComboBox<String> horaComboBox; // Reemplaza horaTextField
    private JTextArea motivoTextArea;
    private LocalDate currentWeekStart;

    public ProgramarCitaDialog(String idMedicoSeleccionado) {
        setTitle("Programar Cita");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        add(panel);

        JLabel pacienteLabel = new JLabel("Paciente:");
        pacienteComboBox = new JComboBox<>();
        // Llena el combo box con los pacientes disponibles
        try {
            Connection conn = CConexion.estableceConexion();
            String query = "SELECT id_paciente, CONCAT(primer_nombre, ' ', COALESCE(segundo_nombre, ''), ' ', primer_apellido, ' ', segundo_apellido) AS nombre_completo FROM Pacientes";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                pacienteComboBox.addItem(result.getString("id_paciente") + " - " + result.getString("nombre_completo"));
            }
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ProgramarCitaDialog.this, "Error al cargar los pacientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

        // Inicializa currentWeekStart con la fecha actual al crear una instancia de ProgramarCita
        currentWeekStart = LocalDate.now().with(DayOfWeek.MONDAY);

        JLabel fechaLabel = new JLabel("Fecha:");
        fechaChooser = new JDateChooser();
        fechaChooser.setDateFormatString("yyyy-MM-dd");

        JLabel horaLabel = new JLabel("Hora (HH:MM):");
        horaComboBox = new JComboBox<>();
        // Obtener y mostrar las horas disponibles
        ArrayList<String> horasDisponibles = obtenerHorasDisponibles();
        for (String hora : horasDisponibles) {
            horaComboBox.addItem(hora);
        }

        JLabel motivoLabel = new JLabel("Motivo:");
        motivoTextArea = new JTextArea();

        JButton programarButton = new JButton("Programar");
        programarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados por el operador
                String pacienteSeleccionado = (String) pacienteComboBox.getSelectedItem();

                // Obtener la fecha del JDateChooser y formatearla
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = dateFormat.format(fechaChooser.getDate());

                // Obtener la hora seleccionada del JComboBox
                String hora = (String) horaComboBox.getSelectedItem();

                // Formatear la fecha y la hora en el formato adecuado para MySQL
                String fechaHora = fecha + " " + hora + ":00"; // Agregar ":00" para segundos

                String motivo = motivoTextArea.getText();

                // Validar que se hayan ingresado todos los campos
                if (pacienteSeleccionado.isEmpty() || fecha.isEmpty() || hora.isEmpty() || motivo.isEmpty()) {
                    JOptionPane.showMessageDialog(ProgramarCitaDialog.this, "Por favor, complete todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Guardar la cita en la base de datos
                    try {
                        Connection conn = CConexion.estableceConexion();
                        String query = "INSERT INTO CitasMedicas (id_paciente, id_medico, fecha_hora, motivo) VALUES (?, ?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(query);
                        // Extraer el ID del paciente seleccionado del combo box
                        String[] pacienteParts = pacienteSeleccionado.split(" - ");
                        statement.setString(1, pacienteParts[0]); // ID del paciente
                        statement.setString(2, idMedicoSeleccionado); // ID del médico
                        statement.setString(3, fechaHora); // Utilizar fechaHora formateada
                        statement.setString(4, motivo);
                        statement.executeUpdate();
                        statement.close();
                        conn.close();
                        JOptionPane.showMessageDialog(ProgramarCitaDialog.this, "Cita programada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Cerrar el diálogo después de programar la cita
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(ProgramarCitaDialog.this, "Error al programar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        panel.add(pacienteLabel);
        panel.add(pacienteComboBox);
        panel.add(fechaLabel);
        panel.add(fechaChooser);
        panel.add(horaLabel);
        panel.add(horaComboBox);
        panel.add(motivoLabel);
        panel.add(new JScrollPane(motivoTextArea));
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(programarButton);

        setVisible(true);
    }

    // Función para obtener las horas disponibles
    private ArrayList<String> obtenerHorasDisponibles() {
        ArrayList<String> horas = new ArrayList<>();
        for (int hora = 6; hora <= 17; hora++) {
            horas.add(String.format("%02d:00", hora));
        }
        return horas;
    }

    public static void main(String[] args) {
        new ProgramarCitaDialog("1"); // Prueba de la clase ProgramarCitaDialog
    }
}