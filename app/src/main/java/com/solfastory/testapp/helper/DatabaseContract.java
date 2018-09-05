package com.solfastory.testapp.helper;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Login.TABLE_NAME + " (" +
                    Login._ID + " INTEGER PRIMARY KEY," +
                    Login.COLUMN_EMAIL + " TEXT," +
                    Login.COLUMN_PASSWORD + " TEXT," +
                    Login.COLUMN_STATUS_LOGIN + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Login.TABLE_NAME;

    private DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static class Login implements BaseColumns {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_EMAIL= "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_STATUS_LOGIN = "status_login";
    }
}

