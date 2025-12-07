package org.softbakers.utils.mikata.api;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * DateUtilAPI Interface for comprehensive date manipulation utilities.
 * Provides methods for obtaining current date/time, comparing dates, calculating differences,
 * and measuring durations between various date/time representations.
 * Supports multiple date types including java.util.Date, LocalDate, LocalDateTime, Timestamp, and long timestamps.
 *
 * @author Softbakers
 * @version 1.0
 * @see DateType
 */
public interface DateUtilsAPI {

    // =========================================================================
    // Current Date/Time Methods
    // =========================================================================

    /**
     * Gets the current date and time as LocalDateTime.
     *
     * @return current LocalDateTime with system default time zone
     */
    public LocalDateTime now();

    /**
     * Gets the current date and time as java.util.Date.
     *
     * @return current java.util.Date
     */
    public java.util.Date date();

    /**
     * Gets the current date and time as LocalDateTime.
     *
     * @return current LocalDateTime
     */
    public LocalDateTime localDateTime();

    /**
     * Gets the current date as LocalDate (without time component).
     *
     * @return current LocalDate
     */
    public LocalDate localDate();

    /**
     * Gets the current timestamp in milliseconds since epoch.
     *
     * @return current timestamp in milliseconds
     */
    public long timestamp();

    /**
     * Gets the current Unix timestamp in seconds since epoch.
     *
     * @return current Unix timestamp in seconds
     */
    public long unixTimestamp();

    /**
     * Gets the current date and time as SQL Timestamp.
     *
     * @return current SQL Timestamp
     */
    public Timestamp sqlTimestamp();

    /**
     * Gets the current date/time as formatted String using default pattern and locale.
     *
     * @return formatted date/time string
     */
    public String string();

    /**
     * Gets the current date/time as formatted String using specified pattern.
     *
     * @param pattern the date format pattern to use
     * @return formatted date/time string
     */
    public String string(String pattern);

    /**
     * Gets the current date as formatted String for LocalDate using default pattern and locale.
     *
     * @return formatted date string
     */
    public String stringLocalDate();

    /**
     * Gets the current date as formatted String for LocalDate using specified locale.
     *
     * @param locale the locale for formatting
     * @return formatted date string
     */
    public String stringLocalDate(Locale locale);

    /**
     * Gets the current date as formatted String for LocalDate using specified locale and pattern.
     *
     * @param locale the locale for formatting
     * @param pattern the date format pattern
     * @return formatted date string
     */
    public String stringLocalDate(Locale locale, String pattern);

    /**
     * Gets the current date/time as formatted String for LocalDateTime using default pattern and locale.
     *
     * @return formatted date/time string
     */
    public String stringLocalDateTime();

    /**
     * Gets the current date/time as formatted String for LocalDateTime using specified locale.
     *
     * @param locale the locale for formatting
     * @return formatted date/time string
     */
    public String stringLocalDateTime(Locale locale);

    /**
     * Gets the current date/time as formatted String for LocalDateTime using specified locale and pattern.
     *
     * @param locale the locale for formatting
     * @param pattern the date/time format pattern
     * @return formatted date/time string
     */
    public String stringLocalDateTime(Locale locale, String pattern);

    /**
     * Gets the current date/time in the specified type representation.
     *
     * @param type the DateType specifying the desired return type
     * @return current date/time in the specified type format
     */
    public Object now(DateType type);

    // =========================================================================
    // Configuration Methods
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

    /**
     * Checks if the given timestamp value is a valid Unix timestamp (seconds since epoch).
     *
     * @param timestamp the timestamp value to check
     * @return true if the timestamp represents a valid Unix timestamp, false otherwise
     */
    public boolean isUnixTimestamp(long timestamp);

    // =========================================================================
    // Comparison Methods - java.util.Date
    // =========================================================================

