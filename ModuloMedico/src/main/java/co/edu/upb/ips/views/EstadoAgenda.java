package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstadoAgenda extends JFrame {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;
    private LocalDate currentDate;
    private JLabel currentDateLabel;

    public EstadoAgenda() {

        // Propiedades del JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel con color de fondo blanco
        panel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setBackground(Color.WHITE);

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

        // Crear JLabel para mostrar la fecha actual
        currentDateLabel = new JLabel();
        currentDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentDateLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        currentDateLabel.setForeground(Color.BLACK);
        currentDateLabel.setBounds(205, 220, 1000, 25);
        panel.add(currentDateLabel);

        // Botones para cambiar de día
        JButton prevDayButton = new JButton("<");
        prevDayButton.setBounds(542, 220, 45, 25);
        prevDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDate(currentDate.minusDays(1));
            }
        });
        panel.add(prevDayButton);

        JButton nextDayButton = new JButton(">");
        nextDayButton.setBounds(820, 220, 45, 25);
        nextDayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDate(currentDate.plusDays(1));
            }
        });
        panel.add(nextDayButton);

        // Campo de texto para búsqueda de día específico
        JTextField searchField = new JTextField();
        searchField.setBounds(930, 220, 200, 25);
        searchField.setFont(new Font("Arial", Font.BOLD, 15));
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate date = LocalDate.parse(searchField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    updateDate(date);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Formato de fecha inválido. Utilice el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(searchField);

        // Crear Botón para buscar día específico
        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(1140, 220, 80, 25);
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate date = LocalDate.parse(searchField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    updateDate(date);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Formato de fecha inválido. Utilice el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Crear tabla con las horas y los días de la semana
        String[] columnNames = {"Hora", "Evento", "Descripción", "Estado"}; // Columnas de la tabla
        Object[][] data = new Object[12][4]; // Número de horas
        for (int i = 0; i < 12; i++) {
            int hour = i + 6;
            String timePeriod = "AM";
            if (hour >= 12) {
                timePeriod = "PM";
                if (hour > 12) {
                    hour -= 12;
                }
            }
            data[i][0] = hour + ":00 " + timePeriod;
            for (int j = 1; j < 4; j++) {
                data[i][j] = "";
            }
        }
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 3) {
                    return JPanel.class; // Cambiar el tipo de clase de la columna "Estado" a JPanel
                }
                return Object.class;
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

        // Cambiar color de las celdas de la tabla
        table.setBackground(new Color(255, 255, 255, 255)); // Gris claro
        table.setForeground(Color.BLACK);

        // Establecer bordes para la tabla
        Border border = LineBorder.createBlackLineBorder();
        table.setBorder(border);

        // Crear JScrollPane con la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(215, 290, 1000, 350);
        panel.add(scrollPane);

        // Asignar el renderizador de botones personalizado para la columna "Estado"
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());

        // Crear JLabel para el título
        JLabel titulo = new JLabel("Estado de la Agenda");
        titulo.setBounds(0, 120, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setVisible(true);
        panel.add(titulo); // Agrega titulo a panel

        // Añadir JLabel para mostrar la fecha actual
        JLabel currentDateLabel = new JLabel();
        currentDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        currentDateLabel.setForeground(Color.BLACK);
        currentDateLabel.setBounds(200, 230, 1000, 25);
        topPanel.add(currentDateLabel);

        // Mostrar la ventana
        this.setVisible(true);

        // Establecer la fecha actual y actualizar la tabla
        currentDate = LocalDate.now();
        updateDate(currentDate);

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
                // Abrir la vista de GestionarAgenda
                GestionarAgenda gestionarAgenda = new GestionarAgenda();
                gestionarAgenda.setVisible(true);
                dispose(); // Cerrar la ventana actual
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

    private void updateDate(LocalDate date) {
        currentDate = date;
        String[] daysOfWeek = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Actualizar el título
        String title = "Estado de Agenda - " + date.getDayOfMonth() + " de " + monthNames[date.getMonthValue() - 1] + " de " + date.getYear();
        this.setTitle(title);

        // Actualizar la etiqueta de la fecha actual
        currentDateLabel.setText("Fecha Actual: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Actualizar los datos de la tabla y agregar botones en la columna "Estado"
        for (int i = 0; i < 12; i++) {
            JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // Crear un panel para los botones
            JButton acceptButton = new JButton("Aceptar"); // Botón de Aceptar
            JButton cancelButton = new JButton("Cancelar"); // Botón de Cancelar
            buttonPanel.add(acceptButton);
            buttonPanel.add(cancelButton);
            tableModel.setValueAt(buttonPanel, i, 3);
        }
    }

    // Renderizador de botones personalizado
    private class ButtonRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value; // Devolver el componente (en este caso, el panel con los botones)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EstadoAgenda::new);
    }
}