package com.example.adrian.micurriculum.clases.Renderers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 22/04/2015.
 */
public class RendererExperiencias extends RendererAbstract {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    static class HolderExperiencias {
        TextView NombreEmpresa;
        TextView Fecha;
        TextView Puesto;
        TextView Ciudad;
        TextView Descripcion;
    }
}
