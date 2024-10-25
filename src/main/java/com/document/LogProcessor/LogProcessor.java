package com.document.LogProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.document.Enum.EventType;

public class LogProcessor {

	private final List<LogEntry> logs = new ArrayList<>();
    private final Map<String, Double> averages = new HashMap<>();
    private int documentCount = 0;

    public void processLogLine(String officeName, String userName, String monthDay, long timeInMilliseconds, String logString) {
        EventType eventType = EventType.fromString(logString);
        if (eventType != null) {
            LogEntry entry = new LogEntry(officeName, userName, monthDay, timeInMilliseconds, eventType);
            logs.add(entry);
        }
    }

    public void calculateAverages(String day, String hour, String office, String user) {
        long totalScanTime = 0;
        long totalSaveTime = 0;
        long totalShowTime = 0;
        int scanCount = 0;

        for (LogEntry entry : logs) {
            if ((office == null || entry.getOfficeName().equals(office)) &&
                (user == null || entry.getUserName().equals(user)) &&
                (day == null || entry.monthDay.equals(day))) {

                if (entry.getEventType() == EventType.SCAN_DONE) {
                    totalScanTime += entry.getTime();
                    scanCount++;
                } else if (entry.getEventType() == EventType.IMAGE_SAVED) {
                    totalSaveTime += entry.getTime();
                } else if (entry.getEventType() == EventType.IMAGE_DISPLAYED) {
                    totalShowTime += entry.getTime();
                }
            }
        }

        if (scanCount > 0) {
        	System.out.println("Summary");
            System.out.println("Avrg time to scan: " + (totalScanTime / scanCount) + " ms");
            System.out.println("Avrg time to save img: " + (totalSaveTime / scanCount) + " ms");
            System.out.println("Avrg time to show image: " + (totalShowTime / scanCount) + " ms");
            System.out.println("All documents scanned: " + scanCount);

            System.out.println("Detail:");
            System.out.println("Office " + (office != null ? office : "All") + ": " + scanCount + " documents scanned");
            System.out.println("User " + (user != null ? user : "All") + ": " + scanCount + " documents scanned");
            System.out.println("Day: " + (day != null ? day : "All") + ". " + scanCount + " documents scanned");
            System.out.println("Hour: " + (hour != null ? hour : "All") + ". " + scanCount + " documents scanned");
        } else {
            System.out.println("No documents scanned for the given filters.");
        
        }
    }
}
