package co.edu.upb.ips.views;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<String> obtenerHorasDisponibles() {
        ArrayList<String> horas = new ArrayList<>();
        for (int hora = 6; hora <= 17; hora++) {
            horas.add(String.format("%02d:00", hora));
        }
        return horas;
    }

    public static void main(String[] args) {
        // Prueba de la función obtenerHorasDisponibles
        ArrayList<String> horasDisponibles = obtenerHorasDisponibles();
        System.out.println("Horas disponibles:");
        for (String hora : horasDisponibles) {
            System.out.println(hora);
        }
    }
}