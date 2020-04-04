package com.example.dental.services.serviceimpl;

import android.util.Log;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.LoginModel;
import com.example.dental.models.UserModel;
import com.example.dental.repositories.ClientApi;
import com.example.dental.services.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserServiceImpl implements UserService {

    ClientApi clientApi = new ClientApi();


    @Override
    public void login(LoginModel loginModel, final CallBackData<UserModel> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().login(loginModel);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        Log.i("Login", result);
                        Type type = new TypeToken<UserModel>() {
                        }.getType();
                        UserModel userModel = new Gson().fromJson(result, type);
                        if (result != null) {
                            callBackData.onSuccess(userModel);
                        } else {
                            callBackData.onFail("Failed!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFail("LOGIN INCORRECT!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("LOGIN FAILED!");
            }
        });


    }

    @Override
    public void getUserInfo(String token, long id, final CallBackData<UserModel> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getUserInfo("Bearer " + token, id);
        serviceCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        Log.i("Info", result);
                        Type type = new TypeToken<UserModel>() {
                        }.getType();
                        UserModel userModel = new Gson().fromJson(result, type);
                        if (result != null) {
                            callBackData.onSuccess(userModel);
                        } else {
                            callBackData.onFail("Failed!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    callBackData.onFail("LOGIN INCORRECT!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBackData.onFail("LOGIN FAILED!");
            }
        });
    }
}
