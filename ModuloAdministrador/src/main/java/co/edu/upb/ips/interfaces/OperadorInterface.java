package co.edu.upb.ips.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperadorInterface extends Remote {

    public String loginAdmin(String numeroDocumento, String contraseña) throws RemoteException;

    public String registrarAdmin(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String modificarAdmin(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String eliminarAdmin(String numeroDocumento) throws RemoteException;

    public String consultarAdmin(String numeroDocumento) throws RemoteException;

    public String listarAdmin() throws RemoteException;

    public String loginMedico(String numeroDocumento, String contraseña) throws RemoteException;

    public String registrarMedico(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String modificarMedico(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String eliminarMedico(String numeroDocumento) throws RemoteException;

    public String consultarMedico(String numeroDocumento) throws RemoteException;

    public String listarMedico() throws RemoteException;

    public String loginPaciente(String numeroDocumento, String contraseña) throws RemoteException;

    public String registrarPaciente(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String modificarPaciente(String numeroDocumento, String contraseña, String tipoUsuario, String sede) throws RemoteException;

    public String eliminarPaciente(String numeroDocumento) throws RemoteException;

    public String consultarPaciente(String numeroDocumento) throws RemoteException;

    public String listarPaciente() throws RemoteException;

    public String modificarOrden(String numeroOrden, String fecha, String hora, String sede, String ciudad, String estado, String tipoOrden, String numeroDocumento) throws RemoteException;

    public String eliminarOrden(String numeroOrden) throws RemoteException;

    public String consultarOrden(String numeroOrden) throws RemoteException;

    public String listarOrden() throws RemoteException;

    public String modificarHistorial(String numeroHistorial, String fecha, String hora, String sede, String ciudad, String estado, String tipoHistorial, String numeroDocumento) throws RemoteException;

    public String eliminarHistorial(String numeroHistorial) throws RemoteException;

    public String consultarHistorial(String numeroHistorial) throws RemoteException;

    public String listarHistorial() throws RemoteException;

    public String modificarCita(String numeroCita, String fecha, String hora, String sede, String ciudad, String estado, String tipoCita, String numeroDocumento) throws RemoteException;

    public String eliminarCita(String numeroCita) throws RemoteException;

    public String consultarCita(String numeroCita) throws RemoteException;

    public String listarCita() throws RemoteException;

    public String modificarSede(String nombreSede, String direccion, String ciudad, String telefono, String email) throws RemoteException;

    public String eliminarSede(String nombreSede) throws RemoteException;

    public String consultarSede(String nombreSede) throws RemoteException;

    public String listarSede() throws RemoteException;
}
