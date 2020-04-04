package com.example.dental.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.activities.LoginActivity;
import com.example.dental.models.UserModel;
import com.example.dental.presenters.UserPresenter;
import com.example.dental.views.UserView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment implements UserView {

    Button logout;
    UserPresenter presenter;
    EditText username, email, phone, fullname;
    TextView labelName;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        logout = view.findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.setUserName(getActivity().getApplicationContext(), "");
                startActivity(new Intent(getActivity().getApplicationContext(), LoginActivity.class));
                getActivity().finishAfterTransition();

            }
        });

        username = view.findViewById(R.id.username_edit_text);
        email = view.findViewById(R.id.email_edit_text);
        phone = view.findViewById(R.id.phone_edit_text);
        labelName = view.findViewById(R.id.label_name_text_view);

        presenter = new UserPresenter(this, getActivity().getApplicationContext());
        presenter.getUserInfo(SaveSharedPreference.getUserName(getActivity().getApplicationContext()),
                Long.parseLong(SaveSharedPreference.getUserId(getActivity().getApplicationContext())));
        Toast.makeText(getActivity().getApplicationContext(), SaveSharedPreference.getUserId(getActivity().getApplicationContext()), Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void login(UserModel result) {
    }

    @Override
    public void getUserInfo(UserModel result) {
        Toast.makeText(getActivity().getApplicationContext(), result.getPhone(), Toast.LENGTH_SHORT).show();
        username.setText(result.getName());
        labelName.setText(result.getName());
        email.setText(result.getEmail());
        phone.setText(result.getPhone());
    }
}
