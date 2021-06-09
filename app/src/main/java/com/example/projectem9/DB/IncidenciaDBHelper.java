package com.example.projectem9.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.projectem9.DB.IncidenciaContract.IncidenciaEntry;
import com.example.projectem9.Objetos.Incidencia;

import java.util.ArrayList;

public class IncidenciaDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "incidencias2.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + IncidenciaEntry.TABLE_NAME +
            "(" + IncidenciaEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            IncidenciaEntry.COLUMN_NAME_TITLE + " TEXT," + IncidenciaEntry.PRIORIDAD_INCIDENCIA + " TEXT, "
            + IncidenciaEntry.DESCIPCION_INCIDENCIA + " TEXT, " + IncidenciaEntry.STATUS_INCIDENCIA + " INTEGER, "
            + IncidenciaEntry.FECHA_INCIDENCIA + " TEXT);";

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


    public void insertIncidencia(SQLiteDatabase db, Incidencia incidencia){
        //Check the bd is open
        if (db.isOpen()){

            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();
            //Insert the incidence getting all values

            values.put(IncidenciaEntry.COLUMN_NAME_TITLE, incidencia.getTitolIncidencia());
            values.put(IncidenciaEntry.PRIORIDAD_INCIDENCIA, incidencia.getPrioritatIncidencia());
            values.put(IncidenciaEntry.DESCIPCION_INCIDENCIA, incidencia.getDescripcion());
            values.put(IncidenciaEntry.STATUS_INCIDENCIA, "0"); // 0: Pending, 1: Assigned, 2: Solved
            values.put(IncidenciaEntry.FECHA_INCIDENCIA, incidencia.getFecha());


            db.insert(IncidenciaEntry.TABLE_NAME, null, values);
        }else{
            Log.d("sql","DB esta tancada");
        }
    }

    public static ArrayList<Incidencia> arraydeincidencias(SQLiteDatabase db, int num){
        Cursor cursor = db.rawQuery("SELECT * FROM " + IncidenciaEntry.TABLE_NAME, null);
        if (num != 3){
            cursor = db.rawQuery("SELECT * FROM " + IncidenciaEntry.TABLE_NAME + "WHERE " + IncidenciaEntry.STATUS_INCIDENCIA + " = " + num,null);

        }
        ArrayList<Incidencia> arrayincidencia = new ArrayList<>();
        Incidencia incidencia;

        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                incidencia = new Incidencia(cursor.getString(1),cursor.getString(2));
                incidencia.setId(cursor.getInt(0));
                incidencia.setDescripcion(cursor.getString(3));
                incidencia.setStatus(Integer.parseInt(cursor.getString(4)));
                incidencia.setFecha(Long.parseLong(cursor.getString(5)));

                arrayincidencia.add(incidencia);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return arrayincidencia;
    }

    public void borrarAllIncidencias(SQLiteDatabase db){
        String borrar = "DELETE FROM "+ IncidenciaEntry.TABLE_NAME;
        Log.i("Borrar", "Se borra");
        db.execSQL(borrar);

    }



    public static void borrarIncidencia(SQLiteDatabase db, String id){
        String borrar = "DELETE FROM "+ IncidenciaEntry.TABLE_NAME + " WHERE "+IncidenciaEntry.ID + " = " + id;
        db.execSQL(borrar);
    }

}
