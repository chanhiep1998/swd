package com.example.dental.views;

import com.example.dental.models.ClinicModel;
import com.example.dental.models.UserModel;

import java.util.List;

public interface UserView {
    void login(UserModel result);

    void getUserInfo(UserModel result);
}
