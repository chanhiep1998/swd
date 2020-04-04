package com.example.dental.activities;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.BookingTimeAdapter;
import com.example.dental.models.BookingTimeModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
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

    TextView id, name, oldPrice, price, description, discount, serviceDescription;
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
        id = findViewById(R.id.itemId);
        name = findViewById(R.id.itemNameTextView);
        oldPrice = findViewById(R.id.itemOldPriceTextView);
        price = findViewById(R.id.itemPriceTextView);
        description = findViewById(R.id.itemDescriptionTextView);
        discount = findViewById(R.id.itemDiscountTextView);
        serviceDescription = findViewById(R.id.textServiceDescription);

        String des = "<h2 style=\"background: #3399FF; padding: 5px 15px; margin: 15px 0px; color: #ffffff; display: table;\"><span id=\"I_Truong_hop_nao_nen_tram_rang_tham_my\"><span style=\"font-size: 12pt;\"><b>I. Trường hợp nào nên trám răng thẩm mỹ?&nbsp;&nbsp;</b></span></span></h2>\n" +
                "<p style=\"text-align: justify;\">Trám răng là kỹ thuật nha khoa mà bác sỹ sẽ sử dụng vật liệu trám răng (thường là composite) để bù mô khuyết trên răng bị hư hại. Trám răng thẩm mỹ là biện pháp được các chuyên gia đánh giá rất cao về độ an toàn, nhanh chóng, chi phí tối ưu.</p>\n" +
                "<p style=\"text-align: justify;\">Những trường hợp dưới đây cần thiết phải thực hiện trám răng thẩm mỹ, phục hồi răng khiếm khuyết:</p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"color: #008000;\">✓</span> Răng bị sứt mẻ, vỡ nhỏ</p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"color: #008000;\">✓</span> Răng sau hỗ trợ điều trị lỗ sâu, viêm tủy</p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"color: #008000;\">✓</span> Răng bị mòn men.</p>\n" +
                "<h2 style=\"background: #3399FF; padding: 5px 15px; margin: 15px 0px; color: #ffffff; display: table;\"><span id=\"II_Uu_diem_khien_tram_rang_tham_my_Laser_Tech_duoc_uu_chuong\"><span style=\"font-size: 12pt;\"><b>II. Ưu điểm khiến trám răng thẩm mỹ Laser Tech được ưu chuộng?</b></span></span></h2>\n" +
                "<p style=\"text-align: justify;\">Dựa trên những nghiên cứu quan trọng về các đặc tính của Laser Er trong thẩm mỹ răng, các chuyên gia phục hình răng đã phát triển những đặc tính tốt của loại laser này, đẩy tới giá trị cao và an toàn cho cơ thể để sử dụng cho trám răng.</p>\n" +
                "<h3 class=\"svb_tt3\" style=\"text-align: justify;\"><span id=\"1_Tram_rang_the_he_laser_40_dac_dung\"><span style=\"font-size: 14pt; color: #008000;\"><strong>1/ Trám răng thế hệ laser 4.0 đặc dụng</strong></span></span></h3>\n" +
                "<p style=\"text-align: justify;\">Laser Tech là thế hệ laser Nha khoa 4.0 đặc dụng, thích hợp cho tương tác giữa các chất liệu trám răng nhân tạo với bề mặt răng sinh lý diễn ra tương khớp, loại trừ được tất cả những sai khác mà phương pháp trám thông thường dễ mắc phải.</p>\n" +
                "<h3 class=\"svb_tt3\"><span id=\"2_Tram_rang_tham_my_Laser_tech_co_do_ben_cao\"><span style=\"font-size: 14pt; color: #008000;\"><strong><span style=\"color: #008000;\"><span style=\"color: #008000;\">2/ T</span>rám răng thẩm mỹ Laser tech có độ bền cao</span></strong></span></span></h3>\n" +
                "<p style=\"text-align: justify;\">Laser nha khoa 4.0 giúp kích thích chất trám tạo ra hàng ngàn&nbsp;chân bám tại vị trí cố định. Do đó, miếng trám composite sẽ có độ bền cao, bám chắc chắn.</p>\n" +
                "<p style=\"text-align: justify;\">Chất liệu trám có thành phần khoáng hóa gần tương đương với ngà răng sinh lý. Khi đông cứng, chất trám có sức bền cao gần bằng ngà răng thật, không bị cong vênh trong thời gian dài, giúp bạn ăn nhai &nbsp;bình thường.*</p>\n" +
                "<h3 style=\"text-align: justify;\"><span id=\"3_Khong_xay_ra_hien_tuong_khoang_rong_sau_tram_rang\"><span style=\"font-size: 14pt; color: #008000;\"><strong>3/ Không xảy ra hiện tượng khoang rỗng sau trám răng</strong></span></span></h3>\n" +
                "<p style=\"text-align: justify;\">Công nghệ thực hiện hóa cứng miếng trám dẻo Composite bằng sóng laser er nha khoa nên có thể ngăn được tình trạng co miếng trám khi chịu những&nbsp;kích thích nóng lạnh, giúp khắc phục tình trạng bị khoang rỗng sau khi đông cứng chất trám – điều rất dễ gặp trong trám răng thông thường.</p>\n" +
                "<h3 class=\"svb_tt3\" style=\"text-align: justify;\"><span id=\"4_Chat_lieu_tram_rang_an_toan_voi_co_the\"><span style=\"color: #008000; font-size: 14pt;\"><strong>4/ Chất liệu trám răng an toàn với cơ thể</strong></span></span></h3>\n" +
                "<p style=\"text-align: justify;\">Laser Tech đặc biệt tương thích cho trám răng sâu do khả năng dễ hấp thụ nước trong lỗ sâu và có thể tạo xoang trám nhanh chóng, có chọn lọc nên không phạm vào mô răng lành, an toàn với cơ thể.</p>";

        serviceDescription.setText(HtmlCompat.fromHtml(des, HtmlCompat.FROM_HTML_MODE_LEGACY));

        image = findViewById(R.id.itemImage);
        people = new ArrayList<>();
        people.add(10);
        people.add(10);
        people.add(9);
        people.add(3);
        people.add(5);
        people.add(8);
        people.add(0);
        people.add(10);
        people.add(10);
        people.add(0);
        people.add(10);
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
        Intent intent = getIntent();
