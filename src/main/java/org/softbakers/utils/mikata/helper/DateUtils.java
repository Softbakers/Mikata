package org.softbakers.utils.mikata.helper;

import org.softbakers.utils.mikata.api.DateUtilsAPI;
import org.softbakers.utils.mikata.api.DateType;

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
 * DateUtil - Date util for manipulating dates
 * @author Mohamed Lamine JELLAD
 * @version 1.0.0
 */
public class DateUtils implements DateUtilsAPI {

    private Locale defaultLocale = Locale.getDefault();
    private String defaultPattern = "yyyy-MM-dd";
    private final DateConverterUtils converter = new DateConverterUtils();

    /**
     * Default constructor
     */
    public DateUtils() {
        converter.setDefaultLocale(this.defaultLocale);
        converter.setDefaultPattern(this.defaultPattern);
    }

    /**
     * Parameterized constructor
     * @param defaultLocale the default locale to use in conversion
     * @param defaultPattern the default pattern to use in conversion
     */
    public DateUtils(Locale defaultLocale, String defaultPattern) {
        this.defaultLocale = defaultLocale;
        this.defaultPattern = defaultPattern;
        converter.setDefaultLocale(this.defaultLocale);
        converter.setDefaultPattern(this.defaultPattern);
    }

    /**
     * Get date now as LocalDateTime object
     * @return a LocalDateTime date
     */
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Get date now as java Date legacy object
     * @return a Date object
     */
    @Override
    public java.util.Date date() {
        return new java.util.Date(System.currentTimeMillis());
    }

    /**
     * Get date now as java LocalDateTime object
     * @return a LocalDateTime object
     */
    @Override
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Get date now as java LocalDate object
     * @return a LocalDate without time
     */
    @Override
    public LocalDate localDate() {
        return LocalDate.now();
    }

    /**
     * Get the current timestamp
     * @return a long timestamp value
     */
    @Override
    public long timestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Get the current unix timestamp
     * @return a long unix timestamp value
     */
    @Override
    public long unixTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    /**
     * Get the current java.sql timestamp
     * @return Timestamp object
     */
    @Override
    public Timestamp sqlTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Get the current date as string
     * @return string date
     */
    @Override
    public String string() {
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        return new SimpleDateFormat(defaultPattern).format(date);
    }

