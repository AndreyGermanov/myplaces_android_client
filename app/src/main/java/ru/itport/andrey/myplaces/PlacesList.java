package ru.itport.andrey.myplaces;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ru.itport.andrey.myplaces.models.Place;
import ru.itport.andrey.myplaces.models.PlacesApplication;
import ru.itport.andrey.myplaces.models.PlacesDBHelper;

public class PlacesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);
        PlacesApplication app = PlacesApplication.getApplication(getBaseContext());
    }
}
