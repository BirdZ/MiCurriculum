package com.example.adrian.micurriculum.Interactors;

/**
 * Created by Adrian on 21/04/2015.
 *
 * Esta clase se encarga de sacar los datos almacenados. Si no están los pide al servicio web
 * Los campos que pueden crecer con el tiempo se encuentran guardados en la base de datos. Aptitudes también puede crecer
 * pero como es sólo una String se ha optado por utilizar un array de String almacenado en un XML.
 * El resto de campos también se encuentra almacenado en XML
 */

import android.content.Context;
import android.database.Cursor;

import com.example.adrian.micurriculum.Objetos.Datos;

public class InteractorManager {

    private SQLiteHelper db;
    private XMLHelper xml;
    private GestorDatos gd;

    public InteractorManager(Context cntx, Adapter adapter) {
        db = new SQLiteHelper(cntx, "DBMiCurriculum", null, 1);
        xml = new XMLHelper(cntx);
        gd = new GestorDatos(db, xml, cntx, adapter);
    }

    public Datos getDatosPersonales() {
        Datos datos = xml.getDatosPersonales();

        //Si no hay datos almacenados, se tendrá que descargar
        if (datos == null)
            gd.DescargarDatosPersonales();

        return datos;
    }

    public String getResumen() {
        String resumen = xml.getResumen();

        //Si no hay datos almacenados, se tendrá que descargar
        if (resumen == null || resumen.equals(""))
            gd.DescargarResumen();

        return resumen;
    }

    public String[] getAptitudes() {
        String[] aptitudes = xml.getAptitudes();

        //Si no hay datos almacenados, se tendrá que descargar
        if (aptitudes == null || aptitudes.length == 0)
            gd.DescargarAptitudes();

        return aptitudes;
    }

    public Cursor getExperiencia() {
        Cursor c = db.getCursorExperiencia();

        //Si no hay datos en la base de datos, se tendrá que descargar
        if (c == null) {
            gd.DescargarExperiencias();
        }

        return c;
    }

    public Cursor getEstudios() {
        Cursor c = db.getCursorEstudios();

        //Si no hay datos en la base de datos, se tendrá que descargar
        if (c == null) {
            gd.DescargarEstudios();
        }

        return c;
    }

    public Cursor getDiplomas() {
        Cursor c = db.getCursorDiplomas();

        //Si no hay datos en la base de datos, se tendrá que descargar
        if (c == null) {
            gd.DescargarDiplomas();
        }

        return c;
    }

    public Cursor getAptitudesTecnicas() {
        Cursor c = db.getCursorAptitudes();
        //Si no hay datos en la base de datos, se tendrá que descargar
        if (c == null) {
            gd.DescargarAptitudesTecnicas();
        }

        return c;
    }

    public Cursor getIdiomas() {
        Cursor c = db.getCursorIdiomas();

        //Si no hay datos en la base de datos, se tendrá que descargar
        if (c == null) {
            gd.DescargarIdiomas();
        }

        return c;
    }

    public String getInformacionAdicional() {
        String informacionAdicional = xml.getInformacionAdicional();

        //Si no hay datos almacenados, se tendrá que descargar
        if (informacionAdicional == null || informacionAdicional.equals(""))
            gd.DescargarInformacionAdicional();

        return informacionAdicional;
    }
}
