package com.document.LogProcessor;

import com.document.Enum.EventType;

public class LogEntry {
	public final String officeName;
	public final String userName;
	public final String monthDay;
    public final long time; // in milliseconds
    public final EventType eventType;
    
    public LogEntry(String officeName, String userName, String monthDay, long time, EventType eventType) {
		super();
		this.officeName = officeName;
		this.userName = userName;
		this.monthDay = monthDay;
		this.time = time;
		this.eventType = eventType;
	}
    
    public long getTime() {
        return time;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getOfficeName() {
        return officeName;
    }

    public String getUserName() {
        return userName;
    }
	

}
