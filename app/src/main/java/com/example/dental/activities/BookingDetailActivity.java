package com.example.dental.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.dental.R;
import com.example.dental.activities.thaotest.LoadingCancelDialog;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BookingDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LocationManager locationManager;

    LocationListener locationListener;

    LatLng clinic;

    TextView clinicAddress;

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        clinicAddress = findViewById(R.id.clinicAddressTextView);
        cancelButton = findViewById(R.id.activity_booking_detail_btnHuy);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingCancelDialog loading = new LoadingCancelDialog(BookingDetailActivity.this);
                loading.startDialog();
            }
        });
    }

    public Button getCancelButton() {
        return this.cancelButton;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {


                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                }
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        // Add a marker in Sydney and move the camera
        clinic = new LatLng(10.792085, 106.673578);

        mMap.addMarker(new MarkerOptions().position(clinic).title("Nha Khoa Lan Anh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(clinic, 15));


        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());


        try {
            List<Address> listAddresses = geocoder.getFromLocation(10.792085, 106.673578, 1);

            if (listAddresses != null && listAddresses.size() > 0) {
                Log.i("PlaceInfo", listAddresses.get(0).toString());
                clinicAddress.setText(listAddresses.get(0).getAddressLine(0));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };


    }

    public void clickToDialFromNotification(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0915223623"));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "NOT GRANTED", Toast.LENGTH_LONG).show();
            String[] permissions = {Manifest.permission.CALL_PHONE};
            requestPermissions(permissions, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            startActivity(intent);
        }
    }

    public void clickToTravelFromNotification(View view) {
        Intent intent = new Intent(getApplicationContext(), TravelActivity.class);
        startActivity(intent);
    }
}
