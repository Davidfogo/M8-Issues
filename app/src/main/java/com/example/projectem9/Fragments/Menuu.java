package com.example.projectem9.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectem9.DB.IncidenciaContract;
import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.R;

public class Menuu extends Fragment {
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;

    private static final String SQL_BORRAR_CONTENIDO =  "delete from " + IncidenciaContract.IncidenciaEntry.TABLE_NAME;

    private static final String SQL_BORRAR = "update sqlite_sequence set seq=0 where name=" + IncidenciaContract.IncidenciaEntry.TABLE_NAME;
    public Menuu() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fMenu =  inflater.inflate(R.layout.fragment_menuu, container, false);

        Button btnAfegir = fMenu.findViewById(R.id.btn_add);
        btnAfegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("PROVES", "Button afegir click");

                Fragment fAfegirIncidencia = new AddIncidencies();
                MenuManager(fAfegirIncidencia);

            }
        });

        Button btnLlistar = fMenu.findViewById(R.id.btn_lista);
        btnLlistar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("PROVES", "Button afegir click");

                Fragment fLlistaIncidencies = new LlistaIncidencies();
                MenuManager(fLlistaIncidencies);

            }
        });

        Button btnEliminar = fMenu.findViewById(R.id.btn_borrar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("PROVES", "Button afegir click");
                db.execSQL(SQL_BORRAR_CONTENIDO);
                db.execSQL(SQL_BORRAR);


            }
        });
        return fMenu;
    }
    public void MenuManager(Fragment parametro){
        FragmentManager menuManager = getFragmentManager();
        FragmentTransaction menuTransaction = menuManager.beginTransaction();
        menuTransaction.replace(R.id.frameLayout, parametro);

        menuTransaction.commit();
    }
}