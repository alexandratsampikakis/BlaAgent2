// This class is used on all Androids below Honeycomb
package com.phonegap.plugins.statusBarNotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.example.BlaAgent.R;

import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;

public class StatusNotificationIntent {

    public static void sendNotification(Context context, CharSequence tag, CharSequence contentTitle, CharSequence contentText, int flag, int typeOfMessage) {
        Intent intent = new Intent("com.ismobile.blaandroid.showAssDetails");
        intent.putExtra("com.ismobile.blaandroid.showAssDetails", "9Bk5THugReWsbQ6xq2nTkA"); // Key to an assignment in Blå Android.
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText(contentText + " " + typeOfMessage)
                .setContentTitle(contentTitle)
                .setSmallIcon(R.drawable.notification)
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);
        Notification noti = builder.build();
        nm.notify(1, noti);
    }

    public static Notification buildNotification( Context context, CharSequence tag, CharSequence contentTitle, CharSequence contentText, int flag, int typeOfMessage) {
        int icon = R.drawable.notification;
        long when = System.currentTimeMillis();

        Notification noti = new Notification(icon, contentTitle, when);
        noti.flags |= flag;

        PackageManager pm = context.getPackageManager();
        Intent notificationIntent = pm.getLaunchIntentForPackage(context.getPackageName());
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        notificationIntent.putExtra("notificationTag", tag);

        // Opens Blå Android application when pressing the notification.
        Intent intent = new Intent("com.ismobile.blaandroid.showAssDetails");
        intent.putExtra("com.ismobile.blaandroid.showAssDetails", "9Bk5THugReWsbQ6xq2nTkA"); // Key to an assignment in Blå Android.
        ResolveInfo r = context.getPackageManager().resolveActivity(intent, 0);
        if (r != null) {
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
            noti.setLatestEventInfo(context, contentTitle, contentText + " " + typeOfMessage, contentIntent);
        }

        return noti;
    }
}