package com.es.coro.logindb;

/**
 * Created by Rachel on 16/02/2017.
 */

public class Usuarios {

    private int id;
    private String nombre;
    private String password;

    public Usuarios(String nombre, String password) {

        this.nombre = nombre;
        this.password = password;
    }

    public Usuarios() {
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

    public String getPassword() {
        return password;
    }

    public void setUser(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
}