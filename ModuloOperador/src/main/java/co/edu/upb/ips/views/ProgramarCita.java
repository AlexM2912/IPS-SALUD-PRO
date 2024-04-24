package co.edu.upb.ips.views;

import co.edu.upb.ips.models.CConexion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
public class ProgramarCita extends JFrame {

    private JPanel panel;
    private DefaultTableModel tableModel;
    private JComboBox<String> servicioComboBox;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;
    private DefaultTableModel tableModel2;
    private JLabel monthLabel;
    private JTable table2;

    private LocalDate currentWeekStart;
    private JTable table;

    public ProgramarCita() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Agregar panel al JFrame
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        panel.add(topPanel);
        topPanel.setBackground(new Color(0, 47, 87));
        topPanel.setBounds(0, 0, 1400, 70);
        panel.add(topPanel);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        JLabel titulo = new JLabel("Programar Cita");
        titulo.setBounds(0, 165, 1400, 40);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        // Crear botón para programar una cita
        JButton programarCitaButton = new JButton("Programar Cita");
        programarCitaButton.setBounds(230, 600, 150, 40);
        programarCitaButton.setFont(new Font("Arial", Font.BOLD, 12));
        programarCitaButton.setBackground(new Color(0, 47, 87));
        programarCitaButton.setForeground(Color.WHITE);
        panel.add(programarCitaButton);

        // ActionListener del botón "Programar"
        programarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String idMedicoSeleccionado = (String) table.getValueAt(selectedRow, 0);
                    new ProgramarCitaDialog(idMedicoSeleccionado);

                    // Obtener el ID de la cita médica
                    String idCitaSeleccionada = (String) table.getValueAt(selectedRow, 0);

