package com.example.adrian.micurriculum.clases;

/**
 * Created by Adrián on 20/04/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {

    String sqlExperiencia = "CREATE TABLE InfoExperiencia (NombreEmpresa TEXT PRIMARY KEY, MesInicio INT, AnyoInicio INT, MesFin INT, AnyoFin INT,  Puesto TEXT, Ciudad TEXT, Descripcion TEXT)";
    String sqlEducacion = "CREATE TABLE InfoEducacion (NombreEstudios TEXT PRIMARY KEY, MesInicio INT, AnyoInicio INT, MesFin INT, AnyoFin INT,  Ciudad Text NombreCentro TEXT)";
    String sqlDiplomas = "CREATE TABLE InfoDiplomas (NombreEstudios TEXT PRIMARY KEY, MesInicio INT, AnyoInicio INT, MesFin INT, AnyoFin INT,  Ciudad Text NombreCentro TEXT)";
    String sqlAptitudesTecnicas = "CREATE TABLE InfoAptitudes (Experiencia TEXT PRIMARY KEY, Aptitud TEXT, Tiempo INT)";
    String sqlIdiomas = "CREATE TABLE InfoIdiomas (Idioma TEXT PRIMARY KEY, Nivel TEXT)";

    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlExperiencia);
        db.execSQL(sqlEducacion);
        db.execSQL(sqlDiplomas);
        db.execSQL(sqlAptitudesTecnicas);
        db.execSQL(sqlIdiomas);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.
        Log.v("BasedeDatos", "Upgrade1");
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS InfoExperiencia");
        db.execSQL("DROP TABLE IF EXISTS InfoEducacion");
        db.execSQL("DROP TABLE IF EXISTS InfoDiplomas");
        db.execSQL("DROP TABLE IF EXISTS InfoAptitudes");
        db.execSQL("DROP TABLE IF EXISTS InfoIdiomas");
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlExperiencia);
        db.execSQL(sqlEducacion);
        db.execSQL(sqlDiplomas);
        db.execSQL(sqlAptitudesTecnicas);
        db.execSQL(sqlIdiomas);

    }

    public boolean insertarExperiencia(String NombreEmpresa, int MesInicio, int AnyoInicio, int MesFin, int AnyoFin, String Puesto, String Ciudad, String Descripcion) {

        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;

        if (db != null) {

            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put("NombreEmpresa", NombreEmpresa);
            valores.put("MesInicio", MesInicio);
            valores.put("AnyoInicio", AnyoInicio);
            valores.put("MesFin", MesFin);
            valores.put("AnyoFin", AnyoFin);
            valores.put("Puesto", Puesto);
            valores.put("Ciudad", Ciudad);
            valores.put("Descripcion", Descripcion);

            try {
                //Insertamos la nueva línea
                long result = db.insert("InfoExperiencia", null, valores);

                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    result = db.replace("InfoExperiencia", null, valores);
                    if (result >= 0)
                        resultado = true;

                } else
                    resultado = true;
            } catch (Exception e) {
            }

            //Se cerra el escritor
            db.close();

        }
        return resultado;
    }

    public boolean insertarEstudio(String NombreEstudios, int MesInicio, int AnyoInicio, int MesFin, int AnyoFin, String Ciudad, String NombreCentro) {

        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;

        if (db != null) {

            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put("NombreEstudios", NombreEstudios);
            valores.put("MesInicio", MesInicio);
            valores.put("AnyoInicio", AnyoInicio);
            valores.put("MesFin", MesFin);
            valores.put("AnyoFin", AnyoFin);
            valores.put("Ciudad", Ciudad);
            valores.put("NombreCentro", NombreCentro);

            try {
                //Insertamos la nueva línea
                long result = db.insert("InfoEducacion", null, valores);

                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    result = db.replace("InfoEducacion", null, valores);
                    if (result >= 0)
                        resultado = true;
                } else
                    resultado = true;
            } catch (Exception e) {
            }

            //Se cerra el escritor
            db.close();

        }
        return resultado;
    }

    public boolean insertarDiploma(String NombreEstudios, int MesInicio, int AnyoInicio, int MesFin, int AnyoFin, String Ciudad, String NombreCentro) {

        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;

        if (db != null) {

            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put("NombreEstudios", NombreEstudios);
            valores.put("MesInicio", MesInicio);
            valores.put("AnyoInicio", AnyoInicio);
            valores.put("MesFin", MesFin);
            valores.put("AnyoFin", AnyoFin);
            valores.put("Ciudad", Ciudad);
            valores.put("NombreCentro", NombreCentro);

            try {
                //Insertamos la nueva línea
                long result = db.insert("InfoDiplomas", null, valores);

                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    result = db.replace("InfoDiplomas", null, valores);
                    if (result >= 0)
                        resultado = true;
                } else
                    resultado = true;
            } catch (Exception e) {
            }

            //Se cerra el escritor
            db.close();
        }
        return resultado;
    }

    public boolean insertarAptitud(String Experiencia, String Aptitud, int Tiempo) {

        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;

        if (db != null) {

            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put("Experiencia", Experiencia);
            valores.put("Aptitud", Aptitud);
            valores.put("Tiempo", Tiempo);

            try {
                //Insertamos la nueva línea
                long result = db.insert("InfoAptitudes", null, valores);

                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    result = db.replace("InfoAptitudes", null, valores);
                    if (result >= 0)
                        resultado = true;
                } else
                    resultado = true;
            } catch (Exception e) {
            }

            //Se cerra el escritor
            db.close();
        }
        return resultado;
    }

    public boolean insertarIdioma(String Idioma, String Nivel) {

        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;

        if (db != null) {

            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put("Idioma", Idioma);
            valores.put("Nivel", Nivel);

            try {
                //Insertamos la nueva línea
                long result = db.insert("InfoIdiomas", null, valores);

                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    result = db.replace("InfoIdiomas", null, valores);
                    if (result >= 0)
                        resultado = true;
                } else
                    resultado = true;
            } catch (Exception e) {
            }

            //Se cerra el escritor
            db.close();
        }
        return resultado;
    }

    public Cursor getCursorExperiencia() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"NombreEmpresa", "Puesto", "MesInicio", "AnyoInicio", "MesFin", "AnyoFin", "Ciudad", "Descripcion"};

        Cursor c = db.query("InfoExperiencia", valores_recuperar,
                null, null, null, null, "AnyoFin DESC, MesFin DESC", null);

        if (c != null) {
            c.moveToFirst();

        }

        return c;
    }

    public Cursor getCursorEstudios() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"NombreEstudios", "MesInicio", "AnyoInicio", "MesFin", "AnyoFin", "Ciudad", "NombreCentro"};

        Cursor c = db.query("InfoEducacion", valores_recuperar,
                null, null, null, null, "AnyoFin DESC, MesFin DESC", null);

        if (c != null) {
            c.moveToFirst();

        }

        return c;
    }

    public Cursor getCursorDiplomas() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"NombreEstudios", "MesInicio", "AnyoInicio", "MesFin", "AnyoFin", "Ciudad", "NombreCentro"};

        Cursor c = db.query("InfoDiplomas", valores_recuperar,
                null, null, null, null, "AnyoFin DESC, MesFin DESC", null);

        if (c != null) {
            c.moveToFirst();

        }

        return c;
    }

    public Cursor getCursorAptitudes() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();

        String[] valores_recuperar = {"Experiencia", "Aptitud", "Tiempo"};

        Cursor c = db.query("InfoImagenMeteo", valores_recuperar,
                null, null, null, null, "Codigo DESC", null);

        if (c != null) {
            c.moveToFirst();

        }

        return c;
    }

    public Cursor getCursorIdiomas() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"Idioma", "Nivel"};

        Cursor c = db.query("InfoImagenMeteo", valores_recuperar,
                null, null, null, null, "Codigo DESC", null);

        if (c != null) {
            c.moveToFirst();

        }

        return c;
    }
}
