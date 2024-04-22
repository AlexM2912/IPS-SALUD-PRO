package co.edu.upb.ips.views;

import co.edu.upb.ips.models.DatabaseManager;

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

public class GestionarCitas extends JFrame{

    private JPanel panel;
    private JPanel topPanel;
    private DefaultTableModel tableModel;


    public GestionarCitas() {
        this.setVisible(true);
        this.setBounds(EXIT_ON_CLOSE, ABORT, 1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel con color de fondo blanco
        JPanel panel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setVisible(true);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(0, 47, 87)); // Azul oscuro
        topPanel.setBounds(0, 0, 1400, 70);
        topPanel.setVisible(true);
        panel.add(topPanel);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        // Crear JLabel para el título
        JLabel titulo = new JLabel("Gestionar Citas");
        titulo.setBounds(0, 165, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        panel.add(titulo);

        // Crear JLabel para el número de Documento del paciente
        JLabel documentoLabel = new JLabel("<html><div style='text-align: center;'>Número de <br>Identificación:</div></html>");
        documentoLabel.setBounds(130, 316, 200, 40);
        documentoLabel.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
        documentoLabel.setForeground(Color.BLACK);
        panel.add(documentoLabel);

        // Crear JTextField para el número de Documento del paciente
        JTextField documentoField = new JTextField();
        documentoField.setBounds(260, 320, 200, 25);
        documentoField.setFont(new Font("Arial", Font.PLAIN, 16));
        documentoField.setForeground(Color.BLACK);
        documentoField.setBackground(Color.WHITE);
        documentoField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(documentoField);

        // Crear Botón para Programar Cita
        JButton programarButton = new JButton("<html><div style='text-align: center;'>Programar <br>Cita</div></html>");
        programarButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        programarButton.setForeground(Color.WHITE);
        programarButton.setBounds(120, 520, 120, 50);
        programarButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        programarButton.setVisible(true);
        panel.add(programarButton);

        // Añadir Imagen encima del botón de Programar Cita
        String path2 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon2 = new ImageIcon(path2);
        JLabel logolabel2 = new JLabel(icon2);
        logolabel2.setBounds(130, 420, 104, 88);
        panel.add(logolabel2);

        // Crear Botón para Cancelar Cita
        JButton cancelarButton = new JButton("<html><div style='text-align: center;'>Cancelar <br>Cita</div></html>");
        cancelarButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        cancelarButton.setForeground(Color.WHITE);
        cancelarButton.setBounds(270, 520, 120, 50);
        cancelarButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        cancelarButton.setVisible(true);
        panel.add(cancelarButton);

        // Añadir Imagen encima del botón de Cancelar Cita
        String path3 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/img_1.png";
        ImageIcon icon3 = new ImageIcon(path3);
        JLabel logolabel3 = new JLabel(icon3);
        logolabel3.setBounds(275, 420, 114, 89);
        panel.add(logolabel3);

        // Crear Botón para Reprogramar Cita
        JButton reprogramarButton = new JButton("<html><div style='text-align: center;'>Reprogramar <br>Cita</div></html>");
        reprogramarButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        reprogramarButton.setForeground(Color.WHITE);
        reprogramarButton.setBounds(420, 520, 120, 50);
        reprogramarButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        reprogramarButton.setVisible(true);
        panel.add(reprogramarButton);

        // Añadir Imagen encima del botón de Reprogramar Cita
        String path4 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/img_2.png";
        ImageIcon icon4 = new ImageIcon(path4);
        JLabel logolabel4 = new JLabel(icon4);
        logolabel4.setBounds(430, 420, 96, 89);
        panel.add(logolabel4);

        // Crear tabla para consultar información de los pacientes
        String[] columnNames = {"Nombre", "Apellido", "Tipo Documento", "Estado", "Teléfono"}; // Columnas de la tabla
        Object[][] data = {

        };
        tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
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
        scrollPane.setBounds(615, 280, 700, 200); // Se ha reducido el ancho
        panel.add(scrollPane);

        // Crear JButton para consultar información del paciente
        JButton consultarButton = new JButton("Consultar");
        consultarButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        consultarButton.setForeground(Color.WHITE);
        consultarButton.setBounds(830, 530, 120, 40);
        consultarButton.setBackground(new Color(0, 47, 87, 255));
        consultarButton.setVisible(true);
        panel.add(consultarButton);
        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
        consultarButton.setBorder(buttonBorder);

        // Crear ActionListener para el botón de Consultar
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDocumento = documentoField.getText();

                // Validar que el campo del número de documento no esté vacío
                if (numeroDocumento.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Por favor ingrese el número de documento.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Consultar la información del paciente
                String[] paciente = DatabaseManager.consultarPaciente(numeroDocumento);

                if (paciente != null) {
                    // Limpiar la tabla antes de mostrar los resultados
                    tableModel.setRowCount(0);
                    // Agregar la información del paciente a la tabla
                    tableModel.addRow(paciente);
                } else {
                    JOptionPane.showMessageDialog(panel, "Paciente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Crear Botón para remover Información del paciente dentro de la tabla
        JButton removerButton = new JButton("Remover");
        removerButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        removerButton.setForeground(Color.WHITE);
        removerButton.setBounds(980, 530, 120, 40);
        removerButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        removerButton.setVisible(true);
        panel.add(removerButton);
        Border border3 = BorderFactory.createLineBorder(Color.BLACK);
        removerButton.setBorder(border3);

        // Crear Actionlistener para el botón de remover
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    tableModel.removeRow(row);
                } else {
                    JOptionPane.showMessageDialog(panel, "Seleccione una fila para remover", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Crear Botón para volver a la vista de DiligenciarCita
        JButton volverButton = new JButton("Anterior");
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.setForeground(Color.DARK_GRAY);
        volverButton.setBounds(20, 630, 100, 40);
        volverButton.setBackground(new Color(193, 219, 227, 255)); // Azul cielo
        volverButton.setVisible(true);
        panel.add(volverButton);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK);
        volverButton.setBorder(border1);

        // Crear ActionListener para el botón de Volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de DilingenciarCita
                new DiligenciarCita();
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
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarCitas();
            }
        });
    }
}