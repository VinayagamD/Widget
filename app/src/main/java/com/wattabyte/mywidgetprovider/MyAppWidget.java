package com.wattabyte.mywidgetprovider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class MyAppWidget extends AppWidgetProvider {


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int i = 0; i < appWidgetIds.length; i++) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.my_app_widget);

            String data = "Data : " + new Random().nextInt(1000);
            remoteViews.setTextViewText(R.id.textView, data);

            Intent openAppIntent = new Intent(context,MainActivity.class);
            PendingIntent appOpenPendingIntent = PendingIntent.getActivity(context,0,openAppIntent,0);
            remoteViews.setOnClickPendingIntent(R.id.openApp,appOpenPendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds[i],remoteViews);

        }
    }

   
}

