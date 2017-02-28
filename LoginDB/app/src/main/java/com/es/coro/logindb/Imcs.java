package com.es.coro.logindb;

/**
 * Created by Rachel on 16/02/2017.
 */

public class Imcs {

    private int id_usuario;
    private int fecha;
    private float imcs;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public float getImcs() {
        return imcs;
    }

    public void setImcs(float imcs) {
        this.imcs = imcs;
    }

    public Imcs(int id_usuario, int fecha, float imcs) {
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.imcs = imcs;
    }
}