    /**
     * Get the current date as string with specific pattern
     * @param pattern the pattern to use
     * @return string date
     */
    @Override
    public String string(String pattern) {
        java.util.Date date = new java.util.Date(System.currentTimeMillis());
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * Get the current local date as string
     * @return string local date
     */
    @Override
    public String stringLocalDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.getDefault());
        return formatter.format(date);
    }

    /**
     * Get the current local date as string with specific locale
     * @param locale the locale to use
     * @return string local date
     */
    @Override
    public String stringLocalDate(Locale locale) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);
        return formatter.format(date);
    }

    /**
     * Get the current local date as string with specific locale and pattern
     * @param locale the locale to use
     * @param pattern the pattern to use
     * @return string local date
     */
    @Override
    public String stringLocalDate(Locale locale, String pattern) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        formatter = formatter.withLocale(locale);
        return localDate.format(formatter);
    }

    /**
     * Get the current local date time as string
     * @return string local date time
     */
    @Override
    public String stringLocalDateTime() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(defaultLocale).withDecimalStyle(DecimalStyle.ofDefaultLocale());
        return formatter.format(date);
    }

    /**
     * Get the current local date time as string with a specific locale
     * @param locale the locale to use
     * @return string local date time
     */
    @Override
    public String stringLocalDateTime(Locale locale) {
        LocalDateTime date = LocalDateTime.now();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        return formatter.format(date);
    }

    /**
     * Get the current local date time as string with a specific locale and pattern
     * @param locale the locale to use
     * @param pattern the pattern to use
     * @return string local date time
     */
    @Override
    public String stringLocalDateTime(Locale locale, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        formatter = formatter.withLocale(locale);
        return localDateTime.format(formatter);
    }

    /**
     * Get the current date as java object with a specific date type
     * @param type the type of date
     * @return date object
     */
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

    /**
     * Get the default locale
     * @return Locale object
     */
    @Override
    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    /**
     * Set the default locale
     * @param defaultLocale the new default locale
     */
    @Override
    public void setDefaultLocale(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    /**
     * Get the default pattern
     * @return string pattern
     */
    @Override
    public String getDefaultPattern() {
        return defaultPattern;
    }

    /**
     * Set the default pattern
     * @param defaultPattern the new default pattern
     */
    @Override
    public void setDefaultPattern(String defaultPattern) {
        this.defaultPattern = defaultPattern;
    }

    /**
     * Check if timestamp is a Unix timestamp
     * @param timestamp a long value timestamp
     * @return true if is unix timestamp, false otherwise
     */
    @Override
    public boolean isUnixTimestamp(long timestamp) {
        String strTimestamp = String.valueOf(timestamp);
        return strTimestamp.length() <= 10;
    }

    /**
     * Compare two legacy java dates
     * @param date1 the first date to compare
     * @param date2 the second date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(java.util.Date date1, java.util.Date date2) {
        return date1.compareTo(date2);
    }

    /**
     * Compare legacy java date with local date
     * @param date1 the first date to compare
     * @param date2 the second local date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(java.util.Date date1, LocalDate date2) {
        LocalDate date = this.converter.toLocalDate(date1);
        return date.compareTo(date2);
    }

    /**
     * Compare legacy java date with local date time
     * @param date1 the first date to compare
     * @param date2 the second local date time to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Date date1, LocalDateTime date2) {
        LocalDateTime date = this.converter.toLocalDateTime(date1);
        return date.compareTo(date2);
    }

    /**
     * Compare legacy java date with timestamp object
     * @param date1 the first date to compare
     * @param timestamp the second timestamp object to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(java.util.Date date1, Timestamp timestamp) {
        java.util.Date date = this.converter.toDate(timestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare legacy java date with timestamp long value
     * @param date1 the first date to compare
     * @param timestamp the second timestamp long value to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(java.util.Date date1, long timestamp) {
        java.util.Date date = this.converter.toDate(timestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare two local dates
     * @param date1 the first local date to compare
     * @param date2 the second local date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2);
    }

    /**
     * Compare local date with local date time
     * @param date1 the first local date to compare
     * @param date2 the second local date time to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDate date1, LocalDateTime date2) {
        LocalDateTime localTime = this.converter.toLocalDateTime(date1);
        return localTime.compareTo(date2);
    }

    /**
     * Compare local date with legacy java date object
     * @param date1 the first local date to compare
     * @param date2 the second legacy date object to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDate date1, java.util.Date date2) {
        LocalDate date = this.converter.toLocalDate(date2);
        return date1.compareTo(date);
    }

    /**
     * Compare local date with timestamp object
     * @param date1 the first local date to compare
     * @param timestamp the second timestamp object to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDate date1, Timestamp timestamp) {
        LocalDate date = this.converter.toLocalDate(timestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare local date with timestamp long value
     * @param date1 the first local date to compare
     * @param timestamp the second timestamp long value to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDate date1, long timestamp) {
        LocalDate date = this.converter.toLocalDate(timestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare two timestamp objects
     * @param timestamp1 the first timestamp to compare
     * @param timestamp2 the second timestamp to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Timestamp timestamp1, Timestamp timestamp2) {
        return timestamp1.compareTo(timestamp2);
    }

    /**
     * Compare timestamp with legacy java date
     * @param timestamp1 the first timestamp to compare
     * @param date the second legacy date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Timestamp timestamp1, java.util.Date date) {
        java.util.Date date1 = this.converter.toDate(timestamp1);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp with local date
     * @param timestamp1 the first timestamp to compare
     * @param date the second local date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Timestamp timestamp1, LocalDate date) {
        LocalDate date1 = this.converter.toLocalDate(timestamp1);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp with local date time
     * @param timestamp1 the first timestamp to compare
     * @param date the second local date time to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Timestamp timestamp1, LocalDateTime date) {
        LocalDateTime date1 = this.converter.toLocalDateTime(timestamp1);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp object with timestamp long value
     * @param timestamp1 the first timestamp object to compare
     * @param timestamp2 the second timestamp long value to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(Timestamp timestamp1, long timestamp2) {
        return this.compareTo(timestamp1.getTime(), timestamp2);
    }

    /**
     * Compare two timestamp long values
     * @param startTimestamp the first timestamp long value
     * @param endTimestamp the second timestamp long value
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
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

    /**
     * Compare timestamp long value with legacy java date
     * @param startTimestamp the first timestamp long value
     * @param date the second legacy date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(long startTimestamp, java.util.Date date) {
        java.util.Date date1 = this.converter.toDate(startTimestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp long value with local date
     * @param startTimestamp the first timestamp long value
     * @param date the second local date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(long startTimestamp, LocalDate date) {
        LocalDate date1 = this.converter.toLocalDate(startTimestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp long value with local date time
     * @param startTimestamp the first timestamp long value
     * @param date the second local date time to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(long startTimestamp, LocalDateTime date) {
        LocalDateTime date1 = this.converter.toLocalDateTime(startTimestamp);
        return date1.compareTo(date);
    }

    /**
     * Compare timestamp long value with timestamp object
     * @param startTimestamp the first timestamp long value
     * @param endTimestamp the second timestamp object to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(long startTimestamp, Timestamp endTimestamp) {
        return this.compareTo(startTimestamp, endTimestamp.getTime());
    }

    /**
     * Compare two local date times
     * @param date1 the first local date time to compare
     * @param date2 the second local date time to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDateTime date1, LocalDateTime date2) {
        return date1.compareTo(date2);
    }

    /**
     * Compare local date time with legacy java date
     * @param date1 the first local date time to compare
     * @param date2 the second legacy date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDateTime date1, Date date2) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(date2);
        return date1.compareTo(dateTime);
    }

    /**
     * Compare local date time with local date
     * @param date1 the first local date time to compare
     * @param date2 the second local date to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDateTime date1, LocalDate date2) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(date2);
        return date1.compareTo(dateTime);
    }

    /**
     * Compare local date time with timestamp object
     * @param date1 the first local date time to compare
     * @param timestamp the second timestamp object to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDateTime date1, Timestamp timestamp) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(timestamp);
        return date1.compareTo(dateTime);
    }

    /**
     * Compare local date time with timestamp long value
     * @param date1 the first local date time to compare
     * @param timestamp the second timestamp long value to compare
     * @return a negative integer, zero, or a positive integer as the first date is less than, equal to, or greater than the second
     */
    @Override
    public int compareTo(LocalDateTime date1, long timestamp) {
        LocalDateTime dateTime = this.converter.toLocalDateTime(timestamp);
        return date1.compareTo(dateTime);
    }

    /**
     * Get difference between two dates in specified time unit
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public long diff(java.util.Date date1, java.util.Date date2, TimeUnit timeUnit) {
        return timeUnit.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
    }

    /**
     * Get detailed difference between two legacy java dates
     * @param startDate the start date
     * @param endDate the end date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit,Long> diff(java.util.Date startDate, java.util.Date endDate) {
        long diffInMillies = endDate.getTime() - startDate.getTime();

        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }

        return result;
    }

    /**
     * Get detailed difference between legacy java date and local date time
     * @param date1 the start date
     * @param endDateTime the end local date time
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, LocalDateTime endDateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(date1);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between legacy java date and local date
     * @param date1 the start date
     * @param date2 the end local date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, LocalDate date2) {
        Date date = this.converter.toDate(date2);
        return this.diff(date1, date);
    }

    /**
     * Get detailed difference between legacy java date and timestamp object
     * @param date1 the start date
     * @param timestamp the end timestamp object
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, Timestamp timestamp) {
        Date date = this.converter.toDate(timestamp);
        return this.diff(date1, date);
    }

    /**
     * Get detailed difference between legacy java date and timestamp long value
     * @param date1 the start date
     * @param timestamp the end timestamp long value
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Date date1, long timestamp) {
        Date date = this.converter.toDate(timestamp);
        return this.diff(date1, date);
    }

    /**
     * Get detailed difference between two local date times
     * @param startDateTime the start local date time
     * @param endDateTime the end local date time
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit,Long> diff(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        long diffInMillies = this.converter.toTimestamp(endDateTime) - this.converter.toTimestamp(startDateTime);

        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }

        return result;
    }

    /**
     * Get detailed difference between local date time and legacy java date
     * @param startDateTime the start local date time
     * @param date2 the end legacy date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, Date date2) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(date2);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between local date time and local date
     * @param startDateTime the start local date time
     * @param date2 the end local date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, LocalDate date2) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(date2);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between local date time and timestamp object
     * @param startDateTime the start local date time
     * @param timestamp the end timestamp object
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, Timestamp timestamp) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between local date time and timestamp long value
     * @param startDateTime the start local date time
     * @param timestamp the end timestamp long value
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDateTime startDateTime, long timestamp) {
        LocalDateTime endDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between two local dates
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate startLocalDate, LocalDate endLocalDate) {
        long diffInMillies = this.converter.toTimestamp(endLocalDate) - this.converter.toTimestamp(startLocalDate);

        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }

        return result;
    }

    /**
     * Get detailed difference between local date and legacy java date
     * @param date1 the start local date
     * @param date2 the end legacy date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, Date date2) {
        java.util.Date date = this.converter.toDate(date1);
        return this.diff(date, date2);
    }

    /**
     * Get detailed difference between local date and local date time
     * @param date1 the start local date
     * @param endDateTime the end local date time
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, LocalDateTime endDateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(date1);
        return this.diff(startDateTime, endDateTime);
    }

    /**
     * Get detailed difference between local date and timestamp object
     * @param date1 the start local date
     * @param timestamp the end timestamp object
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, Timestamp timestamp) {
        Timestamp startTimestamp = this.converter.toSqlTimestamp(date1);
        return this.diff(startTimestamp, timestamp);
    }

    /**
     * Get detailed difference between local date and timestamp long value
     * @param date1 the start local date
     * @param timestamp the end timestamp long value
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(LocalDate date1, long timestamp) {
        long startTimestamp = this.converter.toTimestamp(date1);
        return this.diff(startTimestamp, timestamp);
    }

    /**
     * Get detailed difference between timestamp object and local date
     * @param timestamp the start timestamp object
     * @param date the end local date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, LocalDate date) {
        Timestamp endTimestamp = this.converter.toSqlTimestamp(date);
        return this.diff(timestamp, endTimestamp);
    }

    /**
     * Get detailed difference between timestamp object and legacy java date
     * @param timestamp the start timestamp object
     * @param date the end legacy date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, Date date) {
        Date date1 = this.converter.toDate(timestamp);
        return this.diff(date1, date);
    }

    /**
     * Get detailed difference between timestamp object and local date time
     * @param timestamp the start timestamp object
     * @param dateTime the end local date time
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp timestamp, LocalDateTime dateTime) {
        LocalDateTime startDateTime = this.converter.toLocalDateTime(timestamp);
        return this.diff(startDateTime, dateTime);
    }

    /**
     * Get detailed difference between two timestamp objects
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp object
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp startTimestamp, Timestamp endTimestamp) {
        long diffInMillies = this.converter.toTimestamp(endTimestamp) - this.converter.toTimestamp(startTimestamp);

        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }

        return result;
    }

    /**
     * Get detailed difference between timestamp object and timestamp long value
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp long value
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(Timestamp startTimestamp, long endTimestamp) {
        return this.diff(startTimestamp.getTime(), endTimestamp);
    }

    /**
     * Get detailed difference between timestamp long value and local date
     * @param timestamp the start timestamp long value
     * @param date the end local date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, LocalDate date) {
        return this.diff(timestamp, this.converter.toTimestamp(date));
    }

    /**
     * Get detailed difference between timestamp long value and legacy java date
     * @param timestamp the start timestamp long value
     * @param date the end legacy date
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, Date date) {
        return this.diff(timestamp, date.getTime());
    }

    /**
     * Get detailed difference between timestamp long value and local date time
     * @param timestamp the start timestamp long value
     * @param dateTime the end local date time
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(long timestamp, LocalDateTime dateTime) {
        return this.diff(timestamp, this.converter.toTimestamp(dateTime));
    }

    /**
     * Get detailed difference between timestamp long value and timestamp object
     * @param startTimestamp the start timestamp long value
     * @param endTimestamp the end timestamp object
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(long startTimestamp, Timestamp endTimestamp) {
        return this.diff(startTimestamp, this.converter.toTimestamp(endTimestamp));
    }

    /**
     * Get detailed difference between two timestamp long values
     * @param startTimestamp the start timestamp long value
     * @param endTimestamp the end timestamp long value
     * @return Map of TimeUnit to difference values
     */
    @Override
    public Map<TimeUnit, Long> diff(long startTimestamp, long endTimestamp) {
        long diffInMillies = endTimestamp - startTimestamp;

        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
        long milliesRest = diffInMillies;

        for (TimeUnit unit : units) {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }

        return result;
    }

    /* durations */
    /**
     * Calculate duration between two LocalDateTime objects in centuries
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.durationInYears(startDateTime, endDateTime) / 100;
    }

    /**
     * Calculate duration between two LocalDateTime objects in years using Period
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getYears();
    }

    /**
     * Calculate total duration between two LocalDateTime objects in years using ChronoUnit
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.YEARS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    /**
     * Calculate total duration between two LocalDateTime objects in months using ChronoUnit
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return java.time.temporal.ChronoUnit.MONTHS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    /**
     * Calculate duration between two LocalDateTime objects in months using Period
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getMonths();
    }

    /**
     * Calculate duration between two LocalDateTime objects in weeks
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.totalDurationInDays(startDateTime, endDateTime) / 7;
    }

    /**
     * Calculate total duration between two LocalDateTime objects in days using ChronoUnit
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return java.time.temporal.ChronoUnit.DAYS.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
    }

    /**
     * Calculate duration between two LocalDateTime objects in days using Period
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Period duration = Period.between(this.converter.toLocalDate(startDateTime), this.converter.toLocalDate(endDateTime));
        return duration.getDays();
    }

    /**
     * Calculate duration between two LocalDateTime objects in hours
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toHours();
    }

    /**
     * Calculate duration between two LocalDateTime objects in minutes
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toMinutes();
    }

    /**
     * Calculate duration between two LocalDateTime objects in seconds
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).getSeconds();
    }

    /**
     * Calculate duration between two LocalDateTime objects in milliseconds
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toMillis();
    }

    /**
     * Calculate duration between two LocalDateTime objects in microseconds
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toNanos() / 1000;
    }

    /**
     * Calculate duration between two LocalDateTime objects in nanoseconds
     * @param startDateTime the start date and time
     * @param endDateTime the end date and time
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return Duration.between(startDateTime, endDateTime).toNanos();
    }

    /**
     * Calculate duration between two Date objects in centuries
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Date startDateTime, Date endDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in years
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in years
     */
    @Override
    public long durationInYears(Date startDateTime, Date endDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate total duration between two Date objects in years
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Date startDateTime, Date endDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in months
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in months
     */
    @Override
    public long durationInMonths(Date startDateTime, Date endDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate total duration between two Date objects in months
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Date startDateTime, Date endDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in weeks
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Date startDateTime, Date endDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in days
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in days
     */
    @Override
    public long durationInDays(Date startDateTime, Date endDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate total duration between two Date objects in days
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Date startDateTime, Date endDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in hours
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in hours
     */
    @Override
    public long durationInHours(Date startDateTime, Date endDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in minutes
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Date startDateTime, Date endDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in seconds
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Date startDateTime, Date endDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in milliseconds
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Date startDateTime, Date endDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in microseconds
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Date startDateTime, Date endDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Date objects in nanoseconds
     * @param startDateTime the start date
     * @param endDateTime the end date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Date startDateTime, Date endDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startDateTime), this.converter.toLocalDateTime(endDateTime));
    }

    /**
     * Calculate duration between two Timestamp objects in centuries
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in years
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in years
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two Timestamp objects in years
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in months
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in months
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two Timestamp objects in months
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in weeks
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in days
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in days
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two Timestamp objects in days
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in hours
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in hours
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in minutes
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in seconds
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in milliseconds
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in microseconds
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two Timestamp objects in nanoseconds
     * @param startTimestamp the start timestamp
     * @param endTimestamp the end timestamp
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in centuries
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(long startTimestamp, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in years
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in years
     */
    @Override
    public long durationInYears(long startTimestamp, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two timestamp values in years
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(long startTimestamp, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in months
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in months
     */
    @Override
    public long durationInMonths(long startTimestamp, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two timestamp values in months
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in weeks
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(long startTimestamp, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in days
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in days
     */
    @Override
    public long durationInDays(long startTimestamp, long endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between two timestamp values in days
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(long startTimestamp, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in hours
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in hours
     */
    @Override
    public long durationInHours(long startTimestamp, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in minutes
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(long startTimestamp, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in seconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(long startTimestamp, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in milliseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(long startTimestamp, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in microseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(long startTimestamp, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two timestamp values in nanoseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp value
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(long startTimestamp, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between two LocalDate objects in centuries
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between two LocalDate objects in years
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between two LocalDate objects in years
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between two LocalDate objects in months
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between two LocalDate objects in months
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between two LocalDate objects in weeks
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between two LocalDate objects in days
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between two LocalDate objects in days
     * @param startLocalDate the start local date
     * @param endLocalDate the end local date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in nanoseconds
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in nanoseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in nanoseconds
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in nanoseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in nanoseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in nanoseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in nanoseconds
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(long startTimestamp, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in nanoseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in nanoseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in nanoseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in nanoseconds
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in nanoseconds
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInNanos(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in nanoseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in nanoseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in nanoseconds
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in nanoseconds
     */
    @Override
    public long durationInNanos(LocalDate startLocalDate, Date endDate) {
        return this.durationInNanos(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in microseconds
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in microseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in microseconds
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in microseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in microseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in microseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in microseconds
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(long startTimestamp, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in microseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in microseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in microseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in microseconds
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in microseconds
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMicros(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in microseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in microseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in microseconds
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in microseconds
     */
    @Override
    public long durationInMicros(LocalDate startLocalDate, Date endDate) {
        return this.durationInMicros(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in milliseconds
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in milliseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in milliseconds
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in milliseconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in milliseconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in milliseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in milliseconds
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(long startTimestamp, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in milliseconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in milliseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in milliseconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in milliseconds
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in milliseconds
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMillis(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in milliseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in milliseconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in milliseconds
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in milliseconds
     */
    @Override
    public long durationInMillis(LocalDate startLocalDate, Date endDate) {
        return this.durationInMillis(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in seconds
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in seconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in seconds
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in seconds
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in seconds
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in seconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in seconds
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(long startTimestamp, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in seconds
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in seconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in seconds
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in seconds
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in seconds
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInSeconds(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in seconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in seconds
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in seconds
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in seconds
     */
    @Override
    public long durationInSeconds(LocalDate startLocalDate, Date endDate) {
        return this.durationInSeconds(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in minutes
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in minutes
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in minutes
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in minutes
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in minutes
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in minutes
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in minutes
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(long startTimestamp, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in minutes
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in minutes
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in minutes
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in minutes
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in minutes
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMinutes(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in minutes
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in minutes
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in minutes
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in minutes
     */
    @Override
    public long durationInMinutes(LocalDate startLocalDate, Date endDate) {
        return this.durationInMinutes(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and long timestamp in hours
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in hours
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in hours
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in hours
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in hours
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in hours
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in hours
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in hours
     */
    @Override
    public long durationInHours(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in hours
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in hours
     */
    @Override
    public long durationInHours(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in hours
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in hours
     */
    @Override
    public long durationInHours(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in hours
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in hours
     */
    @Override
    public long durationInHours(long startTimestamp, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in hours
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in hours
     */
    @Override
    public long durationInHours(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in hours
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in hours
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in hours
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in hours
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInHours(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in hours
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in hours
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in hours
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in hours
     */
    @Override
    public long durationInHours(LocalDate startLocalDate, Date endDate) {
        return this.durationInHours(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between Timestamp and long timestamp in days
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between Timestamp and LocalDateTime in days
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between Timestamp and Date in days
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between Timestamp and LocalDate in days
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between long timestamp and Timestamp in days
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between long timestamp and LocalDateTime in days
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between long timestamp and Date in days
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(long startTimestamp, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between long timestamp and LocalDate in days
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDateTime and Timestamp in days
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and long timestamp in days
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and Date in days
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDateTime and LocalDate in days
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInDays(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDate and Timestamp in days
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and long timestamp in days
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and Date in days
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDate and LocalDateTime in days
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return total duration in days
     */
    @Override
    public long totalDurationInDays(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInDays(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate duration between Timestamp and long timestamp in days
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in days
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in days
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in days
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in days
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in days
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in days
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in days
     */
    @Override
    public long durationInDays(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in days
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in days
     */
    @Override
    public long durationInDays(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in days
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in days
     */
    @Override
    public long durationInDays(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in days
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in days
     */
    @Override
    public long durationInDays(long startTimestamp, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in days
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in days
     */
    @Override
    public long durationInDays(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in days
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in days
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in days
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in days
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInDays(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in days
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in days
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in days
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, Date endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDate and LocalDateTime in days
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return duration in days
     */
    @Override
    public long durationInDays(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInDays(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate duration between Timestamp and long timestamp in weeks
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in weeks
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in weeks
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in weeks
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in weeks
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in weeks
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in weeks
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(long startTimestamp, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in weeks
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in weeks
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in weeks
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in weeks
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in weeks
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInWeeks(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in weeks
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in weeks
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in weeks
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, Date endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDate and LocalDateTime in weeks
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return duration in weeks
     */
    @Override
    public long durationInWeeks(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInWeeks(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate total duration between Timestamp and long timestamp in months
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between Timestamp and LocalDateTime in months
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between Timestamp and Date in months
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between Timestamp and LocalDate in months
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between long timestamp and Timestamp in months
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between long timestamp and LocalDateTime in months
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between long timestamp and Date in months
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between long timestamp and LocalDate in months
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDateTime and Timestamp in months
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and long timestamp in months
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and Date in months
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDateTime and LocalDate in months
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDate and Timestamp in months
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and long timestamp in months
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and Date in months
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDate and LocalDateTime in months
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return total duration in months
     */
    @Override
    public long totalDurationInMonths(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInMonths(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate duration between Timestamp and long timestamp in months
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in months
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in months
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in months
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in months
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in months
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in months
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in months
     */
    @Override
    public long durationInMonths(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in months
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in months
     */
    @Override
    public long durationInMonths(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in months
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in months
     */
    @Override
    public long durationInMonths(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in months
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in months
     */
    @Override
    public long durationInMonths(long startTimestamp, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in months
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in months
     */
    @Override
    public long durationInMonths(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in months
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in months
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in months
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in months
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInMonths(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in months
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in months
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in months
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, Date endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDate and LocalDateTime in months
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return duration in months
     */
    @Override
    public long durationInMonths(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInMonths(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate total duration between Timestamp and long timestamp in years
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between Timestamp and LocalDateTime in years
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between Timestamp and Date in years
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between Timestamp and LocalDate in years
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between long timestamp and Timestamp in years
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(long startTimestamp, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between long timestamp and LocalDateTime in years
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate total duration between long timestamp and Date in years
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(long startTimestamp, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between long timestamp and LocalDate in years
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(long startTimestamp, LocalDate endLocalDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDateTime and Timestamp in years
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and long timestamp in years
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDateTime and Date in years
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, Date endDate) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDateTime and LocalDate in years
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.totalDurationInYears(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate total duration between LocalDate and Timestamp in years
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and long timestamp in years
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, long endTimestamp) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate total duration between LocalDate and Date in years
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, Date endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate total duration between LocalDate and LocalDateTime in years
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return total duration in years
     */
    @Override
    public long totalDurationInYears(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.totalDurationInYears(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate duration between Timestamp and long timestamp in years
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in years
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in years
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in years
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in years
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in years
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in years
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in years
     */
    @Override
    public long durationInYears(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in years
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in years
     */
    @Override
    public long durationInYears(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in years
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in years
     */
    @Override
    public long durationInYears(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in years
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in years
     */
    @Override
    public long durationInYears(long startTimestamp, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in years
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in years
     */
    @Override
    public long durationInYears(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in years
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in years
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in years
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in years
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInYears(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in years
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in years
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in years
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, Date endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDate and LocalDateTime in years
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return duration in years
     */
    @Override
    public long durationInYears(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInYears(this.converter.toLocalDateTime(startLocalDate), endDate);
    }

    /**
     * Calculate duration between Timestamp and long timestamp in centuries
     * @param startTimestamp the start timestamp object
     * @param endTimestamp the end timestamp value
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between Timestamp and LocalDateTime in centuries
     * @param startTimestamp the start timestamp object
     * @param endLocalDateTime the end local date time
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between Timestamp and Date in centuries
     * @param startTimestamp the start timestamp object
     * @param endDate the end date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between Timestamp and LocalDate in centuries
     * @param startTimestamp the start timestamp object
     * @param endLocalDate the end local date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(Timestamp startTimestamp, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between long timestamp and Timestamp in centuries
     * @param startTimestamp the start timestamp value
     * @param endTimestamp the end timestamp object
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(long startTimestamp, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between long timestamp and LocalDateTime in centuries
     * @param startTimestamp the start timestamp value
     * @param endLocalDateTime the end local date time
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(long startTimestamp, LocalDateTime endLocalDateTime) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), endLocalDateTime);
    }

    /**
     * Calculate duration between long timestamp and Date in centuries
     * @param startTimestamp the start timestamp value
     * @param endDate the end date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(long startTimestamp, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between long timestamp and LocalDate in centuries
     * @param startTimestamp the start timestamp value
     * @param endLocalDate the end local date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(long startTimestamp, LocalDate endLocalDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startTimestamp), this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDateTime and Timestamp in centuries
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp object
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, Timestamp endTimestamp) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and long timestamp in centuries
     * @param startLocalDateTime the start local date time
     * @param endTimestamp the end timestamp value
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, long endTimestamp) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDateTime and Date in centuries
     * @param startLocalDateTime the start local date time
     * @param endDate the end date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, Date endDate) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDateTime and LocalDate in centuries
     * @param startLocalDateTime the start local date time
     * @param endLocalDate the end local date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDateTime startLocalDateTime, LocalDate endLocalDate) {
        return this.durationInCenturies(startLocalDateTime, this.converter.toLocalDateTime(endLocalDate));
    }

    /**
     * Calculate duration between LocalDate and Timestamp in centuries
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp object
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, Timestamp endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and long timestamp in centuries
     * @param startLocalDate the start local date
     * @param endTimestamp the end timestamp value
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, long endTimestamp) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endTimestamp));
    }

    /**
     * Calculate duration between LocalDate and Date in centuries
     * @param startLocalDate the start local date
     * @param endDate the end date
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, Date endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), this.converter.toLocalDateTime(endDate));
    }

    /**
     * Calculate duration between LocalDate and LocalDateTime in centuries
     * @param startLocalDate the start local date
     * @param endDate the end local date time
     * @return duration in centuries
     */
    @Override
    public long durationInCenturies(LocalDate startLocalDate, LocalDateTime endDate) {
        return this.durationInCenturies(this.converter.toLocalDateTime(startLocalDate), endDate);
    }
}