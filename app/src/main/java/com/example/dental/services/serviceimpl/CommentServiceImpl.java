package com.example.dental.services.serviceimpl;

import android.util.Log;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.constants.Constant;
import com.example.dental.models.CommentModel;
import com.example.dental.repositories.ClientApi;
import com.example.dental.services.CommentService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentServiceImpl implements CommentService {

    ClientApi clientApi = new ClientApi();


    @Override
    public void getCommentForClinic(final CallBackData<List<CommentModel>> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getCommentForClinic();
        System.out.println(serviceCall);
        try {
            serviceCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response != null && response.body() != null) {
                        if (response.code() == 200) {
                            try {
                                String result = response.body().string();
                                Log.i("Result", result);
                                Type type = new TypeToken<List<CommentModel>>() {
                                }.getType();
                                List<CommentModel> responseResult = new Gson().fromJson(result, type);
                                if (responseResult != null) {
                                    callBackData.onSuccess(responseResult);
                                } else {
                                    callBackData.onFail("Failed!");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            callBackData.onFail(Constant.MSG_ERROR);
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println(t.getMessage());
                    callBackData.onFail("FAILED!");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
