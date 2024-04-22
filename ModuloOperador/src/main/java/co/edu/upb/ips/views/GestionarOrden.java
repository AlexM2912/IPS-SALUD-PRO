package co.edu.upb.ips.views;

import javax.swing.*;
import java.awt.*;
public class GestionarOrden extends JFrame {

    private JPanel panel;
    private JPanel topPanel;

    public GestionarOrden() {
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
        JLabel titulo = new JLabel("Gestionar Orden");
        titulo.setBounds(0, 165, 1400, 40); // Ajusta las coordenadas según sea necesario
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto horizontalmente
        panel.add(titulo);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarOrden();
            }
        });
    }

}
