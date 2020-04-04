package com.example.dental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.fragments.AccountFragment;
import com.example.dental.fragments.HomeFragment;
import com.example.dental.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView textBadge;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (SaveSharedPreference.getUserName(MainActivity.this).length() == 0) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {

            Intent intent = getIntent();
            token = intent.getStringExtra("token");
            token = SaveSharedPreference.getUserName(MainActivity.this);
            Toast.makeText(this, SaveSharedPreference.getUserId(MainActivity.this), Toast.LENGTH_LONG).show();

            String tempNotification = "";
            if (intent.getStringExtra("notification") != null) {
                tempNotification = intent.getStringExtra("notification");
            }
            BottomNavigationView bottom_navigation = findViewById(R.id.bottom_navigation);

            bottom_navigation.setItemIconTintList(null);
            bottom_navigation.setOnNavigationItemSelectedListener(this);
//        BottomNavigationMenuView view = (BottomNavigationMenuView) bottom_navigation.getChildAt(1);
//        View v = view.getChildAt(1);
//        BottomNavigationItemView itemView = (BottomNavigationItemView) v;
//        itemView.removeViewAt(itemView.getChildCount() - 1);

            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) bottom_navigation.getChildAt(0);

            View v = bottomNavigationMenuView.getChildAt(1);

            BottomNavigationItemView itemView = (BottomNavigationItemView) v;

            if (tempNotification.length() > 0) {
                View badge = LayoutInflater.from(this).inflate(R.layout.fragment_notification_badge, itemView, true);
                textBadge = badge.findViewById(R.id.badgeTextView);
                textBadge.setText("1");
            }


            Bundle bundle = new Bundle();
            bundle.putString("token", token);
            HomeFragment fragment = new HomeFragment();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }


    }

    public String getToken() {
        return token;
    }


    public void setBottomNavBarIconSelected(String icon) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.navigation_notification:
                if (textBadge != null) {
                    textBadge.setVisibility(View.GONE);
                }
                fragment = new NotificationFragment();
                break;

            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;

            default:
                fragment = new HomeFragment();
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    public void clickToDetail(View view) {


        TextView id = findViewById(R.id.itemId);
        Toast.makeText(getApplicationContext(), "test " + id.getText().toString(), Toast.LENGTH_LONG).show();
        TextView name = findViewById(R.id.itemNameTextView);
        TextView oldPrice = findViewById(R.id.itemOldPriceTextView);
        TextView price = findViewById(R.id.itemPriceTextView);
        TextView description = findViewById(R.id.itemDescriptionTextView);
        TextView discount = findViewById(R.id.itemDiscountTextView);

        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
        intent.putExtra("clinicId", id.getText());
        intent.putExtra("clinicName", name.getText());
        intent.putExtra("clinicOldPrice", oldPrice.getText());
        intent.putExtra("clinicPrice", price.getText());
        intent.putExtra("clinicDescription", description.getText());
        intent.putExtra("clinicDiscount", discount.getText());
        intent.putExtra("clinicImage", discount.getText());

        intent.putExtra("isClinic", "service");
        startActivity(intent);
    }

    public void clickToSearch(View view) {
        startActivity(new Intent(this, SearchActivity.class));
    }


//    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);
//            intent.putExtra("Name","Niec");
//            startActivity(intent);
//        }
//    };


}
