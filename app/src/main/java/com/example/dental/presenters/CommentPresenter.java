package com.example.dental.presenters;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.helpers.CommentHelper;
import com.example.dental.models.CommentModel;
import com.example.dental.views.CommentView;

import java.util.List;

public class CommentPresenter {
    CommentHelper helper;
    CommentView view;
    Context context;

    public CommentPresenter(CommentView view, Context context) {
        helper = new CommentHelper();
        this.view = view;
        this.context = context;
    }


    public void getCommentForClinic() {
        helper.getCommentForClinic(new CallBackData<List<CommentModel>>() {
            @Override
            public void onSuccess(List<CommentModel> commentModels) {
                view.getCommentForClinic(commentModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

}
