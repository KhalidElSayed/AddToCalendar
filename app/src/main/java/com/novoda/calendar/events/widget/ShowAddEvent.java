package com.novoda.calendar.events.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ShowAddEvent extends BroadcastReceiver{

	private static final long ONE_HOUR = (long) 1000 * 60 * 60;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Intent addEvent = getAddEvent();
		context.startActivity(addEvent);
	}

	private Intent getAddEvent() {
		Intent intent = new Intent(Intent.ACTION_EDIT);  
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra("title", "");
		intent.putExtra("description", "");
		long eventStartInMillis = System.currentTimeMillis();
		long eventEndInMillis = eventStartInMillis + ONE_HOUR;
		intent.putExtra("beginTime", eventStartInMillis);
		intent.putExtra("endTime", eventEndInMillis);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		return intent;
	}

}
