package com.softbakers.utils.mikata.api;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * DateUtilAPI Interface for different methods to manipulate date.
 */
public interface DateUtilAPI {

    public LocalDateTime now();
    public java.util.Date date();
    public LocalDateTime localDateTime();
    public LocalDate localDate();
    public long timestamp();
    public long unixTimestamp();
    public Timestamp sqlTimestamp();

    public String string();
    public String string(String pattern);
    public String stringLocalDate();
    public String stringLocalDate(Locale locale);
    public String stringLocalDate(Locale locale, String pattern);
    public String stringLocalDateTime();
    public String stringLocalDateTime(Locale locale);
    public String stringLocalDateTime(Locale locale, String pattern);
    public Object now(DateType type);

    public Locale getDefaultLocale();
    public void setDefaultLocale(Locale defaultLocale);
    public String getDefaultPattern();
    public void setDefaultPattern(String defaultPattern);
    public boolean isUnixTimestamp(long timestamp);

    public int compareTo(java.util.Date date1, java.util.Date date2);
    public int compareTo(java.util.Date date1, LocalDate date2);
    public int compareTo(java.util.Date date1, LocalDateTime date2);
    public int compareTo(java.util.Date date1, Timestamp timestamp);
    public int compareTo(java.util.Date date1, long timestamp);

    public int compareTo(LocalDate date1, LocalDate date2);
    public int compareTo(LocalDate date1, LocalDateTime date2);
    public int compareTo(LocalDate date1, java.util.Date date2);
    public int compareTo(LocalDate date1, Timestamp timestamp);
    public int compareTo(LocalDate date1, long timestamp);

    public int compareTo(Timestamp timestamp1, Timestamp timestamp2);
    public int compareTo(Timestamp timestamp1, java.util.Date date);
    public int compareTo(Timestamp timestamp1, LocalDate date) ;
    public int compareTo(Timestamp timestamp1, LocalDateTime date) ;
    public int compareTo(Timestamp timestamp1, long timestamp2);

    public int compareTo(long timestamp1, long timestamp2);
    public int compareTo(long timestamp1, java.util.Date date);
    public int compareTo(long timestamp1, LocalDate date);
    public int compareTo(long timestamp1, LocalDateTime date);
    public int compareTo(long timestamp1, Timestamp timestamp2);

    public int compareTo(LocalDateTime date1, LocalDateTime date2);
    public int compareTo(LocalDateTime date1, java.util.Date date2);
    public int compareTo(LocalDateTime date1, LocalDate date2);
    public int compareTo(LocalDateTime date1, Timestamp timestamp);
    public int compareTo(LocalDateTime date1, long timestamp);

