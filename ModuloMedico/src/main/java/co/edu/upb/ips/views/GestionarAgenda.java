package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class GestionarAgenda extends JFrame {

    public GestionarAgenda() {
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

        // Crear Jlabel para el título
        JLabel titulo = new JLabel("Agenda");
        titulo.setBounds(0, 140, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setVisible(true);
        panel.add(titulo); // Agrega titulo a panel

        // Crear JCalendar para seleccionar la fecha
        CustomCalendar calendar = new CustomCalendar();
        calendar.setBounds(620, 240, 630, 380);
        panel.add(calendar);

        // Añadir Jlabel para mensaje "Seleccione la Opción correspondiente"
        JLabel mensaje = new JLabel("Seleccione la Opción correspondiente");
        mensaje.setBounds(183, 320, 300, 50);
        mensaje.setFont(new Font("Arial", Font.CENTER_BASELINE, 16));
        mensaje.setForeground(Color.BLACK);
        panel.add(mensaje);

        // Añadir Botón de Consultar Detalles de la Agenda
        JButton consultar = new JButton("Consultar Detalles de la Agenda");
        consultar.setBounds(180, 370, 300, 40);
        consultar.setBackground(new Color(0, 47, 87));
        consultar.setForeground(Color.WHITE);
        consultar.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(consultar);

        // Añadir Botón para Definir el Estado de la Agenda
        JButton definir = new JButton("Definir Estado de la Agenda");
        definir.setBounds(180, 420, 300, 40);
        definir.setBackground(new Color(0, 47, 87));
        definir.setForeground(Color.WHITE);
        definir.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(definir);

        // Añadir Botón para Realizar Consulta Avanzada
        JButton avanzada = new JButton("Realizar Consulta Avanzada");
        avanzada.setBounds(180, 470, 300, 40);
        avanzada.setBackground(new Color(0, 47, 87));
        avanzada.setForeground(Color.WHITE);
        avanzada.setFont(new Font("Arial", Font.ITALIC, 16));
        panel.add(avanzada);

        // Crear Botón para volver a la vista de DiligenciarCita
        JButton volverButton = new JButton("Anterior");
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.setForeground(Color.DARK_GRAY);
        volverButton.setBounds(20, 630, 100, 40);
        volverButton.setBackground(new Color(193, 219, 227, 255)); // Azul cielo
        volverButton.setVisible(true);
        panel.add(volverButton);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        volverButton.setBorder(border);

        // Crear ActionListener para el botón de Volver a la vista de GestionarActividades
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de GestionarActividades
                GestionarActividades gestionarActividades = new GestionarActividades();
                gestionarActividades.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear ActionListener para el botón de Consultar Detalles de la Agenda
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de DetallesAgenda con el ID del médico
                DetallesAgenda detallesAgenda = new DetallesAgenda(1);
                detallesAgenda.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });


        // Crear ActionListener para el botón de Definir Estado de la Agenda
        definir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de EstadoAgenda
                EstadoAgenda estadoAgenda = new EstadoAgenda();
                estadoAgenda.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear ActionListener para el botón de Realizar Consulta Avanzada
        avanzada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de ConsultaAvanzada
                ConsultaAvAgenda consultaAvAvanzada = new ConsultaAvAgenda();
                consultaAvAvanzada.setVisible(true);
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
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new GestionarAgenda().setVisible(true);
            }
        });
    }
}
