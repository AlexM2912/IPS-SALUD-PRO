package co.edu.upb.ips.views;

import co.edu.upb.ips.models.UsuariosManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    public Login() {

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

        // Crear JPanel inferior con color de fondo gris claro
        JPanel infPanel = new JPanel(null);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        infPanel.setBorder(border);
        infPanel.setBackground(new Color(207, 212, 217, 210)); // gris claro
        infPanel.setBounds(0, 625, 1400, 75);
        infPanel.setVisible(true);
        panel.add(infPanel);

        //Añadir información al panel inferior
        JLabel infoLabel = new JLabel("© 2024 IPS SALUD PRO - Todos los derechos reservados");
        infoLabel.setBounds(500, 20, 400, 40);
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
        String path3 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/IconoSerpienteSalud.png";
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
        String[] sedes = {"","Principal - Bucaramanga", "Sede - Floridablanca", "Sede - Piedecuesta", "Sede - Girón", "Sede - Ríonegro", "Sede - Pamplona", "Sede - Lebrija"};
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

        // Crear ActionListener para el botón de ingresar
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroIdentificacion = textField1.getText();
                String contrasena = new String(passwordField1.getPassword());

                // Validar que los campos no estén vacíos
                if (numeroIdentificacion.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese número de identificación y contraseña.");
                    return;
                }
                try {
                    if (UsuariosManager.iniciarSesion(numeroIdentificacion, contrasena)) {
                        // Acceso concedido, realizar la acción deseada
                        //Abrir la vista de GestionarAgenda
                        GestionarAgenda gestionarAgenda = new GestionarAgenda();
                        gestionarAgenda.setVisible(true);
                        dispose(); // Cerrar la ventana actual
                    } else {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión fallido. Verifique sus credenciales.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
                }
            }
        });

        // Añadir imagen al Panel de la izquierda
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloAdministrador/src/main/java/co/edu/upb/ips/images/SALUD_PRO-preview.png";
        ImageIcon logo = new ImageIcon(path);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(130, 100, 500, 500);
        panel.add(logoLabel, BorderLayout.CENTER);

        // Añadir imagen al Panel de la pantalla completa
        String path2 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/mbbstres-doctores-l6mpzm2z8xq90u8e.jpg";
        ImageIcon logo2 = new ImageIcon(path2);
        JLabel fondoLabel2 = new JLabel(logo2);
        fondoLabel2.setBounds(0, 0, 1366, 768);
        panel.add(fondoLabel2, BorderLayout.CENTER);

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
                new Login().setVisible(true);
            }
        });
    }
}