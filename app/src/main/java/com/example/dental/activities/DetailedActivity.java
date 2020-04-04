package com.example.dental.activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.fragments.ClinicPromotionFragment;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nineoldandroids.animation.ValueAnimator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DetailedActivity extends AppCompatActivity implements ClinicView, OnMapReadyCallback {
    TextView name, clinicDescription, oldPrice, price, description, discount;
    ClinicPresenter presenter;
    ImageView image;

    ServiceModel model;

    boolean toggle = false;

    private GoogleMap mMap;

    LocationManager locationManager;

    LocationListener locationListener;

    TextView timeAndDistance;

    TextView clinicAddress;

    LatLng clinic;

    Button dial;

    Geocoder geocoder;

    Dialog dialog;

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        dial = findViewById(R.id.dialButton);

//        Intent intent = getIntent();
//        String clinicName = intent.getStringExtra("clinicId");
//
//         name =  findViewById(R.id.itemNameTextView);
//         oldPrice =  findViewById(R.id.itemOldPriceTextView);
//         price =  findViewById(R.id.itemPriceTextView);
//         description =  findViewById(R.id.itemDescriptionTextView);
//         discount =  findViewById(R.id.itemDiscountTextView);
//         image = (ImageView) findViewById(R.id.itemImage);
//
//        name.setText(intent.getStringExtra("clinicName"));
//        oldPrice.setText(intent.getStringExtra("clinicOldPrice"));
//        price.setText(intent.getStringExtra("clinicPrice"));
//        description.setText(intent.getStringExtra("clinicDescription"));
//        discount.setText(intent.getStringExtra("clinicDiscount"));


        Intent intent = getIntent();
        String isClinic = intent.getStringExtra("isClinic");
        String clinicId = intent.getStringExtra("id");
        model = (ServiceModel) intent.getSerializableExtra("serviceObj");
        presenter = new ClinicPresenter(this, this);
        presenter.getServicesByClinicId(SaveSharedPreference.getUserName(this), model.getClinic().getId());

        ClinicPromotionFragment fragment = (ClinicPromotionFragment) getSupportFragmentManager().findFragmentById(R.id.clinicFragmentPromotion);
        fragment.setModel(model);

        timeAndDistance = findViewById(R.id.timeAndDistanceTextView);
        clinicAddress = findViewById(R.id.clinicAddressTextView);
        name = findViewById(R.id.clinicNameTextView);
        clinicDescription = findViewById(R.id.textClinicDescription);

        clinicDescription.setText(HtmlCompat.fromHtml(getResources().getString(R.string.clinic_description), HtmlCompat.FROM_HTML_MODE_LEGACY));
        name.setText(model.getClinic().getName());
        clinicAddress.setText(model.getClinic().getAddress());
        clinic = new LatLng(model.getClinic().getLatitude(), model.getClinic().getLongtitude());


        if (!isClinic.equalsIgnoreCase("clinic")) {

            Intent popIntent = new Intent(this, PopActivity.class);
            popIntent.putExtra("serviceObj", model);
            startActivity(popIntent);
//        dialog = new Dialog(this);
//        showPopup();

        }

        final TextView showMore = findViewById(R.id.showAllTextView);
        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!toggle) {
                    clickToShowMore(ViewGroup.LayoutParams.WRAP_CONTENT);
                    toggle = !toggle;
                    showMore.setText("Đóng");
                } else {
                    clickToShowMore(0);
                    toggle = !toggle;
                    showMore.setText("Xem toàn bộ thông tin");
                }

            }
        });
    }


    // get the selected dropdown list value


    public void clickToClose(View view) {
        this.finish();
    }


    @Override
    public void getAllClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getAllServices(List<ServiceModel> listResult) {

    }

    @Override
    public void getServicesByClinicId(List<ServiceModel> listResult) {
        ArrayList<ServiceModel> tempList = new ArrayList<>();
        for (ServiceModel service : listResult) {
            ServiceModel model = new ServiceModel();

        }

    }

    @Override
    public void getMostDiscountClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getNearbyClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getClinicById(ClinicModel result) {

        name.setText(result.getName());
//        description.setText(result.getDescription());
//        oldPrice.setText(String.format("%,d", result.getOldPrice()) + " đ");
//        price.setText(String.format("%,d", result.getPrice()) + " đ");
//        discount.setText(result.getDiscountPercent());
//
//        if (result.getImage() != null) {
//            Picasso.get().load(result.getImage()).into(image);
//        }


    }

    @Override
    public void getClinicByIdNew(ClinicModel result) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;


        mMap.addMarker(new MarkerOptions().position(clinic).title(model.getClinic().getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))).showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(clinic, 15));

        geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        try {

            List<Address> listAddresses = geocoder.getFromLocation(clinic.latitude, clinic.longitude, 1);

            if (listAddresses != null && listAddresses.size() > 0) {

                clinicAddress.setText(listAddresses.get(0).getAddressLine(0));

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                float[] results = new float[1];
                Location.distanceBetween(clinic.latitude, clinic.longitude,
                        userLocation.latitude, userLocation.longitude, results);
                String distance = "";

                float timeTravel = 0;

                if (results[0] < 1000) {
                    distance = Math.round(results[0]) + " m";
                } else {
                    distance = Math.round(results[0] / 1000) + " km";

                }
                timeTravel = results[0] / 1000 / 20 * 60;
                timeAndDistance.setText(Math.round(timeTravel) + " phút" + " - " + distance);


                Log.i("Distance", distance);


                try {
                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    if (listAddresses != null && listAddresses.size() > 0) {
                        Log.i("PlaceInfo", listAddresses.get(0).toString());
//                        Toast.makeText(getApplicationContext(), listAddresses.get(0).getAddressLine(0), Toast.LENGTH_SHORT).show();
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
            mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
        }

    }

    public void clickToDial(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + model.getClinic().getPhone().trim()));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "NOT GRANTED", Toast.LENGTH_LONG).show();
            String[] permissions = {Manifest.permission.CALL_PHONE};
            requestPermissions(permissions, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            startActivity(intent);
        }
    }

    public void clickToTravel(View view) {
        Intent intent = new Intent(getApplicationContext(), TravelActivity.class);
        startActivity(intent);
    }

    public void clickToSearchService(View view) {
        Intent intent = new Intent(this, SearchServiceActivity.class);
        intent.putExtra("clinicId", model.getClinic().getId() + "");
        startActivity(intent);
    }

    public void clickToShowMore(int height) {
        ValueAnimator anim = ValueAnimator.ofInt(clinicDescription.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = clinicDescription.getLayoutParams();
                layoutParams.height = val;
                clinicDescription.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }

//    public void showPopup () {
//        dialog.setContentView(R.layout.fragment_service_detail);
//        startActivity(new Intent(this, PopActivity.class));
//        dialog.show();
//    }
}

