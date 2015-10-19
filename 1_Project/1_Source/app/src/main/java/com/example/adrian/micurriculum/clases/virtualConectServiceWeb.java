package com.example.adrian.micurriculum.clases;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Adrian on 22/04/2015.
 * <p/>
 * Clase con los métodos para conectarse al servicio Web virtual
 */
public class virtualConectServiceWeb {

    public static JSONArray getJSONArrayFromURL(String url) {

        JSONArray jsonArray = null;
        switch (url) {
            case "Experiencias":
                jsonArray = virtualServiceWeb.getJSONExperiencias();
                break;
            case "Estudios":
                jsonArray = virtualServiceWeb.getJSONEstudios();
                break;
            case "Diplomas":
                jsonArray = virtualServiceWeb.getJSONDiplomas();
                break;
            case "AptitudesTecnicas":
                jsonArray = virtualServiceWeb.getJSONAptitudesTecnicas();
                break;
            case "Idiomas":
                jsonArray = virtualServiceWeb.getJSONIdiomas();
                break;

        }

        return jsonArray;
    }

    public static JSONObject getJSONObjectFromURL(String url) {

        JSONObject Json = null;
        switch (url) {
            case "Datos":
                Json = virtualServiceWeb.getJSONDatosPersonales();
                break;
            case "Aptitudes":
                Json = virtualServiceWeb.getJSONAptitudes();
                break;
            case "Resumen":
                Json = virtualServiceWeb.getJSONResumen();
                break;
            case "InformacionAdicional":
                Json = virtualServiceWeb.getJSONInformacionAdicional();
                break;
        }

        return Json;
    }
}
