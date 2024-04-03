package com.emergentes.modelo;
/**
 *
 * @author Deyvid
 */
public class Estudiante {
    private int id;
    private String nombre;
    private int priNota;
    private int segNota;
    private int terNota;
    private int totNota;
    
    public Estudiante(){
        this.id=0;
        this.nombre="";
        this.priNota=0;
        this.segNota=0;
        this.terNota=0;
        this.totNota=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPriNota() {
        return priNota;
    }

    public void setPriNota(int priNota) {
        this.priNota = priNota;
    }

    public int getSegNota() {
        return segNota;
    }

    public void setSegNota(int segNota) {
        this.segNota = segNota;
    }

    public int getTerNota() {
        return terNota;
    }

    public void setTerNota(int terNota) {
        this.terNota = terNota;
    }

    public int getTotNota() {
        return totNota;
    }

    public void setTotNota(int totNota) {
        this.totNota = totNota;
    }
}