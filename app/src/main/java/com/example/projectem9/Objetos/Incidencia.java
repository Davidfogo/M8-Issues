package com.example.projectem9.Objetos;

import java.io.Serializable;

public class Incidencia implements Serializable {
    public String titolIncidencia;
    public String prioritatIncidencia;
    public String id;
    public int status;
    public String descripcion;
    public long fecha;


    public Incidencia(String titolIncidencia, String prioritat) {
        this.titolIncidencia = titolIncidencia;
        this.prioritatIncidencia = prioritat;
    }

    public String getTitolIncidencia() {
        return titolIncidencia;
    }

    public String getPrioritatIncidencia() {
        return prioritatIncidencia;
    }

    public void setPrioritatIncidencia(String prioritatIncidencia) {
        this.prioritatIncidencia = prioritatIncidencia;
    }

    public String getId() {
        return id;
    }

    public void setId(int id) {
        this.id = "" + id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
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
