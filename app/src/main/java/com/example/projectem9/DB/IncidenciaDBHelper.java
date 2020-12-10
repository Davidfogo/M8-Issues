package com.example.projectem9.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.projectem9.DB.IncidenciaContract.IncidenciaEntry;
import com.example.projectem9.Incidencia;

public class IncidenciaDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencies.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT)";

    public IncidenciaDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + IncidenciaEntry.TABLE_NAME);
    }

    public void insertIncidencia(SQLiteDatabase db, Incidencia i){
        //Check the bd is open
        if (db.isOpen()){
//Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, i.getTitol());

            db.insert(IncidenciaEntry.TABLE_NAME, null, values);
        }else{
            Log.d("sql","Database is closed");
        }
    }

}
