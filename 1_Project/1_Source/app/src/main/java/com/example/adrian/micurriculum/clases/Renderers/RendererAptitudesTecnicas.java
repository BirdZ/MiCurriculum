package com.example.adrian.micurriculum.clases.Renderers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Adrian on 23/04/2015.
 */
public class RendererAptitudesTecnicas extends RendererAbstract {

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

    static class HolderAptitudesTecnicas {
        TextView Experiencia;
        TextView Aptitud;
        TextView Tiempo;
    }
}
