package com.listeners;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class SmartRServletContextListener implements ServletContextListener {

	private ScheduledExecutorService InsertAttendanceDetailsScheduler;
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("[Initial Server Startup] Attendance Scheduler will run in: " + getInitialDelayTime() + " minutes. \nScheduler will run everyday at 12AM.");
		//Scheduler that runs InsertAttendanceDetailsScheduler.java
		//Initial delay: time in minutes from, current time till today's 12am
		//run every 1440 minutes (24hours) subsequently  
		InsertAttendanceDetailsScheduler = Executors.newSingleThreadScheduledExecutor();
		//InsertAttendanceDetailsScheduler.scheduleAtFixedRate(new InsertAttendanceDetailsScheduler(), 0, 1440, TimeUnit.MINUTES);
		InsertAttendanceDetailsScheduler.scheduleAtFixedRate(new InsertAttendanceDetailsScheduler(), getInitialDelayTime(), 1440, TimeUnit.MINUTES);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		InsertAttendanceDetailsScheduler.shutdownNow();
	}
	
	// Setting the next timing for scheduler to execute
	private long getInitialDelayTime() {		
		// current means current time
		Calendar current = Calendar.getInstance();
		current.set(Calendar.SECOND, 0);
		current.set(Calendar.MILLISECOND, 0);
		
		// runTime means the deadline
		Calendar runTime = Calendar.getInstance();
		
		//set time to 12 AM
		runTime.set(Calendar.HOUR_OF_DAY, 24);
		runTime.set(Calendar.MINUTE, 0);
		runTime.set(Calendar.SECOND, 0);
		runTime.set(Calendar.MILLISECOND, 0);
		
		// calculate the difference between runTime and current
		long differenceInMillis = runTime.getTimeInMillis() - current.getTimeInMillis();
		long minutes = differenceInMillis / 1000 / 60;
		return minutes;
	}
}
