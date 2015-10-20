package com.example.adrian.micurriculum.Beans;

/**
 * Created by Adrian on 22/04/2015.
 */
public class Estudios {

    private String NombreEstudios;
    private int MesInicio;
    private int AnyoInicio;
    private int MesFin;
    private int AnyoFin;
    private String Ciudad;
    private String NombreCentro;

    public Estudios(String nombreEstudios, int mesInicio, int anyoInicio, int mesFin, int anyoFin, String ciudad, String nombreCentro) {
        NombreEstudios = nombreEstudios;
        MesInicio = mesInicio;
        AnyoInicio = anyoInicio;
        MesFin = mesFin;
        AnyoFin = anyoFin;
        Ciudad = ciudad;
        NombreCentro = nombreCentro;
    }

    public String getNombreEstudios() {
        return NombreEstudios;
    }

    public int getMesInicio() {
        return MesInicio;
    }

    public int getAnyoInicio() {
        return AnyoInicio;
    }

    public int getMesFin() {
        return MesFin;
    }

    public int getAnyoFin() {
        return AnyoFin;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getNombreCentro() {
        return NombreCentro;
    }
}
