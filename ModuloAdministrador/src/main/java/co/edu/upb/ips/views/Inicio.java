package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    public Inicio () {

        // Propiedades del JFrame
        this.setVisible(true);
        this.setBounds(EXIT_ON_CLOSE, ABORT, 1400, 800);
        this.setLocationRelativeTo(null);

        // Crear JPanel con color de fondo blanco
        JPanel panel = new JPanel(null);
        getContentPane().add(panel); // Añadir panel al JFrame
        panel.setVisible(true);
        panel.setBounds(0, 0, 1400, 400);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(new Color(0, 47, 87)); // Azul oscuro
        topPanel.setBounds(0, 0, 1400, 86);
        topPanel.setVisible(true);
        panel.add(topPanel);

        // Crear JLabel con el título
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloAdministrador/src/main/java/co/edu/upb/ips/images/SALUD_PRO-preview.png";
        ImageIcon logo = new ImageIcon(path);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(440, 90, 500, 500);
        panel.add(logoLabel, BorderLayout.CENTER);

        // Crear botón de inicio
        JButton iniciarButton = new JButton("Iniciar");
        iniciarButton.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
        iniciarButton.setBounds(640, 600, 100, 40);
        iniciarButton.setBackground(new Color(48, 172, 227)); // Azul cielo
        iniciarButton.setVisible(true);
        panel.add(iniciarButton);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        iniciarButton.setBorder(border);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de Login
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

}