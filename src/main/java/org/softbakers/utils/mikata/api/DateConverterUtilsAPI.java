package org.softbakers.utils.mikata.api;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * DateConverterUtilAPI Interface for Date conversion methods.
 * Provides comprehensive date and time conversion utilities between various date representations
 * including java.util.Date, LocalDate, LocalDateTime, Timestamp, and String formats.
 * Supports locale-specific formatting and parsing with customizable patterns.
 *
 * @author Mohamed Lamine JELLAD from Softbakers
 * @version 1.0.0
 */
public interface DateConverterUtilsAPI {

        // =========================================================================
        // toString conversion methods
        // =========================================================================

        /**
         * Converts a java.util.Date to String using default locale and pattern.
         *
         * @param date the date to convert
         * @return formatted date string using default settings
         */
        public String toString(java.util.Date date);

        /**
         * Converts a java.util.Date to String using specified pattern and default locale.
         *
         * @param date the date to convert
         * @param pattern the date format pattern (e.g., "yyyy-MM-dd HH:mm:ss")
         * @return formatted date string using specified pattern
         */
        public String toString(java.util.Date date, String pattern);

        /**
         * Converts a java.util.Date to String using specified locale and default pattern.
         *
         * @param date the date to convert
         * @param locale the locale for formatting
         * @return formatted date string using specified locale
         */
        public String toString(java.util.Date date, Locale locale);

        /**
         * Converts a java.util.Date to String using specified locale and pattern.
         *
         * @param date the date to convert
         * @param locale the locale for formatting
         * @param pattern the date format pattern
         * @return formatted date string using specified locale and pattern
         */
        public String toString(java.util.Date date, Locale locale, String pattern);

        /**
         * Converts a LocalDate to String using specified locale and pattern.
         *
         * @param date the LocalDate to convert
         * @param locale the locale for formatting
         * @param pattern the date format pattern
         * @return formatted date string using specified locale and pattern
         */
        public String toString(LocalDate date, Locale locale, String pattern);

        /**
         * Converts a LocalDate to String using specified locale and default pattern.
         *
         * @param date the LocalDate to convert
         * @param locale the locale for formatting
         * @return formatted date string using specified locale
         */
        public String toString(LocalDate date, Locale locale);

        /**
         * Converts a LocalDate to String using specified pattern and default locale.
         *
         * @param date the LocalDate to convert
         * @param pattern the date format pattern
         * @return formatted date string using specified pattern
         */
        public String toString(LocalDate date, String pattern);

        /**
         * Converts a LocalDate to String using default locale and pattern.
         *
         * @param date the LocalDate to convert
         * @return formatted date string using default settings
         */
        public String toString(LocalDate date);

        /**
         * Converts a LocalDateTime to String using specified locale and pattern.
         *
         * @param dateTime the LocalDateTime to convert
         * @param locale the locale for formatting
         * @param pattern the date-time format pattern
         * @return formatted date-time string using specified locale and pattern
         */
        public String toString(LocalDateTime dateTime, Locale locale, String pattern);

        /**
         * Converts a LocalDateTime to String using specified locale and default pattern.
         *
         * @param dateTime the LocalDateTime to convert
         * @param locale the locale for formatting
         * @return formatted date-time string using specified locale
         */
        public String toString(LocalDateTime dateTime, Locale locale);

        /**
         * Converts a LocalDateTime to String using specified pattern and default locale.
         *
         * @param dateTime the LocalDateTime to convert
         * @param pattern the date-time format pattern
         * @return formatted date-time string using specified pattern
         */
        public String toString(LocalDateTime dateTime, String pattern);

        /**
         * Converts a LocalDateTime to String using default locale and pattern.
         *
         * @param dateTime the LocalDateTime to convert
         * @return formatted date-time string using default settings
         */
        public String toString(LocalDateTime dateTime);

        /**
         * Converts a Timestamp to String using default locale and pattern.
         *
         * @param timestamp the Timestamp to convert
         * @return formatted timestamp string using default settings
         */
        public String toString(Timestamp timestamp);

        /**
         * Converts a Timestamp to String using specified pattern and default locale.
         *
         * @param timestamp the Timestamp to convert
         * @param pattern the date-time format pattern
         * @return formatted timestamp string using specified pattern
         */
        public String toString(Timestamp timestamp, String pattern);

        /**
         * Converts a Timestamp to String using specified locale and default pattern.
         *
         * @param timestamp the Timestamp to convert
         * @param locale the locale for formatting
         * @return formatted timestamp string using specified locale
         */
        public String toString(Timestamp timestamp, Locale locale);

