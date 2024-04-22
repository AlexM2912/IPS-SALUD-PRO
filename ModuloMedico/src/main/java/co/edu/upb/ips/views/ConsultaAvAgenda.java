package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.table.TableCellRenderer;

public class ConsultaAvAgenda extends JFrame {
    private JPanel panel;
    private JLabel monthLabel;
    private JTable table;
    private DefaultTableModel tableModel;
    private LocalDate currentWeekStart;

    public ConsultaAvAgenda() {
        // Propiedades del JFrame
        this.setTitle("Consulta Avanzada de Agenda");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel con color de fondo blanco
        panel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setBackground(Color.WHITE);

        // Crear JLabel para el título
        JLabel titulo = new JLabel("Consulta Avanzada de la Agenda");
        titulo.setBounds(0, 120, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setVisible(true);
        panel.add(titulo); // Agrega titulo a panel

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        panel.add(topPanel);
        topPanel.setBackground(new Color(0, 47, 87)); // Azul oscuro
        topPanel.setBounds(0, 0, 1400, 70);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        // Crear JLabel para el mes
        monthLabel = new JLabel();
        monthLabel.setBounds(230, 240, 200, 30); // Ajusta las coordenadas según sea necesario
        monthLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        monthLabel.setForeground(Color.BLACK);
        panel.add(monthLabel);

        // Crear tabla con las horas y los días de la semana
        String[] columnNames = {"", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"}; // Columnas de la tabla
        Object[][] data = new Object[13][6]; // Número de horas
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 && j == 0) {
                    data[i][j] = "<html><b>Hora</b></html>"; // Palabra "Hora" en negrita en la esquina superior izquierda
                } else if (i == 0) {
                    data[i][j] = "<html><b>" + columnNames[j] + "</b></html>"; // Días de la semana en negrita
                } else {
                    if (j == 0) {
                        data[i][j] = "<html><b></b></html>"; // Horas en negrita
                    } else {
                        data[i][j] = ""; // Datos vacíos para el resto de la tabla
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
        table.setBackground(new Color(255, 255, 255, 255)); // Gris claro
        table.setForeground(Color.BLACK);

        // Establecer bordes para la tabla
        Border border = LineBorder.createBlackLineBorder();
        table.setBorder(border);

        // Crear JScrollPane con la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(215, 290, 800, 350); // Se ha reducido el ancho
        panel.add(scrollPane);

        // Crear botones para cambiar la semana
        JButton prevWeek = new JButton("Semana anterior");
        prevWeek.setBounds(500, 240, 140, 30);
        prevWeek.setBackground(new Color(0, 47, 87)); // Azul cielo
        prevWeek.setForeground(Color.WHITE);
        panel.add(prevWeek);
        prevWeek.addActionListener(e -> updateWeek(currentWeekStart.minusWeeks(1)));

        JButton nextWeek = new JButton("Siguiente semana");
        nextWeek.setBounds(690, 240, 140, 30);
        nextWeek.setBackground(new Color(0, 47, 87)); // Azul cielo
        nextWeek.setForeground(Color.WHITE);
        panel.add(nextWeek);
        nextWeek.addActionListener(e -> updateWeek(currentWeekStart.plusWeeks(1)));

        // Crear JLabel y JTextField para buscar por fecha
        JLabel buscarFechaLabel = new JLabel("Buscar por fecha:");
        panel.add(buscarFechaLabel);

        JTextField fechaTextField = new JTextField();
        panel.add(fechaTextField);

        JButton buscarFechaButton = new JButton("Buscar");
        buscarFechaButton.setBackground(new Color(118, 154, 197)); // Azul cielo
        panel.add(buscarFechaButton);

        // Crear JLabel y JTextField para buscar por referencia
        JLabel buscarReferenciaLabel = new JLabel("Buscar por Referencia:");
        panel.add(buscarReferenciaLabel);

        JTextField referenciaTextField = new JTextField();
        panel.add(referenciaTextField);

        JButton buscarReferenciaButton = new JButton("Buscar");
        buscarReferenciaButton.setBackground(new Color(118, 154, 197)); // Azul cielo
        panel.add(buscarReferenciaButton);

        // Ajustar las posiciones de los campos de búsqueda y botones para que queden dentro de la GUI
        buscarFechaLabel.setBounds(1130, 300, 200, 30);
        fechaTextField.setBounds(1100, 330, 200, 30);
        buscarFechaButton.setBounds(1100, 365, 200, 30);
        buscarReferenciaLabel.setBounds(1130, 420, 200, 30);
        referenciaTextField.setBounds(1100, 450, 200, 30);
        buscarReferenciaButton.setBounds(1100, 485, 200, 30);

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

        // Crear ActionListener para el botón de búsqueda por referencia
        buscarReferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String referenciaBusqueda = referenciaTextField.getText();
                // Realizar la búsqueda por referencia
                // ...
            }
        });

        // Crear ActionListener para el botón de Volver a la vista de GestionarAgenda
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de GestionarAgenda
                GestionarAgenda gestionarAgenda = new GestionarAgenda();
                gestionarAgenda.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // ActionListener para el botón de búsqueda por fecha
        buscarFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaBusquedaStr = fechaTextField.getText();
                try {
                    // Convertir la fecha ingresada al formato correcto (DD-MM-YYYY)
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate fechaBusqueda = LocalDate.parse(fechaBusquedaStr, formatter);

                    // Calcular el inicio de la semana que contiene la fecha buscada
                    LocalDate inicioSemana = fechaBusqueda.with(DayOfWeek.MONDAY);

                    // Actualizar la tabla para mostrar esa semana
                    updateWeek(inicioSemana);
                } catch (DateTimeParseException ex) {
                    // Si la entrada no es una fecha válida, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(panel, "Formato de fecha incorrecto. Por favor, ingrese una fecha en formato DD-MM-YYYY.", "Error", JOptionPane.ERROR_MESSAGE);
                }
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

        // Mostrar la ventana
        this.setVisible(true);

    }

    // Método para actualizar la semana en la tabla
    private void updateWeek(LocalDate startDate) {
        currentWeekStart = startDate;
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String month = "Mes: " + monthNames[startDate.getMonthValue() - 1];
        monthLabel.setText(month);

        LocalDate currentDay = startDate;
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("dd");
        for (int i = 1; i < table.getColumnCount(); i++) {
            table.setValueAt(currentDay.format(dayFormatter), 0, i);
            currentDay = currentDay.plusDays(1);
        }

        String[] hours = {"6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM"};
        for (int i = 0; i < hours.length; i++) {
            table.setValueAt("<html><b>" + hours[i] + "</b></html>", i + 1, 0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new ConsultaAvAgenda().setVisible(true);
            }
        });
    }
}