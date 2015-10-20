package com.example.adrian.micurriculum.DataRepository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Adrian on 21/04/2015.
 * <p/>
 * Clase creada para simular la conexión al servicio web
 */
public class virtualServiceWeb {

    public static JSONObject getJSONDatosPersonales() {
        JSONObject json = new JSONObject();
        try {
            json.put("Nombre", "Adrián Estellés Hereu");
            json.put("Direccion", "C/La Paz nº38,\n" +
                    "Carcaixent (Valencia), 46740");
            json.put("DNI", "20839184B");
            json.put("Fecha de nacimiento", "7 de Junio de 1982");
            json.put("Telefono", "667742523");
            json.put("CorreoElectronico", "hastajales10@gmail.com");
            json.put("CarnetConducir", "B");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }

    public static JSONObject getJSONResumen() {
        JSONObject json = new JSONObject();
        try {
            json.put("Resumen", "Me dejé los estudios a los 17 años y empecé a trabajar en la industria de la madera. Estuve en dos" +
                    "fábricas de muebles en las que rápidamente aprendí a llevar maquinaría que a otra gente le era difícil" +
                    "el manejo y esto me fue bien valorado. La primera empresa cerró y de la segunda me fui a los 24" +
                    "años para empezar mis estudios.\n" +
                    "Durante mis estudios estuve trabajando los fines de semana en un negocio de ocio, a los pocos años el" +
                    "dueño me propuso crear una franquicia del mismo tema pero debido a la crisis no pudimos lanzar la" +
                    "empresa porque no obtuvimos financiación. Este empleo lo dejé en el momento que terminé los" +
                    "estudios.\n" +
                    "La carrera me la saqué en 4 años, quedándome para el cuarto año el proyecto y 2 asignaturas. El" +
                    "proyecto del máster lo realicé mediante una beca de colaboración de 5 meses. Estuve desarrollando" +
                    "el software, firmware y control de un sistema que se está utilizando en una investigación en el" +
                    "Instituto de Investigación de La Fe. Cuando se me terminó la beca, me ofrecieron otra desde el I. I." +
                    "La Fe para supervisar y mejorar el sistema.\n" +
                    "Nunca he sido despedido de ninguna empresa en la que haya trabajado, siendo en cambio bien" +
                    "valorado por mis jefes.\n");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }

    public static JSONObject getJSONAptitudes() {
        JSONObject json = new JSONObject();
        try {
            String[] Aptitudes = {"Java/C/C++", "C#", "Aptitudes de programación y diseño", "SDK de Android", "ADA'95", "LabView", "Matlab", "Simulink", "Programación de microcontroladores", "Programación de FPGA", "Dominio de los protocolos TCP/IP", "Bus CAN, I2C, serie...", "Bluetooth", "Diseño de sistemas de control", "Calibración de sensores", "Manejo de actuadores", "PWM"};
            json.put("Aptitudes", Aptitudes);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }


    public static JSONArray getJSONExperiencias() {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            json.put("NombreEmpresa", "LeZeus");
            json.put("MesInicio", 11);
            json.put("AnyoInicio", 2013);
            json.put("MesFin", 3);
            json.put("AnyoFin", 2015);
            json.put("Puesto", "Desarrollador");
            json.put("Ciudad", "Valencia");
            json.put("Descripcion", "Desarrollo de la aplicación para Android de la web www.lezeus.com. Sigo ayudándoles cuando lo necesitan.\n" +
                    "\n" +
                    "\n" +
                    "https://play.google.com/store/apps/details?id=app.LeZeus&hl=es");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("NombreEmpresa", "Instituto de Investigación La Fe ");
            json.put("MesInicio", 9);
            json.put("AnyoInicio", 2014);
            json.put("MesFin", 2);
            json.put("AnyoFin", 2015);
            json.put("Puesto", "Becario");
            json.put("Ciudad", "Valencia");
            json.put("Descripcion", "Prolongación del proyecto de la cámara para el control de oxígeno para la investigación con ratones" +
                    "del efecto en crías prematuras con estado de hipoxia e hiperoxia.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("NombreEmpresa", "Laser Game Evolution  ");
            json.put("MesInicio", 9);
            json.put("AnyoInicio", 2007);
            json.put("MesFin", 9);
            json.put("AnyoFin", 2014);
            json.put("Puesto", "Paterna");
            json.put("Ciudad", "Valencia");
            json.put("Descripcion", "Este trabajo me ayudó a pagarme los estudios. No sería de mayor relevancia si no hubiera sido porque" +
                    "durante el trascurso de dicho empleo estuve construyendo una franquicia de Láser Tag con el jefe y" +
                    "el gerente del negocio. Mi papel era la de desarrollar la parte técnica necesaria para el juego." +
                    "Desarrollé el software con Java y supervisé el diseño de las placas electrónicas del chaleco. Este" +
                    "proyecto no pudo ver la luz al no conseguir financiación.\n" +
                    "Actualmente sigo trabajando para ellos de manera esporádica reparando las averías electrónicas de" +
                    "los chalecos.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("NombreEmpresa", "Universidad Politécnica de Valencia");
            json.put("MesInicio", 3);
            json.put("AnyoInicio", 2014);
            json.put("MesFin", 7);
            json.put("AnyoFin", 2014);
            json.put("Puesto", "Becario");
            json.put("Ciudad", "Valencia");
            json.put("Descripcion", "En esta beca desarrollé el software, firmware y control de una cámara para el control de oxígeno" +
                    "para la investigación con ratones del efecto en crías prematuras con estado de hipoxia e hiperoxia.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        jsonArray.put(json);
        try {
            json.put("NombreEmpresa", "Empresas varias en el sector de la madera");
            json.put("MesInicio", 6);
            json.put("AnyoInicio", 1999);
            json.put("MesFin", 2);
            json.put("AnyoFin", 2007);
            json.put("Puesto", "Responsable de sección");
            json.put("Ciudad", "");
            json.put("Descripcion", "Antes de estudiar en la universidad estuve trabajando 8 años en dos empresas del sector de madera." +
                    "La primera cerró y la segunda me lo dejé para volver a los estudios.\n" +
                    "En las dos empresas conseguí subir rápidamente de cargo, a pesar de mi juventud.\n" +
                    "No detallo más estos trabajos porque no tienen relevancia en mi carrera como informático.");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);

        return jsonArray;

    }

    public static JSONArray getJSONEstudios() {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            json.put("NombreEstudios", "Máster de Automática e Informática Industrial");
            json.put("MesInicio", 9);
            json.put("AnyoInicio", 2012);
            json.put("MesFin", 9);
            json.put("AnyoFin", 2014);
            json.put("Ciudad", "Valencia");
            json.put("NombreCentro", "Universidad Politécnica de Valencia");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("NombreEstudios", "Ingeniería Técnica de Informática en Sistemas");
            json.put("MesInicio", 9);
            json.put("AnyoInicio", 2008);
            json.put("MesFin", 9);
            json.put("AnyoFin", 2012);
            json.put("Ciudad", "Valencia");
            json.put("NombreCentro", "Universidad Politécnica de Valencia ");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("NombreEstudios", "Prueba de acceso para mayores de 25 años");
            json.put("MesInicio", 10);
            json.put("AnyoInicio", 2006);
            json.put("MesFin", 6);
            json.put("AnyoFin", 2007);
            json.put("Ciudad", "Alzira");
            json.put("NombreCentro", "UNED");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);

        return jsonArray;

    }

    public static JSONArray getJSONDiplomas() {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            json.put("NombreEstudios", "Android: Introducción a la programación");
            json.put("MesInicio", 4);
            json.put("AnyoInicio", 2014);
            json.put("MesFin", 5);
            json.put("AnyoFin", 2014);
            json.put("Ciudad", "Valencia");
            json.put("NombreCentro", "UPVX");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        return jsonArray;

    }

    public static JSONArray getJSONAptitudesTecnicas() {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            json.put("Experiencia", "SDK de Android");
            json.put("Aptitud", "Programación para móviles");
            json.put("Tiempo", "1 año y 5 meses");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Experiencia", "Eclipse");
            json.put("Aptitud", "Programación Java");
            json.put("Tiempo", "1 año y medio");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Experiencia", "Android Estudio");
            json.put("Aptitud", "Programación para móviles");
            json.put("Tiempo", "2 meses");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Experiencia", "LabView");
            json.put("Aptitud", "Programación de microcontroladores y FPGA");
            json.put("Tiempo", "1 año");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Experiencia", "PID");
            json.put("Aptitud", "Diseño de sistemas de control");
            json.put("Tiempo", "1 año");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);

        return jsonArray;

    }

    public static JSONArray getJSONIdiomas() {

        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            json.put("Idioma", "Valenciano");
            json.put("Nivel", "Materno");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Idioma", "Castellano");
            json.put("Nivel", "Materno");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);
        try {
            json.put("Idioma", "Inglés");
            json.put("Nivel", "B1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(json);

        return jsonArray;

    }

    public static JSONObject getJSONInformacionAdicional() {
        JSONObject json = new JSONObject();
        try {
            json.put("InformaciónAdicional", "Me considero una persona dinámica, con buena adaptación al trabajo en grupo y capacidad de" +
                    "liderazgo.\n" +
                    "Los lenguajes de programación de Android y LabView (mis principales aptitudes) los aprendí por mí" +
                    "mismo (el curso de Android lo realicé después de aprender por tener algún diploma). Soy una persona" +
                    "con facilidad de aprendizaje.\n" +
                    "Tengo buena capacidad para desarrollar ideas y aportar nuevas ideas en los proyectos que participo.");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }

}
