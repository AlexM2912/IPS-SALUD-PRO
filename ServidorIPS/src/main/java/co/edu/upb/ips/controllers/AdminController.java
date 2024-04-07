package co.edu.upb.ips.controllers;

import co.edu.upb.ips.interfaces.AdminInterface;

import java.rmi.RemoteException;

public class AdminController implements AdminInterface {
    /**
     * @param numeroDocumento
     * @param contraseña
     * @return
     * @throws RemoteException
     */
    @Override
    public String loginAdmin(String numeroDocumento, String contraseña) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String registrarAdmin(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarAdmin(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarAdmin(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarAdmin(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarAdmin() throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @return
     * @throws RemoteException
     */
    @Override
    public String loginMedico(String numeroDocumento, String contraseña) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String registrarMedico(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarMedico(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarMedico(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarMedico(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarMedico() throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @return
     * @throws RemoteException
     */
    @Override
    public String loginPaciente(String numeroDocumento, String contraseña) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String registrarPaciente(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @param contraseña
     * @param tipoUsuario
     * @param sede
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarPaciente(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarPaciente(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarPaciente(String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarPaciente() throws RemoteException {
        return null;
    }

    /**
     * @param numeroOrden
     * @param fecha
     * @param hora
     * @param sede
     * @param ciudad
     * @param estado
     * @param tipoOrden
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarOrden(String numeroOrden, String fecha, String hora, String sede, String ciudad, String estado, String tipoOrden, String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroOrden
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarOrden(String numeroOrden) throws RemoteException {
        return null;
    }

    /**
     * @param numeroOrden
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarOrden(String numeroOrden) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarOrden() throws RemoteException {
        return null;
    }

    /**
     * @param numeroHistorial
     * @param fecha
     * @param hora
     * @param sede
     * @param ciudad
     * @param estado
     * @param tipoHistorial
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarHistorial(String numeroHistorial, String fecha, String hora, String sede, String ciudad, String estado, String tipoHistorial, String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroHistorial
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarHistorial(String numeroHistorial) throws RemoteException {
        return null;
    }

    /**
     * @param numeroHistorial
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarHistorial(String numeroHistorial) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarHistorial() throws RemoteException {
        return null;
    }

    /**
     * @param numeroCita
     * @param fecha
     * @param hora
     * @param sede
     * @param ciudad
     * @param estado
     * @param tipoCita
     * @param numeroDocumento
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarCita(String numeroCita, String fecha, String hora, String sede, String ciudad, String estado, String tipoCita, String numeroDocumento) throws RemoteException {
        return null;
    }

    /**
     * @param numeroCita
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarCita(String numeroCita) throws RemoteException {
        return null;
    }

    /**
     * @param numeroCita
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarCita(String numeroCita) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarCita() throws RemoteException {
        return null;
    }

    /**
     * @param nombreSede
     * @param direccion
     * @param ciudad
     * @param telefono
     * @param email
     * @return
     * @throws RemoteException
     */
    @Override
    public String modificarSede(String nombreSede, String direccion, String ciudad, String telefono, String email) throws RemoteException {
        return null;
    }

    /**
     * @param nombreSede
     * @return
     * @throws RemoteException
     */
    @Override
    public String eliminarSede(String nombreSede) throws RemoteException {
        return null;
    }

    /**
     * @param nombreSede
     * @return
     * @throws RemoteException
     */
    @Override
    public String consultarSede(String nombreSede) throws RemoteException {
        return null;
    }

    /**
     * @return
     * @throws RemoteException
     */
    @Override
    public String listarSede() throws RemoteException {
        return null;
    }
}
