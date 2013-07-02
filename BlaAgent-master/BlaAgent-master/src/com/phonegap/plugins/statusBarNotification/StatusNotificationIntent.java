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
import android.support.v4.app.TaskStackBuilder;

public class StatusNotificationIntent {

    public static void sendNotification(Context context, CharSequence tag, CharSequence contentTitle, CharSequence contentText, int flag, int typeOfMessage) {
        String[] events = new String[6];
        Intent intent = new Intent("com.ismobile.blaandroid.showAssDetails");
        intent.putExtra("com.ismobile.blaandroid.showAssDetails", "9Bk5THugReWsbQ6xq2nTkA"); // Key to an assignment in Blå Android.
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intent, 0);
        String details = "Assignment: " + "Vattenfall AB";

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        // Sets a title for the Inbox style big view
        events[0] = "Helloo..!";
        events[1] = "How are you?";
        events[2] = "HIII !!";
        events[3] = "i am fine...";
        events[4] = "what about you? all is well?";
        events[5] = "Yes, every thing is all right..";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentText(contentText)
                .setContentTitle(contentTitle)
                .setSmallIcon(R.drawable.notification)
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_SOUND);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Event Details");

        // Moves events into the big view
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        // Moves the big view style object into the notification object.
        builder.setStyle(inboxStyle);

        nm.notify(100, builder.build());
    }

    /*public static Notification buildNotification( Context context, CharSequence tag, CharSequence contentTitle, CharSequence contentText, int flag, int typeOfMessage) {
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
    }*/
}