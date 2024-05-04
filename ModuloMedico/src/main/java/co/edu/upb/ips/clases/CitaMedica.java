package co.edu.upb.ips.clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica {
    private LocalDate fecha;
    private LocalTime hora;
    private String descripcion;

    public CitaMedica(LocalDate fecha, LocalTime hora, String descripcion) {
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
