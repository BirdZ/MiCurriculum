package com.example.adrian.micurriculum.DataRepository;

import android.content.Context;
import android.util.Xml;

import com.example.adrian.micurriculum.Objetos.Datos;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Adrian on 22/04/2015.
 * <p/>
 * Clase para almacenar los datos simples del curriculum
 */
public class XMLHelper {

    private FileOutputStream fout;
    private FileInputStream fin;
    private XmlSerializer ser;
    private XmlPullParser parser;

    private Context cntx;

    public XMLHelper(Context cntx) {

        this.cntx = cntx;

    }


    public boolean insertarDatosPersonales(String Nombre, String Direccion, String DNI, String FechaDeNacimiento, String Telefono, String CorreoElectronico, String CarnetConducir) {
        try {

            fout = cntx.getApplicationContext().openFileOutput("DatosPersonales.xml", Context.MODE_PRIVATE);
            ser = Xml.newSerializer();

            try {
                ser.setOutput(fout, "UTF-8");
                ser.startDocument(null, true);

                ser.startTag("", "DatosPersonales");

                ser.startTag("", "Nombre");
                ser.text(Nombre);
                ser.endTag("", "Nombre");

                ser.startTag("", "Direccion");
                ser.text(Direccion);
                ser.endTag("", "Direccion");

                ser.startTag("", "DNI");
                ser.text(DNI);
                ser.endTag("", "DNI");

                ser.startTag("", "FechaDeNacimiento");
                ser.text(FechaDeNacimiento);
                ser.endTag("", "FechaDeNacimiento");

                ser.startTag("", "Telefono");
                ser.text(Telefono);
                ser.endTag("", "Telefono");

                ser.startTag("", "CorreoElectronico");
                ser.text(CorreoElectronico);
                ser.endTag("", "CorreoElectronico");

                ser.startTag("", "CarnetConducir");
                ser.text(CarnetConducir);
                ser.endTag("", "CarnetConducir");

                ser.endTag("", "DatosPersonales");

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public boolean insertarAptitudes(String[] Aptitudes) {
        try {

            fout = cntx.getApplicationContext().openFileOutput("Aptitudes.xml", Context.MODE_PRIVATE);
            ser = Xml.newSerializer();

            try {
                ser.setOutput(fout, "UTF-8");
                ser.startDocument(null, true);

                ser.startTag("", "Aptitudes");

                for (int i = 0; i < Aptitudes.length; i++) {
                    ser.startTag("", "Nombre");
                    ser.text(Aptitudes[i]);
                    ser.endTag("", "Nombre");
                }


                ser.endTag("", "Aptitudes");

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public boolean insertarResumen(String Resumen) {
        try {

            fout = cntx.getApplicationContext().openFileOutput("Resumen.xml", Context.MODE_PRIVATE);
            ser = Xml.newSerializer();

            try {
                ser.setOutput(fout, "UTF-8");
                ser.startDocument(null, true);

                ser.startTag("", "Resumen");

                ser.startTag("", "Texto");
                ser.text(Resumen);
                ser.endTag("", "Texto");

                ser.endTag("", "Resumen");

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public boolean insertarInformacionAdicional(String InformacionAdicional) {
        try {

            fout = cntx.getApplicationContext().openFileOutput("InformacionAdicional.xml", Context.MODE_PRIVATE);
            ser = Xml.newSerializer();

            try {
                ser.setOutput(fout, "UTF-8");
                ser.startDocument(null, true);

                ser.startTag("", "InformacionAdicional");

                ser.startTag("", "Texto");
                ser.text(InformacionAdicional);
                ser.endTag("", "Texto");

                ser.endTag("", "InformacionAdicional");

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    public Datos getDatosPersonales() {

        int i = 0;
        String[] atributos = new String[7];
        try {
            fin = cntx.getApplicationContext().openFileInput("DatosPersonales.xml");
            parser = Xml.newPullParser();
            parser.setInput(fin, "UTF-8");

            int event = parser.next();
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.TEXT && parser.getText().trim().length() != 0) {
                    atributos[i] = parser.getText();
                    i++;
                }

                event = parser.next();
            }
            fin.close();

        } catch (Exception e) {
            return null;
        }
        return new Datos(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], atributos[5], atributos[6]);

    }

    public String[] getAptitudes() {

        int i = 0;
        ArrayList<String> aptitudes = new ArrayList<String>();
        try {
            fin = cntx.getApplicationContext().openFileInput("Aptitudes.xml");
            parser = Xml.newPullParser();
            parser.setInput(fin, "UTF-8");

            int event = parser.next();
            parser.getAttributeCount();
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.TEXT && parser.getText().trim().length() != 0) {
                    aptitudes.add(parser.getText());

                }


                event = parser.next();
            }
            fin.close();

        } catch (Exception e) {
            return null;
        }
        return (String[]) aptitudes.toArray();

    }

    public String getResumen() {

        String resumen = "";
        try {
            fin = cntx.getApplicationContext().openFileInput("Resumen.xml");
            parser = Xml.newPullParser();
            parser.setInput(fin, "UTF-8");

            int event = parser.next();
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.TEXT && parser.getText().trim().length() != 0)
                    resumen = parser.getText();

                event = parser.next();
            }
            fin.close();

        } catch (Exception e) {
            return null;
        }
        return resumen;

    }

    public String getInformacionAdicional() {

        int i = 0;
        String InformacionAdicional = "";
        try {
            fin = cntx.getApplicationContext().openFileInput("InformacionAdicional.xml");
            parser = Xml.newPullParser();
            parser.setInput(fin, "UTF-8");

            int event = parser.next();
            while (event != XmlPullParser.END_DOCUMENT) {

                if (event == XmlPullParser.TEXT && parser.getText().trim().length() != 0)
                    InformacionAdicional = parser.getText();

                event = parser.next();
            }
            fin.close();

        } catch (Exception e) {
            return null;
        }
        return InformacionAdicional;

    }
}
