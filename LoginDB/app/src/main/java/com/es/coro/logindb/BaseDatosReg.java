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
    private static final String SQL_CREA_TABLA_IMCS = "create table IMCS (fecha INTEGER, imc DECINAL, id_usuario INTEGER, PRIMARY KEY (id_usuario,fecha), FOREING KEY (id_usuario) REFERENCES USUARIOS (id))";

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

    public void insertarcoche(Usuarios usuarios) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("Insert into Coche (modelo, id_persona) values ('" + usuarios.getModelo() + "', " + coche.getPersona().getId() + ")");
        sqLiteDatabase.close();

    }

    public void insertarpersona(Imcs imcs) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("Insert into Persona (modelo, id_persona) values ('" + imcs.getId() + "', '" + persona.getNombre() + "')");
        sqLiteDatabase.close();

    }

    public List<Usuarios> consultarcoches_xpersona(Imcs imcs) {

        List<Usuarios> cocheList = null;

        String consulta = "select modelo from Coche where id_persona=" + persona.getId();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);

        if ((cursor != null) && (cursor.getCount() > 0)) {
            //tnemos datos
            cursor.moveToFirst();
            cocheList = new ArrayList<>(Usuarios);
            String modelo = null;
            Coche coche = null;
            do {

                cursor.getString(0);
                coche = new Coche(modelo);
                cocheList.add(coche);

            } while (cursor.moveToNext());
            cursor.close();

        }

        sqLiteDatabase.close();
        return cocheList;
    }
}
