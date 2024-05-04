package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionarUsuarios extends JFrame {

    private JPanel panel;
    private JPanel topPanel;
    private JLabel titulo;
    private JLabel logolabel;

    public GestionarUsuarios() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Agregar panel al JFrame
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

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
        JLabel titulo = new JLabel("Gestionar Usuarios");
        titulo.setBounds(0, 140, 1400, 40);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

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

        // Crear Botón para agregar Usuarios
        JButton pacientesButton = new JButton("Agregar Usuarios");
        pacientesButton.setFont(new Font("Serif", Font.BOLD, 14));
        pacientesButton.setForeground(Color.WHITE);
        pacientesButton.setBounds(180, 370, 300, 40);
        pacientesButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        pacientesButton.setVisible(true);
        panel.add(pacientesButton);

        // Crear Botón para eliminar Usuarios
        JButton operadoresButton = new JButton("Eliminar Usuarios");
        operadoresButton.setFont(new Font("Serif", Font.BOLD, 14));
        operadoresButton.setForeground(Color.WHITE);
        operadoresButton.setBounds(180, 420, 300, 40);
        operadoresButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        operadoresButton.setVisible(true);
        panel.add(operadoresButton);

        // Crear Botón para modificar Usuarios
        JButton medicosButton = new JButton("Modificar Usuarios");
        medicosButton.setFont(new Font("Serif", Font.BOLD, 14));
        medicosButton.setForeground(Color.WHITE);
        medicosButton.setBounds(180, 470, 300, 40);
        medicosButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        medicosButton.setVisible(true);
        panel.add(medicosButton);

        // Crear Botón para consultar Usuarios
        JButton administradoresButton = new JButton("Consultar Usuarios");
        administradoresButton.setFont(new Font("Serif", Font.BOLD, 14));
        administradoresButton.setForeground(Color.WHITE);
        administradoresButton.setBounds(180, 520, 300, 40);
        administradoresButton.setBackground(new Color(0, 47, 87, 255)); // Azul cielo
        administradoresButton.setVisible(true);
        panel.add(administradoresButton);

        // Crear Botón para volver a la vista de GestionarActividades
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

        // Crear ActionListener para el botón de Agregar Usuarios
        pacientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de AgregarUsuarios
                AgregarUsuarios agregarUsuarios = new AgregarUsuarios();
                agregarUsuarios.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear ActionListener para el botón de Eliminar Usuarios
        operadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de EliminarUsuarios
                EliminarUsuarios eliminarUsuarios = new EliminarUsuarios();
                eliminarUsuarios.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear ActionListener para el botón de Modificar Usuarios
        medicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de ModificarUsuarios
                ModificarUsuarios modificarUsuarios = new ModificarUsuarios();
                modificarUsuarios.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });

        // Crear ActionListener para el botón de Consultar Usuarios
        administradoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de ConsultarUsuarios
                ConsultarUsuarios consultarUsuarios = new ConsultarUsuarios();
                consultarUsuarios.setVisible(true);
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
                new GestionarUsuarios();
            }
        });
    }
}
