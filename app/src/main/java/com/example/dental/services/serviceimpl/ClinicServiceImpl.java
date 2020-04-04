package com.example.dental.services.serviceimpl;

import android.util.Log;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.constants.Constant;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.repositories.ClientApi;
import com.example.dental.services.ClinicService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClinicServiceImpl implements ClinicService {

    ClientApi clientApi = new ClientApi();

    @Override
    public void getAllClinic(String token, final CallBackData<List<ClinicModel>> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getClinic("Bearer " + token);
        System.out.println(serviceCall);
        try {
            serviceCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response != null && response.body() != null) {
                        if (response.code() == 200) {
                            try {
                                String result = response.body().string();
                                Log.i("ResultA", result);
                                Type type = new TypeToken<List<ClinicModel>>() {
                                }.getType();
                                List<ClinicModel> responseResult = new Gson().fromJson(result, type);
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

    public void getNearbyClinics(final CallBackData<List<ClinicModel>> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getNearbyClinics();
        System.out.println(serviceCall);
        try {
            serviceCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response != null && response.body() != null) {
                        if (response.code() == 200) {
                            try {
                                String result = response.body().string();
                                Log.i("ResultNearby", result);
                                Type type = new TypeToken<List<ClinicModel>>() {
                                }.getType();
                                List<ClinicModel> responseResult = new Gson().fromJson(result, type);
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

    @Override
    public void getClinicById(final CallBackData<ClinicModel> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getClinicById();
        System.out.println("service call " + serviceCall.toString());
        try {
            serviceCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response != null && response.body() != null) {
                        if (response.code() == 200) {
                            try {
                                String result = response.body().string();
                                Log.i("ResultI", result);
                                Type type = new TypeToken<ClinicModel>() {
                                }.getType();
                                ClinicModel responseResult = new Gson().fromJson(result, type);
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

    @Override
    public void getClinicByIdNew(int id, final CallBackData<ClinicModel> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getClinicByIdTest(id);
        System.out.println("service call " + serviceCall.toString());
        try {
            serviceCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response != null && response.body() != null) {
                        if (response.code() == 200) {
                            try {
                                String result = response.body().string();
                                Log.i("ResultI", result);
                                Type type = new TypeToken<ClinicModel>() {
                                }.getType();
                                ClinicModel responseResult = new Gson().fromJson(result, type);
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

    @Override
    public void getServicesByClinicId(String token, long id, final CallBackData<List<ServiceModel>> callBackData) {
        Call<ResponseBody> call = clientApi.getGenericApi().getServicesByClinicId("Bearer " + token, id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        Type type = new TypeToken<List<ServiceModel>>() {
                        }.getType();
                        List<ServiceModel> responseResult = new Gson().fromJson(result, type);
                        if (responseResult != null) {
                            callBackData.onSuccess(responseResult);
                        } else {
                            callBackData.onFail("Failed!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Error!");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t.getMessage());
                callBackData.onFail("FAILED!");
            }
        });
    }


    public void getAllServices(String token, final CallBackData<List<ServiceModel>> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getService("Bearer " + token);
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
                                Type type = new TypeToken<List<ServiceModel>>() {
                                }.getType();
                                List<ServiceModel> responseResult = new Gson().fromJson(result, type);
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

    public void getMostDiscountClinics(final CallBackData<List<ClinicModel>> callBackData) {
        Call<ResponseBody> serviceCall = clientApi.getGenericApi().getMostDiscountClinics();
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
                                Type type = new TypeToken<List<ClinicModel>>() {
                                }.getType();
                                List<ClinicModel> responseResult = new Gson().fromJson(result, type);
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
