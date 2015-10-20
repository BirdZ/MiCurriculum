package com.example.adrian.micurriculum.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.micurriculum.Adapters.Renderers.RendererAbstract;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererAptitudes;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererAptitudesTecnicas;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererDatosPersonales;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererDiplomas;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererEstudios;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererExperiencias;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererIdiomas;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererInformacionAdicional;
import com.example.adrian.micurriculum.Adapters.Renderers.RendererResumen;
import com.example.adrian.micurriculum.Adapters.Adapter;

/**
 * Created by Adrian on 21/04/2015.
 * <p/>
 * Esta clase se encarga de llamar al render del campo que se precise. Para crear los campos se ha utilizado
 * poliformismo para poder facilitar la introduccion de nuevos campos en el futuro.
 */
public class Renderer {

    private Context cntx;
    private Adapter adapter;
    private String Campo;
    private Repositorio repositorio;
    private RendererAbstract rendererAbstract;

    public Renderer(Context cntx, Adapter adapter, String Campo) {
        this.cntx = cntx;
        this.adapter = adapter;
        this.Campo = Campo;
        this.repositorio = new Repositorio(cntx, adapter);
        rendererAbstract = AsignarRenderer(Campo);
    }

    public void setCampo(String Campo) {
        this.Campo = Campo;
        rendererAbstract = AsignarRenderer(Campo);

    }

    public View getView(int position, View convertView, ViewGroup parent, String Campo) {
        View view = null;

        return view;
    }

    public int getCount() {
        return rendererAbstract.getCount();

    }

    public Object getItem(int position) {
        return rendererAbstract.getItem(position);
    }

    public long getItemId(int position) {
        return rendererAbstract.getItemId(position);
    }

    private RendererAbstract AsignarRenderer(String Campo) {
        switch (Campo) {
            case "DatosPersonales":
                return new RendererDatosPersonales(repositorio);
            case "Resumen":
                return new RendererResumen();
            case "Aptitudes":
                return new RendererAptitudes();
            case "Experiencias":
                return new RendererExperiencias();
            case "Estudios":
                return new RendererEstudios();
            case "Diplomas":
                return new RendererDiplomas();
            case "AptitudesTecnicas":
                return new RendererAptitudesTecnicas();
            case "Idiomas":
                return new RendererIdiomas();
            case "InformacionAdicional":
                return new RendererInformacionAdicional();
        }
        return null;
    }

}
