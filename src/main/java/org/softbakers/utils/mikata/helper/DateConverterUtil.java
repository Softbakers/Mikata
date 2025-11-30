package org.softbakers.utils.mikata.helper;

import org.softbakers.utils.mikata.api.DateConverterUtilAPI;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * DateConverterUtil implementation for Date conversion methods.
 * Provides comprehensive date and time conversion utilities between various date representations
 * including java.util.Date, LocalDate, LocalDateTime, Timestamp, and String formats.
 * Supports locale-specific formatting and parsing with customizable patterns.
 *
 * @author Mohamed Lamine JELLAD from Softbakers
 * @version 1.0.0
 */
public class DateConverterUtil implements DateConverterUtilAPI {

    private Locale defaultLocale = Locale.getDefault();
    private String defaultPattern = "yyyy-MM-dd";

    /**
     * Default constructor initializes with system default locale and default pattern.
     */
    public DateConverterUtil() {
    }

    /**
     * Parameterized constructor with custom locale and pattern.
     *
     * @param defaultLocale the locale to use for formatting and parsing
     * @param defaultPattern the default date pattern to use
     */
    public DateConverterUtil(Locale defaultLocale, String defaultPattern) {
        this.defaultLocale = defaultLocale;
        this.defaultPattern = defaultPattern;
    }

