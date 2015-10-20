package com.example.adrian.micurriculum.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Adrian on 22/04/2015.
 */
public class Adapter extends BaseAdapter {

    private String Campo;
    private Renderer renderer;
    private Context cntx;

    public Adapter(String campo, Context cntx) {
        Campo = campo;
        this.cntx = cntx;
        renderer = new Renderer(cntx, this, Campo);
    }

    public void Actualizar() {
        this.notifyDataSetChanged();
    }

    public String getCampo() {
        return Campo;
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
        renderer.setCampo(Campo);
        Actualizar();
    }

    @Override
    public int getCount() {
        return renderer.getCount();
    }

    @Override
    public Object getItem(int position) {
        return renderer.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return renderer.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return renderer.getView(position, convertView, parent, Campo);
    }

}
