package com.example.adrian.micurriculum.UI.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adrian.micurriculum.R;

/**
 * Created by Adrian on 24/04/2015.
 */
public class FotoFragment extends Fragment {

    private SwipeRefreshLayout swipeContainer;
    private Context cntx;

    public static FotoFragment nuevaInstancia()
    {
        return new FotoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cntx = getActivity().getApplicationContext();
        //swipeContainer = (SwipeRefreshLayout) ((Activity)cntx).findViewById(R.id.swipeFoto);
       /* swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Aquí se va el código para comprabar si la foto ha cambiado

            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
