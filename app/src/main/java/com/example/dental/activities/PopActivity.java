package com.example.dental.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.BookingTimeAdapter;
import com.example.dental.models.BookingTimeModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;
import com.nineoldandroids.animation.ValueAnimator;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.example.dental.R.id.bookingDateFragment;

public class PopActivity extends AppCompatActivity implements ClinicView {

    TextView name, oldPrice, price, description, discount;
    ImageView image;
    ClinicPresenter presenter;
    Spinner spinner1;
    boolean toggle = false;
    String[] Price = new String[]{
            "100k",
            "200k",
            "300k",
            "400k"
    };
    String[] BookingTime = new String[]{
            "9:00",
            "10:00",
            "10:30",
            "11:00",
            "11:30",
            "13:00",
            "14:30",
            "15:30",
            "16:30",
            "17:00",
            "19:00",
            "20:00"
    };


    List<Integer> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.fragment_service_detail);
        name = findViewById(R.id.itemNameTextView);
        oldPrice = findViewById(R.id.itemOldPriceTextView);
        price = findViewById(R.id.itemPriceTextView);
        description = findViewById(R.id.itemDescriptionTextView);
        discount = findViewById(R.id.itemDiscountTextView);
        image = findViewById(R.id.itemImage);
        people = new ArrayList<>();
        people.add(0);
        people.add(0);
        people.add(0);
        people.add(3);
        people.add(5);
        people.add(8);
        people.add(0);
        people.add(0);
        people.add(0);
        people.add(0);
        people.add(0);
        people.add(0);
        Collections.shuffle(people);

//        spinnerWithTextView = (Spinner)findViewById(R.id.spinner);
//
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                this,R.layout.textview_layout,Subject );
//
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.textview_layout);
//
//        spinnerWithTextView.setAdapter(spinnerArrayAdapter);

//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int) (width * 1), (int) (height * .8));

        presenter = new ClinicPresenter(this, this);
        presenter.getClinicById();
        addItemsOnSpinner1();
        RelativeLayout close = findViewById(R.id.closeRelativeLayout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        // ...but notify us that it happened.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_OUTSIDE == event.getAction()) {
            finish();
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void addItemsOnSpinner1() {

        spinner1 = findViewById(R.id.spinner1);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(bookingDateFragment);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(dataAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), "Hi: " + spinner1.getSelectedItem(), Toast.LENGTH_SHORT).show();
//                fragment.getView().setVisibility(View.GONE);
                ArrayList<BookingTimeModel> tempList = new ArrayList<>();
                Random rd = new Random();
                Collections.shuffle(people);
                for (int i = 0; i < 12; i++) {
                    tempList.add(new BookingTimeModel(BookingTime[i], Price[rd.nextInt(4)], people.get(i)));
                }

                BookingTimeAdapter adapter = new BookingTimeAdapter(getApplicationContext(), tempList);
                RecyclerView bookingTime = findViewById(R.id.bookingTimeList);
                Log.i("result", tempList.get(0).getTime());
                bookingTime.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        final TextView showMore = findViewById(R.id.showMoreTextView);
        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!toggle) {
                    clickToShowMore(300);
                    toggle = !toggle;
                    showMore.setText("Xem ít hơn");
                } else {
                    clickToShowMore(100);
                    toggle = !toggle;
                    showMore.setText("Xem thêm");
                }

            }
        });
    }

    @Override
    public void getAllClinic(List<ClinicModel> listResult) {

    }

    @Override
    public void getMostLikedClinics(List<ClinicModel> listResult) {

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
        description.setText(result.getDescription());
        oldPrice.setText(String.format("%,d", result.getOldPrice()) + " đ");
        price.setText(String.format("%,d", result.getPrice()) + " đ");
        discount.setText(result.getDiscountPercent() + "%");

        if (result.getImage() != null) {
            Picasso.get().load(result.getImage()).into(image);
        }
    }

    public void clickToShowMore(int height) {
        final TextView textPolicy = findViewById(R.id.policy);
        ValueAnimator anim = ValueAnimator.ofInt(textPolicy.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = textPolicy.getLayoutParams();
                layoutParams.height = val;
                textPolicy.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }
}
