package com.example.dental.helpers;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.LoginModel;
import com.example.dental.models.UserModel;
import com.example.dental.services.UserService;
import com.example.dental.services.serviceimpl.UserServiceImpl;

public class UserHelper {
    private Context context;
    UserService service;

    public UserHelper(Context context) {
        this.context = context;
    }

    public UserHelper() {
    }


    public void login(LoginModel loginModel, final CallBackData<UserModel> callBackData) {
        service = new UserServiceImpl();
        service.login(loginModel, new CallBackData<UserModel>() {
            @Override
            public void onSuccess(UserModel model) {
                callBackData.onSuccess(model);
            }

            @Override
            public void onFail(String message) {
            }
        });
    }

    public void getUserInfo(String token, long id, final CallBackData<UserModel> callBackData) {
        service = new UserServiceImpl();
        service.getUserInfo(token, id, new CallBackData<UserModel>() {
            @Override
            public void onSuccess(UserModel model) {
                callBackData.onSuccess(model);
            }

            @Override
            public void onFail(String message) {
            }
        });
    }

}
