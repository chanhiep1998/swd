package com.example.dental.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.dental.R;
import com.example.dental.fragments.ClinicBottomSheetFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.maps.android.ui.IconGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TravelActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    LocationManager locationManager;

    LocationListener locationListener;

    LatLng clinic;

    List<Marker> clinics;

    LatLng userLatLgn;

    Geocoder geocoder;

    Marker userMarker;

    Polyline line;

    float zIndex = 0;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 10, locationListener);

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        clinics = new ArrayList<>();
        clinic = new LatLng(10.792085, 106.673578);

        addNewClinicMarker("Nha Khoa Lan Anh", clinic, R.drawable.banner1);


//        mMap.addMarker(new MarkerOptions().position(clinic).title("Nha Khoa Lan Anh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();
//        mMap.addMarker(new MarkerOptions().position(clinic1).title("Peace").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();
//        mMap.addMarker(new MarkerOptions().position(clinic2).title("Full house").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();
//        mMap.addMarker(new MarkerOptions().position(clinic3).title("Nha Khoa Kim").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();
//        mMap.addMarker(new MarkerOptions().position(clinic4).title("Nha Khoa Shoryuken").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();

        geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());

                if (userMarker != null) {
                    userMarker.remove();
                }

                userMarker = mMap.addMarker(new MarkerOptions().position(userLocation).title("Bạn đang ở đây"));

                userMarker.showInfoWindow();

                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    if (listAddresses != null && listAddresses.size() > 0) {
                        Log.i("PlaceInfo", listAddresses.get(0).toString());
                        Toast.makeText(getApplicationContext(), listAddresses.get(0).getAddressLine(0), Toast.LENGTH_SHORT).show();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

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


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        } else {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 10, locationListener);

            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            LatLng userLocation = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());

            userLatLgn = userLocation;

            userMarker = mMap.addMarker(new MarkerOptions().position(userLocation).title("Bạn đang ở đây"));


//            LatLngBounds fromUserToClinic = new LatLngBounds(
//                    clinic, userLatLgn);


            float[] results = new float[1];
            Location.distanceBetween(clinic.latitude, clinic.longitude,
                    userLocation.latitude, userLocation.longitude, results);


            float zoomLevel = getZoomLevel(results[0] / 1000);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(userLatLgn)
                    .zoom(18)                   // Sets the zoom
                    .bearing(210)                // Sets the orientation of the camera to east
                    .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                    .build();                   // Creates a CameraPosition from the builder
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


            userMarker.showInfoWindow();

            mMap.addPolyline(new PolylineOptions()
                    .add(userLatLgn, new LatLng(10.7919, 106.6722), clinic)
                    .width(30)
                    .color(Color.parseColor("#4fc3f7"))
                    .startCap(new ButtCap())
                    .endCap(new RoundCap()));

        }
    }

    public void addNewClinicMarker(String clinicName, LatLng clinicLatLng, int imageResource) {


        TextView text = new TextView(getApplicationContext());
        LinearLayout layout = new LinearLayout(this);
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setImageResource(imageResource);

        text.setTextColor(Color.BLACK);
        text.setTextSize(18);
        text.setPadding(10, 0, 10, 0);
        text.setTypeface(Typeface.DEFAULT_BOLD);
        text.setText(clinicName);
        layout.addView(image);
        layout.addView(text);

        image.getLayoutParams().height = 100;
        image.getLayoutParams().width = 100;
        IconGenerator generator = new IconGenerator(getApplicationContext());
        generator.setBackground(getApplicationContext().getDrawable(R.drawable.bubble_mask));
        generator.setColor(Color.WHITE);
//        generator.setContentView(text);
        generator.setContentView(layout);
        generator.setContentPadding(5, 5, 5, 5);
        Bitmap icon = generator.makeIcon();

        MarkerOptions tp = new MarkerOptions().position(clinicLatLng).icon(BitmapDescriptorFactory.fromBitmap(icon)).alpha(0.7f);
        mMap.addMarker(tp);
        Marker clinic = mMap.addMarker(tp);
        clinics.add(clinic);
    }


    public String getClinicAddress(LatLng clinicLatlgn) {
        String result = "";
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        try {
            List<Address> listAddresses = geocoder.getFromLocation(clinicLatlgn.latitude, clinicLatlgn.longitude, 1);

            if (listAddresses != null && listAddresses.size() > 0) {
                Log.i("ClinicInfo", listAddresses.get(0).toString());
                result = listAddresses.get(0).getAddressLine(0);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getZoomLevel(double radius) {
        double scale = radius / 500;
        return ((int) (8 - Math.log(scale) / Math.log(2)));
    }

}
