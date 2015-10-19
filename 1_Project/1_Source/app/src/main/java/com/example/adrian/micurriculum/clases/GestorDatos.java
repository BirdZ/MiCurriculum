package com.example.adrian.micurriculum.clases;

import android.content.Context;
import android.os.AsyncTask;

import com.example.adrian.micurriculum.Objetos.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adrian on 22/04/2015.
 * <p/>
 * Esta clase nos es util para cuando se tenga que modificar el tipo de datos del servicio, el servicio, o la procedencia de los datos
 */
public class GestorDatos {

    private SQLiteHelper db;
    private XMLHelper xml;
    private Context cntx;
    private Adapter adapter;

    public GestorDatos(SQLiteHelper db, XMLHelper xml, Context cntx, Adapter adapter) {
        this.db = db;
        this.xml = xml;
        this.cntx = cntx;
        this.adapter = adapter;
    }

    public void DescargarDatosPersonales() {
        new getJSONObjectTask().execute("Datos");
    }

    public void DescargarResumen() {
        new getJSONObjectTask().execute("Resumen");
    }

    public void DescargarAptitudes() {

        new getJSONObjectTask().execute("Aptitudes");
    }

    public void DescargarExperiencias() {
        new getJSONArrayTask().execute("Experiencias");
    }

    public void DescargarEstudios() {
        new getJSONArrayTask().execute("Estudios");
    }

    public void DescargarDiplomas() {
        new getJSONArrayTask().execute("Diplomas");
    }

    public void DescargarAptitudesTecnicas() {
        new getJSONArrayTask().execute("AptitudesTecnicas");
    }

    public void DescargarIdiomas() {
        new getJSONArrayTask().execute("idiomas");
    }

    public void DescargarInformacionAdicional() {
        new getJSONObjectTask().execute("InformacionAdicional");
    }

    private JSONArray getJsonArray(String tipo) {
        return virtualConectServiceWeb.getJSONArrayFromURL(tipo);
    }

    private JSONObject getJsonObject(String tipo) {
        return virtualConectServiceWeb.getJSONObjectFromURL(tipo);
    }

    private boolean AlmacenarDatos(JSONObject json, String tipo) {
        boolean result = false;
        try {
            switch (tipo) {
                case "Datos":
                    result = xml.insertarDatosPersonales(json.getString("Nombre"), json.getString("Direccion"),
                            json.getString("DNI"), json.getString("FechaDeNacimiento"), json.getString("Telefono"),
                            json.getString("CorreoElectronico"), json.getString("CarnetConducir"));
                    break;
                case "Resumen":
                    result = xml.insertarResumen(json.getString("Resumen"));
                    break;
                case "Aptitudes":
                    result = xml.insertarAptitudes((String[]) json.get("Aptitudes"));
                    break;
                case "Experiencias":
                    result = db.insertarExperiencia(json.getString("NombreEmpresa"), json.getInt("MesInicio"),
                            json.getInt("AnyoInicio"), json.getInt("MesFin"), json.getInt("AnyoFin"),
                            json.getString("Puesto"), json.getString("Ciudad"), json.getString("Descripcion"));
                    break;
                case "Estudios":
                    result = db.insertarEstudio(json.getString("NombreEstudios"), json.getInt("MesInicio"),
                            json.getInt("AnyoInicio"), json.getInt("MesFin"), json.getInt("AnyoFin"),
                            json.getString("Ciudad"), json.getString("NombreCentro"));
                    break;
                case "Diplomas":
                    result = db.insertarDiploma(json.getString("NombreEstudios"), json.getInt("MesInicio"),
                            json.getInt("AnyoInicio"), json.getInt("MesFin"), json.getInt("AnyoFin"),
                            json.getString("Ciudad"), json.getString("NombreCentro"));
                    break;
                case "AptitudesTecnicas":
                    result = db.insertarAptitud(json.getString("Experiencia"), json.getString("Aptitud"),
                            json.getInt("Tiempo"));
                    break;
                case "Idiomas":
                    result = db.insertarIdioma(json.getString("Idioma"), json.getString("Nivel"));
                    break;
                case "InformacionAdicional":
                    result = xml.insertarInformacionAdicional(json.getString("InformacionAdicional"));
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void ActualizarAdapter() {
        adapter.Actualizar();
    }

    private class getJSONObjectTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            JSONObject json = getJsonObject(params[0]);
            boolean result = false;

            result = AlmacenarDatos(json, params[0]);

            //Comprobamos que el campo actualizado es el que se está mostrando por pantalla
            if (params[0].equals(adapter.getCampo()))
                return result;

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            if (aBoolean)
                ActualizarAdapter();
        }
    }

    private class getJSONArrayTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            JSONArray jsonArray = getJsonArray(params[0]);
            boolean result = false;

            for (int i = 0; i < jsonArray.length(); i++)
                try {
                    result = AlmacenarDatos(jsonArray.getJSONObject(i), params[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            //Comprobamos que el campo actualizado es el que se está mostrando por pantalla
            if (params[0].equals(adapter.getCampo()))
                return result;

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            if (aBoolean)
                ActualizarAdapter();

        }
    }
}
