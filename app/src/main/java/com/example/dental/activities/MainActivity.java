package com.example.dental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dental.R;
import com.example.dental.fragments.AccountFragment;
import com.example.dental.fragments.HomeFragment;
import com.example.dental.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setItemIconTintList(null);
        bottom_navigation.setOnNavigationItemSelectedListener(this);
//        BottomNavigationMenuView view = (BottomNavigationMenuView) bottom_navigation.getChildAt(1);
//        View v = view.getChildAt(1);
//        BottomNavigationItemView itemView = (BottomNavigationItemView) v;
//        itemView.removeViewAt(itemView.getChildCount() - 1);

        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottom_navigation.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(3);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        View badge = LayoutInflater.from(this)
                .inflate(R.layout.notification_badge, itemView, true);

        loadFragment(new HomeFragment());
    }

    public void setBottomNavBarIconSelected(String icon) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.navigation_notification:
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
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);

        TextView id = (TextView) findViewById(R.id.itemId);
        TextView name = (TextView) findViewById(R.id.itemNameTextView);
        TextView oldPrice = (TextView) findViewById(R.id.itemOldPriceTextView);
        TextView price = (TextView) findViewById(R.id.itemPriceTextView);
        TextView description = (TextView) findViewById(R.id.itemDescriptionTextView);
        TextView discount = (TextView) findViewById(R.id.itemDiscountTextView);


        intent.putExtra("clinicId", id.getText());
        intent.putExtra("clinicName", name.getText());
        intent.putExtra("clinicOldPrice", oldPrice.getText());
        intent.putExtra("clinicPrice", price.getText());
        intent.putExtra("clinicDescription", description.getText());
        intent.putExtra("clinicDiscount", discount.getText());
        intent.putExtra("clinicImage", discount.getText());

        intent.putExtra("isClinic","service");
        startActivity(intent);
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
