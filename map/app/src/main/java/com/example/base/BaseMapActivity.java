package com.example.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.example.map.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public abstract class BaseMapActivity extends BaseActivity {
    protected MapView mapView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Mapbox.getInstance(this, "pk.eyJ1Ijoicm9qc2FzaGEiLCJhIjoiY2p6MTB6ZjI2MGd4aTNlbXl4Mzd5YTV1dSJ9.uf5mvNIAZZEg4UpGGd5w7Q");
        super.onCreate(savedInstanceState);
        initViews();
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    private void initViews() {
        mapView = findViewById(R.id.mapView);
    }
}
