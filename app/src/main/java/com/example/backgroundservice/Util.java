package com.example.backgroundservice;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

class Util {

    static void scheduleJob(Context context) {
        ComponentName serviceComponent = new ComponentName(context, MyJobService.class);

        JobInfo info = new JobInfo.Builder(1234, serviceComponent)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .build();

        JobScheduler jobScheduler = context.getSystemService(JobScheduler.class);

        if (jobScheduler != null) {
            int resultCode = jobScheduler.schedule(info);
            if (resultCode == JobScheduler.RESULT_SUCCESS) {
                Log.d("NEW-SERVICE", "Job Scheduled");
            } else {
                Log.d("NEW-SERVICE", "Job Scheduled failed");
            }
        }
    }

}
