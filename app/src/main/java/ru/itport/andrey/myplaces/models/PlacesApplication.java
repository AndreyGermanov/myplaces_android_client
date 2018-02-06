package ru.itport.andrey.myplaces.models;

import android.content.Context;

/**
 * Created by andrey on 2/5/18.
 */

public class PlacesApplication {
    public static PlacesApplication shared = new PlacesApplication();

    public PlacesDBHelper dbHelper;
    private Context context;
    static boolean initialized = false;

    private PlacesApplication() {

    }

    public static PlacesApplication getApplication(Context context) {
        if (!PlacesApplication.initialized && context != null) {
            PlacesApplication.shared.context = context;
            PlacesApplication.shared.dbHelper = new PlacesDBHelper(PlacesApplication.shared.context);
            PlacesApplication.initialized = true;
        }
        return PlacesApplication.shared;
    }

}
