package com.example.projectem9;

import java.util.ArrayList;

public class Incidencia{
    public String titolIncidencia;
    public String prioritatIncidencia;
    public ArrayList lista;

    public Incidencia(String titolIncidencia, String prioritat) {
        this.titolIncidencia = titolIncidencia;
        this.prioritatIncidencia = prioritat;
    }


    public String getTitol() {
        return titolIncidencia;
    }

    public void setTitolIncidencia(String titolIncidencia) {
        this.titolIncidencia = titolIncidencia;
    }


    public String getPrioritat(){
        return prioritatIncidencia;
    }

    public void setPrioritat(String prioritat){
        this.prioritatIncidencia = prioritat;
    }
}