        /**
         * Converts a Timestamp to String using specified locale and pattern.
         *
         * @param timestamp the Timestamp to convert
         * @param locale the locale for formatting
         * @param pattern the date-time format pattern
         * @return formatted timestamp string using specified locale and pattern
         */
        public String toString(Timestamp timestamp, Locale locale,String pattern);

        /**
         * Converts a long timestamp to String using default locale and pattern.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return formatted date string using default settings
         */
        public String toString(long timestamp);

        /**
         * Converts a long timestamp to String using specified pattern and default locale.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @param pattern the date format pattern
         * @return formatted date string using specified pattern
         */
        public String toString(long timestamp, String pattern);

        /**
         * Converts a long timestamp to String using specified locale and default pattern.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @param locale the locale for formatting
         * @return formatted date string using specified locale
         */
        public String toString(long timestamp, Locale locale);

        /**
         * Converts a long timestamp to String using specified locale and pattern.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @param locale the locale for formatting
         * @param pattern the date format pattern
         * @return formatted date string using specified locale and pattern
         */
        public String toString(long timestamp, Locale locale,String pattern);

        // =========================================================================
        // toDefaultFormatString conversion methods
        // =========================================================================

        /**
         * Converts a java.util.Date to String using default format.
         *
         * @param date the date to convert
         * @return formatted date string using default format
         */
        public String toDefaultFormatString(java.util.Date date);

        /**
         * Converts a java.util.Date to String using default format and specified locale.
         *
         * @param date the date to convert
         * @param locale the locale for formatting
         * @return formatted date string using default format and specified locale
         */
        public String toDefaultFormatString(java.util.Date date, Locale locale);

        /**
         * Converts a LocalDate to String using default format.
         *
         * @param date the LocalDate to convert
         * @return formatted date string using default format
         */
        public String toDefaultFormatString(LocalDate date);

        /**
         * Converts a LocalDate to String using default format and specified locale.
         *
         * @param date the LocalDate to convert
         * @param locale the locale for formatting
         * @return formatted date string using default format and specified locale
         */
        public String toDefaultFormatString(LocalDate date, Locale locale);

        /**
         * Converts a LocalDateTime to String using default format.
         *
         * @param dateTime the LocalDateTime to convert
         * @return formatted date-time string using default format
         */
        public String toDefaultFormatString(LocalDateTime dateTime);

        /**
         * Converts a LocalDateTime to String using default format and specified locale.
         *
         * @param dateTime the LocalDateTime to convert
         * @param locale the locale for formatting
         * @return formatted date-time string using default format and specified locale
         */
        public String toDefaultFormatString(LocalDateTime dateTime, Locale locale);

        /**
         * Converts a Timestamp to String using default format.
         *
         * @param timestamp the Timestamp to convert
         * @return formatted timestamp string using default format
         */
        public String toDefaultFormatString(Timestamp timestamp);

        /**
         * Converts a Timestamp to String using default format and specified locale.
         *
         * @param timestamp the Timestamp to convert
         * @param locale the locale for formatting
         * @return formatted timestamp string using default format and specified locale
         */
        public String toDefaultFormatString(Timestamp timestamp, Locale locale);

        /**
         * Converts a long timestamp to String using default format.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return formatted date string using default format
         */
        public String toDefaultFormatString(long timestamp);

        /**
         * Converts a long timestamp to String using default format and specified locale.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @param locale the locale for formatting
         * @return formatted date string using default format and specified locale
         */
        public String toDefaultFormatString(long timestamp, Locale locale);

        // =========================================================================
        // toDate conversion methods
        // =========================================================================

        /**
         * Converts a LocalDate to java.util.Date.
         *
         * @param date the LocalDate to convert
         * @return java.util.Date representation
         */
        public java.util.Date toDate(LocalDate date);

        /**
         * Converts a LocalDateTime to java.util.Date.
         *
         * @param dateTime the LocalDateTime to convert
         * @return java.util.Date representation
         */
        public java.util.Date toDate(LocalDateTime dateTime);

        /**
         * Converts a Timestamp to java.util.Date.
         *
         * @param timestamp the Timestamp to convert
         * @return java.util.Date representation
         */
        public java.util.Date toDate(Timestamp timestamp);

        /**
         * Converts a long timestamp to java.util.Date.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return java.util.Date representation
         */
        public java.util.Date toDate(long timestamp);

        /**
         * Converts a String to java.util.Date using default locale and pattern.
         *
         * @param stringDate the date string to parse
         * @return parsed java.util.Date
         */
        public java.util.Date toDate(String stringDate);

        /**
         * Converts a String to java.util.Date using specified pattern and default locale.
         *
         * @param stringDate the date string to parse
         * @param pattern the date format pattern
         * @return parsed java.util.Date
         */
        public java.util.Date toDate(String stringDate, String pattern);

