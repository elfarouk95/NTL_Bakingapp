package com.example.elfaroukomar.ntl_bakingaopp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class BakingWidget extends AppWidgetProvider {


    static void updateAppWidget(Context context, final AppWidgetManager appWidgetManager,
                                final int appWidgetId, String text) {

       // final CharSequence widgetText = text+"hjkl;lkjhgfdfghjk";


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.baking_widget);
        views.setTextViewText(R.id.appwidget_text, ""+appWidgetId);
        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent n = PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.appwidget_text,n);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId,"");
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

}

