package com.softbakers.utils.mikata.helper;

import com.softbakers.utils.mikata.api.DateUtilAPI;
import com.softbakers.utils.mikata.api.DateType;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * DateUtil - Date util for manipulate date
 * @author Mohamed Lamine JELLAD
 * @version 1.0.0
 */
public class DateUtil implements DateUtilAPI {

    private Locale defaultLocale = Locale.getDefault();
    private String defaultPattern = "yyyy-MM-dd";
    private DateConverterUtil converter = new DateConverterUtil();

    public DateUtil() {
        converter.setDefaultLocale(this.defaultLocale);
        converter.setDefaultPattern(this.defaultPattern);
    }

    public DateUtil(Locale defaultLocale, String defaultPattern) {
        // Utility class - prevent instantiation
        this.defaultLocale = defaultLocale;
        this.defaultPattern = defaultPattern;
        converter.setDefaultLocale(this.defaultLocale);
        converter.setDefaultPattern(this.defaultPattern);
    }

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @Override
    public java.util.Date date() {
        return new java.util.Date(System.currentTimeMillis());
    }

    @Override
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @Override
    public LocalDate localDate() {
        return LocalDate.now();
    }


    @Override
    public long timestamp() {
        return System.currentTimeMillis();
    }

    @Override
    public long unixTimestamp() {
        return (long) System.currentTimeMillis() / 1000L;
    }

    @Override
    public Timestamp sqlTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String string() {
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        return new SimpleDateFormat(defaultPattern).format(date);
    }

    @Override
    public String string(String pattern) {
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        return new SimpleDateFormat(pattern).format(date);
    }

