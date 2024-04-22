package co.edu.upb.ips.views;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.itextpdf.text.Image;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GestionarReporte extends JFrame {

    class MyPdfPageEventHelper extends PdfPageEventHelper {
        public void onStartPage(PdfWriter writer, Document document) {
            com.itextpdf.text.Font ffont = new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.UNDEFINED, 5, com.itextpdf.text.Font.ITALIC);
            Paragraph p = new Paragraph("Por favor, escriba la descripción del Reporte:", ffont);
            try {
                Image img = Image.getInstance("C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/LogoReporte.png");
                img.scaleAbsolute(100, 100);
                img.setAbsolutePosition(50, 800);
                writer.getDirectContent().addImage(img);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para cargar el PDF
    public void loadPdf(String path) {
        try {
            PDDocument document = PDDocument.load(new File(path));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            System.out.println(text);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Otros métodos y variables de la clase...

    private JPanel panel;
    private JPanel topPanel;

    public GestionarReporte() {
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
        ImageIcon icon = new ImageIcon("C:/Users/alexd.MONTAÑEZ/IdeaProjects/IPS-SALUD-PRO/ModuloOperador/src/main/java/co/edu/upb/ips/images/LogoReporte.png");
        JLabel logolabel = new JLabel(icon);
        logolabel.setBounds(80, 180, 335, 369);
        panel.add(logolabel);

        // Crear JLabel para el título
        JLabel titulo = new JLabel("Gestionar Reporte");
        titulo.setBounds(550, 100, 500, 40); // Ajusta las coordenadas según sea necesario
        titulo.setFont(new Font("Arial", Font.ITALIC, 30));
        panel.add(titulo);

        // Crear JLabel para seleccionar el Tipo de Reporte a enviar
        JLabel tipoReporteLabel = new JLabel("Seleccione el Tipo de Reporte:");
        tipoReporteLabel.setBounds(550, 200, 300, 40); // Incremento de 20 en y
        tipoReporteLabel.setFont(new Font("Arial", Font.ITALIC, 17));
        panel.add(tipoReporteLabel);

        // Crear JComboBox para seleccionar el Tipo de Reporte a enviar
        String[] tiposReporte = {"", "Pregunta", "Queja", "Reclamo", "Sugerencia", "Denuncia"};
        JComboBox<String> tipoReporteComboBox = new JComboBox<>(tiposReporte);
        tipoReporteComboBox.setBounds(550, 250, 500, 30);
        tipoReporteComboBox.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        panel.add(tipoReporteComboBox);

        // Seleccionar la fecha del evento que se desea reportar
        JLabel fechaLabel = new JLabel("Seleccione la fecha del evento a reportar:");
        fechaLabel.setBounds(550, 300, 500, 40);
        fechaLabel.setFont(new Font("Arial", Font.ITALIC, 17));
        panel.add(fechaLabel);

        // Crear un JCalendar para seleccionar la fecha
        JCalendar calendario = new JCalendar();
        calendario.setBounds(550, 350, 430, 250);
        panel.add(calendario);

        // Añadir Botones
        JButton boton2 = new JButton("Descargar Reporte");
        JButton boton3 = new JButton("Cargar Reporte");
        JButton boton4 = new JButton("Enviar Reporte");

        // Ajustar las coordenadas de los botones con espacio distribuido y corridos a la izquierda
        boton2.setBounds(1080, 300, 150, 50);
        boton3.setBounds(1080, 400, 150, 50);
        boton4.setBounds(1080, 500, 150, 50);

        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);

        // Añadir imagen al Panel de fondo
        ImageIcon icon7 = new ImageIcon("");
        JLabel logolabel7 = new JLabel(icon7);
        logolabel7.setBounds(1170, 60, 170, 170);
        panel.add(logolabel7);

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

        // Añadir un reloj al panel de la derecha
        JLabel reloj = new JLabel();
        reloj.setBounds(65, 100, 300, 40);
        reloj.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        reloj.setForeground(Color.BLACK);
        reloj.setVisible(true);
        panel.add(reloj);

        // Crear un hilo para actualizar el reloj
        Thread hilo = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        reloj.setText(new java.util.Date().toString());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Error en el hilo");
                }
            }
        };
        hilo.start();

        // Crear ActionListener para el botón de Volver
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la vista de GestionarActividades
                GestionarActividades gestionarActividades = new GestionarActividades();
                gestionarActividades.setVisible(true);
                dispose(); // Cerrar la ventana actual
            }
        });


        // Crear ActionListener para el botón de Cargar Reporte
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPdf("Reporte.pdf");
            }
        });

        // Crear ActionListener para el botón de Enviar Reporte
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un mensaje emergente de confirmación
                JOptionPane.showMessageDialog(panel, "Reporte enviado exitosamente", "Reporte Enviado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Validar que el JComboBox tenga un valor seleccionado
        boton4.setEnabled(false);
        tipoReporteComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tipoReporteComboBox.getSelectedIndex() != 0) {
                    boton4.setEnabled(true);
                } else {
                    boton4.setEnabled(false);
                }
            }
        });

        // Validar que el reporte se haya cargado
        boton4.setEnabled(false);
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton4.setEnabled(true);
            }
        });

        // Validar que el reporte se haya descargado
        boton4.setEnabled(false);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton4.setEnabled(true);
            }
        });

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarReporte().setVisible(true);
            }
        });
    }
}