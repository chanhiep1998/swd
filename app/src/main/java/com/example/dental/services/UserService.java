package com.example.dental.services;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.LoginModel;
import com.example.dental.models.UserModel;

public interface UserService {
    void login(LoginModel model , CallBackData<UserModel> callBackData);
    void getUserInfo(String token, long id, CallBackData<UserModel> callBackData);
}
