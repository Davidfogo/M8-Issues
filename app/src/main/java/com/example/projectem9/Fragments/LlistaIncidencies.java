package com.example.projectem9.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.R;
import com.example.projectem9.Recycler.ListAdapter;


public class LlistaIncidencies extends Fragment {
    private IncidenciaDBHelper dbHelper;
    private  SQLiteDatabase db;

    public LlistaIncidencies() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View LlistaArrayIncidencia = inflater.inflate(R.layout.fragment_llista_incidencies, container, false);

        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = (RecyclerView)LlistaArrayIncidencia.findViewById(R.id.RecyclerView_lista);
        recyclerView.setLayoutManager(new LinearLayoutManager((LlistaArrayIncidencia.getContext())));
        ListAdapter listAdapter = new ListAdapter(IncidenciaDBHelper.arraydeincidencias(db,3), getContext());
        recyclerView.setAdapter(listAdapter);

        return LlistaArrayIncidencia;
    }


}
