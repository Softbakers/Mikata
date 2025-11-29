package com.softbakers.utils.mikata.api;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * DateConverterUtilAPI Interface for Date conversion methods.
 */
public interface DateConverterUtilAPI {


        public String toString(java.util.Date date);
        public String toString(java.util.Date date, String pattern);
        public String toString(java.util.Date date, Locale locale);
        public String toString(java.util.Date date, Locale locale, String pattern);
        public String toString(LocalDate date, Locale locale, String pattern);
        public String toString(LocalDate date, Locale locale);
        public String toString(LocalDate date, String pattern);
        public String toString(LocalDate date);
        public String toString(LocalDateTime dateTime, Locale locale, String pattern);
        public String toString(LocalDateTime dateTime, Locale locale);
        public String toString(LocalDateTime dateTime, String pattern);
        public String toString(LocalDateTime dateTime);
        public String toString(Timestamp timestamp);
        public String toString(Timestamp timestamp, String pattern);
        public String toString(Timestamp timestamp, Locale locale);
        public String toString(Timestamp timestamp, Locale locale,String pattern);
        public String toString(long timestamp);
        public String toString(long timestamp, String pattern);
        public String toString(long timestamp, Locale locale);
        public String toString(long timestamp, Locale locale,String pattern);


        public String toDefaultFormatString(java.util.Date date);
        public String toDefaultFormatString(java.util.Date date, Locale locale);
        public String toDefaultFormatString(LocalDate date);
        public String toDefaultFormatString(LocalDate date, Locale locale);
        public String toDefaultFormatString(LocalDateTime dateTime);
        public String toDefaultFormatString(LocalDateTime dateTime, Locale locale);
        public String toDefaultFormatString(Timestamp timestamp);
        public String toDefaultFormatString(Timestamp timestamp, Locale locale);
        public String toDefaultFormatString(long timestamp);
        public String toDefaultFormatString(long timestamp, Locale locale);



        public java.util.Date toDate(LocalDate date);
        public java.util.Date toDate(LocalDateTime dateTime);
        public java.util.Date toDate(Timestamp timestamp);
        public java.util.Date toDate(long timestamp);
        public java.util.Date toDate(String stringDate);
        public java.util.Date toDate(String stringDate, String pattern);
        public java.util.Date toDate(String stringDate, Locale locale);
        public java.util.Date toDate(String stringDate, Locale locale, String pattern);

        public LocalDate toLocalDate(LocalDateTime localDateTime);
        public LocalDate toLocalDate(Timestamp timestamp);
        public LocalDate toLocalDate(java.util.Date date);
        public LocalDate toLocalDate(long timestamp);
        public LocalDate toLocalDate(String stringDate);
        public LocalDate toLocalDate(String stringDate, String pattern);
        public LocalDate toLocalDate(String stringDate, Locale locale);
        public LocalDate toLocalDate(String stringDate, Locale locale, String pattern);

        public LocalDateTime toLocalDateTime(LocalDate localDate);
        public LocalDateTime toLocalDateTime(Timestamp timestamp);
        public LocalDateTime toLocalDateTime(java.util.Date date);
        public LocalDateTime toLocalDateTime(long timestamp);
        public LocalDateTime toLocalDateTime(String stringDate);
        public LocalDateTime toLocalDateTime(String stringDate, String pattern);
        public LocalDateTime toLocalDateTime(String stringDate, Locale locale);
        public LocalDateTime toLocalDateTime(String stringDate, Locale locale, String pattern);


        public Timestamp toSqlTimestamp(java.util.Date date);
        public Timestamp toSqlTimestamp(LocalDate date);
        public Timestamp toSqlTimestamp(LocalDateTime dateTime);
        public Timestamp toSqlTimestamp(long timestamp);
        public Timestamp toSqlTimestamp(String stringDate);
        public Timestamp toSqlTimestamp(String stringDate, String pattern);
        public Timestamp toSqlTimestamp(String stringDate, Locale locale);
        public Timestamp toSqlTimestamp(String stringDate, Locale locale, String pattern);

        public long toTimestamp(java.util.Date date);
        public long toTimestamp(LocalDate date);
        public long toTimestamp(LocalDateTime dateTime);
        public long toTimestamp(Timestamp timestamp);
        public long toTimestamp(String stringDate);
        public long toTimestamp(String stringDate, String pattern);
        public long toTimestamp(String stringDate, Locale locale);
        public long toTimestamp(String stringDate, Locale locale, String pattern) ;

        public long toUnixTimestamp(Timestamp timestamp);
        public long toUnixTimestamp(java.util.Date date);
        public long toUnixTimestamp(LocalDate date);
        public long toUnixTimestamp(LocalDateTime dateTime);
        public long toUnixTimestamp(String stringDate);
        public long toUnixTimestamp(String stringDate, String pattern);
        public long toUnixTimestamp(String stringDate, Locale locale);
        public long toUnixTimestamp(String stringDate, Locale locale, String pattern);

        public Locale getDefaultLocale();
        public void setDefaultLocale(Locale defaultLocale);
        public String getDefaultPattern();
        public void setDefaultPattern(String defaultPattern);



}
