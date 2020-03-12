package com.example.dental.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.CommentAdapter;
import com.example.dental.models.CommentModel;
import com.example.dental.presenters.CommentPresenter;
import com.example.dental.views.CommentView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentFragment extends Fragment implements CommentView {
    private RecyclerView commentList;
    CommentAdapter adapter;
    CommentPresenter presenter;

    public CommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comment_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        commentList = (RecyclerView) view.findViewById(R.id.commentList);

        commentList.setLayoutManager(layoutManager);


        presenter = new CommentPresenter(this, getContext());
        presenter.getCommentForClinic();
        return view;
    }

    @Override
    public void getCommentForClinic(List<CommentModel> listResult) {
        ArrayList<CommentModel> tempList = new ArrayList<>();
        for (CommentModel item : listResult) {
            CommentModel comment = new CommentModel();
            comment.setComment(item.getComment());
            comment.setCommentTime(item.getCommentTime());
            comment.setServiceRating(item.getServiceRating());
            comment.setUserName(item.getUserName());
            comment.setUserPosition(item.getUserPosition());
            comment.setUserImage(item.getUserImage());
            tempList.add(comment);
        }
        adapter = new CommentAdapter(tempList, getContext());
        commentList.setAdapter(adapter);
    }
}
