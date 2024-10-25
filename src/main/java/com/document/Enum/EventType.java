package com.document.Enum;
import java.util.EnumSet;

public enum EventType {
    SCAN_STARTED("*********Starting scan********"),
    SCAN_DONE("Scan done. Image loaded in memory"),
    IMAGE_SAVED("Image TIF saved in shared disc"),
    IMAGE_LOADED("Loading image…"),
    IMAGE_DISPLAYED("Image showed in applet");

    public final String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static EventType fromString(String logString) {
        for (EventType event : EnumSet.allOf(EventType.class)) {
            if (logString.contains(event.getDescription())) {
                return event;
            }
        }
        return null;
    }
}