                    // Actualizar la base de datos para indicar que la cita está programada
                    try {
                        Connection conn = CConexion.estableceConexion();
                        String query = "UPDATE CitasMedicas SET estado_cita = 'Programada' WHERE id_cita = ?";
                        PreparedStatement statement = conn.prepareStatement(query);
                        statement.setString(1, idCitaSeleccionada);
                        int rowsAffected = statement.executeUpdate();
                        if (rowsAffected > 0) {
                            // La cita médica ha sido programada exitosamente
                        } else {
                            // Ocurrió un error al programar la cita médica
                        }
                        statement.close();
                        conn.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(panel, "Error al actualizar la cita médica en la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Por favor, seleccione un médico antes de programar una cita.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JLabel servicioLabel = new JLabel("Seleccione el tipo de servicio solicitado:");
        servicioLabel.setBounds(80, 300, 300, 40);
        servicioLabel.setFont(new Font("Arial", Font.BOLD, 14));
        servicioLabel.setForeground(Color.BLACK);
        panel.add(servicioLabel);

        String[] servicios = {"", "Medicina familiar", "Fisioterapia", "Medicina interna", "Psicología"};
        servicioComboBox = new JComboBox<>(servicios);
        servicioComboBox.setBounds(80, 350, 300, 40);
        panel.add(servicioComboBox);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(400, 350, 100, 40);
        buscarButton.setFont(new Font("Arial", Font.BOLD, 12));
        buscarButton.setBackground(new Color(0, 47, 87));
        buscarButton.setForeground(Color.WHITE);
        panel.add(buscarButton);

        // Crear ActionListener para el botón de buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String servicioSeleccionado = (String) servicioComboBox.getSelectedItem();
                try {
                    Connection conn = CConexion.estableceConexion();
                    String query = "SELECT id_medico, primer_nombre, primer_apellido, consultorio FROM medicos WHERE especialidad = ?";
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, servicioSeleccionado);
                    ResultSet rs = statement.executeQuery();

                    tableModel.setRowCount(0);

                    while (rs.next()) {
                        String id = rs.getString("id_medico");
                        String nombre = rs.getString("primer_nombre");
                        String primerApellido = rs.getString("primer_apellido");
                        String consultorio = rs.getString("consultorio");
                        tableModel.addRow(new String[]{id, nombre, primerApellido, consultorio});
                    }

                    rs.close();
                    statement.close();
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(panel, "Error al consultar la base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        // Crear JLabel para la tabla de médicos
        JLabel medicosLabel = new JLabel("Médicos disponibles:");
        medicosLabel.setBounds(80, 400, 200, 40);
        medicosLabel.setFont(new Font("Arial", Font.BOLD, 14));
        medicosLabel.setForeground(Color.BLACK);
        panel.add(medicosLabel);

        String[] columnNames = {"ID", "Nombre", "Primer Apellido", "Consultorio"};
        Object[][] data = {};
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

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        table.setRowHeight(30);

        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }

        table.getTableHeader().setReorderingAllowed(false);

        table.setBackground(new Color(255, 255, 255, 255));
        table.setForeground(Color.BLACK);

        LineBorder border = new LineBorder(Color.BLACK);
        table.setBorder(border);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80, 450, 420, 100);
        panel.add(scrollPane);

        // Crear JLabel para el mes
        monthLabel = new JLabel();
        monthLabel.setBounds(900, 235, 200, 40); // Ajusta las coordenadas según sea necesario
        monthLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        monthLabel.setForeground(Color.BLACK);
        monthLabel.setVisible(true);
        panel.add(monthLabel);

        // Crear tabla con las horas y los días de la semana
        String[] columnNames2 = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}; // Columnas de la tabla
        Object[][] data2 = new Object[13][6]; // Número de horas
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    data2[i][j] = "<html><b>Hora</b></html>"; // Palabra "Hora" en negrita en la esquina superior izquierda
                } else if (i == 0) {
                    data2[i][j] = "<html><b>" + columnNames2[j] + "</b></html>"; // Días de la semana en negrita
                } else {
                    if (j == 0) {
                        data2[i][j] = "<html><b></b></html>"; // Horas en negrita
                    } else {
                        data2[i][j] = ""; // Datos vacíos para el resto de la tabla
                    }
                }
            }
        }

        tableModel2 = new DefaultTableModel(data2, columnNames2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2 = new JTable(tableModel2);
        table2.setShowGrid(true);
        table2.setGridColor(Color.BLACK);
        table2.setIntercellSpacing(new Dimension(0, 0));
        table2.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table2, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table2, value, isSelected, hasFocus, row, column);
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });

        // Establecer el ancho de las columnas
        for (int i = 0; i < table2.getColumnCount(); i++) {
            table2.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        // Establecer el alto de las filas
        table2.setRowHeight(30);

        // Desactivar redimensionamiento de columnas
        table2.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table2.getColumnCount(); i++) {
            table2.getColumnModel().getColumn(i).setResizable(false);
        }

        // Evitar que las columnas se muevan
        table2.getTableHeader().setReorderingAllowed(false);

        // Actualizar la tabla y el JLabel del mes
        currentWeekStart = LocalDate.now().with(DayOfWeek.MONDAY);
        updateWeek(currentWeekStart);

        // Cambiar color de las celdas de la tabla
        table2.setBackground(new Color(255, 255, 255, 255)); // Gris claro
        table2.setForeground(Color.BLACK);

        // Establecer bordes para la tabla
        Border border4 = LineBorder.createBlackLineBorder();
        table2.setBorder(border4);

        // Crear JScrollPane con la tabla
        JScrollPane scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(650, 290, 620, 350);
        panel.add(scrollPane2);

        // Crear botones para cambiar la semana
        JButton prevWeek = new JButton("Semana anterior");
        prevWeek.setBounds(680, 240, 150, 30);
        prevWeek.setBackground(new Color(0, 47, 87)); // Azul cielo
        prevWeek.setForeground(Color.WHITE);
        panel.add(prevWeek);
        prevWeek.addActionListener(e -> updateWeek(currentWeekStart.minusWeeks(1)));

        JButton nextWeek = new JButton("Siguiente semana");
        nextWeek.setBounds(1080, 240, 150, 30);
        nextWeek.setBackground(new Color(0, 47, 87)); // Azul cielo
        nextWeek.setForeground(Color.WHITE);
        panel.add(nextWeek);
        nextWeek.addActionListener(e -> updateWeek(currentWeekStart.plusWeeks(1)));

        // Crear Botón para volver a la vista de DiligenciarCita
        JButton volverButton = new JButton("Anterior");
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.setForeground(Color.DARK_GRAY);
        volverButton.setBounds(20, 630, 100, 40);
        volverButton.setBackground(new Color(193, 219, 227, 255)); // Azul cielo
        volverButton.setVisible(true);
        panel.add(volverButton);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK);
        volverButton.setBorder(border2);

        // Crear ActionListener para el botón de volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de GestionarCitas
                GestionarCitas gestionarCitas = new GestionarCitas();
                gestionarCitas.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear Advertencia si se oprime el botón de Cerrar
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                Object[] options = {"Sí", "No"};
                if (JOptionPane.showOptionDialog(panel, "¿Desea cerrar la aplicación?", "Cerrar Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        this.setVisible(true);

    }

    private void updateWeek(LocalDate startDate) {
        currentWeekStart = startDate;
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String month = "Mes: " + monthNames[startDate.getMonth().getValue() - 1];
        monthLabel.setText(month);

        LocalDate currentDay = startDate;
        for (int i = 1; i < table2.getColumnCount(); i++) {
            table2.setValueAt(currentDay.getDayOfMonth(), 0, i);
            currentDay = currentDay.plusDays(1);
        }

        String[] hours = {"6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM"};
        for (int i = 0; i < hours.length; i++) {
            table2.setValueAt("<html><b>" + hours[i] + "</b></html>", i + 1, 0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProgramarCita();
            }
        });
    }
}