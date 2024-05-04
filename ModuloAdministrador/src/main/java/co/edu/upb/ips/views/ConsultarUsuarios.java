package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ConsultarUsuarios extends JFrame {

    private JPanel panel;
    private JPanel topPanel;
    private JLabel titulo;
    private JLabel logolabel;

    public ConsultarUsuarios() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Agregar panel al JFrame
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        // Añadir Imagenes a los botones
        String path1 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloAdministrador/src/main/java/co/edu/upb/ips/images/img_2.png";
        ImageIcon icon1 = new ImageIcon(path1);
        JLabel logolabel1 = new JLabel(icon1);
        logolabel1.setBounds(355, 345, 150, 150);
        panel.add(logolabel1);

        String path2 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloAdministrador/src/main/java/co/edu/upb/ips/images/img_2.png";
        ImageIcon icon2 = new ImageIcon(path2);
        JLabel logolabel2 = new JLabel(icon2);
        logolabel2.setBounds(640, 345, 150, 150);
        panel.add(logolabel2);

        String path3 = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloAdministrador/src/main/java/co/edu/upb/ips/images/img_2.png";
        ImageIcon icon3 = new ImageIcon(path3);
        JLabel logolabel3 = new JLabel(icon3);
        logolabel3.setBounds(930, 345, 150, 150);
        panel.add(logolabel3);

        // Crear JPanel superior con color de fondo azul oscuro
        JPanel topPanel = new JPanel(null);
        panel.add(topPanel);
        topPanel.setBackground(new Color(0, 47, 87));
        topPanel.setBounds(0, 0, 1400, 70);
        panel.add(topPanel);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        // Crear Jlabel para el título
        JLabel titulo = new JLabel("Consultar Usuarios");
        titulo.setBounds(0, 140, 1400, 40);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        // Crear JLabel para el subtítulo
        JLabel subtitulo = new JLabel("Por favor, seleccione el tipo de usuario que desea consultar");
        subtitulo.setBounds(0, 200, 1400, 40);
        subtitulo.setFont(new Font("Arial", Font.ITALIC, 20));
        subtitulo.setForeground(Color.BLACK);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitulo);

        // Añadir Botones
        JButton boton1 = new JButton("Operadores");
        JButton boton2 = new JButton("Médicos");
        JButton boton3 = new JButton("Pacientes");

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

        // Crear ActionListener para el botón de Volver a la vista de GestionarUsuarios
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de GestionarUsuarios
                GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();
                gestionarUsuarios.setVisible(true);
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
                new ConsultarUsuarios().setVisible(true);
            }
        });
    }
}