package com.example.dental.services;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.CommentModel;

import org.w3c.dom.Comment;

import java.util.List;

public interface CommentService {
    void getCommentForClinic(CallBackData<List<CommentModel>> callBackData);
}