        /**
         * Converts a String to java.util.Date using specified locale and default pattern.
         *
         * @param stringDate the date string to parse
         * @param locale the locale for parsing
         * @return parsed java.util.Date
         */
        public java.util.Date toDate(String stringDate, Locale locale);

        /**
         * Converts a String to java.util.Date using specified locale and pattern.
         *
         * @param stringDate the date string to parse
         * @param locale the locale for parsing
         * @param pattern the date format pattern
         * @return parsed java.util.Date
         */
        public java.util.Date toDate(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // toLocalDate conversion methods
        // =========================================================================

        /**
         * Converts a LocalDateTime to LocalDate (truncates time portion).
         *
         * @param localDateTime the LocalDateTime to convert
         * @return LocalDate representation (time portion truncated)
         */
        public LocalDate toLocalDate(LocalDateTime localDateTime);

        /**
         * Converts a Timestamp to LocalDate.
         *
         * @param timestamp the Timestamp to convert
         * @return LocalDate representation
         */
        public LocalDate toLocalDate(Timestamp timestamp);

        /**
         * Converts a java.util.Date to LocalDate.
         *
         * @param date the java.util.Date to convert
         * @return LocalDate representation
         */
        public LocalDate toLocalDate(java.util.Date date);

        /**
         * Converts a long timestamp to LocalDate.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return LocalDate representation
         */
        public LocalDate toLocalDate(long timestamp);

        /**
         * Converts a String to LocalDate using default locale and pattern.
         *
         * @param stringDate the date string to parse
         * @return parsed LocalDate
         */
        public LocalDate toLocalDate(String stringDate);

        /**
         * Converts a String to LocalDate using specified pattern and default locale.
         *
         * @param stringDate the date string to parse
         * @param pattern the date format pattern
         * @return parsed LocalDate
         */
        public LocalDate toLocalDate(String stringDate, String pattern);

        /**
         * Converts a String to LocalDate using specified locale and default pattern.
         *
         * @param stringDate the date string to parse
         * @param locale the locale for parsing
         * @return parsed LocalDate
         */
        public LocalDate toLocalDate(String stringDate, Locale locale);

        /**
         * Converts a String to LocalDate using specified locale and pattern.
         *
         * @param stringDate the date string to parse
         * @param locale the locale for parsing
         * @param pattern the date format pattern
         * @return parsed LocalDate
         */
        public LocalDate toLocalDate(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // toLocalDateTime conversion methods
        // =========================================================================

        /**
         * Converts a LocalDate to LocalDateTime (sets time to start of day).
         *
         * @param localDate the LocalDate to convert
         * @return LocalDateTime representation with time set to start of day
         */
        public LocalDateTime toLocalDateTime(LocalDate localDate);

        /**
         * Converts a Timestamp to LocalDateTime.
         *
         * @param timestamp the Timestamp to convert
         * @return LocalDateTime representation
         */
        public LocalDateTime toLocalDateTime(Timestamp timestamp);

        /**
         * Converts a java.util.Date to LocalDateTime.
         *
         * @param date the java.util.Date to convert
         * @return LocalDateTime representation
         */
        public LocalDateTime toLocalDateTime(java.util.Date date);

        /**
         * Converts a long timestamp to LocalDateTime.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return LocalDateTime representation
         */
        public LocalDateTime toLocalDateTime(long timestamp);

        /**
         * Converts a String to LocalDateTime using default locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @return parsed LocalDateTime
         */
        public LocalDateTime toLocalDateTime(String stringDate);

        /**
         * Converts a String to LocalDateTime using specified pattern and default locale.
         *
         * @param stringDate the date-time string to parse
         * @param pattern the date-time format pattern
         * @return parsed LocalDateTime
         */
        public LocalDateTime toLocalDateTime(String stringDate, String pattern);

        /**
         * Converts a String to LocalDateTime using specified locale and default pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @return parsed LocalDateTime
         */
        public LocalDateTime toLocalDateTime(String stringDate, Locale locale);

        /**
         * Converts a String to LocalDateTime using specified locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @param pattern the date-time format pattern
         * @return parsed LocalDateTime
         */
        public LocalDateTime toLocalDateTime(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // toSqlTimestamp conversion methods
        // =========================================================================

        /**
         * Converts a java.util.Date to SQL Timestamp.
         *
         * @param date the java.util.Date to convert
         * @return SQL Timestamp representation
         */
        public Timestamp toSqlTimestamp(java.util.Date date);

        /**
         * Converts a LocalDate to SQL Timestamp (sets time to start of day).
         *
         * @param date the LocalDate to convert
         * @return SQL Timestamp representation with time set to start of day
         */
        public Timestamp toSqlTimestamp(LocalDate date);

        /**
         * Converts a LocalDateTime to SQL Timestamp.
         *
         * @param dateTime the LocalDateTime to convert
         * @return SQL Timestamp representation
         */
        public Timestamp toSqlTimestamp(LocalDateTime dateTime);

        /**
         * Converts a long timestamp to SQL Timestamp.
         *
         * @param timestamp the timestamp in milliseconds since epoch
         * @return SQL Timestamp representation
         */
        public Timestamp toSqlTimestamp(long timestamp);

        /**
         * Converts a String to SQL Timestamp using default locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @return parsed SQL Timestamp
         */
        public Timestamp toSqlTimestamp(String stringDate);

        /**
         * Converts a String to SQL Timestamp using specified pattern and default locale.
         *
         * @param stringDate the date-time string to parse
         * @param pattern the date-time format pattern
         * @return parsed SQL Timestamp
         */
        public Timestamp toSqlTimestamp(String stringDate, String pattern);

        /**
         * Converts a String to SQL Timestamp using specified locale and default pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @return parsed SQL Timestamp
         */
        public Timestamp toSqlTimestamp(String stringDate, Locale locale);

        /**
         * Converts a String to SQL Timestamp using specified locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @param pattern the date-time format pattern
         * @return parsed SQL Timestamp
         */
        public Timestamp toSqlTimestamp(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // toTimestamp conversion methods
        // =========================================================================

        /**
         * Converts a java.util.Date to timestamp (milliseconds since epoch).
         *
         * @param date the java.util.Date to convert
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(java.util.Date date);

        /**
         * Converts a LocalDate to timestamp (milliseconds since epoch).
         *
         * @param date the LocalDate to convert
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(LocalDate date);

        /**
         * Converts a LocalDateTime to timestamp (milliseconds since epoch).
         *
         * @param dateTime the LocalDateTime to convert
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(LocalDateTime dateTime);

        /**
         * Converts a Timestamp to timestamp (milliseconds since epoch).
         *
         * @param timestamp the Timestamp to convert
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(Timestamp timestamp);

        /**
         * Converts a String to timestamp using default locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(String stringDate);

        /**
         * Converts a String to timestamp using specified pattern and default locale.
         *
         * @param stringDate the date-time string to parse
         * @param pattern the date-time format pattern
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(String stringDate, String pattern);

        /**
         * Converts a String to timestamp using specified locale and default pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(String stringDate, Locale locale);

        /**
         * Converts a String to timestamp using specified locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @param pattern the date-time format pattern
         * @return timestamp in milliseconds since epoch
         */
        public long toTimestamp(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // toUnixTimestamp conversion methods
        // =========================================================================

        /**
         * Converts a Timestamp to Unix timestamp (seconds since epoch).
         *
         * @param timestamp the Timestamp to convert
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(Timestamp timestamp);

        /**
         * Converts a java.util.Date to Unix timestamp (seconds since epoch).
         *
         * @param date the java.util.Date to convert
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(java.util.Date date);

        /**
         * Converts a LocalDate to Unix timestamp (seconds since epoch).
         *
         * @param date the LocalDate to convert
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(LocalDate date);

        /**
         * Converts a LocalDateTime to Unix timestamp (seconds since epoch).
         *
         * @param dateTime the LocalDateTime to convert
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(LocalDateTime dateTime);

        /**
         * Converts a String to Unix timestamp using default locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(String stringDate);

        /**
         * Converts a String to Unix timestamp using specified pattern and default locale.
         *
         * @param stringDate the date-time string to parse
         * @param pattern the date-time format pattern
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(String stringDate, String pattern);

        /**
         * Converts a String to Unix timestamp using specified locale and default pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(String stringDate, Locale locale);

        /**
         * Converts a String to Unix timestamp using specified locale and pattern.
         *
         * @param stringDate the date-time string to parse
         * @param locale the locale for parsing
         * @param pattern the date-time format pattern
         * @return Unix timestamp in seconds since epoch
         */
        public long toUnixTimestamp(String stringDate, Locale locale, String pattern);

        // =========================================================================
        // Configuration methods
        // =========================================================================

        /**
         * Gets the default locale used for formatting and parsing.
         *
         * @return the default locale
         */
        public Locale getDefaultLocale();

        /**
         * Sets the default locale for formatting and parsing.
         *
         * @param defaultLocale the locale to set as default
         */
        public void setDefaultLocale(Locale defaultLocale);

        /**
         * Gets the default date/time pattern used for formatting and parsing.
         *
         * @return the default pattern
         */
        public String getDefaultPattern();

        /**
         * Sets the default date/time pattern for formatting and parsing.
         *
         * @param defaultPattern the pattern to set as default
         */
        public void setDefaultPattern(String defaultPattern);

}