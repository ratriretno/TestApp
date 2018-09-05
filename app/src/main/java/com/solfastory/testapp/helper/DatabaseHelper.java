package com.solfastory.testapp.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.solfastory.testapp.model.LoginModel;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "TestApp.db";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insertLogin (Context context, String email, String password, Boolean login){
        DatabaseHelper mDbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Login.COLUMN_EMAIL, email);
        values.put(DatabaseContract.Login.COLUMN_PASSWORD, password);
        values.put(DatabaseContract.Login.COLUMN_STATUS_LOGIN, login.toString());

        long newRowId = db.insert(DatabaseContract.Login.TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    public LoginModel getLogin (Context context){
        DatabaseHelper mDbHelper = new DatabaseHelper(context);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                DatabaseContract.Login.COLUMN_EMAIL,
                DatabaseContract.Login.COLUMN_PASSWORD,
                DatabaseContract.Login.COLUMN_STATUS_LOGIN
        };

        String sortOrder = DatabaseContract.Login._ID + " DESC";

        Cursor cursor = db.query(
                DatabaseContract.Login.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
             null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        LoginModel model = new LoginModel();
        while(cursor.moveToNext()) {
            model.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Login.COLUMN_EMAIL)));
            model.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Login.COLUMN_PASSWORD)));
            model.setLoginStatus(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Login.COLUMN_STATUS_LOGIN))));
            Log.d("login", model.getEmail() + model.isLoginStatus() +cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.Login.COLUMN_STATUS_LOGIN)));
        }
        cursor.close();
        db.close();

        return model;
    }
}