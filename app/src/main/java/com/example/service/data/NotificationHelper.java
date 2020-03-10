package com.example.service.data;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.service.R;

public class NotificationHelper {

    private static String CHANNEL_ID = "Service";
    private static String ACTION_CLOSE = "ACTION_CLOSE";

    public static void showNotification(Context context){

        createNotificationChannel(context);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, createNotification(context));
    }

    public static Notification createNotification(Context context){

        Intent intent = new Intent(context, ServiceBuilder.class);
        intent.setAction(ACTION_CLOSE);

        PendingIntent pendingIntent = PendingIntent
                .getService(context, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.
                Builder(context, CHANNEL_ID)
                .setContentTitle("Notification")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher, "stop", pendingIntent)
                .setContentText("Helllloooo!!!");

        return builder.build();
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "rbjskbsjnusnkvjns";
            String description = "efufbsknosinvksv";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
