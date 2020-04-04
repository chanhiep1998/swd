package com.example.dental.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.SearchAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements ClinicView {
    private RecyclerView clinicList;
    SearchAdapter adapter;
    ClinicPresenter presenter;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_clinic_search_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        clinicList = findViewById(R.id.clinicList);
        resultTextView = findViewById(R.id.resultTextView);
        clinicList.setLayoutManager(layoutManager);

        EditText search = findViewById(R.id.searchEditText);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0) {
                    resultTextView.setText("Kết quả");
                } else {
                    resultTextView.setText("Tất cả");
                }
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        presenter = new ClinicPresenter(this, this);
        presenter.getAllClinic("a");
    }


    @Override
    public void getAllClinics(List<ClinicModel> listResult) {
        ArrayList<ClinicModel> tempList = new ArrayList<>();
        for (ClinicModel item : listResult) {
            ClinicModel clinic = new ClinicModel();
            clinic.setId(item.getId());
            clinic.setName(item.getName());
            clinic.setDescription(item.getDescription());
            clinic.setOldPrice(item.getOldPrice());
            clinic.setPrice(item.getPrice());
            if (item.getImage() != null) {
                clinic.setImage(item.getImage());
            }
            tempList.add(clinic);
        }
        adapter = new SearchAdapter(this, tempList);
        clinicList.setAdapter(adapter);
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

    }

    @Override
    public void getClinicByIdNew(ClinicModel result) {

    }
}
