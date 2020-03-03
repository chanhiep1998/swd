package com.example.dental.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dental.R;
import com.example.dental.fragments.AccountFragment;
import com.example.dental.fragments.CalendarFragment;
import com.example.dental.fragments.HomeFragment;
import com.example.dental.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.navigation_notification:
                fragment = new NotificationFragment();
                break;
            case R.id.navigation_calendar:
                fragment = new CalendarFragment();
                break;
            case R.id.navigation_account:
                fragment = new AccountFragment();
                break;
            default:
                fragment = new HomeFragment();
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment (Fragment fragment) {
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }


    public void clickToDetail(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailedActivity.class);

        TextView clinicName = (TextView) findViewById(R.id.itemNameTextView);
        intent.putExtra("Name",clinicName.getText());
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
