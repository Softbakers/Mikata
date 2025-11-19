package com.softbakers.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Mikata - Date conversion utility with localization support
 */
public class Mikata {

    private Mikata() {
        // Utility class - prevent instantiation
    }

    /**
     * Convert Date to localized string
     */
    public static String dateToString(Date date, Locale locale) {
        if (date == null) return null;
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return formatter.format(date);
    }

    /**
     * Convert Date to string with specified format style
     */
    public static String dateToString(Date date, Locale locale, int style) {
        if (date == null) return null;
        DateFormat formatter = DateFormat.getDateInstance(style, locale);
        return formatter.format(date);
    }

    /**
     * Convert LocalDate to localized string
     */
    public static String localDateToString(LocalDate date, Locale locale) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(locale);
        return date.format(formatter);
    }

    /**
     * Convert LocalDateTime to localized string
     */
    public static String localDateTimeToString(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(locale);
        return dateTime.format(formatter);
    }

    /**
     * Convert string to Date using localized parsing
     */
    public static Date stringToDate(String dateString, Locale locale) throws ParseException {
        if (dateString == null || dateString.trim().isEmpty()) return null;
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return formatter.parse(dateString);
    }

    /**
     * Convert string to LocalDate using localized parsing
     */
    public static LocalDate stringToLocalDate(String dateString, Locale locale) {
        if (dateString == null || dateString.trim().isEmpty()) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
                .withLocale(locale);
        return LocalDate.parse(dateString, formatter);
    }

    /**
     * Convert between date string formats with different locales
     */
    public static String convertDateFormat(String dateString, Locale sourceLocale, Locale targetLocale)
            throws ParseException {
        Date date = stringToDate(dateString, sourceLocale);
        return dateToString(date, targetLocale);
    }

    /**
     * Get available date patterns for a locale
     */
    public static String[] getAvailablePatterns(Locale locale) {
        DateFormat[] formats = {
                DateFormat.getDateInstance(DateFormat.SHORT, locale),
                DateFormat.getDateInstance(DateFormat.MEDIUM, locale),
                DateFormat.getDateInstance(DateFormat.LONG, locale),
                DateFormat.getDateInstance(DateFormat.FULL, locale)
        };

        String[] patterns = new String[formats.length];
        for (int i = 0; i < formats.length; i++) {
            if (formats[i] instanceof SimpleDateFormat) {
                patterns[i] = ((SimpleDateFormat) formats[i]).toPattern();
            }
        }
        return patterns;
    }
}