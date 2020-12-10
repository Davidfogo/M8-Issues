package com.example.projectem9.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.Incidencia;
import com.example.projectem9.R;

import java.util.ArrayList;


public class LlistaIncidencies extends Fragment {
    ArrayList<Incidencia> llista_Incidencia;
    RecyclerView RecyclerView_Incidencia;

    IncidenciaDBHelper conn;
    public LlistaIncidencies() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View LlistaArrayIncidencia = inflater.inflate(R.layout.fragment_llista_incidencies, container, false);
        return LlistaArrayIncidencia;
    }
}