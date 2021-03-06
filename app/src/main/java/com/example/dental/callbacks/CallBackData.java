package com.example.dental.callbacks;

public interface CallBackData<T> {
    void onSuccess(T t);
    void onFail(String message);
}
