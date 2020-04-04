package com.example.dental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.models.LoginModel;
import com.example.dental.models.UserModel;
import com.example.dental.presenters.UserPresenter;
import com.example.dental.views.UserView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginActivity extends AppCompatActivity implements UserView {
    UserPresenter presenter;
    String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextInputLayout passwordTextInput = findViewById(R.id.password_text_input);
        final TextInputEditText usernameEditText = findViewById(R.id.username_edit_text);
        final TextInputEditText passwordEditText = findViewById(R.id.password_edit_text);
        MaterialButton loginButton = findViewById(R.id.login_button);


        Toast.makeText(getApplicationContext(), SaveSharedPreference.getUserName(this), Toast.LENGTH_SHORT).show();
        // Set an error if the password is less than 8 characters.
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(getString(R.string.dental_error_password));


                } else {
                    passwordTextInput.setError(null); // Clear the error
                    LoginModel loginModel = new LoginModel(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                    presenter = new UserPresenter(LoginActivity.this, getApplicationContext());
                    presenter.login(loginModel);
                }
            }
        });

        // Clear the error once more than 8 characters are typed.
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (isPasswordValid(passwordEditText.getText())) {
                    passwordTextInput.setError(null); //Clear the error
                }
                return false;
            }
        });
    }

    /*
            In reality, this will have more complex logic including, but not limited to, actual
            authentication of the username and password.
         */
    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

    @Override
    public void login(UserModel result) {
        token = result.getToken();
//        Toast.makeText(this, result + "", Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), result.getToken(), Toast.LENGTH_SHORT).show();
        if (token != null) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("token", token);
            SaveSharedPreference.setUserName(getApplicationContext(), token);
            SaveSharedPreference.setUserId(getApplicationContext(), result.getId());
            startActivity(intent);
            finishAfterTransition();
        }
    }

    @Override
    public void getUserInfo(UserModel result) {

    }
}
