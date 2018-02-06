package ru.itport.andrey.myplaces.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;

/**
 * Created by andrey on 2/5/18.
 */

public class PlacesDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "places.db";
    public static final String CREATE_DB_SQL = "CREATE TABLE places (id TEXT PRIMARY KEY,name TEXT, description TEXT, lat INTEGER, lng INTEGER);"+
                                               "CREATE TABLE photos (id TEXT PRIMARY KEY,description TEXT,place_id TEXT, FOREIGN KEY  (place_id) "+
                                                "REFERENCES places (id) ON DELETE CASCADE ON UPDATE CASCADE";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public PlacesDBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public <T extends DBModel> T[] getList(Class<T> cls) {
        T model;
        try {
            model = cls.newInstance();
            String tableName = model.getTableName();
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);
            T[] result = (T[]) Array.newInstance(cls, cursor.getCount());
            int counter = 0;
            while (cursor.moveToNext()) {
                model.parseRow(cursor);
                result[counter++] = model;
            }
            return result;
        } catch (Exception e) {
            Log.e("placesapi",e.getMessage());
            return null;
        }
    }


}
