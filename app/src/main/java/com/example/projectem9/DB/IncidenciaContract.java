package com.example.projectem9.DB;

import android.provider.BaseColumns;

public class IncidenciaContract {

    private IncidenciaContract(){}
    public static class IncidenciaEntry implements BaseColumns {
        public static final String TABLE_NAME ="incidencia";
        public static final String COLUMN_NAME_TITLE = "titulo";
        public static final String ID = "id";
        public static final String PRIORIDAD_INCIDENCIA = "prioridad";
        public static final String FECHA_INCIDENCIA = "fecha";
        public static final String STATUS_INCIDENCIA = "status";
        public static final String DESCIPCION_INCIDENCIA = "descripcion";
    }

}
