package co.edu.upb.ips.clases;

import java.io.Serializable;

public class UserMedico implements Serializable {

    private String numeroDocumento;
    private String contraseña;
    private String tipoUsuario;
    private String sede;

    public UserMedico(String numeroDocumento, String contraseña, String tipoUsuario, String sede) {
        this.numeroDocumento = numeroDocumento;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.sede = sede;
    }

    // Getters y setters
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}