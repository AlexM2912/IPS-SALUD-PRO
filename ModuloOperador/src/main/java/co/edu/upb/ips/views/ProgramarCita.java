package co.edu.upb.ips.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgramarCita extends JFrame {

    private JPanel panel;

    public ProgramarCita() {
        initComponents();
    }

    private void initComponents() {
        // Configuración del JFrame
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel principal
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setVisible(true);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(0, 47, 87));
        topPanel.setBounds(0, 0, 1400, 70);
        topPanel.setVisible(true);
        panel.add(topPanel);

        // Añadir imagen al JPanel superior
        ImageIcon logoIcon = new ImageIcon("ruta/a/la/imagen/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(30, 80, 150, 168);
        panel.add(logoLabel);

        // Crear JLabel para el título
        JLabel titleLabel = new JLabel("Programar Cita");
        titleLabel.setBounds(0, 165, 1400, 40);
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 30));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        // Crear campos para ingresar el número de documento y la fecha de la cita
        JLabel documentoLabel = new JLabel("Número de Identificación:");
        documentoLabel.setBounds(130, 316, 200, 40);
        panel.add(documentoLabel);

        JTextField documentoField = new JTextField();
        documentoField.setBounds(280, 320, 200, 25);
        panel.add(documentoField);

        JLabel fechaLabel = new JLabel("Fecha de la Cita:");
        fechaLabel.setBounds(130, 366, 150, 30);
        panel.add(fechaLabel);

        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        fechaSpinner.setBounds(260, 370, 200, 25);
        JSpinner.DateEditor fechaEditor = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy");
        fechaSpinner.setEditor(fechaEditor);
        panel.add(fechaSpinner);

        // Crear botón para programar cita
        JButton programarButton = new JButton("Programar Cita");
        programarButton.setBounds(120, 420, 150, 40);
        panel.add(programarButton);

        // Crear ActionListener para el botón de programar cita
        programarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDocumento = documentoField.getText();
                Date fechaCita = (Date) fechaSpinner.getValue();

                // Validar que se haya ingresado un número de documento
                if (numeroDocumento.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Por favor ingrese el número de documento.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar que se haya seleccionado una fecha válida
                if (fechaCita == null) {
                    JOptionPane.showMessageDialog(panel, "Por favor seleccione una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Convertir la fecha a formato deseado (puedes ajustar esto según tu base de datos)
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaCitaStr = sdf.format(fechaCita);

            }
        });

        // Otros componentes y acciones...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProgramarCita::new);
    }
}
