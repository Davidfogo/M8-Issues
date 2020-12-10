package com.example.projectem9.Fragments;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.Incidencia;
import com.example.projectem9.Menu;
import com.example.projectem9.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class AddIncidencies extends Fragment {

    ArrayList list;
    int Contador;
    EditText titol_incidencia;

    //Create the instance of dbHelper
    private IncidenciaDBHelper dbHelper;
    private SQLiteDatabase db;


    public AddIncidencies() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fIncidencies =  inflater.inflate(R.layout.fragment_addincidencies, container, false);



        Intent recogerdatos = getActivity().getIntent();
        list = recogerdatos.getIntegerArrayListExtra("list");

        final Spinner spinner = fIncidencies.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btn_guardar =fIncidencies.findViewById(R.id.btn_guardar);
        titol_incidencia = fIncidencies.findViewById(R.id.ET_Incidencia);

        //Creation of the dbHelper
        dbHelper = ((Menu)getActivity()).dbHelper;
        db = ((Menu)getActivity()).db;

        btn_guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                boolean des_ok = botonnegar(v);

                EditText titol_incidencia = fIncidencies.findViewById(R.id.ET_Incidencia);
                if (des_ok) {
                    String titol = titol_incidencia.getText().toString();
                    Incidencia in = new Incidencia(titol, "alta");
                    dbHelper.insertIncidencia(db, in);
                }
            }

        });

        return fIncidencies;
    }



    public boolean botonnegar(View v){
        if (validar()){
            Toast.makeText(getActivity(), "ADDED", Toast.LENGTH_SHORT).show();
        }
        return validar();
    }

    public boolean validar(){
        String titol = titol_incidencia.getText().toString();
        if (titol.isEmpty()) {
            titol_incidencia.setError("INTRODUEIX AQUEST PARAMETRE");
            return false;
        }
        return true;
    }
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("list", list);
        getActivity().setResult(RESULT_OK, returnIntent);
        getActivity().finish();
    }
    //Close the db when the activity onDestroy
    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}