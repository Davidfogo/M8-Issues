package com.example.projectem9.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.Objetos.Incidencia;
import com.example.projectem9.R;


public class IncidenciaSola extends Fragment {
    public int count = 0;
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;

    public IncidenciaSola() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fIncidenciaSola =  inflater.inflate(R.layout.fragment_incidencia_sola, container, false);
        final Incidencia incidencia = (Incidencia) this.getArguments().getSerializable("incidencia");

        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        TextView txtnombre = fIncidenciaSola.findViewById(R.id.txtIncidencia);
        TextView txtdrescrip = fIncidenciaSola.findViewById(R.id.txtdescripcion);
        TextView txtprio = fIncidenciaSola.findViewById(R.id.txtPrioritat);
        final ImageView imgprio = fIncidenciaSola.findViewById(R.id.imgPrio);


        txtnombre.setText(incidencia.getTitol());
        txtdrescrip.setText(incidencia.getDescripcion());
        txtprio.setText(incidencia.getPrioritat());
        final String id = incidencia.getId();

        if(incidencia.getPrioritat().contains("3")){
            txtprio.setText("Alta");
        }else if(incidencia.getPrioritat().contains("2")){
            txtprio.setText("Mitjana");
        }else if(incidencia.getPrioritat().contains("1")){
            txtprio.setText("Baixa");
        }
        imgprio.setColorFilter(Color.parseColor("#ff0000"));

        imgprio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 0) {
                    //AMARILLO
                    imgprio.setColorFilter(Color.parseColor("#FFA200"));
                    incidencia.setStatus(0);
                    count++;
                }else if(count == 1){
                    //VERDE
                    imgprio.setColorFilter(Color.parseColor("#1AFF00"));
                    incidencia.setStatus(1);
                    count++;
                }else if(count == 2){
                    //ROJO
                    imgprio.setColorFilter(Color.parseColor("#ff0000"));
                    incidencia.setStatus(2);
                    count = 0;
                }
            }
        });

        Button btnborrar = fIncidenciaSola.findViewById(R.id.btnborrar);
        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.borrarIncidencia(db,id);
            }
        });
        return fIncidenciaSola;
    }

}