//        String a = intent.getStringExtra("id");
//        int b = Integer.parseInt(a);
//        System.out.println(b);
        ServiceModel model = (ServiceModel) intent.getSerializableExtra("serviceObj");
        Toast.makeText(getApplicationContext(), model.getName(), Toast.LENGTH_SHORT).show();

        name.setText(model.getName());
        description.setText(model.getDescription());
//        oldPrice.setText(String.format("%,d", mode.getOldPrice()) + " đ");
        price.setText(String.format("%,d", model.getPrice()) + " đ");
//        discount.setText(result.getDiscountPercent() + "%");









//        presenter.getClinicByIdNew(b);
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

        final TextView showMoreServiceDes = findViewById(R.id.showMoreServiceDesTextView);
        showMoreServiceDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView textServiceDescription = findViewById(R.id.textServiceDescription);
                if (!toggle) {
                    clickToShowMoreServiceDescription(3000, textServiceDescription);
                    toggle = !toggle;
                    showMoreServiceDes.setText("Xem ít hơn");
                } else {
                    clickToShowMoreServiceDescription(150, textServiceDescription);
                    toggle = !toggle;
                    showMoreServiceDes.setText("Xem thêm");
                }

            }
        });
    }

    @Override
    public void getAllClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getAllServices(List<ServiceModel> listResult) {

    }

    @Override
    public void getServicesByClinicId(List<ServiceModel> listResult) {

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

    @Override
    public void getClinicByIdNew(ClinicModel result) {
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

    public void clickToShowMoreServiceDescription(int height, final View view) {

        ValueAnimator anim = ValueAnimator.ofInt(view.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = val;
                view.setLayoutParams(layoutParams);
            }
        });
        anim.start();
    }
}
