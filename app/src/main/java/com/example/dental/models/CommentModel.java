package com.example.dental.models;

import java.io.Serializable;

public class CommentModel implements Serializable {
    String userName, userImage, comment;
    String userPosition;
    String commentTime;
    float serviceRating;

    public CommentModel() {
    }

    public CommentModel(String userName, String userImage, String comment, String userPosition, String commentTime, float serviceRating) {
        this.userName = userName;
        this.userImage = userImage;
        this.comment = comment;
        this.userPosition = userPosition;
        this.commentTime = commentTime;
        this.serviceRating = serviceRating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(float serviceRating) {
        this.serviceRating = serviceRating;
    }
}
