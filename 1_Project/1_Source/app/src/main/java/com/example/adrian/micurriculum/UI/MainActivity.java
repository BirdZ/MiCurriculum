package com.example.adrian.micurriculum.UI;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.adrian.micurriculum.clases.Fragments.FotoFragment;
import com.example.adrian.micurriculum.clases.miFragmentAdapter;


public class MainActivity extends ActionBarActivity {

    //Variables para el ViewPager
    private ViewPager pager;
    private miFragmentAdapter pagerAdapter;

    //Variables para el menu deslizable
    private ListView ListaMenu;
    private DrawerLayout menuDeslizable;
    private String[] opciones;
    private ActionBarDrawerToggle mDrawerToggle;

    //Variable Toolbar
    //private android.support.v7.widget.Toolbar miToolBar;
    private android.support.v7.app.ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Log.v("principio", "aquí");
        //Obtenemos la actionBar
        actionBar = this.getSupportActionBar();

        //Instanciamos el viewPager del layout principal
        pager = (ViewPager)findViewById(R.id.mainPager);

        //Creamos el fragmentAdapter
        pagerAdapter = new miFragmentAdapter(getSupportFragmentManager());

        //Añadimos al fragmentAdapter todos los fragments
        pagerAdapter.addFragment(FotoFragment.nuevaInstancia());

        pager.setAdapter(pagerAdapter);

        //Instanciamos el listView y el menú deslizable
        ListaMenu = (ListView) findViewById(R.id.listView_menu);
        menuDeslizable = (DrawerLayout) findViewById(R.id.menuDeslizable);

        //Creamos el adapter para el menú
        final String[] opciones = {"Foto", "Datos Personales", "Resumen", "Aptitudes", "Experiencia", "Estudios", "Diplomas", "Aptitudes Técnicas", "Idiomas", "Información Adicional", };
        Log.v("primero", ListaMenu.toString());

        ListaMenu.setAdapter(new ArrayAdapter<String>(actionBar.getThemedContext(), android.R.layout.simple_list_item_1, opciones));

        //Añadimos la opción al clikar un item
        ListaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {

                switch (position)
                {
                    case 0: pager.setCurrentItem(position); break;
                    default:
                }

                actionBar.setTitle(opciones[position]);
                //Cerramos el menú
                menuDeslizable.closeDrawer(ListaMenu);
            }
        });



        mDrawerToggle = new ActionBarDrawerToggle(
                this,                 //la actividad
                menuDeslizable,         //el drawerLayout que desplegará
                R.drawable.ic_launcher, //el icono que mostraremos
                R.string.app_name,  //descripción al abrir
                R.string.app_name  //descripción al cerrar
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle("Provisional Seleccion");
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Provisional app");
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }
        };
        menuDeslizable.setDrawerListener(mDrawerToggle);

        //Obtenemos el Action bar
        actionBar = this.getSupportActionBar();

        try {
            //Mostramos el botón en la barra de la aplicación
            actionBar.setDisplayHomeAsUpEnabled(true);
            //Activamso el click en el icono de la aplicación
            actionBar.setHomeButtonEnabled(true);
        }catch (Exception e)
        {
            Log.v("error", e.toString());
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        /*boolean menuAbierto = menuDeslizable.isDrawerOpen(ListaMenu);

        if(menuAbierto)
            Log.v("menu", "abierto");
        else
            Log.v("menu", "cerrado");*/

        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
