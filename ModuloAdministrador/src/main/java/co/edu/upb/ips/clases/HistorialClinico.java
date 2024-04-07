package co.edu.upb.ips.clases;

import java.io.Serializable;

/**
 * Class that represents a clinical history.
 *
 * Clase que representa un historial clinico.
 *
 * @autor Alex Daniel Montanez Valenzuela
 */

public class HistorialClinico implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String idPaciente;
    private String idMedico;
    private String fecha;
    private String descripcion;

    public HistorialClinico() {
    }

    public HistorialClinico(String id, String idPaciente, String idMedico, String fecha, String descripcion) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "HistorialClinico{" +
                "id='" + id + '\'' +
                ", idPaciente='" + idPaciente + '\'' +
                ", idMedico='" + idMedico + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
