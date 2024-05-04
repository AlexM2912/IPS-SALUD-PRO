package co.edu.upb.ips.views;

import javax.swing.*;
import java.awt.*;

public class GestionarActividades extends JFrame {

    private JPanel panel;
    private JPanel topPanel;
    public GestionarActividades() {
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

        // Añadir imagen al Panel de fondo
        String path7 = "";
        ImageIcon icon7 = new ImageIcon(path7);
        JLabel logolabel7 = new JLabel(icon7);
        logolabel7.setBounds(1170, 60, 170, 170);
        panel.add(logolabel7);

        // Crear Panel para Jlabel de Bienvenida
        JPanel bienvenidaPanel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setVisible(true);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(Color.WHITE);

        // Crear Jlabel para el título
        JLabel titulo = new JLabel("Bienvenid@, ¿Qué desea diligenciar?");
        titulo.setBounds(0, 165, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        titulo.setVisible(true);
        panel.add(titulo); // Agrega titulo a panel

        // Añadir Imagenes a los botones
        String path23 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoAgenda.png";
        ImageIcon icon23 = new ImageIcon(path23);
        JLabel logolabel23 = new JLabel(icon23);
        logolabel23.setBounds(355, 330, 150, 150);
        panel.add(logolabel23);

        String path4 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoRegistro.png";
        ImageIcon icon4 = new ImageIcon(path4);
        JLabel logolabel4 = new JLabel(icon4);
        logolabel4.setBounds(650, 330, 150, 149);
        panel.add(logolabel4);

        String path5 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoOrden.png";
        ImageIcon icon5 = new ImageIcon(path5);
        JLabel logolabel5 = new JLabel(icon5);
        logolabel5.setBounds(935, 335, 128, 140);
        panel.add(logolabel5);

        // Crear Jlabel para el subtítulo
        JLabel subtitulo = new JLabel("Seleccione la opción correspondiente");
        subtitulo.setBounds(0, 240, 1400, 35); // Ajusta las coordenadas según sea necesario
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 20));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        subtitulo.setVisible(true);
        panel.add(subtitulo); // Agrega subtitulo a panel

        // Añadir Botones
        JButton boton1 = new JButton("Gestionar Usuarios");
        JButton boton2 = new JButton("Historial Clínico");
        JButton boton3 = new JButton("Reporte");

        // Cambiar el color de fuentes de los botones
        boton1.setForeground(Color.WHITE);
        boton2.setForeground(Color.WHITE);
        boton3.setForeground(Color.WHITE);

        // Ajustar las coordenadas de los botones con espacio distribuido y corridos a la izquierda
        boton1.setBounds(350, 500, 150, 40);
        boton1.setBackground(new Color(0, 47, 87)); // Azul oscuro
        boton2.setBounds(640, 500, 150, 40);
        boton2.setBackground(new Color(0, 47, 87)); // Azul oscuro
        boton3.setBounds(930, 500, 150, 40);
        boton3.setBackground(new Color(0, 47, 87)); // Azul oscuro

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);

        // Crear JLabel para el texto de instrucción con salto de línea
        JLabel instruccionLabel = new JLabel("<html><center>Estimado(a) Administrador(a), recuerde que para la gestión de usuarios,<br>solo podrá realizarla siempre y cuando estos(as) pertenezcan a su jurisdicción.</center></html>");
        instruccionLabel.setFont(new Font("Urbanist", Font.ITALIC, 14));
        instruccionLabel.setForeground(Color.BLACK);
        instruccionLabel.setBounds(0, 600, 1400, 50);
        instruccionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        panel.add(instruccionLabel);

        // Crear ActionListener para el botón de Reporte
        boton3.addActionListener(e -> {
            // Abrir la vista de GestionarReportes
            GestionarReportes gestionarReportes = new GestionarReportes();
            gestionarReportes.setVisible(true);
            dispose(); // Cerrar la ventana actual
        });

        // Crear ActionListener para el botón de Usuarios
        boton1.addActionListener(e -> {
            // Abrir la vista de GestionarUsuarios
            GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();
            gestionarUsuarios.setVisible(true);
            dispose(); // Cerrar la ventana actual
        });

        // Crear ActionListener para el botón de Historial Clínico
        boton2.addActionListener(e -> {
            // Abrir la vista de GestionarHistorialClinico
            GestionarHistorialClinico gestionarHistorialClinico = new GestionarHistorialClinico();
            gestionarHistorialClinico.setVisible(true);
            dispose(); // Cerrar la ventana actual
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
                new GestionarActividades().setVisible(true);
            }
        });
    }
}