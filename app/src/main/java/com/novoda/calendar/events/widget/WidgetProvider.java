package com.novoda.calendar.events.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		RemoteViews views = prepareViews(context);
		for ( int id : appWidgetIds){
			appWidgetManager.updateAppWidget(id, views);
		}
	}

	private RemoteViews prepareViews(Context c) {
		String name = c.getPackageName();
		RemoteViews views = new RemoteViews(name, R.layout.widget);
		PendingIntent showAddEvent = getShowAddEvent(c);
		views.setOnClickPendingIntent(R.id.add_event_btn, showAddEvent);		
		return views;
	}

	private PendingIntent getShowAddEvent(Context c) {
		Intent startReceiver = new Intent(c, ShowAddEvent.class);
		return PendingIntent.getBroadcast(c, 0, startReceiver, 0);
	}

}
