package com.softbakers.utils.mikata.helper;

import com.softbakers.utils.mikata.api.DateConverterUtilAPI;

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
 * DateConverterUtil - Date util for convert different date types and format
 * @author Mohamed Lamine JELLAD
  * @version 1.0.0
 */
public class DateConverterUtil implements DateConverterUtilAPI {

    private Locale defaultLocale = Locale.getDefault();
    private String defaultPattern = "yyyy-MM-dd";

    /**
    * DateConverterUtil : the default constructor
     */
    public DateConverterUtil() {
    }

    /**
     * DateConverterUtil : parameterized constructor
     * @param defaultLocale the oldest date
     * @param defaultPattern the newest date
     */
    public DateConverterUtil(Locale defaultLocale, String defaultPattern) {
        this.defaultLocale = defaultLocale;
        this.defaultPattern = defaultPattern;
    }

    /**
     * Get default format string from Date
     * @param date the oldest date
     * @return the string format for the date
     */
    @Override
    public String toDefaultFormatString(java.util.Date date) {
        if (date == null) return null;
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Convert date in question to string format with a locale in param
     * @param date the date to convert to string
     * @param locale the locale in question
     * @return the string format for the date with local in question
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
     * Convert date in question to string format
     * @param date the date to convert to string
     * @return the string format for the date
     */
    @Override
    public String toString(java.util.Date date) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(this.defaultPattern, this.defaultLocale);
        return formatter.format(date);
    }

