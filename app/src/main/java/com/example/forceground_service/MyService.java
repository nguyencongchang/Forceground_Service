package com.example.forceground_service;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.forceground_service.MyApplication.channel_id;

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String datanhan = intent.getStringExtra("key");
        createNotification(datanhan);
        return START_NOT_STICKY;
    }

    private void createNotification(String datanhan) {
        Intent intent = new Intent(this, Activity.class);
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new NotificationCompat.Builder(this,channel_id)
                .setSmallIcon(R.drawable.car4)
                .setContentText(datanhan)
                .setContentTitle("chang dep trai")
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