    /**
     * Compares two java.util.Date objects.
     *
     * @param date1 the first date to compare
     * @param date2 the second date to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(java.util.Date date1, java.util.Date date2);

    /**
     * Compares a java.util.Date with a LocalDate.
     *
     * @param date1 the java.util.Date to compare
     * @param date2 the LocalDate to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(java.util.Date date1, LocalDate date2);

    /**
     * Compares a java.util.Date with a LocalDateTime.
     *
     * @param date1 the java.util.Date to compare
     * @param date2 the LocalDateTime to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(java.util.Date date1, LocalDateTime date2);

    /**
     * Compares a java.util.Date with a Timestamp.
     *
     * @param date1 the java.util.Date to compare
     * @param timestamp the Timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(java.util.Date date1, Timestamp timestamp);

    /**
     * Compares a java.util.Date with a long timestamp.
     *
     * @param date1 the java.util.Date to compare
     * @param timestamp the timestamp in milliseconds to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(java.util.Date date1, long timestamp);

    // =========================================================================
    // Comparison Methods - LocalDate
    // =========================================================================

    /**
     * Compares two LocalDate objects.
     *
     * @param date1 the first LocalDate to compare
     * @param date2 the second LocalDate to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDate date1, LocalDate date2);

    /**
     * Compares a LocalDate with a LocalDateTime.
     *
     * @param date1 the LocalDate to compare
     * @param date2 the LocalDateTime to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDate date1, LocalDateTime date2);

    /**
     * Compares a LocalDate with a java.util.Date.
     *
     * @param date1 the LocalDate to compare
     * @param date2 the java.util.Date to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDate date1, java.util.Date date2);

    /**
     * Compares a LocalDate with a Timestamp.
     *
     * @param date1 the LocalDate to compare
     * @param timestamp the Timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(LocalDate date1, Timestamp timestamp);

    /**
     * Compares a LocalDate with a long timestamp.
     *
     * @param date1 the LocalDate to compare
     * @param timestamp the timestamp in milliseconds to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(LocalDate date1, long timestamp);

    // =========================================================================
    // Comparison Methods - Timestamp
    // =========================================================================

    /**
     * Compares two Timestamp objects.
     *
     * @param timestamp1 the first Timestamp to compare
     * @param timestamp2 the second Timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first timestamp
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(Timestamp timestamp1, Timestamp timestamp2);

    /**
     * Compares a Timestamp with a java.util.Date.
     *
     * @param timestamp1 the Timestamp to compare
     * @param date the java.util.Date to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(Timestamp timestamp1, java.util.Date date);

    /**
     * Compares a Timestamp with a LocalDate.
     *
     * @param timestamp1 the Timestamp to compare
     * @param date the LocalDate to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(Timestamp timestamp1, LocalDate date);

    /**
     * Compares a Timestamp with a LocalDateTime.
     *
     * @param timestamp1 the Timestamp to compare
     * @param date the LocalDateTime to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(Timestamp timestamp1, LocalDateTime date);

    /**
     * Compares a Timestamp with a long timestamp.
     *
     * @param timestamp1 the Timestamp to compare
     * @param timestamp2 the timestamp in milliseconds to compare
     * @return a negative integer, zero, or a positive integer as the first timestamp
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(Timestamp timestamp1, long timestamp2);

    // =========================================================================
    // Comparison Methods - long timestamp
    // =========================================================================

    /**
     * Compares two long timestamps.
     *
     * @param timestamp1 the first timestamp in milliseconds
     * @param timestamp2 the second timestamp in milliseconds
     * @return a negative integer, zero, or a positive integer as the first timestamp
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(long timestamp1, long timestamp2);

    /**
     * Compares a long timestamp with a java.util.Date.
     *
     * @param timestamp1 the timestamp in milliseconds to compare
     * @param date the java.util.Date to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(long timestamp1, java.util.Date date);

    /**
     * Compares a long timestamp with a LocalDate.
     *
     * @param timestamp1 the timestamp in milliseconds to compare
     * @param date the LocalDate to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(long timestamp1, LocalDate date);

    /**
     * Compares a long timestamp with a LocalDateTime.
     *
     * @param timestamp1 the timestamp in milliseconds to compare
     * @param date the LocalDateTime to compare
     * @return a negative integer, zero, or a positive integer as the timestamp
     *         is less than, equal to, or greater than the date
     */
    public int compareTo(long timestamp1, LocalDateTime date);

