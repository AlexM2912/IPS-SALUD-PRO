package co.edu.upb.ips.clases;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CitasTableModel extends AbstractTableModel {
    private List<CitaMedica> citas;
    private LocalDate startDate;

    public CitasTableModel(LocalDate startDate) {
        this.citas = new ArrayList<>();
        this.startDate = startDate;
    }

    public void addCita(CitaMedica cita) {
        citas.add(cita);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return 13; // 6:00 AM a 5:00 PM, 1 fila para cada hora
    }

    @Override
    public int getColumnCount() {
        return 6; // Lunes a Viernes
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LocalDate date = startDate.plusDays(columnIndex - 1);
        LocalTime time = LocalTime.of(rowIndex + 6, 0); // A partir de las 6:00 AM
        for (CitaMedica cita : citas) {
            if (cita.getFecha().isEqual(date) && cita.getHora().equals(time)) {
                return cita.getDescripcion();
            }
        }
        return "";
    }
}