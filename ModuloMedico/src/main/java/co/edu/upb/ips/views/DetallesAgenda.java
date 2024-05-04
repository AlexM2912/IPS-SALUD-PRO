package co.edu.upb.ips.views;

import co.edu.upb.ips.models.CConexion;
import co.edu.upb.ips.clases.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.*;
import java.util.HashMap;
import javax.swing.table.TableCellRenderer;

public class DetallesAgenda extends JFrame {
    private JPanel panel;
    private JLabel monthLabel;
    private JTable table;
    private DefaultTableModel tableModel;
    private LocalDate currentWeekStart;
    private int idMedicoSeleccionado;
    private Connection connection;

    public DetallesAgenda(int idMedico) {
        idMedicoSeleccionado = idMedico;
        connection = new CConexion().estableceConexion();

        // Propiedades del JFrame
        this.setTitle("Agenda");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel con color de fondo blanco
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        panel.add(topPanel);
        topPanel.setBackground(new Color(0, 47, 87));
        topPanel.setBounds(0, 0, 1400, 70);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        // Crear JLabel para el título
        JLabel titulo = new JLabel("Detalles de la Agenda");
        titulo.setBounds(0, 120, 1400, 40);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setVisible(true);
        panel.add(titulo);

        // Crear JLabel para el mes
        monthLabel = new JLabel();
        monthLabel.setBounds(650, 200, 200, 40);
        monthLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        monthLabel.setForeground(Color.BLACK);
        monthLabel.setVisible(true);
        panel.add(monthLabel);

        // Crear tabla con las horas y los días de la semana
        String[] columnNames = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        Object[][] data = new Object[13][6];
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    data[i][j] = "<html><b>Hora</b></html>";
                } else if (i == 0) {
                    data[i][j] = "<html><b>" + columnNames[j] + "</b></html>";
                } else {
                    if (j == 0) {
                        data[i][j] = "<html><b></b></html>";
                    } else {
                        data[i][j] = "";
                    }
                }
            }
        }
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });

        // Establecer el ancho de las columnas
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        // Establecer el alto de las filas
        table.setRowHeight(30);

        // Desactivar redimensionamiento de columnas
        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        // Evitar que las columnas se muevan
        table.getTableHeader().setReorderingAllowed(false);

        // Actualizar la tabla y el JLabel del mes
        currentWeekStart = LocalDate.now().with(DayOfWeek.MONDAY);
        updateWeek(currentWeekStart);

        // Cambiar color de las celdas de la tabla
        table.setBackground(new Color(255, 255, 255, 255));
        table.setForeground(Color.BLACK);

        // Establecer bordes para la tabla
        Border border = LineBorder.createBlackLineBorder();
        table.setBorder(border);

        // Crear JScrollPane con la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(215, 290, 1000, 350);
        panel.add(scrollPane);

        // Crear botones para cambiar la semana
        JButton prevWeek = new JButton("Semana anterior");
        prevWeek.setBounds(215, 240, 150, 30);
        prevWeek.setBackground(new Color(0, 47, 87));
        prevWeek.setForeground(Color.WHITE);
        panel.add(prevWeek);
        prevWeek.addActionListener(e -> updateWeek(currentWeekStart.minusWeeks(1)));

        JButton nextWeek = new JButton("Siguiente semana");
        nextWeek.setBounds(1065, 240, 150, 30);
        nextWeek.setBackground(new Color(0, 47, 87));
        nextWeek.setForeground(Color.WHITE);
        panel.add(nextWeek);
        nextWeek.addActionListener(e -> updateWeek(currentWeekStart.plusWeeks(1)));

        // Crear Botón para volver a la vista de DiligenciarCita
        JButton volverButton = new JButton("Anterior");
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.setForeground(Color.DARK_GRAY);
        volverButton.setBounds(20, 630, 100, 40);
        volverButton.setBackground(new Color(193, 219, 227, 255));
        volverButton.setVisible(true);
        panel.add(volverButton);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK);
        volverButton.setBorder(border2);

        //Crear ActionListener para el botón de volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Abrir la vista de GestionarAgenda
                GestionarAgenda gestionarAgenda = new GestionarAgenda();
                gestionarAgenda.setVisible(true);
                dispose();
            }
        });

        // Crear Advertencia si se oprime el botón de Cerrar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Object[] options = {"Sí", "No"};
                if (JOptionPane.showOptionDialog(panel, "¿Desea cerrar la aplicación?", "Cerrar Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Agregar cita de prueba manualmente
        agregarCitaManualmente(1, LocalDateTime.of(2024, Month.MAY, 3, 9, 0), "Programada");

        // Mostrar la ventana
        this.setVisible(true);

        // Cargar las citas programadas
        cargarCitasProgramadas();
    }

    // Método para cargar las citas programadas del médico
    // Método para cargar las citas programadas del médico
    private void cargarCitasProgramadas() {
        try {
            String sql = "SELECT * FROM CitasMedicas WHERE id_medico = ? AND (estado_cita = 'Programada' OR estado_cita = 'Confirmada')";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idMedicoSeleccionado);
            ResultSet resultSet = statement.executeQuery();

            // Limpiar la tabla
            for (int i = 1; i < table.getRowCount(); i++) {
                for (int j = 1; j < table.getColumnCount(); j++) {
                    table.setValueAt("", i, j);
                }
            }

            // Asignar citas médicas a las celdas de la tabla
            while (resultSet.next()) {
                LocalDateTime fechaHoraCita = resultSet.getTimestamp("fecha_hora").toLocalDateTime();
                LocalDate fechaCita = fechaHoraCita.toLocalDate();
                LocalTime horaCita = fechaHoraCita.toLocalTime();
                int columna = fechaCita.getDayOfWeek().getValue(); // Obtener el día de la semana como un número
                int fila = horaCita.getHour() - 6; // Calcular la diferencia de horas respecto al inicio de la tabla

                // Verificar que la fila y la columna estén dentro del rango válido
                if (fila >= 0 && fila < 13 && columna >= 1 && columna <= 5) {
                    // Asignar el mensaje "Consulta Médica" a la celda correspondiente en la tabla
                    table.setValueAt("Consulta Médica", fila + 1, columna);
                }
            }

            // Repintar la tabla para reflejar los cambios
            table.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(panel, "Error al cargar las citas programadas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void updateWeek(LocalDate startDate) {
        currentWeekStart = startDate;
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String month = "Mes: " + monthNames[startDate.getMonth().getValue() - 1];
        monthLabel.setText(month);

        LocalDate currentDay = startDate;
        for (int i = 1; i < table.getColumnCount(); i++) {
            table.setValueAt(currentDay.getDayOfMonth(), 0, i);
            currentDay = currentDay.plusDays(1);
        }

        String[] hours = {"6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM"};
        for (int i = 0; i < hours.length; i++) {
            table.setValueAt("<html><b>" + hours[i] + "</b></html>", i + 1, 0);
        }
    }

    public void agregarCitaManualmente(int idMedico, LocalDateTime fechaHora, String estadoCita) {
        try {
            String sql = "INSERT INTO CitasMedicas (id_medico, fecha_hora, estado_cita) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idMedico);
            statement.setTimestamp(2, Timestamp.valueOf(fechaHora));
            statement.setString(3, estadoCita);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Se ha añadido una nueva cita médica.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar la cita médica: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DetallesAgenda(1).setVisible(true);
        });
    }
}
