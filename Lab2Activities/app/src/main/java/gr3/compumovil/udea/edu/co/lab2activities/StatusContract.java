package gr3.compumovil.udea.edu.co.lab2activities;

import android.provider.BaseColumns;

/**
 * Created by johnny.castaneda on 2/09/16.
 */
public class StatusContract {

    public static final String DB_NAME = "timeline.db"; //Nombre de la DB
    public static final int DB_VERSION = 1; //Versión de la DB
    public static final String TABLE_USER = "TablaUsuario"; //Nombre de la tabla
    public static final String TABLE_PLACE = "TablaLugares"; //Nombre de la tabla

    public class TablaLugares {

        public static final String NAME = BaseColumns._ID;
        public static final String INFO = "info";
        public static final String LOCATION = "location";
        public static final String TEMP = "temp";
        public static final String SITES = "sites";

    }

    public class TablaUsuario {

        public static final String USER = BaseColumns._ID;
        public static final String PASSWORD = "password";
        public static final String EMAIL = "email";
        public static final String AGE = "age";
        public static final String PHOTO = "photo";        ;
    }
}

