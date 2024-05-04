package co.edu.upb.ips.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class CustomCalendar extends JPanel {
    private YearMonth currentYearMonth;
    private JLabel monthLabel;
    private JPanel calendarPanel;

    public CustomCalendar() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Obtener el mes y año actual
        currentYearMonth = YearMonth.now();

        // Crear panel superior con el nombre del mes y botones para cambiar de mes
        JPanel monthPanel = new JPanel(new BorderLayout());
        monthPanel.setBackground(new Color(135, 206, 235)); // Color de fondo bonito
        monthLabel = new JLabel();
        monthLabel.setFont(new Font("Arial", Font.BOLD, 24));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monthLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        updateMonthLabel();
        monthPanel.add(monthLabel, BorderLayout.CENTER);

        // Botones para cambiar de mes
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(e -> previousMonth());
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(e -> nextMonth());
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.add(prevButton);
        buttonsPanel.add(nextButton);
        monthPanel.add(buttonsPanel, BorderLayout.EAST);

        add(monthPanel, BorderLayout.NORTH);

        // Crear panel central para el calendario
        calendarPanel = new JPanel(new GridLayout(0, 7));
        calendarPanel.setBackground(Color.WHITE); // Color de fondo del panel de calendario
        calendarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Líneas alrededor del panel de calendario
        add(calendarPanel, BorderLayout.CENTER);

        // Actualizar el calendario
        updateCalendar();
    }

    private void updateMonthLabel() {
        String monthName = currentYearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1).toLowerCase();
        int year = currentYearMonth.getYear();
        monthLabel.setText(monthName + " " + year);
    }

    private void updateCalendar() {
        calendarPanel.removeAll();

        // Agregar etiquetas de los días de la semana
        String[] daysOfWeek = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
        for (String day : daysOfWeek) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            calendarPanel.add(label);
        }

        // Obtener el primer día del mes y el número de días en el mes
        LocalDate firstOfMonth = currentYearMonth.atDay(1);
        int firstDayOfWeek = firstOfMonth.getDayOfWeek().getValue();
        int daysInMonth = currentYearMonth.lengthOfMonth();

        // Rellenar los espacios en blanco al principio del mes
        for (int i = 1; i < firstDayOfWeek; i++) {
            calendarPanel.add(new JLabel(""));
        }

        // Agregar los números de los días del mes
        LocalDate today = LocalDate.now(); // Obtener el día actual
        for (int day = 1; day <= daysInMonth; day++) {
            JLabel label = new JLabel(String.valueOf(day), SwingConstants.CENTER);
            LocalDate date = currentYearMonth.atDay(day);
            if (date.equals(today)) {
                label.setOpaque(true); // Necesario para que el color de fondo sea visible
                label.setBackground(Color.cyan); // Cambiar el color de fondo a amarillo
            }
            calendarPanel.add(label);
        }

        revalidate();
        repaint();
    }

    public void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        updateMonthLabel();
        updateCalendar();
    }

    public void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        updateMonthLabel();
        updateCalendar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Calendar");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            CustomCalendar customCalendar = new CustomCalendar();
            frame.add(customCalendar);

            frame.setVisible(true);
        });
    }
}