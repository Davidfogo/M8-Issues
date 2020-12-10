package com.example.projectem9;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectem9.DB.IncidenciaDBHelper;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();

    public IncidenciaDBHelper dbHelper;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Creation of the dbHelper
        dbHelper = new IncidenciaDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        //borrar base de datos
        //dbHelper.dropTable(db);

        //Crear base de datos
        //dbHelper.onCreate(db);

    }
}