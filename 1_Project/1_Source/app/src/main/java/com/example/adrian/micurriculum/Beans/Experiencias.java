package com.example.adrian.micurriculum.Beans;

/**
 * Created by Adrian on 22/04/2015.
 */
public class Experiencias {

    private String NombreEmpresa;
    private int MesInicio;
    private int AnyoInicio;
    private int MesFin;
    private int AnyoFin;
    private String Puesto;
    private String Ciudad;
    private String Descripcion;

    public Experiencias(String nombreEmpresa, int mesInicio, int anyoInicio, int mesFin, int anyoFin, String puesto, String ciudad, String descripcion) {
        NombreEmpresa = nombreEmpresa;
        MesInicio = mesInicio;
        AnyoInicio = anyoInicio;
        MesFin = mesFin;
        AnyoFin = anyoFin;
        Puesto = puesto;
        Ciudad = ciudad;
        Descripcion = descripcion;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
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

    public String getPuesto() {
        return Puesto;
    }

    public int getAnyoFin() {
        return AnyoFin;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getDescripcion() {
        return Descripcion;
    }
}
