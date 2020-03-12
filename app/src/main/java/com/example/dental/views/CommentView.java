package com.example.dental.views;

import com.example.dental.models.CommentModel;

import java.util.List;

public interface CommentView {
    void getCommentForClinic(List<CommentModel> listResult);
}
