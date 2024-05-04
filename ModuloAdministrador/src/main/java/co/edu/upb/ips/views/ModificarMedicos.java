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
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModificarMedicos extends JFrame {

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

    public ModificarMedicos() {
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
        titulo = new JLabel("Modificar Médicos");
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
        lblConsultorio.setBounds(990, 380, 150, 20);
        panel.add(lblConsultorio);
        JTextField txtConsultorio = new JTextField();
        txtConsultorio.setBounds(1120, 380, 150, 20);
        panel.add(txtConsultorio);

        // Crear Jlabel y Jtext para la contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(990, 420, 150, 20);
        panel.add(lblContrasena);
        JTextField txtContrasena = new JTextField();
        txtContrasena.setBounds(1120, 420, 150, 20);
        panel.add(txtContrasena);

        // Crear JTextField para el número de identificación
        JTextField textField1 = new JTextField();
        textField1.setBounds(990, 270, 140, 28); // Incremento de 20 en y
        textField1.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
        textField1.setVisible(true);
        panel.add(textField1);

        // Botón para buscar médico
        JButton btnBuscar = new JButton("Buscar Médico");
        btnBuscar.setBounds(1140, 260, 130, 50);
        btnBuscar.setBackground(new Color(0, 47, 87));
        btnBuscar.setForeground(Color.WHITE);
        panel.add(btnBuscar);

        // Configuración del ActionListener para el botón "Consultar"
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el número de documento ingresado
                String numeroDocumento = textField1.getText();

                // Realizar la consulta en la base de datos usando el número de documento
                try {
                    Connection connection = new CConexion().estableceConexion();
                    String query = "SELECT * FROM Medicos WHERE numero_documento = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, numeroDocumento);
                    ResultSet resultSet = statement.executeQuery();

                    // Si se encontraron resultados, mostrar la información en los JTextFields correspondientes
                    if (resultSet.next()) {
                        txtIdSede.setText(resultSet.getString("id_sede"));
                        txtPrimerNombre.setText(resultSet.getString("primer_nombre"));
                        txtSegundoNombre.setText(resultSet.getString("segundo_nombre"));
                        txtPrimerApellido.setText(resultSet.getString("primer_apellido"));
                        txtSegundoApellido.setText(resultSet.getString("segundo_apellido"));
                        txtNumeroDocumento.setText(resultSet.getString("numero_documento"));
                        txtTelefono.setText(resultSet.getString("telefono"));
                        txtCorreoElectronico.setText(resultSet.getString("correo_electronico"));
                        txtDireccion.setText(resultSet.getString("direccion"));
                        cmbEstrato.setSelectedItem(resultSet.getString("estrato_socieconomico"));
                        cmbEstadoCivil.setSelectedItem(resultSet.getString("estado_civil"));
                        cmbZonaResidencia.setSelectedItem(resultSet.getString("zona_residencia"));
                        cmbEspecialidad.setSelectedItem(resultSet.getString("especialidad"));
                        cmbGrupoSanguineo.setSelectedItem(resultSet.getString("grupo_sanguineo"));
                        txtFechaNacimiento.setText(resultSet.getString("fecha_nacimiento"));
                        txtSalario.setText(resultSet.getString("salario"));
                        txtConsultorio.setText(resultSet.getString("consultorio"));
                        txtContrasena.setText(resultSet.getString("contrasena"));

                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún médico con el número de documento especificado.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
                }
            }
        });

        // Botón para Modificar médico
        btnAgregar = new JButton("Modificar Médico");
        btnAgregar.setBounds(1060, 500, 150, 50);
        btnAgregar.setBackground(new Color(29, 133, 33));
        btnAgregar.setForeground(Color.WHITE);
        panel.add(btnAgregar);

        // Configuración del ActionListener para el botón "Modificar"
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos ingresados por el usuario
                String idSede = txtIdSede.getText();
                String primerNombre = txtPrimerNombre.getText();
                String segundoNombre = txtSegundoNombre.getText();
                String primerApellido = txtPrimerApellido.getText();
                String segundoApellido = txtSegundoApellido.getText();
                String numeroDocumento = txtNumeroDocumento.getText();
                String telefono = txtTelefono.getText();
                String correoElectronico = txtCorreoElectronico.getText();
                String direccion = txtDireccion.getText();
                String estrato = cmbEstrato.getSelectedItem().toString();
                String estadoCivil = cmbEstadoCivil.getSelectedItem().toString();
                String zonaResidencia = cmbZonaResidencia.getSelectedItem().toString();
                String especialidad = cmbEspecialidad.getSelectedItem().toString();
                String grupoSanguineo = cmbGrupoSanguineo.getSelectedItem().toString();
                String fechaNacimiento = txtFechaNacimiento.getText();
                String salario = txtSalario.getText();
                String consultorio = txtConsultorio.getText();
                String contrasena = txtContrasena.getText();

                // Realizar la actualización en la base de datos
                try {
                    Connection connection = new CConexion().estableceConexion();
                    String query = "UPDATE Medicos SET id_sede = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, " +
                            "segundo_apellido = ?, numero_documento = ?, telefono = ?, correo_electronico = ?, direccion = ?, " +
                            "especialidad = ?, estrato_socieconomico = ?, estado_civil = ?, " +
                            "zona_residencia = ?, grupo_sanguineo = ?, fecha_nacimiento = ?, salario = ?, consultorio = ?, contrasena = ? " +
                            "WHERE numero_documento = ?";
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
                    statement.setString(11, estrato);
                    statement.setString(12, estadoCivil);
                    statement.setString(13, zonaResidencia);
                    statement.setString(14, (String) cmbGrupoSanguineo.getSelectedItem());
                    statement.setString(15, fechaNacimiento);
                    statement.setString(16, salario);
                    statement.setString(17, contrasena);
                    statement.setString(18, txtConsultorio.getText());
                    statement.setString(19, numeroDocumento);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Médico actualizado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar el médico.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el médico: " + ex.getMessage());
                }
            }
        });

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
                new EliminarUsuarios();
            }
        });
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(ModificarMedicos::new);
    }
}