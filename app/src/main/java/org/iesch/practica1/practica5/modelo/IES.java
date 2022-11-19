package org.iesch.practica1.practica5.modelo;

public class IES {
    private String nombre;
    private double latitud;
    private double longitud;

    public IES(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
