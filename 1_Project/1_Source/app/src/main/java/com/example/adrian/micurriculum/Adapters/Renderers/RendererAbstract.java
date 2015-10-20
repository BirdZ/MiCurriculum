package com.example.adrian.micurriculum.Adapters.Renderers;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Adrian on 23/04/2015.
 * <p/>
 * Clase estatica de los renderers. Se utiliza para declarar el objeto renderer y utilizar los métodos de las clases dinámicas.
 */
public abstract class RendererAbstract {

    public RendererAbstract() {

    }

    public abstract int getCount();

    public abstract Object getItem(int position);

    public abstract long getItemId(int position);

    public abstract View getView(int position, View convertView, ViewGroup parent);


}
