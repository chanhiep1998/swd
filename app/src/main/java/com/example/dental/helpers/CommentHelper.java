package com.example.dental.helpers;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.CommentModel;
import com.example.dental.services.CommentService;
import com.example.dental.services.serviceimpl.CommentServiceImpl;

import java.util.List;

public class CommentHelper {
    private Context context;
    CommentService service;

    public CommentHelper(Context context) {
        this.context = context;
    }

    public CommentHelper() {
    }


    public void getCommentForClinic(final CallBackData<List<CommentModel>> callBackData) {
        service = new CommentServiceImpl();
        service.getCommentForClinic(new CallBackData<List<CommentModel>>() {
            @Override
            public void onSuccess(List<CommentModel> commentModels) {
                callBackData.onSuccess(commentModels);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

}
