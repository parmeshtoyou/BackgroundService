package com.example.backgroundservice;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import com.example.backgroundservice.api.RestClient;
import com.example.backgroundservice.api.ServiceInterface;
import com.example.backgroundservice.model.ResponseModel;
import com.example.backgroundservice.model.SecondResponseModel;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Log.d("NEW-SERVICE", "onStartJob");

        startCallingAPI(jobParameters);

        return true;
    }

    private void startCallingAPI(final JobParameters jobParameters) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Date date = Calendar.getInstance().getTime();
                    Log.d("NEW-SERVICE", "LOGS FROM JOB SCHEDULER: " + date);
                    //callFirstApi();
                    //callSecondApi();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                jobFinished(jobParameters, true);
            }
        });
        thread.start();
    }

    private void callFirstApi() {

        ServiceInterface serviceInterface = RestClient.getClient().create(ServiceInterface.class);
        final String FIRST_URL = "https://rideabird.co/api/actions.php?action=store_device_location&device_address=8asasfsfgfswww&phone=9999999998&key=972726364e4ec13fd565d5b9dc0be77c&lang=17.690071&lat=83.217230&speed=27&battery_level=33";
        Call<ResponseModel> call = serviceInterface.callFirstApi(FIRST_URL);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    Log.d("API-RESPONSE", "Response1: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    private void callSecondApi() {

        ServiceInterface serviceInterface = RestClient.getClient().create(ServiceInterface.class);
        final String SECOND_URL = "https://rideabird.co/api/actions.php?action=device_status&device_address=8asasfsfgfswww&phone=9999999998&key=972726364e4ec13fd565d5b9dc0be77c";
        Call<SecondResponseModel> call = serviceInterface.callSecondApi(SECOND_URL);
        call.enqueue(new Callback<SecondResponseModel>() {
            @Override
            public void onResponse(Call<SecondResponseModel> call, Response<SecondResponseModel> response) {
                if (response.isSuccessful()) {
                    Log.d("API-RESPONSE", "Response2: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<SecondResponseModel> call, Throwable t) {

            }
        });
    }
}