    /**
     * Compares a long timestamp with a Timestamp.
     *
     * @param timestamp1 the timestamp in milliseconds to compare
     * @param timestamp2 the Timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first timestamp
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(long timestamp1, Timestamp timestamp2);

    // =========================================================================
    // Comparison Methods - LocalDateTime
    // =========================================================================

    /**
     * Compares two LocalDateTime objects.
     *
     * @param date1 the first LocalDateTime to compare
     * @param date2 the second LocalDateTime to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDateTime date1, LocalDateTime date2);

    /**
     * Compares a LocalDateTime with a java.util.Date.
     *
     * @param date1 the LocalDateTime to compare
     * @param date2 the java.util.Date to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDateTime date1, java.util.Date date2);

    /**
     * Compares a LocalDateTime with a LocalDate.
     *
     * @param date1 the LocalDateTime to compare
     * @param date2 the LocalDate to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the second
     */
    public int compareTo(LocalDateTime date1, LocalDate date2);

    /**
     * Compares a LocalDateTime with a Timestamp.
     *
     * @param date1 the LocalDateTime to compare
     * @param timestamp the Timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(LocalDateTime date1, Timestamp timestamp);

    /**
     * Compares a LocalDateTime with a long timestamp.
     *
     * @param date1 the LocalDateTime to compare
     * @param timestamp the timestamp in milliseconds to compare
     * @return a negative integer, zero, or a positive integer as the first date
     *         is less than, equal to, or greater than the timestamp
     */
    public int compareTo(LocalDateTime date1, long timestamp);

    // =========================================================================
    // Difference Methods - Complete breakdown by time units
    // =========================================================================

    /**
     * Calculates the difference between two java.util.Date objects broken down by time units.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return Map containing the difference in various time units (DAYS, HOURS, MINUTES, etc.)
     */
    public Map<TimeUnit,Long> diff(java.util.Date date1, java.util.Date date2);

