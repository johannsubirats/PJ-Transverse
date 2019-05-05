package com.example.ecosystem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Déchets";
    private static final String COL1 = "ID";
    private static final String COL2 = "objet";
    private static final String COL3 = "poubelle";
    private static final String COL4 = "info";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    /*
    override onCreate crée la table lorsqu'elle n'existe pas
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL2 +" TEXT , "+ COL3 +" TEXT, "+ COL4 +" TEXT)";
        db.execSQL(createTable);
    }

    /*
    override onUpgrade prend un la table qui existe deja
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*
     * ajoute un produit dans un base de donnée
     */

    public boolean addData(String objet, String poubelle, String info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, objet);
        contentValues.put(COL3, poubelle);
        contentValues.put(COL4, info);

        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    /*
     * Return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(  query, null);
        return data;
    }


    /**
     * Updates
     * @param newName
     * @param id
     * @param oldName

    public void update(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }
     */

    /*
     * Delete
     */
    public void deleteData(int id, String objet){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL1 + " = '" + id + "'" + " AND " + COL2 + " = '" + objet + "'";
        db.execSQL(query);
    }

    /*
     * ListDATA
     */
    public ArrayList<String> getAll() {
        ArrayList<String> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Déchets" , null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            list.add(res.getString(res.getColumnIndex(COL1)));
            res.moveToNext();
        }

        //ListAdapter adapter = new ArrayAdapter<String>(YourActivityName.this, android.R.layout.simple_list_item_1, list);
        //mListView.setAdapter(adapter);
        return list;
    }
}