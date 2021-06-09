package com.example.projectem9.Fragments;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.projectem9.DB.IncidenciaDBHelper;
import com.example.projectem9.Objetos.Incidencia;
import com.example.projectem9.R;


public class AddIncidencies extends Fragment {


    int Contador;

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

       /* Intent recogerdatos = getActivity().getIntent();
        ArrayList list = recogerdatos.getIntegerArrayListExtra("list");*/

        final Spinner spinner = fIncidencies.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Urgencia, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final EditText titol_incidencia = fIncidencies.findViewById(R.id.ET_Incidencia);
        final EditText descripcion_incidencia = fIncidencies.findViewById(R.id.ET_Descripcion);

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getContext());
        db = dbHelper.getWritableDatabase();


        Button btn_guardar =fIncidencies.findViewById(R.id.btn_guardar);
        btn_guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String titol = titol_incidencia.getText().toString();
                String descrip = descripcion_incidencia.getText().toString();
                String prioritat = spinner.getSelectedItem().toString();

                checkData(titol, prioritat);

                if (prioritat.equals("Baixa")) {
                    prioritat = "1";
                }else if (prioritat.equals("Mitjana")) {
                    prioritat = "2";
                } else if (prioritat.equals("Alta")) {
                    prioritat = "3";
                }

                if(titol.length() > 0){
                    Incidencia incidencia = new Incidencia(titol, prioritat);

                    incidencia.setFecha(System.currentTimeMillis() / 1000);
                    incidencia.setDescripcion(descrip);
                    dbHelper.insertIncidencia(db, incidencia);
                }
            }

        });

        return fIncidencies;
    }



   /* public boolean botonnegar(View v){
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
    }*/
    public void checkData(String title, String prio) {
        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();

        if (title.length() > 0) { // Data is correct
            alertDialog.setTitle("PERFECTO!");
            alertDialog.setMessage("Titulo: " + " " + title );
            alertDialog.setMessage("Prioridad: " + " " + prio);
        } else {
            alertDialog.setTitle("ERROR");
            alertDialog.setMessage("NO PUEDE ESTAR VACIO!");
        }
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "CERRAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}