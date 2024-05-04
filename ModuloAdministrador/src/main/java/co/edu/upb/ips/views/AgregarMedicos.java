package co.edu.upb.ips.views;

import co.edu.upb.ips.models.CConexion;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarMedicos extends JFrame {

    private JPanel panel;
    private JPanel topPanel;
    private JLabel titulo;
    private JLabel logolabel;
    private JLabel lblIdSede, lblPrimerNombre, lblSegundoNombre, lblPrimerApellido, lblSegundoApellido, lblNumeroDocumento,
            lblTelefono, lblCorreoElectronico, lblDireccion, lblEstrato, lblEstadoCivil, lblZonaResidencia, lblEspecialidad,
            lblGrupoSanguineo, lblFechaNacimiento, lblNumeroTarjetaProfesional, lblSalario;
    private JTextField txtIdSede, txtPrimerNombre, txtSegundoNombre, txtPrimerApellido, txtSegundoApellido, txtNumeroDocumento,
            txtTelefono, txtCorreoElectronico, txtDireccion, txtNumeroTarjetaProfesional, txtSalario;
    private JComboBox<String> cmbEstrato, cmbEstadoCivil, cmbZonaResidencia, cmbEspecialidad, cmbGrupoSanguineo;
    private JButton btnAgregar;

    public AgregarMedicos() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);

        // Agregar panel al JFrame
        panel = new JPanel(null);
        getContentPane().add(panel);
        panel.setBackground(Color.WHITE);

        // Crear JPanel superior con color de fondo azul oscuro
        topPanel = new JPanel(null);
        panel.add(topPanel);
        topPanel.setBackground(new Color(0, 47, 87));
        topPanel.setBounds(0, 0, 1400, 70);
        panel.add(topPanel);

        // Añadir imagen al Panel de fondo
        String path = "C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloMedico/src/main/java/co/edu/upb/ips/images/img.png";
        ImageIcon icon = new ImageIcon(path);
        logolabel = new JLabel(icon);
        logolabel.setBounds(30, 80, 150, 168);
        panel.add(logolabel);

        // Crear JLabel para el título
        titulo = new JLabel("Agregar Médicos");
        titulo.setBounds(0, 140, 1400, 40);
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        // Crear JLabels y JTextFields para los datos del médico
        lblIdSede = new JLabel("ID de Sede:");
        lblIdSede.setBounds(230, 260, 150, 20);
        panel.add(lblIdSede);
        txtIdSede = new JTextField();
        txtIdSede.setBounds(400, 260, 150, 20);
        panel.add(txtIdSede);

        lblPrimerNombre = new JLabel("Primer Nombre:");
        lblPrimerNombre.setBounds(230, 300, 150, 20);
        panel.add(lblPrimerNombre);
        txtPrimerNombre = new JTextField();
        txtPrimerNombre.setBounds(400, 300, 150, 20);
        panel.add(txtPrimerNombre);

        lblSegundoNombre = new JLabel("Segundo Nombre:");
        lblSegundoNombre.setBounds(230, 340, 150, 20);
        panel.add(lblSegundoNombre);
        txtSegundoNombre = new JTextField();
        txtSegundoNombre.setBounds(400, 340, 150, 20);
        panel.add(txtSegundoNombre);

        lblPrimerApellido = new JLabel("Primer Apellido:");
        lblPrimerApellido.setBounds(230, 380, 150, 20);
        panel.add(lblPrimerApellido);
        txtPrimerApellido = new JTextField();
        txtPrimerApellido.setBounds(400, 380, 150, 20);
        panel.add(txtPrimerApellido);

        lblSegundoApellido = new JLabel("Segundo Apellido:");
        lblSegundoApellido.setBounds(230, 420, 150, 20);
        panel.add(lblSegundoApellido);
        txtSegundoApellido = new JTextField();
        txtSegundoApellido.setBounds(400, 420, 150, 20);
        panel.add(txtSegundoApellido);

        lblNumeroDocumento = new JLabel("Número de Documento:");
        lblNumeroDocumento.setBounds(230, 460, 150, 20);
        panel.add(lblNumeroDocumento);
        txtNumeroDocumento = new JTextField();
        txtNumeroDocumento.setBounds(400, 460, 150, 20);
        panel.add(txtNumeroDocumento);

        lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(230, 500, 150, 20);
        panel.add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(400, 500, 150, 20);
        panel.add(txtTelefono);

        lblCorreoElectronico = new JLabel("Correo Electrónico:");
        lblCorreoElectronico.setBounds(230, 540, 150, 20);
        panel.add(lblCorreoElectronico);
        txtCorreoElectronico = new JTextField();
        txtCorreoElectronico.setBounds(400, 540, 150, 20);
        panel.add(txtCorreoElectronico);

        lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(230, 580, 150, 20);
        panel.add(lblDireccion);
        txtDireccion = new JTextField();
        txtDireccion.setBounds(400, 580, 150, 20);
        panel.add(txtDireccion);

        lblEstrato = new JLabel("Estrato Socioeconómico:");
        lblEstrato.setBounds(610, 260, 150, 20);
        panel.add(lblEstrato);
        String[] estratoOptions = {"","1", "2", "3", "4", "5", "6"};
        cmbEstrato = new JComboBox<>(estratoOptions);
        cmbEstrato.setBounds(780, 260, 150, 20);
        panel.add(cmbEstrato);

        lblEstadoCivil = new JLabel("Estado Civil:");
        lblEstadoCivil.setBounds(610, 300, 150, 20);
        panel.add(lblEstadoCivil);
        String[] estadoCivilOptions = {"","Casado/a", "Soltero/a", "Viudo/a", "Divorciado/a"};
        cmbEstadoCivil = new JComboBox<>(estadoCivilOptions);
        cmbEstadoCivil.setBounds(780, 300, 150, 20);
        panel.add(cmbEstadoCivil);

        lblZonaResidencia = new JLabel("Zona de Residencia:");
        lblZonaResidencia.setBounds(610, 340, 150, 20);
        panel.add(lblZonaResidencia);
        String[] zonaResidenciaOptions = {"","Urbana", "Rural"};
        cmbZonaResidencia = new JComboBox<>(zonaResidenciaOptions);
        cmbZonaResidencia.setBounds(780, 340, 150, 20);
        panel.add(cmbZonaResidencia);

        lblEspecialidad = new JLabel("Especialidad:");
        lblEspecialidad.setBounds(610, 380, 150, 20);
        panel.add(lblEspecialidad);
        String[] especialidadOptions = {"","Medicina Familiar", "Fisioterapia", "Medicina Interna", "Psicología"};
        cmbEspecialidad = new JComboBox<>(especialidadOptions);
        cmbEspecialidad.setBounds(780, 380, 150, 20);
        panel.add(cmbEspecialidad);

        lblGrupoSanguineo = new JLabel("Grupo Sanguíneo:");
        lblGrupoSanguineo.setBounds(610, 420, 150, 20);
        panel.add(lblGrupoSanguineo);
        String[] grupoSanguineoOptions = {"","A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
        cmbGrupoSanguineo = new JComboBox<>(grupoSanguineoOptions);
        cmbGrupoSanguineo.setBounds(780, 420, 150, 20);
        panel.add(cmbGrupoSanguineo);

        lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        lblFechaNacimiento.setBounds(610, 460, 150, 20);
        panel.add(lblFechaNacimiento);

        // Crear JTextfield para escribir la fecha de nacimiento
        JTextField txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setBounds(780, 460, 150, 20);
        panel.add(txtFechaNacimiento);

        // Crear JLabels y JTextFields para los datos del médico
        lblNumeroTarjetaProfesional = new JLabel("<html><center>Número de T.<br>Profesional:</center></html>");
        lblNumeroTarjetaProfesional.setBounds(610, 410, 200, 200);
        panel.add(lblNumeroTarjetaProfesional);
        txtNumeroTarjetaProfesional = new JTextField();
        txtNumeroTarjetaProfesional.setBounds(780, 500, 150, 20);
        panel.add(txtNumeroTarjetaProfesional);

        lblSalario = new JLabel("Salario:");
        lblSalario.setBounds(610, 540, 150, 20);
        panel.add(lblSalario);
        txtSalario = new JTextField();
        txtSalario.setBounds(780, 540, 150, 20);
        panel.add(txtSalario);

        // Crear Jlabel y Jtext para el consultorio
        JLabel lblConsultorio = new JLabel("Consultorio:");
        lblConsultorio.setBounds(610, 580, 150, 20);
        panel.add(lblConsultorio);
        JTextField txtConsultorio = new JTextField();
        txtConsultorio.setBounds(780, 580, 150, 20);
        panel.add(txtConsultorio);

        // Crear Jlabel y Jtext para la contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(990, 260, 150, 20);
        panel.add(lblContrasena);
        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(1120, 260, 150, 20);
        panel.add(txtContrasena);

        // Botón para agregar médico
        btnAgregar = new JButton("Agregar Médico");
        btnAgregar.setBounds(1060, 320, 150, 50);
        btnAgregar.setBackground(new Color(0, 47, 87));
        btnAgregar.setForeground(Color.WHITE);
        panel.add(btnAgregar);

        // botón para volver a la vista de GestionarMedicos
        JButton volverButton = new JButton("Anterior");
        volverButton.setFont(new Font("Serif", Font.BOLD, 14));
        volverButton.setForeground(Color.DARK_GRAY);
        volverButton.setBounds(20, 630, 100, 40);
        volverButton.setBackground(new Color(193, 219, 227, 255)); // Azul cielo
        volverButton.setVisible(true);
        panel.add(volverButton);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        volverButton.setBorder(border);

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

        // Configuración del ActionListener para el botón "Anterior"
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AgregarUsuarios();
            }
        });

        // Configuración del ActionListener para el botón "Agregar Médico"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos de texto y combobox
                String idSede = txtIdSede.getText();
                String primerNombre = txtPrimerNombre.getText();
                String segundoNombre = txtSegundoNombre.getText();
                String primerApellido = txtPrimerApellido.getText();
                String segundoApellido = txtSegundoApellido.getText();
                String numeroDocumento = txtNumeroDocumento.getText();
                String telefono = txtTelefono.getText();
                String correoElectronico = txtCorreoElectronico.getText();
                String direccion = txtDireccion.getText();
                String especialidad = (String) cmbEspecialidad.getSelectedItem();
                String numeroTarjetaProfesional = txtNumeroTarjetaProfesional.getText();
                String estrato = (String) cmbEstrato.getSelectedItem();
                String estadoCivil = (String) cmbEstadoCivil.getSelectedItem();
                String zonaResidencia = (String) cmbZonaResidencia.getSelectedItem();
                String fechaNacimiento = txtFechaNacimiento.getText();
                String salario = txtSalario.getText();
                String contrasena = ""; // Deberías obtener la contraseña de algún campo de texto

                // Realizar la inserción en la base de datos
                try {
                    Connection connection = new CConexion().estableceConexion();
                    String query = "INSERT INTO Medicos (id_sede, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, numero_documento, telefono, correo_electronico, direccion, especialidad, numero_tarjetaProfesional, estrato_socieconomico, estado_civil, zona_residencia, grupo_sanguineo, fecha_nacimiento, fecha_ingreso_sistema, salario, contrasena, consultorio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, idSede);
                    statement.setString(2, primerNombre);
                    statement.setString(3, segundoNombre);
                    statement.setString(4, primerApellido);
                    statement.setString(5, segundoApellido);
                    statement.setString(6, numeroDocumento);
                    statement.setString(7, telefono);
                    statement.setString(8, correoElectronico);
                    statement.setString(9, direccion);
                    statement.setString(10, especialidad);
                    statement.setString(11, numeroTarjetaProfesional);
                    statement.setString(12, estrato);
                    statement.setString(13, estadoCivil);
                    statement.setString(14, zonaResidencia);
                    statement.setString(15, (String) cmbGrupoSanguineo.getSelectedItem());
                    statement.setString(16, fechaNacimiento);
                    statement.setString(17, salario);
                    statement.setString(18, contrasena);
                    statement.setString(19, txtConsultorio.getText());
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Médico agregado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar el médico.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el médico: " + ex.getMessage());
                }
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(AgregarMedicos::new);
    }

}
