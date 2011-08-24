package com.novoda.calendar.events.widget.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.test.InstrumentationTestCase;

import com.jayway.android.robotium.solo.Solo;
import com.novoda.calendar.events.widget.ShowAddEvent;

public class CalendarAddEventIntentTest extends InstrumentationTestCase{

	private Solo robotium;
	private Context context;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		robotium = new Solo(getInstrumentation());
		context = getInstrumentation().getTargetContext();
		Intent addEvent = new Intent(context, ShowAddEvent.class);
		context.sendBroadcast(addEvent);
	}
	
	public void testHelloWorld(){
		robotium.sleep(2000);
		assertTrue(true);
	}

	@Override
	protected void tearDown() throws Exception {
		Activity current = robotium.getCurrentActivity();
		current.finish();
		super.tearDown();
	}
	
	

}
