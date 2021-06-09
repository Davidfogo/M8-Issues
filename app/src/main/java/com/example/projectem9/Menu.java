package com.example.projectem9;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Creation of the dbHelper


        //borrar base de datos
        //dbHelper.dropTable(db);

        //Crear base de datos
        //dbHelper.onCreate(db);

    }
}