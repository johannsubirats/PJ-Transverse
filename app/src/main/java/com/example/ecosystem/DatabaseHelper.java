package com.example.ecosystem;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String TAG = "OBJET.db";

    public static final String TABLE_NAME = "objet";
    public static final String COL1 = "ID";
    public static final String COL2 = "Produit";
    public static final String COL3 = "Poubelle";
    public static final String COL4 = "Description";


    public DatabaseHelper(Context context) {

        super(context, TAG, null, 1);
    }

    public static Cursor getID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}