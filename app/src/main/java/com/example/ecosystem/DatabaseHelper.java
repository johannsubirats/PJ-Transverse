package com.example.ecosystem;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String TAG = "TEST.db";

    private static final String TABLE_NAME = "TEST";
    private static final String COL1 = "Name";


    public DatabaseHelper(Context context) {

        super(context, TAG, null, 1);
    }
}