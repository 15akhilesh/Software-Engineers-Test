package com.document.Main;

import java.util.Map;

import com.document.LogProcessor.LogProcessor;

public class Main {

	public static void main(String[] args) {
		LogProcessor processor = new LogProcessor();
        
        // Example log processing
		processor.processLogLine("Genova", "Paco", "2", 5000, "Scan done. Image loaded in memory");
        processor.processLogLine("Genova", "Paco", "2", 500, "Image TIF saved in shared disc");
        processor.processLogLine("Genova", "Paco", "2", 1000, "Loading image…");
        processor.processLogLine("Genova", "Paco", "2", 1500, "Image showed in applet");
        processor.processLogLine("Genova", "Paco", "2", 6000, "Scan done. Image loaded in memory");
        processor.processLogLine("Genova", "Paco", "2", 800, "Image TIF saved in shared disc");
        processor.processLogLine("Genova", "Paco", "2", 1200, "Image showed in applet");
        // Calculate averages
        String day = "2";
        String hour = "14"; 
        String office = "Genova";
        String user = "Paco";
        
        processor.calculateAverages(day, hour, office, user);
        
    }
}