    /**
     * Calculates the difference between a java.util.Date and a LocalDateTime.
     *
     * @param date1 the java.util.Date
     * @param dateTime2 the LocalDateTime
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(java.util.Date date1, LocalDateTime dateTime2);

    /**
     * Calculates the difference between a java.util.Date and a LocalDate.
     *
     * @param date1 the java.util.Date
     * @param date2 the LocalDate
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(java.util.Date date1, LocalDate date2);

    /**
     * Calculates the difference between a java.util.Date and a Timestamp.
     *
     * @param date1 the java.util.Date
     * @param timestamp the Timestamp
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(java.util.Date date1, Timestamp timestamp);

    /**
     * Calculates the difference between a java.util.Date and a long timestamp.
     *
     * @param date1 the java.util.Date
     * @param timestamp the timestamp in milliseconds
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(java.util.Date date1, long timestamp);

    /**
     * Calculates the difference between two LocalDateTime objects broken down by time units.
     *
     * @param dateTime1 the first LocalDateTime
     * @param dateTime2 the second LocalDateTime
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, LocalDateTime dateTime2);

    /**
     * Calculates the difference between a LocalDateTime and a java.util.Date.
     *
     * @param dateTime1 the LocalDateTime
     * @param date2 the java.util.Date
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, java.util.Date date2);

    /**
     * Calculates the difference between a LocalDateTime and a LocalDate.
     *
     * @param dateTime1 the LocalDateTime
     * @param date2 the LocalDate
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, LocalDate date2);

    /**
     * Calculates the difference between a LocalDateTime and a Timestamp.
     *
     * @param dateTime1 the LocalDateTime
     * @param timestamp the Timestamp
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, Timestamp timestamp);

    /**
     * Calculates the difference between a LocalDateTime and a long timestamp.
     *
     * @param dateTime1 the LocalDateTime
     * @param timestamp the timestamp in milliseconds
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, long timestamp);

    /**
     * Calculates the difference between two LocalDate objects broken down by time units.
     *
     * @param date1 the first LocalDate
     * @param date2 the second LocalDate
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDate date1, LocalDate date2);

    /**
     * Calculates the difference between a LocalDate and a java.util.Date.
     *
     * @param date1 the LocalDate
     * @param date2 the java.util.Date
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDate date1, java.util.Date date2);

    /**
     * Calculates the difference between a LocalDate and a LocalDateTime.
     *
     * @param date1 the LocalDate
     * @param dateTime2 the LocalDateTime
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDate date1, LocalDateTime dateTime2);

    /**
     * Calculates the difference between a LocalDate and a Timestamp.
     *
     * @param date1 the LocalDate
     * @param timestamp the Timestamp
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDate date1, Timestamp timestamp);

    /**
     * Calculates the difference between a LocalDate and a long timestamp.
     *
     * @param date1 the LocalDate
     * @param timestamp the timestamp in milliseconds
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(LocalDate date1, long timestamp);

    /**
     * Calculates the difference between a Timestamp and a LocalDate broken down by time units.
     *
     * @param timestamp the Timestamp
     * @param date the LocalDate
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(Timestamp timestamp, LocalDate date);

    /**
     * Calculates the difference between a Timestamp and a java.util.Date.
     *
     * @param timestamp the Timestamp
     * @param date the java.util.Date
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(Timestamp timestamp, java.util.Date date);

    /**
     * Calculates the difference between a Timestamp and a LocalDateTime.
     *
     * @param timestamp the Timestamp
     * @param dateTime the LocalDateTime
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(Timestamp timestamp, LocalDateTime dateTime);

    /**
     * Calculates the difference between two Timestamp objects broken down by time units.
     *
     * @param timestamp1 the first Timestamp
     * @param timestamp2 the second Timestamp
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(Timestamp timestamp1, Timestamp timestamp2);

    /**
     * Calculates the difference between a Timestamp and a long timestamp.
     *
     * @param timestamp1 the Timestamp
     * @param timestamp2 the timestamp in milliseconds
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(Timestamp timestamp1, long timestamp2);

    /**
     * Calculates the difference between a long timestamp and a LocalDate broken down by time units.
     *
     * @param timestamp the timestamp in milliseconds
     * @param date the LocalDate
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(long timestamp, LocalDate date);

    /**
     * Calculates the difference between a long timestamp and a java.util.Date.
     *
     * @param timestamp the timestamp in milliseconds
     * @param date the java.util.Date
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(long timestamp, java.util.Date date);

    /**
     * Calculates the difference between a long timestamp and a LocalDateTime.
     *
     * @param timestamp the timestamp in milliseconds
     * @param dateTime the LocalDateTime
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(long timestamp, LocalDateTime dateTime);

    /**
     * Calculates the difference between a long timestamp and a Timestamp.
     *
     * @param timestamp1 the timestamp in milliseconds
     * @param timestamp2 the Timestamp
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(long timestamp1, Timestamp timestamp2);

    /**
     * Calculates the difference between two long timestamps broken down by time units.
     *
     * @param timestamp1 the first timestamp in milliseconds
     * @param timestamp2 the second timestamp in milliseconds
     * @return Map containing the difference in various time units
     */
    public Map<TimeUnit,Long> diff(long timestamp1, long timestamp2);

    // =========================================================================
    // Duration Methods - LocalDateTime
    // =========================================================================

    /**
     * Calculates the duration between two LocalDateTime objects in centuries.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in years.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in years
     */
    public long durationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the total duration between two LocalDateTime objects in years (including fractional parts).
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in months.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in months
     */
    public long durationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the total duration between two LocalDateTime objects in months (including fractional parts).
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in weeks.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in days.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in days
     */
    public long durationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the total duration between two LocalDateTime objects in days (including fractional parts).
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in hours.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in hours
     */
    public long durationInHours(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in minutes.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in seconds.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in milliseconds.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in microseconds.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDateTime startDateTime, LocalDateTime endDateTime);

