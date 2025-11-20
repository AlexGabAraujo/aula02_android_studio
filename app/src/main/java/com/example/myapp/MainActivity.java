package com.example.myapp;

import android.annotation.SuppressLint;
import android.app.LocaleManager;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.Manifest;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    private static final String TAG = "MainActivity";
    MapView mapView;
    TextView textView;
    private LocationManager locationManager;
    Button btnGetLocation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Configuration.getInstance().setUserAgentValue(getPackageName());
        mapView = findViewById(R.id.mapView);
        textView = findViewById(R.id.textView); // Inicializando textView
        btnGetLocation = findViewById(R.id.button);
        btnGetLocation.setOnClickListener(v -> checkAndGetLocation());
    }

    private void checkAndGetLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            requestLocationPermission();
            return;
        }
        getLocation();
    }

    public void getLocation() {
        try {
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, location1 -> {
                double latitude = location1.getLatitude();
                double longitude = location1.getLongitude();
                textView.setText("Latitude: " + latitude + ", Longitude: " + longitude);
                showLocationOnMap(latitude, longitude);
            });
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                if (textView != null) {
                    textView.setText("Latitude: " + latitude + ", Longitude: " + longitude);
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void showLocationOnMap(double latitude, double longitude){
        GeoPoint userLocation = new GeoPoint(latitude, longitude);

        mapView.getController().setCenter(userLocation);
        mapView.getController().setCenter(userLocation);

    }
    public void requestLocationPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION);
    }
}
