package co.edu.upb.ips.clases;

import java.io.Serializable;

/**
 * Class that represents a MedicalOrder.
 *
 * Clase que representa una Orden Médica.
 *
 * @autor Alex Daniel Montanez Valenzuela
 */

public class OrdenMedica implements Serializable {

    private int idOrdenMedica;
    private String fechaOrdenMedica;
    private String horaOrdenMedica;
    private String nombreSede;
    private String diagnostico;
    private String tratamiento;
    private String observaciones;
    private String estado;

    public OrdenMedica(int idOrdenMedica, String fechaOrdenMedica, String horaOrdenMedica, String nombreSede, String diagnostico, String tratamiento, String observaciones, String estado) {
        this.idOrdenMedica = idOrdenMedica;
        this.fechaOrdenMedica = fechaOrdenMedica;
        this.horaOrdenMedica = horaOrdenMedica;
        this.nombreSede = nombreSede;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.estado = estado;
    }

    public int getIdOrdenMedica() {
        return idOrdenMedica;
    }

    public void setIdOrdenMedica(int idOrdenMedica) {
        this.idOrdenMedica = idOrdenMedica;
    }

    public String getFechaOrdenMedica() {
        return fechaOrdenMedica;
    }

    public void setFechaOrdenMedica(String fechaOrdenMedica) {
        this.fechaOrdenMedica = fechaOrdenMedica;
    }

    public String getHoraOrdenMedica() {
        return horaOrdenMedica;
    }

    public void setHoraOrdenMedica(String horaOrdenMedica) {
        this.horaOrdenMedica = horaOrdenMedica;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