    /**
     * Converts a java.util.Date to String using default format.
     *
     * @param date the date to convert
     * @return formatted date string using default format, or null if date is null
     */
    @Override
    public String toDefaultFormatString(java.util.Date date) {
        if (date == null) return null;
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Converts a java.util.Date to String using default format and specified locale.
     *
     * @param date the date to convert
     * @param locale the locale for formatting
     * @return formatted date string using default format and specified locale, or null if date is null
     */
    @Override
    public String toDefaultFormatString(java.util.Date date, Locale locale) {
        if (date == null) return null;
        LocalDateTime dateTime = this.toLocalDateTime(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(dateTime);
    }

    /**
     * Converts a java.util.Date to String using default locale and pattern.
     *
     * @param date the date to convert
     * @return formatted date string using default settings, or null if date is null
     */
    @Override
    public String toString(java.util.Date date) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(this.defaultPattern, this.defaultLocale);
        return formatter.format(date);
    }

    /**
     * Converts a java.util.Date to String using specified pattern and default locale.
     *
     * @param date the date to convert
     * @param pattern the date format pattern
     * @return formatted date string using specified pattern, or null if date is null
     */
    @Override
    public String toString(java.util.Date date, String pattern) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, this.defaultLocale);
        return formatter.format(date);
    }

    /**
     * Converts a java.util.Date to String using specified locale and default pattern.
     *
     * @param date the date to convert
     * @param locale the locale for formatting
     * @return formatted date string using specified locale, or null if date is null
     */
    @Override
    public String toString(java.util.Date date, Locale locale) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(this.defaultPattern, locale);
        return formatter.format(date);
    }

    /**
     * Converts a java.util.Date to String using specified locale and pattern.
     *
     * @param date the date to convert
     * @param locale the locale for formatting
     * @param pattern the date format pattern
     * @return formatted date string using specified locale and pattern, or null if date is null
     */
    @Override
    public String toString(java.util.Date date, Locale locale, String pattern) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        return formatter.format(date);
    }

    /**
     * Converts a LocalDate to String using specified locale and pattern.
     *
     * @param date the LocalDate to convert
     * @param locale the locale for formatting
     * @param pattern the date format pattern
     * @return formatted date string using specified locale and pattern, or null if date is null
     */
    @Override
    public String toString(LocalDate date, Locale locale, String pattern) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withLocale(locale);
        return date.format(formatter);
    }

    /**
     * Converts a LocalDate to String using specified locale and default pattern.
     *
     * @param date the LocalDate to convert
     * @param locale the locale for formatting
     * @return formatted date string using specified locale, or null if date is null
     */
    @Override
    public String toString(LocalDate date, Locale locale) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return date.format(formatter);
    }

    /**
     * Converts a LocalDate to String using specified pattern and default locale.
     *
     * @param date the LocalDate to convert
     * @param pattern the date format pattern
     * @return formatted date string using specified pattern, or null if date is null
     */
    @Override
    public String toString(LocalDate date, String pattern) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Converts a LocalDate to String using default format.
     *
     * @param date the LocalDate to convert
     * @return formatted date string using default format, or null if date is null
     */
    @Override
    public String toDefaultFormatString(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Converts a LocalDate to String using default format and specified locale.
     *
     * @param date the LocalDate to convert
     * @param locale the locale for formatting
     * @return formatted date string using default format and specified locale, or null if date is null
     */
    @Override
    public String toDefaultFormatString(LocalDate date, Locale locale) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(date);
    }

    /**
     * Converts a LocalDateTime to String using default format.
     *
     * @param dateTime the LocalDateTime to convert
     * @return formatted date-time string using default format, or null if dateTime is null
     */
    @Override
    public String toDefaultFormatString(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return formatter.format(dateTime);
    }

    /**
     * Converts a LocalDateTime to String using default format and specified locale.
     *
     * @param dateTime the LocalDateTime to convert
     * @param locale the locale for formatting
     * @return formatted date-time string using default format and specified locale, or null if dateTime is null
     */
    @Override
    public String toDefaultFormatString(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(dateTime);
    }

    /**
     * Converts a LocalDate to String using default locale and pattern.
     *
     * @param date the LocalDate to convert
     * @return formatted date string using default settings, or null if date is null
     */
    @Override
    public String toString(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return date.format(formatter);
    }

    /**
     * Converts a LocalDateTime to String using specified locale and pattern.
     *
     * @param dateTime the LocalDateTime to convert
     * @param locale the locale for formatting
     * @param pattern the date-time format pattern
     * @return formatted date-time string using specified locale and pattern, or null if dateTime is null
     */
    @Override
    public String toString(LocalDateTime dateTime, Locale locale, String pattern) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withLocale(locale);
        return dateTime.format(formatter);
    }

    /**
     * Converts a LocalDateTime to String using specified locale and default pattern.
     *
     * @param dateTime the LocalDateTime to convert
     * @param locale the locale for formatting
     * @return formatted date-time string using specified locale, or null if dateTime is null
     */
    @Override
    public String toString(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return dateTime.format(formatter);
    }

    /**
     * Converts a LocalDateTime to String using specified pattern and default locale.
     *
     * @param dateTime the LocalDateTime to convert
     * @param pattern the date-time format pattern
     * @return formatted date-time string using specified pattern, or null if dateTime is null
     */
    @Override
    public String toString(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * Converts a LocalDateTime to String using default locale and pattern.
     *
     * @param dateTime the LocalDateTime to convert
     * @return formatted date-time string using default settings, or null if dateTime is null
     */
    @Override
    public String toString(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return dateTime.format(formatter);
    }

    /**
     * Converts a Timestamp to String using default locale and pattern.
     *
     * @param timestamp the Timestamp to convert
     * @return formatted timestamp string using default settings, or null if timestamp is null
     */
    @Override
    public String toString(Timestamp timestamp) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date);
    }

    /**
     * Converts a Timestamp to String using specified pattern and default locale.
     *
     * @param timestamp the Timestamp to convert
     * @param pattern the date-time format pattern
     * @return formatted timestamp string using specified pattern, or null if timestamp is null
     */
    @Override
    public String toString(Timestamp timestamp, String pattern) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, pattern);
    }

    /**
     * Converts a Timestamp to String using specified locale and default pattern.
     *
     * @param timestamp the Timestamp to convert
     * @param locale the locale for formatting
     * @return formatted timestamp string using specified locale, or null if timestamp is null
     */
    @Override
    public String toString(Timestamp timestamp, Locale locale) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, locale);
    }

    /**
     * Converts a Timestamp to String using specified locale and pattern.
     *
     * @param timestamp the Timestamp to convert
     * @param locale the locale for formatting
     * @param pattern the date-time format pattern
     * @return formatted timestamp string using specified locale and pattern, or null if timestamp is null
     */
    @Override
    public String toString(Timestamp timestamp, Locale locale, String pattern) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, locale, pattern);
    }

    /**
     * Converts a Timestamp to String using default format.
     *
     * @param timestamp the Timestamp to convert
     * @return formatted timestamp string using default format, or null if timestamp is null
     */
    @Override
    public String toDefaultFormatString(Timestamp timestamp) {
        if (timestamp == null) return null;
        java.util.Date date = this.toDate(timestamp);
        return this.toString(date);
    }

    /**
     * Converts a Timestamp to String using default format and specified locale.
     *
     * @param timestamp the Timestamp to convert
     * @param locale the locale for formatting
     * @return formatted timestamp string using default format and specified locale, or null if timestamp is null
     */
    @Override
    public String toDefaultFormatString(Timestamp timestamp, Locale locale) {
        if (timestamp == null) return null;
        LocalDateTime date = this.toLocalDateTime(timestamp);
        return this.toString(date, locale);
    }

    /**
     * Converts a long timestamp to String using default locale and pattern.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return formatted date string using default settings, or null if timestamp is 0
     */
    @Override
    public String toString(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date);
    }

    /**
     * Converts a long timestamp to String using specified pattern and default locale.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @param pattern the date format pattern
     * @return formatted date string using specified pattern, or null if timestamp is 0
     */
    @Override
    public String toString(long timestamp, String pattern) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, pattern);
    }

    /**
     * Converts a long timestamp to String using specified locale and default pattern.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @param locale the locale for formatting
     * @return formatted date string using specified locale, or null if timestamp is 0
     */
    @Override
    public String toString(long timestamp, Locale locale) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, locale);
    }

    /**
     * Converts a long timestamp to String using specified locale and pattern.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @param locale the locale for formatting
     * @param pattern the date format pattern
     * @return formatted date string using specified locale and pattern, or null if timestamp is 0
     */
    @Override
    public String toString(long timestamp, Locale locale, String pattern) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, locale, pattern);
    }

    /**
     * Converts a long timestamp to String using default format.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return formatted date string using default format, or null if timestamp is 0
     */
    @Override
    public String toDefaultFormatString(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = this.toDate(timestamp);
        return this.toString(date);
    }

    /**
     * Converts a long timestamp to String using default format and specified locale.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @param locale the locale for formatting
     * @return formatted date string using default format and specified locale, or null if timestamp is 0
     */
    @Override
    public String toDefaultFormatString(long timestamp, Locale locale) {
        if (timestamp == 0) return null;
        LocalDateTime dateTime = this.toLocalDateTime(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(dateTime);
    }

    /**
     * Converts a Timestamp to Unix timestamp (seconds since epoch).
     *
     * @param timestamp the Timestamp to convert
     * @return Unix timestamp in seconds since epoch, or 0 if timestamp is null
     */
    @Override
    public long toUnixTimestamp(Timestamp timestamp) {
        if (timestamp == null) return 0;
        return timestamp.getTime() / 1000L;
    }

    /**
     * Converts a java.util.Date to Unix timestamp (seconds since epoch).
     *
     * @param date the java.util.Date to convert
     * @return Unix timestamp in seconds since epoch, or 0 if date is null
     */
    @Override
    public long toUnixTimestamp(java.util.Date date) {
        if (date == null) return 0;
        return date.getTime() / 1000L;
    }

    /**
     * Converts a LocalDate to Unix timestamp (seconds since epoch).
     *
     * @param date the LocalDate to convert
     * @return Unix timestamp in seconds since epoch, or 0 if date is null
     */
    @Override
    public long toUnixTimestamp(LocalDate date) {
        if (date == null) return 0;
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        return this.toUnixTimestamp(timestamp);
    }

    /**
     * Converts a LocalDateTime to Unix timestamp (seconds since epoch).
     *
     * @param dateTime the LocalDateTime to convert
     * @return Unix timestamp in seconds since epoch
     */
    @Override
    public long toUnixTimestamp(LocalDateTime dateTime) {
        return (dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
    }

    /**
     * Converts a Timestamp to timestamp (milliseconds since epoch).
     *
     * @param timestamp the Timestamp to convert
     * @return timestamp in milliseconds since epoch, or 0 if timestamp is null
     */
    @Override
    public long toTimestamp(Timestamp timestamp) {
        if (timestamp == null) return 0;
        return timestamp.getTime();
    }

    /**
     * Converts a java.util.Date to timestamp (milliseconds since epoch).
     *
     * @param date the java.util.Date to convert
     * @return timestamp in milliseconds since epoch, or 0 if date is null
     */
    @Override
    public long toTimestamp(java.util.Date date) {
        if (date == null) return 0;
        return date.getTime();
    }

    /**
     * Converts a LocalDate to timestamp (milliseconds since epoch).
     *
     * @param date the LocalDate to convert
     * @return timestamp in milliseconds since epoch, or 0 if date is null
     */
    @Override
    public long toTimestamp(LocalDate date) {
        if (date == null) return 0;
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        return this.toTimestamp(timestamp);
    }

    /**
     * Converts a LocalDateTime to timestamp (milliseconds since epoch).
     *
     * @param dateTime the LocalDateTime to convert
     * @return timestamp in milliseconds since epoch
     */
    @Override
    public long toTimestamp(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * Converts a java.util.Date to SQL Timestamp.
     *
     * @param date the java.util.Date to convert
     * @return SQL Timestamp representation, or null if date is null
     */
    @Override
    public Timestamp toSqlTimestamp(java.util.Date date) {
        if (date == null) return null;
        return new Timestamp(date.getTime());
    }

    /**
     * Converts a LocalDate to SQL Timestamp (sets time to start of day).
     *
     * @param date the LocalDate to convert
     * @return SQL Timestamp representation with time set to start of day, or null if date is null
     */
    @Override
    public Timestamp toSqlTimestamp(LocalDate date) {
        if (date == null) return null;
        return Timestamp.valueOf(date.atStartOfDay());
    }

    /**
     * Converts a LocalDateTime to SQL Timestamp.
     *
     * @param dateTime the LocalDateTime to convert
     * @return SQL Timestamp representation
     */
    @Override
    public Timestamp toSqlTimestamp(LocalDateTime dateTime) {
        return new Timestamp(dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    /**
     * Converts a long timestamp to SQL Timestamp.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return SQL Timestamp representation
     */
    @Override
    public Timestamp toSqlTimestamp(long timestamp) {
        return new Timestamp(timestamp);
    }

    /**
     * Converts a LocalDate to java.util.Date.
     *
     * @param date the LocalDate to convert
     * @return java.util.Date representation, or null if date is null
     */
    @Override
    public java.util.Date toDate(LocalDate date) {
        if (date == null) return null;
        return new java.util.Date(Timestamp.valueOf(date.atStartOfDay()).getTime());
    }

    /**
     * Converts a LocalDateTime to java.util.Date.
     *
     * @param dateTime the LocalDateTime to convert
     * @return java.util.Date representation
     */
    @Override
    public Date toDate(LocalDateTime dateTime) {
        return java.util.Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Converts a Timestamp to java.util.Date.
     *
     * @param timestamp the Timestamp to convert
     * @return java.util.Date representation, or null if timestamp is null
     */
    @Override
    public java.util.Date toDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return new java.util.Date(timestamp.getTime());
    }

    /**
     * Converts a Timestamp to LocalDate.
     *
     * @param timestamp the Timestamp to convert
     * @return LocalDate representation, or null if timestamp is null
     */
    @Override
    public LocalDate toLocalDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return timestamp.toLocalDateTime().toLocalDate();
    }

    /**
     * Converts a java.util.Date to LocalDate.
     *
     * @param date the java.util.Date to convert
     * @return LocalDate representation, or null if date is null
     */
    @Override
    public LocalDate toLocalDate(java.util.Date date) {
        if (date == null) return null;
        return this.toSqlTimestamp(date).toLocalDateTime().toLocalDate();
    }

    /**
     * Converts a long timestamp to java.util.Date.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return java.util.Date representation, or null if timestamp is 0
     */
    @Override
    public java.util.Date toDate(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return date;
    }

    /**
     * Converts a long timestamp to LocalDate.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return LocalDate representation, or null if timestamp is 0
     */
    @Override
    public LocalDate toLocalDate(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            timestamp = timestamp * 1000L;
        }
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Converts a String to java.util.Date using default locale and pattern.
     *
     * @param stringDate the date string to parse
     * @return parsed java.util.Date, or null if stringDate is null or empty
     */
    @Override
    public java.util.Date toDate(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return this.toDate(localDateTime);
    }

    /**
     * Converts a String to java.util.Date using specified pattern and default locale.
     *
     * @param stringDate the date string to parse
     * @param pattern the date format pattern
     * @return parsed java.util.Date, or null if stringDate is null or empty
     */
    @Override
    public java.util.Date toDate(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toDate(localDateTime);
    }

    /**
     * Converts a String to java.util.Date using specified locale and default pattern.
     *
     * @param stringDate the date string to parse
     * @param locale the locale for parsing
     * @return parsed java.util.Date, or null if stringDate is null or empty
     */
    @Override
    public java.util.Date toDate(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, this.defaultPattern);
        return this.toDate(localDateTime);
    }

    /**
     * Converts a String to java.util.Date using specified locale and pattern.
     *
     * @param stringDate the date string to parse
     * @param locale the locale for parsing
     * @param pattern the date format pattern
     * @return parsed java.util.Date, or null if stringDate is null or empty
     */
    @Override
    public java.util.Date toDate(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toDate(localDateTime);
    }

    /**
     * Converts a LocalDateTime to LocalDate (truncates time portion).
     *
     * @param localDateTime the LocalDateTime to convert
     * @return LocalDate representation (time portion truncated)
     */
    @Override
    public LocalDate toLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    /**
     * Converts a String to SQL Timestamp using default locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @return parsed SQL Timestamp, or null if stringDate is null or empty
     */
    @Override
    public Timestamp toSqlTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate);
        return this.toSqlTimestamp(dateTime);
    }

    /**
     * Converts a String to SQL Timestamp using specified pattern and default locale.
     *
     * @param stringDate the date-time string to parse
     * @param pattern the date-time format pattern
     * @return parsed SQL Timestamp, or null if stringDate is null or empty
     */
    @Override
    public Timestamp toSqlTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        long timestamp = this.toTimestamp(stringDate, pattern);
        return this.toSqlTimestamp(timestamp);
    }

    /**
     * Converts a String to SQL Timestamp using specified locale and default pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @return parsed SQL Timestamp, or null if stringDate is null or empty
     */
    @Override
    public Timestamp toSqlTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate, locale);
        return this.toSqlTimestamp(dateTime);
    }

    /**
     * Converts a String to SQL Timestamp using specified locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @param pattern the date-time format pattern
     * @return parsed SQL Timestamp, or null if stringDate is null or empty
     */
    @Override
    public Timestamp toSqlTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate, locale);
        return this.toSqlTimestamp(dateTime);
    }

    /**
     * Converts a String to timestamp using default locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @return timestamp in milliseconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return this.toTimestamp(localDateTime);
    }

    /**
     * Converts a String to timestamp using specified pattern and default locale.
     *
     * @param stringDate the date-time string to parse
     * @param pattern the date-time format pattern
     * @return timestamp in milliseconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toTimestamp(localDateTime);
    }

    /**
     * Converts a String to timestamp using specified locale and default pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @return timestamp in milliseconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale);
        return this.toTimestamp(localDateTime);
    }

    /**
     * Converts a String to timestamp using specified locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @param pattern the date-time format pattern
     * @return timestamp in milliseconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale, pattern);
        return this.toTimestamp(localDateTime);
    }

    /**
     * Converts a String to Unix timestamp using default locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @return Unix timestamp in seconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toUnixTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    /**
     * Converts a String to Unix timestamp using specified pattern and default locale.
     *
     * @param stringDate the date-time string to parse
     * @param pattern the date-time format pattern
     * @return Unix timestamp in seconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toUnixTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    /**
     * Converts a String to Unix timestamp using specified locale and default pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @return Unix timestamp in seconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toUnixTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    /**
     * Converts a String to Unix timestamp using specified locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @param pattern the date-time format pattern
     * @return Unix timestamp in seconds since epoch, or 0 if stringDate is null or empty
     */
    @Override
    public long toUnixTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale, pattern);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    /**
     * Converts a String to LocalDate using default locale and pattern.
     *
     * @param stringDate the date string to parse
     * @return parsed LocalDate, or null if stringDate is null or empty
     */
    @Override
    public LocalDate toLocalDate(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern, this.defaultLocale);
        return LocalDate.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDate using specified pattern and default locale.
     *
     * @param stringDate the date string to parse
     * @param pattern the date format pattern
     * @return parsed LocalDate, or null if stringDate is null or empty
     */
    @Override
    public LocalDate toLocalDate(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, this.defaultLocale);
        return LocalDate.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDate using specified locale and default pattern.
     *
     * @param stringDate the date string to parse
     * @param locale the locale for parsing
     * @return parsed LocalDate, or null if stringDate is null or empty
     */
    @Override
    public LocalDate toLocalDate(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern, locale);
        return LocalDate.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDate using specified locale and pattern.
     *
     * @param stringDate the date string to parse
     * @param locale the locale for parsing
     * @param pattern the date format pattern
     * @return parsed LocalDate, or null if stringDate is null or empty
     */
    @Override
    public LocalDate toLocalDate(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return LocalDate.parse(stringDate, formatter);
    }

    /**
     * Converts a LocalDate to LocalDateTime (sets time to start of day).
     *
     * @param localDate the LocalDate to convert
     * @return LocalDateTime representation with time set to start of day
     */
    @Override
    public LocalDateTime toLocalDateTime(LocalDate localDate) {
        return this.toSqlTimestamp(localDate).toLocalDateTime();
    }

    /**
     * Converts a Timestamp to LocalDateTime.
     *
     * @param timestamp the Timestamp to convert
     * @return LocalDateTime representation
     */
    @Override
    public LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

    /**
     * Converts a java.util.Date to LocalDateTime.
     *
     * @param date the java.util.Date to convert
     * @return LocalDateTime representation
     */
    @Override
    public LocalDateTime toLocalDateTime(Date date) {
        return this.toSqlTimestamp(date).toLocalDateTime();
    }

    /**
     * Converts a long timestamp to LocalDateTime.
     *
     * @param timestamp the timestamp in milliseconds since epoch
     * @return LocalDateTime representation
     */
    @Override
    public LocalDateTime toLocalDateTime(long timestamp) {
        return this.toSqlTimestamp(timestamp).toLocalDateTime();
    }

    /**
     * Converts a String to LocalDateTime using default locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @return parsed LocalDateTime
     */
    @Override
    public LocalDateTime toLocalDateTime(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDateTime using specified pattern and default locale.
     *
     * @param stringDate the date-time string to parse
     * @param pattern the date-time format pattern
     * @return parsed LocalDateTime
     */
    @Override
    public LocalDateTime toLocalDateTime(String stringDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDateTime using specified locale and default pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @return parsed LocalDateTime
     */
    @Override
    public LocalDateTime toLocalDateTime(String stringDate, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    /**
     * Converts a String to LocalDateTime using specified locale and pattern.
     *
     * @param stringDate the date-time string to parse
     * @param locale the locale for parsing
     * @param pattern the date-time format pattern
     * @return parsed LocalDateTime
     */
    @Override
    public LocalDateTime toLocalDateTime(String stringDate, Locale locale, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    /**
     * Gets the default locale used for formatting and parsing.
     *
     * @return the default locale
     */
    @Override
    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    /**
     * Sets the default locale for formatting and parsing.
     *
     * @param defaultLocale the locale to set as default
     */
    @Override
    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * Gets the default date/time pattern used for formatting and parsing.
     *
     * @return the default pattern
     */
    @Override
    public String getDefaultPattern() {
        return defaultPattern;
    }

    /**
     * Sets the default date/time pattern for formatting and parsing.
     *
     * @param defaultPattern the pattern to set as default
     */
    @Override
    public void setDefaultPattern(String defaultPattern) {
        this.defaultPattern = defaultPattern;
    }

    /**
     * Checks if the given timestamp value is a valid Unix timestamp (seconds since epoch).
     *
     * @param timestamp the timestamp value to check
     * @return true if the timestamp represents a valid Unix timestamp, false otherwise
     */
    public boolean isUnixTimestamp(long timestamp) {
        String strTimestamp = String.valueOf(timestamp);
        return strTimestamp.length() <= 10;
    }
}