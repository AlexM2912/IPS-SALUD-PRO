package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Login extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public Login() {

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

        // Crear JPanel inferior con color de fondo gris claro
        JPanel infPanel = new JPanel(null);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        infPanel.setBorder(border);
        infPanel.setBackground(new Color(207, 212, 217, 210)); // gris claro
        infPanel.setBounds(0, 610, 1400, 86);
        infPanel.setVisible(true);
        panel.add(infPanel);

        //Añadir información al panel inferior
        JLabel infoLabel = new JLabel("© 2024 IPS SALUD PRO - Todos los derechos reservados");
        infoLabel.setBounds(500, 25, 400, 40);
        infoLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        infoLabel.setForeground(Color.BLACK);
        infoLabel.setVisible(true);
        infPanel.add(infoLabel); // Agrega infoLabel a infPanel

        // Crear JPanel en la derecha con color de fondo gris claro
        JPanel rightPanel = new JPanel(null);
        border = BorderFactory.createLineBorder(Color.BLACK);
        rightPanel.setBorder(border);
        rightPanel.setBackground(new Color(207, 212, 217, 210)); // gris claro
        rightPanel.setBounds(750, 120, 420, 450);
        rightPanel.setVisible(true);
        panel.add(rightPanel);

        // Crear JLabel para el usuario
        JLabel usuarioLabel = new JLabel("Bienvenid@");
        usuarioLabel.setBounds(160, 10, 300, 40); // Ajusta las coordenadas según sea necesario
        usuarioLabel.setFont(new Font("Lato", Font.BOLD, 22));
        usuarioLabel.setForeground(Color.BLACK);
        usuarioLabel.setVisible(true);
        rightPanel.add(usuarioLabel); // Agrega usuarioLabel a rightPanel

        // Añadir imagen al Panel de la derecha al lado de "Bienvenido"
        String path3 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/IconoSerpienteSalud.png";
        ImageIcon logo3 = new ImageIcon(path3);
        JLabel logoLabel3 = new JLabel(logo3);
        logoLabel3.setBounds(310, 10, 37, 44);
        rightPanel.add(logoLabel3);

        // Añadir JLabel al panel de la derecha para la Sede
        JLabel sedeLabel = new JLabel("Sede:");
        sedeLabel.setBounds(65, 60, 300, 40); // Incremento de 20 en y
        sedeLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        sedeLabel.setForeground(Color.BLACK);
        sedeLabel.setVisible(true);
        rightPanel.add(sedeLabel); // Agrega usuarioLabel a rightPanel

        // Crear JComboBox para seleccionar la sede
        String[] sedes = {"Principal - Bucaramanga", "Sede - Floridablanca", "Sede - Piedecuesta", "Sede - Girón", "Sede - Ríonegro", "Sede - Pamplona", "Sede - Lebrija"};
        JComboBox<String> sedeComboBox = new JComboBox<>(sedes);
        sedeComboBox.setBounds(65, 100, 300, 40);
        sedeComboBox.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        sedeComboBox.setVisible(true);
        rightPanel.add(sedeComboBox);

        // Crear JLabel para el Número de Identificación
        JLabel identificacionLabel = new JLabel("Número de Identificación:");
        identificacionLabel.setBounds(65, 150, 300, 40); // Incremento de 20 en y
        identificacionLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        identificacionLabel.setForeground(Color.BLACK);
        identificacionLabel.setVisible(true);
        rightPanel.add(identificacionLabel); // Agrega identificacionLabel a rightPanel

        // Crear JTextField para el número de identificación
        JTextField textField1 = new JTextField();
        textField1.setBounds(65, 190, 300, 40); // Incremento de 20 en y
        textField1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        textField1.setVisible(true);
        rightPanel.add(textField1);

        // Crear JLabel para la contraseña
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(65, 240, 300, 40); // Incremento de 20 en y
        contrasenaLabel.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        contrasenaLabel.setForeground(Color.BLACK);
        contrasenaLabel.setVisible(true);
        rightPanel.add(contrasenaLabel); // Agrega contrasenaLabel a rightPanel

        // Crear JPasswordField para la contraseña
        JPasswordField passwordField1 = new JPasswordField(null);
        passwordField1.setBounds(65, 280, 300, 40); // Incremento de 20 en y
        passwordField1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        passwordField1.setVisible(true);
        rightPanel.add(passwordField1);

        // Crear botón de ingreso
        JButton ingresarButton = new JButton("Ingresar");
        ingresarButton.setFont(new Font("Arial", Font.ITALIC, 14));
        ingresarButton.setBounds(162, 350, 100, 40);
        ingresarButton.setBackground(new Color(118, 154, 197)); // Azul cielo
        ingresarButton.setVisible(true);
        rightPanel.add(ingresarButton);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK);
        ingresarButton.setBorder(border1);

        // Crear JLabel con el título
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/SALUD_PRO-preview.png";
        ImageIcon logo = new ImageIcon(path);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(130, 100, 500, 500);
        panel.add(logoLabel, BorderLayout.CENTER);

        // Crear JLabel con el título
        String path2 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/blur-hospital-background-free-photo.jpg";
        ImageIcon logo2 = new ImageIcon(path2);
        JLabel logoLabel2 = new JLabel(logo2);
        logoLabel2.setBounds(0, 0, 1400, 800);
        panel.add(logoLabel2, BorderLayout.CENTER);
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}