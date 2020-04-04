package com.example.dental.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.models.CommentModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.RecyclerViewHolder> {
    private ArrayList<CommentModel> commentList;
    private Context context;

    public CommentAdapter(ArrayList<CommentModel> commentModels, Context context) {
        this.commentList = commentModels;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_comment_item, parent, false);
        return new CommentAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.RecyclerViewHolder holder, int position) {
        holder.userName.setText(commentList.get(position).getUserName());
        holder.userPosition.setText(commentList.get(position).getUserPosition());
        holder.commentTime.setText(commentList.get(position).getCommentTime());
        holder.comment.setText(commentList.get(position).getComment());
        holder.serviceRating.setRating(commentList.get(position).getServiceRating());
        Picasso.get().load(commentList.get(position).getUserImage()).into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userPosition;
        TextView commentTime;
        TextView comment;
        RatingBar serviceRating;
        ImageView userImage;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            userName =  itemView.findViewById(R.id.userNameTextView);
            userPosition =  itemView.findViewById(R.id.userAddressTextView);
            comment =  itemView.findViewById(R.id.commentTextView);
            commentTime =  itemView.findViewById(R.id.commentTimeTextView);
            serviceRating = (RatingBar) itemView.findViewById(R.id.serviceRateRatingBar);
            userImage = (ImageView) itemView.findViewById(R.id.userImageImageView);

        }
    }
}


