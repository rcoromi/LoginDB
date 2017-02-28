package com.es.coro.logindb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rachel on 16/02/2017.
 */

public class BaseDatosReg extends SQLiteOpenHelper {

    private int fechaActual = Calendar.DATE;
    private static final String SQL_CREA_TABLA_USUARIOS = "create table USUARIOS (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, password TEXT,UNIQUE (nombre))";
    private static final String SQL_CREA_TABLA_IMCS = "create table IMCS (fecha INTEGER, imcs DECINAL, id_usuario INTEGER, PRIMARY KEY (id_usuario,fecha), FOREIGN KEY (id_usuario) REFERENCES USUARIOS (id))";

    public BaseDatosReg(Context context, String nombre, SQLiteDatabase.CursorFactory cursor, int version) {
        super(context, nombre, cursor, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREA_TABLA_USUARIOS);
        sqLiteDatabase.execSQL(SQL_CREA_TABLA_IMCS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertarusuarios(Usuarios usuarios) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("Insert into Usuarios ( nombre, password) values ('" + usuarios.getNombre() + "', " + usuarios.getPassword() + ")");
        sqLiteDatabase.close();
    }

    public void insertarimcs(Imcs imcs) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("Insert into Imcs (fecha,imc, id_usuario) values ('" + imcs.getFecha() + "', '" + imcs.getImcs() + "' , '" +imcs.getId_usuario()+"' )");
        sqLiteDatabase.close();
    }

    public String consultar_usuarios(Usuarios usuarios) {

        String consulta = "select password from USUARIOS where nombre=" + usuarios.getNombre();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);
        String password = null;
        if ((cursor != null) && (cursor.getCount() > 0))
        {
            cursor.moveToFirst();

            password = cursor.getString(1);
            sqLiteDatabase.close();
        }
        return password;
    }
}
