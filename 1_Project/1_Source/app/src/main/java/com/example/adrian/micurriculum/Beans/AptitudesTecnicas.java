package com.example.adrian.micurriculum.Beans;

/**
 * Created by Adrian on 22/04/2015.
 */
public class AptitudesTecnicas {

    private String Experiencia;
    private String Aptitud;
    private int Tiempo;

    public AptitudesTecnicas(String experiencia, String aptitud, int tiempo) {
        Experiencia = experiencia;
        Aptitud = aptitud;
        Tiempo = tiempo;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public String getAptitud() {
        return Aptitud;
    }

    public int getTiempo() {
        return Tiempo;
    }
}
