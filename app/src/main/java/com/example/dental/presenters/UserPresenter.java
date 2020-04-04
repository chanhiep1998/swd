package com.example.dental.presenters;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.helpers.UserHelper;
import com.example.dental.models.LoginModel;
import com.example.dental.models.UserModel;
import com.example.dental.views.UserView;

public class UserPresenter {
    UserHelper helper;
    UserView view;
    Context context;

    public UserPresenter(UserView view, Context context) {
        helper = new UserHelper();
        this.view = view;
        this.context = context;
    }

    public void login(final LoginModel loginModel) {
        helper.login(loginModel, new CallBackData<UserModel>() {
            @Override
            public void onSuccess(UserModel result) {
                view.login(result);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getUserInfo(String token, long id) {
        helper.getUserInfo(token, id, new CallBackData<UserModel>() {
            @Override
            public void onSuccess(UserModel result) {
                view.getUserInfo(result);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }
}