    @Override
    public String toString(java.util.Date date, String pattern) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, this.defaultLocale);
        return formatter.format(date);
    }

    @Override
    public String toString(java.util.Date date, Locale locale) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(this.defaultPattern, locale);
        return formatter.format(date);
    }

    @Override
    public String toString(java.util.Date date, Locale locale, String pattern) {
        if (date == null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        return formatter.format(date);
    }

    @Override
    public String toString(LocalDate date, Locale locale, String pattern) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withLocale(locale);
        return date.format(formatter);
    }

    @Override
    public String toString(LocalDate date, Locale locale) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return date.format(formatter);
    }

    @Override
    public String toString(LocalDate date, String pattern) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    @Override
    public String toDefaultFormatString(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return formatter.format(date);
    }

    @Override
    public String toDefaultFormatString(LocalDate date, Locale locale) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return formatter.format(date);
    }

    @Override
    public String toDefaultFormatString(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return formatter.format(dateTime);
    }

    @Override
    public String toDefaultFormatString(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(dateTime);
    }

    @Override
    public String toString(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return date.format(formatter);
    }

    @Override
    public String toString(LocalDateTime dateTime, Locale locale, String pattern) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern)
                .withLocale(locale);
        return dateTime.format(formatter);
    }

    @Override
    public String toString(LocalDateTime dateTime, Locale locale) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return dateTime.format(formatter);
    }

    @Override
    public String toString(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    @Override
    public String toString(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.getDefault());
        return dateTime.format(formatter);
    }

    @Override
    public String toString(Timestamp timestamp) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date);
    }

    @Override
    public String toString(Timestamp timestamp, String pattern) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, pattern);
    }

    @Override
    public String toString(Timestamp timestamp, Locale locale) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, locale);
    }

    @Override
    public String toString(Timestamp timestamp, Locale locale,String pattern) {
        if (timestamp == null) return null;
        java.util.Date date = new java.util.Date(timestamp.getTime());
        return this.toString(date, locale, pattern);
    }

    @Override
    public String toDefaultFormatString(Timestamp timestamp) {
        if (timestamp == null) return null;
        java.util.Date date = this.toDate(timestamp);
        return this.toString(date);
    }

    @Override
    public String toDefaultFormatString(Timestamp timestamp, Locale locale) {
        if (timestamp == null) return null;
        LocalDateTime date = this.toLocalDateTime(timestamp);
        return this.toString(date, locale);
    }

    @Override
    public String toString(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date);
    }

    @Override
    public String toString(long timestamp, String pattern) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, pattern);
    }

    @Override
    public String toString(long timestamp, Locale locale) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, locale);
    }

    @Override
    public String toString(long timestamp, Locale locale,String pattern) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return this.toString(date, locale, pattern);
    }

    @Override
    public String toDefaultFormatString(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = this.toDate(timestamp);
        return this.toString(date);
    }

    @Override
    public String toDefaultFormatString(long timestamp, Locale locale) {
        if (timestamp == 0) return null;
        LocalDateTime dateTime = this.toLocalDateTime(timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);
        return formatter.format(dateTime);
    }

    @Override
    public long toUnixTimestamp(Timestamp timestamp) {
        if (timestamp == null) return 0;
        return timestamp.getTime() / 1000L;
    }

    @Override
    public long toUnixTimestamp(java.util.Date date) {
        if (date == null) return 0;
        return date.getTime() / 1000L;
    }

    @Override
    public long toUnixTimestamp(LocalDate date) {
        if (date == null) return 0;
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        return this.toUnixTimestamp(timestamp);
    }

    @Override
    public long toUnixTimestamp(LocalDateTime dateTime) {
        return (dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() / 1000);
    }

    @Override
    public long toTimestamp(Timestamp timestamp) {
        if (timestamp == null) return 0;
        return timestamp.getTime();
    }

    @Override
    public long toTimestamp(java.util.Date date) {
        if (date == null) return 0;
        return date.getTime();
    }

    @Override
    public long toTimestamp(LocalDate date) {
        if (date == null) return 0;
        Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());
        return this.toTimestamp(timestamp);
    }

    @Override
    public long toTimestamp(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    @Override
    public Timestamp toSqlTimestamp(java.util.Date date) {
        if (date == null) return null;
        return new Timestamp(date.getTime());
    }

    @Override
    public Timestamp toSqlTimestamp(LocalDate date) {
        if (date == null) return null;
        return Timestamp.valueOf(date.atStartOfDay());
    }

    @Override
    public Timestamp toSqlTimestamp(LocalDateTime dateTime) {
        return new Timestamp(dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    @Override
    public Timestamp toSqlTimestamp(long timestamp) {
        return new Timestamp(timestamp);
    }


    @Override
    public java.util.Date toDate(LocalDate date) {
        if (date == null) return null;
        return new java.util.Date(Timestamp.valueOf(date.atStartOfDay()).getTime());
    }

    @Override
    public Date toDate(LocalDateTime dateTime) {
        return java.util.Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public java.util.Date toDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return new java.util.Date(timestamp.getTime());
    }

    @Override
    public LocalDate toLocalDate(Timestamp timestamp) {
        if (timestamp == null) return null;
        return timestamp.toLocalDateTime().toLocalDate();
    }

    @Override
    public LocalDate toLocalDate(java.util.Date date) {
        if (date == null) return null;
        return this.toSqlTimestamp(date).toLocalDateTime().toLocalDate();
    }

    @Override
    public java.util.Date toDate(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            date = new java.util.Date(timestamp * 1000L);
        }
        return date;
    }

    @Override
    public LocalDate toLocalDate(long timestamp) {
        if (timestamp == 0) return null;
        java.util.Date date = new java.util.Date(timestamp);
        if(this.isUnixTimestamp(timestamp)) {
            timestamp = timestamp * 1000L;
        }
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public java.util.Date toDate(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return this.toDate(localDateTime);
    }

    @Override
    public java.util.Date toDate(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toDate(localDateTime);
    }

    @Override
    public java.util.Date toDate(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, this.defaultPattern);
        return this.toDate(localDateTime);
    }

    @Override
    public java.util.Date toDate(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toDate(localDateTime);
    }

    @Override
    public LocalDate toLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    @Override
    public Timestamp toSqlTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate);
        return this.toSqlTimestamp(dateTime);
    }

    @Override
    public Timestamp toSqlTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        long timestamp = this.toTimestamp(stringDate, pattern);
        return this.toSqlTimestamp(timestamp);
    }

    @Override
    public Timestamp toSqlTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate, locale);
        return this.toSqlTimestamp(dateTime);
    }

    @Override
    public Timestamp toSqlTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        LocalDateTime dateTime = this.toLocalDateTime(stringDate, locale);
        return this.toSqlTimestamp(dateTime);
    }

    @Override
    public long toTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return this.toTimestamp(localDateTime);
    }

    @Override
    public long toTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return this.toTimestamp(localDateTime);
    }

    @Override
    public long toTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale);
        return this.toTimestamp(localDateTime);
    }

    @Override
    public long toTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale, pattern);
        return this.toTimestamp(localDateTime);
    }

    @Override
    public long toUnixTimestamp(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    @Override
    public long toUnixTimestamp(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, pattern);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    @Override
    public long toUnixTimestamp(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    @Override
    public long toUnixTimestamp(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return 0;
        LocalDateTime localDateTime = this.toLocalDateTime(stringDate, locale, pattern);
        return (this.toTimestamp(localDateTime) / 1000L);
    }

    @Override
    public LocalDate toLocalDate(String stringDate) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern, this.defaultLocale);
        return LocalDate.parse(stringDate, formatter);
    }

    @Override
    public LocalDate toLocalDate(String stringDate, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, this.defaultLocale);
        return LocalDate.parse(stringDate, formatter);
    }

    @Override
    public LocalDate toLocalDate(String stringDate, Locale locale) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern, locale);
        return LocalDate.parse(stringDate, formatter);
    }

    @Override
    public LocalDate toLocalDate(String stringDate, Locale locale, String pattern) {
        if (stringDate == null || stringDate.equalsIgnoreCase("")) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return LocalDate.parse(stringDate, formatter);
    }

    @Override
    public LocalDateTime toLocalDateTime(LocalDate localDate) {
        return this.toSqlTimestamp(localDate).toLocalDateTime();
    }

    @Override
    public LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }

    @Override
    public LocalDateTime toLocalDateTime(Date date) {
        return this.toSqlTimestamp(date).toLocalDateTime();
    }

    @Override
    public LocalDateTime toLocalDateTime(long timestamp) {
        return this.toSqlTimestamp(timestamp).toLocalDateTime();
    }

    @Override
    public LocalDateTime toLocalDateTime(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    @Override
    public LocalDateTime toLocalDateTime(String stringDate, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    @Override
    public LocalDateTime toLocalDateTime(String stringDate, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.defaultPattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    @Override
    public LocalDateTime toLocalDateTime(String stringDate, Locale locale, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(stringDate, formatter);
    }

    @Override
    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    @Override
    public void setDefaultLocale(Locale defaultLocale) {
      this. defaultLocale = defaultLocale;
    }

    @Override
    public String getDefaultPattern() {
        return defaultPattern;
    }

    @Override
    public void setDefaultPattern(String defaultPattern) {
      this. defaultPattern = defaultPattern;
    }

    private boolean isUnixTimestamp(long timestamp) {
        String strTimestamp = String.valueOf(timestamp);
        return strTimestamp.length() <= 10;
    }
}