    @Override
    public String stringLocalDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.getDefault());
        return formatter.format(date);
    }

    @Override
    public String stringLocalDate(Locale locale) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
        return formatter.format(date);
    }

    @Override
    public String stringLocalDate(Locale locale, String pattern) {
        LocalDate localDate = LocalDate.now(); // For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        formatter = formatter.withLocale(locale);
        return localDate.format(formatter);
    }

    @Override
    public String stringLocalDateTime() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(defaultLocale).withDecimalStyle(DecimalStyle.ofDefaultLocale());
        return formatter.format(date);
    }

    @Override
    public String stringLocalDateTime(Locale locale) {
        LocalDateTime date = LocalDateTime.now();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return formatter.format(date);
    }

    @Override
    public String stringLocalDateTime(Locale locale, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now(); // For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        formatter = formatter.withLocale(locale);
        return localDateTime.format(formatter);
    }

    @Override
    public Object now(DateType type) {
        switch (type) {
            case StringDate:
                return this.string();
            case Date:
                return this.date();
            case Timestamp:
                return this.timestamp();
            case SQLTimestamp:
                return this.sqlTimestamp();
            case UnixTimestamp:
                return this.unixTimestamp();
            case LocalDate:
                return this.localDate();
            case StringLocalDate:
                return this.stringLocalDate();
            case LocalDateTime:
                return this.localDateTime();
            case StringLocalDateTime:
                return this.stringLocalDateTime();
            default:
                return this.now();
        }

    }

    @Override
    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    @Override
    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    @Override
    public String getDefaultPattern() {
        return defaultPattern;
    }

    @Override
    public void setDefaultPattern(String defaultPattern) {
        this.defaultPattern = defaultPattern;
    }

    @Override
    public boolean isUnixTimestamp(long timestamp) {
        String strTimestamp = String.valueOf(timestamp);
        return strTimestamp.length() <= 10;
    }

    @Override
    public int compareTo(java.util.Date date1, java.util.Date date2) {
        return date1.compareTo(date2);
    }

    @Override
    public int compareTo(java.util.Date date1, LocalDate date2) {
        LocalDate date = this.converter.toLocalDate(date1);
        return date.compareTo(date2);
    }

    @Override
    public int compareTo(Date date1, LocalDateTime date2) {
        LocalDateTime date = this.converter.toLocalDateTime(date1);
        return date.compareTo(date2);
    }

    @Override
    public int compareTo(java.util.Date date1, Timestamp timestamp) {
        java.util.Date date = this.converter.toDate(timestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(java.util.Date date1, long timestamp) {
        java.util.Date date = this.converter.toDate(timestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2);
    }

    @Override
    public int compareTo(LocalDate date1, LocalDateTime date2) {
        LocalDateTime localTime = this.converter.toLocalDateTime(date1);
        return localTime.compareTo(date2);
    }

    @Override
    public int compareTo(LocalDate date1, java.util.Date date2) {
        LocalDate date = this.converter.toLocalDate(date2);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(LocalDate date1, Timestamp timestamp) {
        LocalDate date = this.converter.toLocalDate(timestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(LocalDate date1, long timestamp) {
        LocalDate date = this.converter.toLocalDate(timestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(Timestamp startTimestamp, Timestamp endTimestamp) {
        return startTimestamp.compareTo(endTimestamp);
    }

    @Override
    public int compareTo(Timestamp startTimestamp, java.util.Date date) {
        java.util.Date date1 = this.converter.toDate(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(Timestamp startTimestamp, LocalDate date) {
        LocalDate date1 = this.converter.toLocalDate(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(Timestamp startTimestamp, LocalDateTime date) {
        LocalDateTime date1 = this.converter.toLocalDateTime(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(Timestamp startTimestamp, long endTimestamp) {
        return this.compareTo(startTimestamp.getTime(), endTimestamp);
    }

    @Override
    public int compareTo(long startTimestamp, long endTimestamp) {
        if(startTimestamp > endTimestamp) {
            return 1;
        } else if(startTimestamp < endTimestamp) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compareTo(long startTimestamp, java.util.Date date) {
        java.util.Date date1 = this.converter.toDate(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(long startTimestamp, LocalDate date) {
        LocalDate date1 = this.converter.toLocalDate(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(long startTimestamp, LocalDateTime date) {
        LocalDateTime date1 = this.converter.toLocalDateTime(startTimestamp);
        return date1.compareTo(date);
    }

    @Override
    public int compareTo(long startTimestamp, Timestamp endTimestamp) {
        return this.compareTo(startTimestamp, endTimestamp.getTime());
    }

    @Override
    public int compareTo(LocalDateTime date1, LocalDateTime date2) {
        return date1.compareTo(date2);
    }

    @Override
    public int compareTo(LocalDateTime date1, Date date2) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(date2);
        return date1.compareTo(dateTime);
    }

    @Override
    public int compareTo(LocalDateTime date1, LocalDate date2) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(date2);
        return date1.compareTo(dateTime);
    }

    @Override
    public int compareTo(LocalDateTime date1, Timestamp timestamp) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(timestamp);
        return date1.compareTo(dateTime);
    }

    @Override
    public int compareTo(LocalDateTime date1, long timestamp) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(timestamp);
        return date1.compareTo(dateTime);
    }

    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public long diff(java.util.Date date1, java.util.Date date2, TimeUnit timeUnit) {
        return timeUnit.convert(date2.getTime() - date1.getTime(),TimeUnit.MILLISECONDS);
    }

    @Override
    public Map<TimeUnit,Long> diff(java.util.Date startDate, java.util.Date endDate) {

        long diffInMillies = endDate.getTime() - startDate.getTime();

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    /**
     * @param date1
     * @param endDateTime
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, LocalDateTime endDateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(date1);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, LocalDate date2) {
        Date date = this.converter.toDate(date2);
        return this.diff(date1, date);
    }

    /**
     * @param date1
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, Timestamp timestamp) {
        Date date = this.converter.toDate(timestamp);
        return this.diff(date1, date);
    }

    /**
     * @param date1
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, long timestamp) {
        Date date = this.converter.toDate(timestamp);
        return this.diff(date1, date);
    }

    @Override
    public Map<TimeUnit,Long> diff(LocalDateTime startDateTime, LocalDateTime endDateTime) {

        long diffInMillies = this.converter.toTimestamp(endDateTime) -  this.converter.toTimestamp(startDateTime);

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    /**
     * @param startDateTime
     * @param date2
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, Date date2) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(date2);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param startDateTime
     * @param date2
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, LocalDate date2) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(date2);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param startDateTime
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, Timestamp timestamp) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param startDateTime
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, long timestamp) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate startLocalDate, LocalDate endLocalDate) {
        long diffInMillies = this.converter.toTimestamp(endLocalDate) -  this.converter.toTimestamp(startLocalDate);

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, Date date2) {
        java.util.Date date = this.converter.toDate(date1);
        return this.diff(date,date2);
    }

    /**
     * @param date1
     * @param endDateTime
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, LocalDateTime endDateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(date1);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * @param date1
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, Timestamp timestamp) {
        Timestamp startTimestamp = this.converter.toSqlTimestamp(date1);
        return this.diff(startTimestamp, timestamp);
    }

    /**
     * @param date1
     * @param timestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, long timestamp) {
        long startTimestamp = this.converter.toTimestamp(date1);
        return this.diff(startTimestamp, timestamp);
    }

    /**
     * @param timestamp
     * @param date
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, LocalDate date) {
        Timestamp endTimestamp = this.converter.toSqlTimestamp(date);
        return this.diff(timestamp, endTimestamp);
    }

    /**
     * @param timestamp
     * @param date
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, Date date) {
        Date date1 = this.converter.toSqlTimestamp(date);
        return this.diff(date1, date);
    }

    /**
     * @param timestamp
     * @param dateTime
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, LocalDateTime dateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, dateTime);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp startTimestamp, Timestamp endTimestamp) {
        long diffInMillies = this.converter.toTimestamp(endTimestamp) -  this.converter.toTimestamp(startTimestamp);

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp startTimestamp, long endTimestamp) {
        return this.diff(startTimestamp.getTime(), endTimestamp);
    }

    /**
     * @param timestamp
     * @param date
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, LocalDate date) {
        return this.diff(timestamp, this.converter.toTimestamp(date));
    }

    /**
     * @param timestamp
     * @param date
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, Date date) {
        return this.diff(timestamp, date.getTime());
    }

    /**
     * @param timestamp
     * @param dateTime
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, LocalDateTime dateTime) {
        return this.diff(timestamp, this.converter.toTimestamp(dateTime));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(long startTimestamp, Timestamp endTimestamp) {
        return this.diff(startTimestamp, this.converter.toTimestamp(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public Map<TimeUnit, Long> diff(long startTimestamp, long endTimestamp) {
        long diffInMillies = endTimestamp - startTimestamp;

        //create the list
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for ( TimeUnit unit : units ) {

            //calculate difference in millisecond
            long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;

            //put the result in the map
            result.put(unit,diff);
        }

        return result;
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInCenturies(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.durationInYears(startDateTime, endDateTime) / 100;
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getYears();
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.YEARS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return java.time.temporal.ChronoUnit.MONTHS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getMonths();
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInWeeks(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.totalDurationInDays(startDateTime, endDateTime) / 7;
    }

    //Period period = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));

    @Override
    public long totalDurationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return java.time.temporal.ChronoUnit.DAYS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    @Override
    public long durationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getDays();
    }

    @Override
    public long durationInHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toHours();
    }

    @Override
    public long durationInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toMinutes();
    }

    @Override
    public long durationInSeconds(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).getSeconds();
    }

    @Override
    public long durationInMillis(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toMillis();
    }

    @Override
    public long durationInMicros(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toNanos() / 1000;
    }

    @Override
    public long durationInNanos(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toNanos();
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInCenturies(Date startDateTime, Date endDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInYears(Date startDateTime, Date endDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long totalDurationInYears(Date startDateTime, Date endDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInMonths(Date startDateTime, Date endDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long totalDurationInMonths(Date startDateTime, Date endDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInWeeks(Date startDateTime, Date endDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInDays(Date startDateTime, Date endDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long totalDurationInDays(Date startDateTime, Date endDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInHours(Date startDateTime, Date endDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInMinutes(Date startDateTime, Date endDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInSeconds(Date startDateTime, Date endDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInMillis(Date startDateTime, Date endDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInMicros(Date startDateTime, Date endDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public long durationInNanos(Date startDateTime, Date endDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(long startTimestamp, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(long startTimestamp, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(long startTimestamp, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(long startTimestamp, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(long startTimestamp, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(long startTimestamp, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(long startTimestamp, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(long startTimestamp, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(long startTimestamp, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(long startTimestamp, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(long startTimestamp, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(long startTimestamp, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(long startTimestamp, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInNanos(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInNanos(long startTimestamp, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInNanos(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMicros(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMicros(long startTimestamp, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMicros(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMillis(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMillis(long startTimestamp, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMillis(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInSeconds(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInSeconds(long startTimestamp, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInSeconds(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMinutes(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMinutes(long startTimestamp, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMinutes(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInHours(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInHours(long startTimestamp, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInHours(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInDays(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInDays(long startTimestamp, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInDays(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInDays(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInDays(long startTimestamp, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInDays(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInWeeks(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInWeeks(long startTimestamp, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInWeeks(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInMonths(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInMonths(long startTimestamp, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMonths(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calcule total duration in years between two dates timestamps
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long totalDurationInYears(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInYears(long startTimestamp, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInYears(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInYears(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInYears(long startTimestamp, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInYears(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startTimestamp
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startTimestamp
     * @param endLocalDateTime
     * @return
     */
    @Override
    public long durationInCenturies(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * @param startTimestamp
     * @param endDate
     * @return
     */
    @Override
    public long durationInCenturies(long startTimestamp, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startTimestamp
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInCenturies(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDateTime
     * @param endDate
     * @return
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDateTime
     * @param endLocalDate
     * @return
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endTimestamp
     * @return
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * @param startLocalDate
     * @param endDate
     * @return
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

}