    public Map<TimeUnit,Long> diff(java.util.Date date1, java.util.Date date2);
    public Map<TimeUnit,Long> diff(java.util.Date date1, LocalDateTime dateTime2);
    public Map<TimeUnit,Long> diff(java.util.Date date1, LocalDate date2);
    public Map<TimeUnit,Long> diff(java.util.Date date1, Timestamp timestamp);
    public Map<TimeUnit,Long> diff(java.util.Date date1, long timestamp);

    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, LocalDateTime dateTime2);
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, java.util.Date date2);
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, LocalDate date2);
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, Timestamp timestamp);
    public Map<TimeUnit,Long> diff(LocalDateTime dateTime1, long timestamp);

    public Map<TimeUnit,Long> diff(LocalDate date1, LocalDate date2);
    public Map<TimeUnit,Long> diff(LocalDate date1, java.util.Date date2);
    public Map<TimeUnit,Long> diff(LocalDate date1, LocalDateTime dateTime2);
    public Map<TimeUnit,Long> diff(LocalDate date1, Timestamp timestamp);
    public Map<TimeUnit,Long> diff(LocalDate date1, long timestamp);

    public Map<TimeUnit,Long> diff(Timestamp timestamp, LocalDate date);
    public Map<TimeUnit,Long> diff(Timestamp timestamp, java.util.Date date);
    public Map<TimeUnit,Long> diff(Timestamp timestamp, LocalDateTime dateTime);
    public Map<TimeUnit,Long> diff(Timestamp timestamp1, Timestamp timestamp2);
    public Map<TimeUnit,Long> diff(Timestamp timestamp1, long timestamp2);

    public Map<TimeUnit,Long> diff(long timestamp, LocalDate date);
    public Map<TimeUnit,Long> diff(long timestamp, java.util.Date date);
    public Map<TimeUnit,Long> diff(long timestamp, LocalDateTime dateTime);
    public Map<TimeUnit,Long> diff(long timestamp1, Timestamp timestamp2);
    public Map<TimeUnit,Long> diff(long timestamp1, long timestamp2);


    public long durationInCenturies(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long totalDurationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long totalDurationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInWeeks(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long totalDurationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInHours(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInSeconds(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInMillis(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInMicros(LocalDateTime startDateTime, LocalDateTime endDateTime);
    public long durationInNanos(LocalDateTime startDateTime, LocalDateTime endDateTime);

    public long durationInCenturies(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInYears(java.util.Date startDateTime, java.util.Date endDateTime);
    public long totalDurationInYears(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInMonths(java.util.Date startDateTime, java.util.Date endDateTime);
    public long totalDurationInMonths(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInWeeks(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInDays(java.util.Date startDateTime, java.util.Date endDateTime);
    public long totalDurationInDays(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInHours(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInMinutes(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInSeconds(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInMillis(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInMicros(java.util.Date startDateTime, java.util.Date endDateTime);
    public long durationInNanos(java.util.Date startDateTime, java.util.Date endDateTime);

    public long durationInCenturies(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInYears(Timestamp startTimestamp, Timestamp endTimestamp);
    public long totalDurationInYears(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInMonths(Timestamp startTimestamp, Timestamp endTimestamp);
    public long totalDurationInMonths(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInWeeks(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInDays(Timestamp startTimestamp, Timestamp endTimestamp);
    public long totalDurationInDays(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInHours(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInMinutes(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInSeconds(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInMillis(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInMicros(Timestamp startTimestamp, Timestamp endTimestamp);
    public long durationInNanos(Timestamp startTimestamp, Timestamp endTimestamp);

    public long durationInCenturies(long startTimestamp, long endTimestamp);
    public long durationInYears(long startTimestamp, long endTimestamp);
    public long totalDurationInYears(long startTimestamp, long endTimestamp);
    public long durationInMonths(long startTimestamp, long endTimestamp);
    public long totalDurationInMonths(long startTimestamp, long endTimestamp);
    public long durationInWeeks(long startTimestamp, long endTimestamp);
    public long durationInDays(long startTimestamp, long endTimestamp);
    public long totalDurationInDays(long startTimestamp, long endTimestamp);
    public long durationInHours(long startTimestamp, long endTimestamp);
    public long durationInMinutes(long startTimestamp, long endTimestamp);
    public long durationInSeconds(long startTimestamp, long endTimestamp);
    public long durationInMillis(long startTimestamp, long endTimestamp);
    public long durationInMicros(long startTimestamp, long endTimestamp);
    public long durationInNanos(long startTimestamp, long endTimestamp);

    public long durationInCenturies(LocalDate startLocalDate, LocalDate endLocalDate);
    public long durationInYears(LocalDate startLocalDate, LocalDate endLocalDate);
    public long totalDurationInYears(LocalDate startLocalDate, LocalDate endLocalDate);
    public long durationInMonths(LocalDate startLocalDate, LocalDate endLocalDate);
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDate endLocalDate);
    public long durationInWeeks(LocalDate startLocalDate, LocalDate endLocalDate);
    public long durationInDays(LocalDate startLocalDate, LocalDate endLocalDate);
    public long totalDurationInDays(LocalDate startLocalDate, LocalDate endLocalDate);

    public long durationInNanos(Timestamp startTimestamp, long endTimestamp);
    public long durationInNanos(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInNanos(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInNanos(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInNanos(long startTimestamp, Timestamp endTimestamp);
    public long durationInNanos(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInNanos(long startTimestamp, java.util.Date endDate);
    public long durationInNanos(long startTimestamp, LocalDate endLocalDate);

    public long durationInNanos(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInNanos(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInNanos(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInNanos(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInNanos(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInNanos(LocalDate startLocalDate, long endTimestamp);
    public long durationInNanos(LocalDate startLocalDate, java.util.Date endDate);

    public long durationInMicros(Timestamp startTimestamp, long endTimestamp);
    public long durationInMicros(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMicros(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInMicros(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInMicros(long startTimestamp, Timestamp endTimestamp);
    public long durationInMicros(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMicros(long startTimestamp, java.util.Date endDate);
    public long durationInMicros(long startTimestamp, LocalDate endLocalDate);

    public long durationInMicros(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInMicros(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInMicros(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInMicros(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInMicros(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInMicros(LocalDate startLocalDate, long endTimestamp);
    public long durationInMicros(LocalDate startLocalDate, java.util.Date endDate);

    public long durationInMillis(Timestamp startTimestamp, long endTimestamp);
    public long durationInMillis(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMillis(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInMillis(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInMillis(long startTimestamp, Timestamp endTimestamp);
    public long durationInMillis(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMillis(long startTimestamp, java.util.Date endDate);
    public long durationInMillis(long startTimestamp, LocalDate endLocalDate);

    public long durationInMillis(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInMillis(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInMillis(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInMillis(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInMillis(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInMillis(LocalDate startLocalDate, long endTimestamp);
    public long durationInMillis(LocalDate startLocalDate, java.util.Date endDate);

    public long durationInSeconds(Timestamp startTimestamp, long endTimestamp);
    public long durationInSeconds(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInSeconds(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInSeconds(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInSeconds(long startTimestamp, Timestamp endTimestamp);
    public long durationInSeconds(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInSeconds(long startTimestamp, java.util.Date endDate);
    public long durationInSeconds(long startTimestamp, LocalDate endLocalDate);

    public long durationInSeconds(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInSeconds(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInSeconds(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInSeconds(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInSeconds(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInSeconds(LocalDate startLocalDate, long endTimestamp);
    public long durationInSeconds(LocalDate startLocalDate, java.util.Date endDate);

    public long durationInMinutes(Timestamp startTimestamp, long endTimestamp);
    public long durationInMinutes(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMinutes(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInMinutes(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInMinutes(long startTimestamp, Timestamp endTimestamp);
    public long durationInMinutes(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMinutes(long startTimestamp, java.util.Date endDate);
    public long durationInMinutes(long startTimestamp, LocalDate endLocalDate);

    public long durationInMinutes(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInMinutes(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInMinutes(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInMinutes(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInMinutes(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInMinutes(LocalDate startLocalDate, long endTimestamp);
    public long durationInMinutes(LocalDate startLocalDate, java.util.Date endDate);

    public long durationInHours(Timestamp startTimestamp, long endTimestamp);
    public long durationInHours(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInHours(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInHours(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInHours(long startTimestamp, Timestamp endTimestamp);
    public long durationInHours(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInHours(long startTimestamp, java.util.Date endDate);
    public long durationInHours(long startTimestamp, LocalDate endLocalDate);

    public long durationInHours(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInHours(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInHours(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInHours(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInHours(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInHours(LocalDate startLocalDate, long endTimestamp);
    public long durationInHours(LocalDate startLocalDate, java.util.Date endDate);



    public long totalDurationInDays(Timestamp startTimestamp, long endTimestamp);
    public long totalDurationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInDays(Timestamp startTimestamp, java.util.Date endDate);
    public long totalDurationInDays(Timestamp startTimestamp, LocalDate endLocalDate);

    public long totalDurationInDays(long startTimestamp, Timestamp endTimestamp);
    public long totalDurationInDays(long startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInDays(long startTimestamp, java.util.Date endDate);
    public long totalDurationInDays(long startTimestamp, LocalDate endLocalDate);

    public long totalDurationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long totalDurationInDays(LocalDateTime startLocalDateTime, long endTimestamp);
    public long totalDurationInDays(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long totalDurationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long totalDurationInDays(LocalDate startLocalDate, Timestamp endTimestamp);
    public long totalDurationInDays(LocalDate startLocalDate, long endTimestamp);
    public long totalDurationInDays(LocalDate startLocalDate, java.util.Date endDate);
    public long totalDurationInDays(LocalDate startLocalDate, LocalDateTime endDate);



    public long durationInDays(Timestamp startTimestamp, long endTimestamp);
    public long durationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInDays(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInDays(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInDays(long startTimestamp, Timestamp endTimestamp);
    public long durationInDays(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInDays(long startTimestamp, java.util.Date endDate);
    public long durationInDays(long startTimestamp, LocalDate endLocalDate);

    public long durationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInDays(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInDays(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInDays(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInDays(LocalDate startLocalDate, long endTimestamp);
    public long durationInDays(LocalDate startLocalDate, java.util.Date endDate);
    public long durationInDays(LocalDate startLocalDate, LocalDateTime endDate);



    public long durationInWeeks(Timestamp startTimestamp, long endTimestamp);
    public long durationInWeeks(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInWeeks(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInWeeks(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInWeeks(long startTimestamp, Timestamp endTimestamp);
    public long durationInWeeks(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInWeeks(long startTimestamp, java.util.Date endDate);
    public long durationInWeeks(long startTimestamp, LocalDate endLocalDate);

    public long durationInWeeks(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInWeeks(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInWeeks(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInWeeks(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInWeeks(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInWeeks(LocalDate startLocalDate, long endTimestamp);
    public long durationInWeeks(LocalDate startLocalDate, java.util.Date endDate);
    public long durationInWeeks(LocalDate startLocalDate, LocalDateTime endDate);



    public long totalDurationInMonths(Timestamp startTimestamp, long endTimestamp);
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInMonths(Timestamp startTimestamp, java.util.Date endDate);
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDate endLocalDate);

    public long totalDurationInMonths(long startTimestamp, Timestamp endTimestamp);
    public long totalDurationInMonths(long startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInMonths(long startTimestamp, java.util.Date endDate);
    public long totalDurationInMonths(long startTimestamp, LocalDate endLocalDate);

    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, long endTimestamp);
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long totalDurationInMonths(LocalDate startLocalDate, Timestamp endTimestamp);
    public long totalDurationInMonths(LocalDate startLocalDate, long endTimestamp);
    public long totalDurationInMonths(LocalDate startLocalDate, java.util.Date endDate);
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDateTime endDate);



    public long durationInMonths(Timestamp startTimestamp, long endTimestamp);
    public long durationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMonths(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInMonths(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInMonths(long startTimestamp, Timestamp endTimestamp);
    public long durationInMonths(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInMonths(long startTimestamp, java.util.Date endDate);
    public long durationInMonths(long startTimestamp, LocalDate endLocalDate);

    public long durationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInMonths(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInMonths(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInMonths(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInMonths(LocalDate startLocalDate, long endTimestamp);
    public long durationInMonths(LocalDate startLocalDate, java.util.Date endDate);
    public long durationInMonths(LocalDate startLocalDate, LocalDateTime endDate);



    public long totalDurationInYears(Timestamp startTimestamp, long endTimestamp);
    public long totalDurationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInYears(Timestamp startTimestamp, java.util.Date endDate);
    public long totalDurationInYears(Timestamp startTimestamp, LocalDate endLocalDate);

    public long totalDurationInYears(long startTimestamp, Timestamp endTimestamp);
    public long totalDurationInYears(long startTimestamp, LocalDateTime endLocalDateTime);
    public long totalDurationInYears(long startTimestamp, java.util.Date endDate);
    public long totalDurationInYears(long startTimestamp, LocalDate endLocalDate);

    public long totalDurationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long totalDurationInYears(LocalDateTime startLocalDateTime, long endTimestamp);
    public long totalDurationInYears(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long totalDurationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long totalDurationInYears(LocalDate startLocalDate, Timestamp endTimestamp);
    public long totalDurationInYears(LocalDate startLocalDate, long endTimestamp);
    public long totalDurationInYears(LocalDate startLocalDate, java.util.Date endDate);
    public long totalDurationInYears(LocalDate startLocalDate, LocalDateTime endDate);



    public long durationInYears(Timestamp startTimestamp, long endTimestamp);
    public long durationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInYears(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInYears(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInYears(long startTimestamp, Timestamp endTimestamp);
    public long durationInYears(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInYears(long startTimestamp, java.util.Date endDate);
    public long durationInYears(long startTimestamp, LocalDate endLocalDate);

    public long durationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInYears(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInYears(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInYears(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInYears(LocalDate startLocalDate, long endTimestamp);
    public long durationInYears(LocalDate startLocalDate, java.util.Date endDate);
    public long durationInYears(LocalDate startLocalDate, LocalDateTime endDate);



    public long durationInCenturies(Timestamp startTimestamp, long endTimestamp);
    public long durationInCenturies(Timestamp startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInCenturies(Timestamp startTimestamp, java.util.Date endDate);
    public long durationInCenturies(Timestamp startTimestamp, LocalDate endLocalDate);

    public long durationInCenturies(long startTimestamp, Timestamp endTimestamp);
    public long durationInCenturies(long startTimestamp, LocalDateTime endLocalDateTime);
    public long durationInCenturies(long startTimestamp, java.util.Date endDate);
    public long durationInCenturies(long startTimestamp, LocalDate endLocalDate);

    public long durationInCenturies(LocalDateTime startLocalDateTime, Timestamp endTimestamp);
    public long durationInCenturies(LocalDateTime startLocalDateTime, long endTimestamp);
    public long durationInCenturies(LocalDateTime startLocalDateTime, java.util.Date endDate);
    public long durationInCenturies(LocalDateTime startLocalDateTime, LocalDate endLocalDate);

    public long durationInCenturies(LocalDate startLocalDate, Timestamp endTimestamp);
    public long durationInCenturies(LocalDate startLocalDate, long endTimestamp);
    public long durationInCenturies(LocalDate startLocalDate, java.util.Date endDate);
    public long durationInCenturies(LocalDate startLocalDate, LocalDateTime endDate);

}
