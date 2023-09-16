package org.example.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public final class DateUtils {

    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final String DATE_TIME_WITH_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String DATE_TIME = "dd.MM.yyyy HH:mm";
    public static final String DATE = "dd.MM.yyyy";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DATE);

    public static String formatDateTime(Temporal val) {
        return formatWithPattern(val, DATE_TIME);
    }

    public static String formatDate(Temporal val) {
        return formatWithPattern(val, DATE);
    }

    private static String formatWithPattern(Temporal val, String pattern) {
        if (val == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern(pattern).format(val);
    }
}
