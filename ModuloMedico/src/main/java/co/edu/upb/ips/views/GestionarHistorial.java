package co.edu.upb.ips.views;

import javax.swing.*;
import java.awt.*;
public class GestionarHistorial extends JFrame {
    private JPanel panel;
    private JPanel topPanel;
    public GestionarHistorial() {

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

        // Crear Panel para Jlabel de Bienvenida
        JPanel bienvenidaPanel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setVisible(true);
        panel.setBounds(0, 0, 1400, 800);
        panel.setBackground(Color.WHITE);

        // Crear Jlabel para el título
        JLabel titulo = new JLabel("Gestionar Historial Clínico");
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
        logolabel23.setBounds(230, 320, 150, 150);
        panel.add(logolabel23);

        String path4 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoRegistro.png";
        ImageIcon icon4 = new ImageIcon(path4);
        JLabel logolabel4 = new JLabel(icon4);
        logolabel4.setBounds(480, 320, 150, 149);
        panel.add(logolabel4);

        String path5 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoOrden.png";
        ImageIcon icon5 = new ImageIcon(path5);
        JLabel logolabel5 = new JLabel(icon5);
        logolabel5.setBounds(730, 325, 128, 140);
        panel.add(logolabel5);

        String path6 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoReporte.png";
        ImageIcon icon6 = new ImageIcon(path6);
        JLabel logolabel6 = new JLabel(icon6);
        logolabel6.setBounds(980, 325, 111, 133);
        panel.add(logolabel6);

        // Crear Jlabel para el subtítulo
        JLabel subtitulo = new JLabel("Seleccione la opción correspondiente");
        subtitulo.setBounds(0, 240, 1400, 35); // Ajusta las coordenadas según sea necesario
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 20));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        subtitulo.setVisible(true);
        panel.add(subtitulo); // Agrega subtitulo a panel

        // Añadir Botones
        JButton boton1 = new JButton("Añadir Información");
        JButton boton2 = new JButton("Consultar Historial");
        JButton boton3 = new JButton("Editar Historial");
        JButton boton4 = new JButton("Reporte");

        // Cambiar el color de fuentes de los botones
        boton1.setForeground(Color.WHITE);
        boton2.setForeground(Color.WHITE);
        boton3.setForeground(Color.WHITE);
        boton4.setForeground(Color.WHITE);

        // Ajustar las coordenadas de los botones con espacio distribuido y corridos a la izquierda
        boton1.setBounds(220, 480, 150, 50);
        boton1.setBackground(new Color(0, 47, 87));
        boton2.setBounds(470, 480, 150, 50);
        boton2.setBackground(new Color(0, 47, 87));
        boton3.setBounds(720, 480, 150, 50);
        boton3.setBackground(new Color(0, 47, 87));
        boton4.setBounds(970, 480, 150, 50);
        boton4.setBackground(new Color(0, 47, 87));

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);

        // Crear JLabel para el texto de instrucción con salto de línea
        JLabel instruccionLabel = new JLabel("<html><center>Estimado(a) Médico(a), recuerde que para tramitar los procesos que manejen información confidencial,<br>deberá diligenciar sus credenciales.</center></html>");
        instruccionLabel.setFont(new Font("Urbanist", Font.ITALIC, 14));
        instruccionLabel.setForeground(Color.BLACK);
        instruccionLabel.setBounds(0, 600, 1400, 50);
        instruccionLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        panel.add(instruccionLabel);

        // Crear ActionListener para el botón de Reporte
        boton4.addActionListener(e -> {
            // Abrir la vista de GestionarReporte
            GestionarReporte gestionarReporte = new GestionarReporte();
            gestionarReporte.setVisible(true);
            dispose(); // Cerrar la ventana actual
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarHistorial().setVisible(true);
            }
        });
    }
}
