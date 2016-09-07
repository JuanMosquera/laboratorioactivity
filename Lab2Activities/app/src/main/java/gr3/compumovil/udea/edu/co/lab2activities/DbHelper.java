package gr3.compumovil.udea.edu.co.lab2activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by johnny.castaneda on 2/09/16.
 */
public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, StatusContract.DB_NAME, null, StatusContract.DB_VERSION);
        //
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String
                .format("create table %s (%s text primary key, %s text, %s text, %s text, %s text);",
                        StatusContract.TABLE_USER,
                        TablaUsuario.USER,
                        TablaUsuario.AGE,
                        TablaUsuario.EMAIL,
                        TablaUsuario.PASSWORD,
                        TablaUsuario.PHOTO);
        //Sentencia para crear tabla
        Log.d("TAG", "onCreate with SQL: " + sql);
        db.execSQL(sql); //Ejecución de la sentencia

        String sql2 = String
                .format("create table %s (%s text primary key, %s text, %s text, %s text, %s text);",
                        StatusContract.TABLE_PLACE,
                        TablaLugares.NAME,
                        TablaLugares.INFO,
                        TablaLugares.LOCATION,
                        TablaLugares.TEMP,
                        TablaLugares.SITES);
        //Sentencia para crear tabla
        Log.d("TAG", "onCreate with SQL: " + sql);
        db.execSQL(sql2); //Ejecución de la sentencia
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Por simplicidad se borran los datos y se crea la tabla de nuevo. Usualmente se haría un ALTER TABLE para cambiar la estructura de la base de datos sin borrar los existentes */
        /*db.execSQL("drop table if exists " + StatusContract.TABLE_USER); //Borrar tabla
        db.execSQL("drop table if exists " + StatusContract.TABLE_PLACE); //Borrar tabla
        onCreate(db);//Crear tabla de nuevo*/
        Log.d("TAG", "onUpgrade");
    }
}
