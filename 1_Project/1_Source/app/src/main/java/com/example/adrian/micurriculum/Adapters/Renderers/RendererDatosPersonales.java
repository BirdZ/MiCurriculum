package com.example.adrian.micurriculum.Adapters.Renderers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adrian.micurriculum.Objetos.Datos;
import com.example.adrian.micurriculum.clases.Repositorio;

/**
 * Created by Adrian on 22/04/2015.
 */
public class RendererDatosPersonales extends RendererAbstract {

    private Datos datos;
    private Repositorio repositorio;

    public RendererDatosPersonales(Repositorio repositorio) {
        this.repositorio = repositorio;
        datos = repositorio.getDatosPersonales();
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return datos;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    static class HolderDatosPersonales {
        TextView Nombre;
        TextView Direccion;
        TextView DNI;
        TextView FechaDeNacimiento;
        TextView Telefono;
        TextView CorreoElectronico;
        TextView CarnetConducir;
    }
}
