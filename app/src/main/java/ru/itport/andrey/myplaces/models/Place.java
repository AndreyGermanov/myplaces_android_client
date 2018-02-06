package ru.itport.andrey.myplaces.models;

import android.database.Cursor;
import android.util.Log;

/**
 * Created by andrey on 2/5/18.
 */

public class Place extends DBModel {

    String name;
    String id;
    double lat;
    double lng;
    String description;
    String tableName;

    public void parseRow(Cursor cursor) {
        this.name = cursor.getString(cursor.getColumnIndex("name"));
        this.id = cursor.getString(cursor.getColumnIndex("id"));
        this.lat = cursor.getDouble(cursor.getColumnIndex("lat"));
        this.lng = cursor.getDouble(cursor.getColumnIndex("lng"));
        this.description = cursor.getString(cursor.getColumnIndex("description"));
    }

    public Place() {
        this.tableName = "places";
    }

    public String getTableName() {
        return this.tableName;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

}
