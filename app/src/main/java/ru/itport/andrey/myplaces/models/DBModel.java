package ru.itport.andrey.myplaces.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by andrey on 2/5/18.
 */

public class DBModel {
    String tableName;

    public void parseRow(Cursor cursor) {

    }

    public String getTableName() {
        return this.tableName;
    }

}