    /**
     * Calculates the duration between two LocalDateTime objects in nanoseconds.
     *
     * @param startDateTime the start LocalDateTime
     * @param endDateTime the end LocalDateTime
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDateTime startDateTime, LocalDateTime endDateTime);

    // =========================================================================
    // Duration Methods - java.util.Date
    // =========================================================================

    /**
     * Calculates the duration between two java.util.Date objects in centuries.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in centuries
     */
    public long durationInCenturies(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in years.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in years
     */
    public long durationInYears(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the total duration between two java.util.Date objects in years (including fractional parts).
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in months.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in months
     */
    public long durationInMonths(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the total duration between two java.util.Date objects in months (including fractional parts).
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in weeks.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in weeks
     */
    public long durationInWeeks(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in days.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in days
     */
    public long durationInDays(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the total duration between two java.util.Date objects in days (including fractional parts).
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in hours.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in hours
     */
    public long durationInHours(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in minutes.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in minutes
     */
    public long durationInMinutes(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in seconds.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in seconds
     */
    public long durationInSeconds(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in milliseconds.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in milliseconds
     */
    public long durationInMillis(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in microseconds.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in microseconds
     */
    public long durationInMicros(java.util.Date startDateTime, java.util.Date endDateTime);

    /**
     * Calculates the duration between two java.util.Date objects in nanoseconds.
     *
     * @param startDateTime the start Date
     * @param endDateTime the end Date
     * @return duration in nanoseconds
     */
    public long durationInNanos(java.util.Date startDateTime, java.util.Date endDateTime);

    // =========================================================================
    // Duration Methods - Timestamp
    // =========================================================================

    /**
     * Calculates the duration between two Timestamp objects in centuries.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in centuries
     */
    public long durationInCenturies(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in years.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in years
     */
    public long durationInYears(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between two Timestamp objects in years (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in months.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in months
     */
    public long durationInMonths(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between two Timestamp objects in months (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in weeks.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in weeks
     */
    public long durationInWeeks(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in days.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in days
     */
    public long durationInDays(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between two Timestamp objects in days (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in hours.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in hours
     */
    public long durationInHours(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in minutes.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in minutes
     */
    public long durationInMinutes(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in seconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in seconds
     */
    public long durationInSeconds(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in milliseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in milliseconds
     */
    public long durationInMillis(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in microseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in microseconds
     */
    public long durationInMicros(Timestamp startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between two Timestamp objects in nanoseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end Timestamp
     * @return duration in nanoseconds
     */
    public long durationInNanos(Timestamp startTimestamp, Timestamp endTimestamp);

    // =========================================================================
    // Duration Methods - long timestamp
    // =========================================================================

    /**
     * Calculates the duration between two long timestamps in centuries.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in centuries
     */
    public long durationInCenturies(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in years.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in years
     */
    public long durationInYears(long startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between two long timestamps in years (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in months.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in months
     */
    public long durationInMonths(long startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between two long timestamps in months (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in weeks.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in weeks
     */
    public long durationInWeeks(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in days.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in days
     */
    public long durationInDays(long startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between two long timestamps in days (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in hours.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in hours
     */
    public long durationInHours(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in minutes.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in minutes
     */
    public long durationInMinutes(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in seconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in seconds
     */
    public long durationInSeconds(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in milliseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in milliseconds
     */
    public long durationInMillis(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in microseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in microseconds
     */
    public long durationInMicros(long startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between two long timestamps in nanoseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in nanoseconds
     */
    public long durationInNanos(long startTimestamp, long endTimestamp);

    // =========================================================================
    // Duration Methods - LocalDate
    // =========================================================================

    /**
     * Calculates the duration between two LocalDate objects in centuries.
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the duration between two LocalDate objects in years.
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return duration in years
     */
    public long durationInYears(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the total duration between two LocalDate objects in years (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the duration between two LocalDate objects in months.
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return duration in months
     */
    public long durationInMonths(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the total duration between two LocalDate objects in months (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the duration between two LocalDate objects in weeks.
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the duration between two LocalDate objects in days.
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return duration in days
     */
    public long durationInDays(LocalDate startLocalDate, LocalDate endLocalDate);

    /**
     * Calculates the total duration between two LocalDate objects in days (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endLocalDate the end LocalDate
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDate startLocalDate, LocalDate endLocalDate);

    // =========================================================================
    // Cross-Type Duration Methods - Nanoseconds
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in nanoseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in nanoseconds
     */
    public long durationInNanos(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in nanoseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in nanoseconds
     */
    public long durationInNanos(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in nanoseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in nanoseconds
     */
    public long durationInNanos(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in nanoseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in nanoseconds
     */
    public long durationInNanos(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in nanoseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in nanoseconds
     */
    public long durationInNanos(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in nanoseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in nanoseconds
     */
    public long durationInNanos(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in nanoseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in nanoseconds
     */
    public long durationInNanos(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in nanoseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in nanoseconds
     */
    public long durationInNanos(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in nanoseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in nanoseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in nanoseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in nanoseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in nanoseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in nanoseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in nanoseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in nanoseconds
     */
    public long durationInNanos(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Microseconds
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in microseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in microseconds
     */
    public long durationInMicros(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in microseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in microseconds
     */
    public long durationInMicros(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in microseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in microseconds
     */
    public long durationInMicros(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in microseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in microseconds
     */
    public long durationInMicros(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in microseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in microseconds
     */
    public long durationInMicros(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in microseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in microseconds
     */
    public long durationInMicros(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in microseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in microseconds
     */
    public long durationInMicros(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in microseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in microseconds
     */
    public long durationInMicros(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in microseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in microseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in microseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in microseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in microseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in microseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in microseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in microseconds
     */
    public long durationInMicros(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Milliseconds
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in milliseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in milliseconds
     */
    public long durationInMillis(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in milliseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in milliseconds
     */
    public long durationInMillis(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in milliseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in milliseconds
     */
    public long durationInMillis(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in milliseconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in milliseconds
     */
    public long durationInMillis(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in milliseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in milliseconds
     */
    public long durationInMillis(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in milliseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in milliseconds
     */
    public long durationInMillis(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in milliseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in milliseconds
     */
    public long durationInMillis(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in milliseconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in milliseconds
     */
    public long durationInMillis(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in milliseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in milliseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in milliseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in milliseconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in milliseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in milliseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in milliseconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in milliseconds
     */
    public long durationInMillis(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Seconds
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in seconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in seconds
     */
    public long durationInSeconds(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in seconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in seconds
     */
    public long durationInSeconds(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in seconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in seconds
     */
    public long durationInSeconds(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in seconds.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in seconds
     */
    public long durationInSeconds(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in seconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in seconds
     */
    public long durationInSeconds(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in seconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in seconds
     */
    public long durationInSeconds(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in seconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in seconds
     */
    public long durationInSeconds(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in seconds.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in seconds
     */
    public long durationInSeconds(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in seconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in seconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in seconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in seconds.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in seconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in seconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in seconds.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in seconds
     */
    public long durationInSeconds(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Minutes
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in minutes.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in minutes
     */
    public long durationInMinutes(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in minutes.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in minutes
     */
    public long durationInMinutes(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in minutes.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in minutes
     */
    public long durationInMinutes(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in minutes.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in minutes
     */
    public long durationInMinutes(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in minutes.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in minutes
     */
    public long durationInMinutes(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in minutes.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in minutes
     */
    public long durationInMinutes(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in minutes.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in minutes
     */
    public long durationInMinutes(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in minutes.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in minutes
     */
    public long durationInMinutes(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in minutes.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in minutes.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in minutes.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in minutes.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in minutes.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in minutes.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in minutes.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in minutes
     */
    public long durationInMinutes(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Hours
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in hours.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in hours
     */
    public long durationInHours(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in hours.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in hours
     */
    public long durationInHours(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in hours.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in hours
     */
    public long durationInHours(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in hours.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in hours
     */
    public long durationInHours(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in hours.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in hours
     */
    public long durationInHours(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in hours.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in hours
     */
    public long durationInHours(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in hours.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in hours
     */
    public long durationInHours(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in hours.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in hours
     */
    public long durationInHours(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in hours.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in hours
     */
    public long durationInHours(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in hours.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in hours
     */
    public long durationInHours(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in hours.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in hours
     */
    public long durationInHours(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in hours.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in hours
     */
    public long durationInHours(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in hours.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in hours
     */
    public long durationInHours(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in hours.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in hours
     */
    public long durationInHours(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in hours.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in hours
     */
    public long durationInHours(LocalDate startLocalDate, java.util.Date endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Total Days
    // =========================================================================

    /**
     * Calculates the total duration between a Timestamp and a long timestamp in days (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between a Timestamp and a LocalDateTime in days (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a Timestamp and a java.util.Date in days (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a Timestamp and a LocalDate in days (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a long timestamp and a Timestamp in days (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a long timestamp and a LocalDateTime in days (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a long timestamp and a java.util.Date in days (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a long timestamp and a LocalDate in days (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDateTime and a Timestamp in days (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a long timestamp in days (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a java.util.Date in days (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDateTime and a LocalDate in days (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDate and a Timestamp in days (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a long timestamp in days (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a java.util.Date in days (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDate and a LocalDateTime in days (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return total duration in days as a long value
     */
    public long totalDurationInDays(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Days
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in days.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in days
     */
    public long durationInDays(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in days.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in days
     */
    public long durationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in days.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in days
     */
    public long durationInDays(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in days.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in days
     */
    public long durationInDays(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in days.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in days
     */
    public long durationInDays(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in days.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in days
     */
    public long durationInDays(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in days.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in days
     */
    public long durationInDays(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in days.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in days
     */
    public long durationInDays(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in days.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in days
     */
    public long durationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in days.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in days
     */
    public long durationInDays(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in days.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in days
     */
    public long durationInDays(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in days.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in days
     */
    public long durationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in days.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in days
     */
    public long durationInDays(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in days.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in days
     */
    public long durationInDays(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in days.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in days
     */
    public long durationInDays(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDate and a LocalDateTime in days.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return duration in days
     */
    public long durationInDays(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Weeks
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in weeks.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in weeks
     */
    public long durationInWeeks(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in weeks.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in weeks
     */
    public long durationInWeeks(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in weeks.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in weeks
     */
    public long durationInWeeks(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in weeks.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in weeks
     */
    public long durationInWeeks(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in weeks.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in weeks
     */
    public long durationInWeeks(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in weeks.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in weeks
     */
    public long durationInWeeks(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in weeks.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in weeks
     */
    public long durationInWeeks(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in weeks.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in weeks
     */
    public long durationInWeeks(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in weeks.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in weeks.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in weeks.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in weeks.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in weeks.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in weeks.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in weeks.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDate and a LocalDateTime in weeks.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return duration in weeks
     */
    public long durationInWeeks(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Total Months
    // =========================================================================

    /**
     * Calculates the total duration between a Timestamp and a long timestamp in months (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between a Timestamp and a LocalDateTime in months (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a Timestamp and a java.util.Date in months (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a Timestamp and a LocalDate in months (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a long timestamp and a Timestamp in months (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a long timestamp and a LocalDateTime in months (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a long timestamp and a java.util.Date in months (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a long timestamp and a LocalDate in months (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDateTime and a Timestamp in months (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a long timestamp in months (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a java.util.Date in months (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDateTime and a LocalDate in months (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDate and a Timestamp in months (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a long timestamp in months (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a java.util.Date in months (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDate and a LocalDateTime in months (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return total duration in months as a long value
     */
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Months
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in months.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in months
     */
    public long durationInMonths(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in months.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in months
     */
    public long durationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in months.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in months
     */
    public long durationInMonths(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in months.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in months
     */
    public long durationInMonths(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in months.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in months
     */
    public long durationInMonths(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in months.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in months
     */
    public long durationInMonths(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in months.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in months
     */
    public long durationInMonths(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in months.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in months
     */
    public long durationInMonths(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in months.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in months
     */
    public long durationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in months.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in months
     */
    public long durationInMonths(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in months.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in months
     */
    public long durationInMonths(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in months.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in months
     */
    public long durationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in months.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in months
     */
    public long durationInMonths(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in months.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in months
     */
    public long durationInMonths(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in months.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in months
     */
    public long durationInMonths(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDate and a LocalDateTime in months.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return duration in months
     */
    public long durationInMonths(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Total Years
    // =========================================================================

    /**
     * Calculates the total duration between a Timestamp and a long timestamp in years (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the total duration between a Timestamp and a LocalDateTime in years (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a Timestamp and a java.util.Date in years (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a Timestamp and a LocalDate in years (including fractional parts).
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a long timestamp and a Timestamp in years (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a long timestamp and a LocalDateTime in years (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the total duration between a long timestamp and a java.util.Date in years (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the total duration between a long timestamp and a LocalDate in years (including fractional parts).
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDateTime and a Timestamp in years (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a long timestamp in years (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDateTime and a java.util.Date in years (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDateTime and a LocalDate in years (including fractional parts).
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the total duration between a LocalDate and a Timestamp in years (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a long timestamp in years (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the total duration between a LocalDate and a java.util.Date in years (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the total duration between a LocalDate and a LocalDateTime in years (including fractional parts).
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return total duration in years as a long value
     */
    public long totalDurationInYears(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Years
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in years.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in years
     */
    public long durationInYears(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in years.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in years
     */
    public long durationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in years.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in years
     */
    public long durationInYears(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in years.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in years
     */
    public long durationInYears(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in years.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in years
     */
    public long durationInYears(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in years.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in years
     */
    public long durationInYears(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in years.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in years
     */
    public long durationInYears(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in years.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in years
     */
    public long durationInYears(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in years.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in years
     */
    public long durationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in years.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in years
     */
    public long durationInYears(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in years.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in years
     */
    public long durationInYears(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in years.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in years
     */
    public long durationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in years.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in years
     */
    public long durationInYears(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in years.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in years
     */
    public long durationInYears(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in years.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in years
     */
    public long durationInYears(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDate and a LocalDateTime in years.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return duration in years
     */
    public long durationInYears(LocalDate startLocalDate, LocalDateTime endDate);

    // =========================================================================
    // Cross-Type Duration Methods - Centuries
    // =========================================================================

    /**
     * Calculates the duration between a Timestamp and a long timestamp in centuries.
     *
     * @param startTimestamp the start Timestamp
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in centuries
     */
    public long durationInCenturies(Timestamp startTimestamp, long endTimestamp);

    /**
     * Calculates the duration between a Timestamp and a LocalDateTime in centuries.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in centuries
     */
    public long durationInCenturies(Timestamp startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a Timestamp and a java.util.Date in centuries.
     *
     * @param startTimestamp the start Timestamp
     * @param endDate the end java.util.Date
     * @return duration in centuries
     */
    public long durationInCenturies(Timestamp startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a Timestamp and a LocalDate in centuries.
     *
     * @param startTimestamp the start Timestamp
     * @param endLocalDate the end LocalDate
     * @return duration in centuries
     */
    public long durationInCenturies(Timestamp startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a long timestamp and a Timestamp in centuries.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endTimestamp the end Timestamp
     * @return duration in centuries
     */
    public long durationInCenturies(long startTimestamp, Timestamp endTimestamp);

    /**
     * Calculates the duration between a long timestamp and a LocalDateTime in centuries.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDateTime the end LocalDateTime
     * @return duration in centuries
     */
    public long durationInCenturies(long startTimestamp, LocalDateTime endLocalDateTime);

    /**
     * Calculates the duration between a long timestamp and a java.util.Date in centuries.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endDate the end java.util.Date
     * @return duration in centuries
     */
    public long durationInCenturies(long startTimestamp, java.util.Date endDate);

    /**
     * Calculates the duration between a long timestamp and a LocalDate in centuries.
     *
     * @param startTimestamp the start timestamp in milliseconds
     * @param endLocalDate the end LocalDate
     * @return duration in centuries
     */
    public long durationInCenturies(long startTimestamp, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDateTime and a Timestamp in centuries.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end Timestamp
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDateTime startLocalDateTime, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a long timestamp in centuries.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDateTime startLocalDateTime, long endTimestamp);

    /**
     * Calculates the duration between a LocalDateTime and a java.util.Date in centuries.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endDate the end java.util.Date
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDateTime startLocalDateTime, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDateTime and a LocalDate in centuries.
     *
     * @param startLocalDateTime the start LocalDateTime
     * @param endLocalDate the end LocalDate
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    /**
     * Calculates the duration between a LocalDate and a Timestamp in centuries.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end Timestamp
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDate startLocalDate, Timestamp endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a long timestamp in centuries.
     *
     * @param startLocalDate the start LocalDate
     * @param endTimestamp the end timestamp in milliseconds
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDate startLocalDate, long endTimestamp);

    /**
     * Calculates the duration between a LocalDate and a java.util.Date in centuries.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end java.util.Date
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDate startLocalDate, java.util.Date endDate);

    /**
     * Calculates the duration between a LocalDate and a LocalDateTime in centuries.
     *
     * @param startLocalDate the start LocalDate
     * @param endDate the end LocalDateTime
     * @return duration in centuries
     */
    public long durationInCenturies(LocalDate startLocalDate, LocalDateTime endDate);

}