package com.softbakers.utils.mikata.api;
/**
 * DateType ENUM.  Each value of this
 * enum represents a java type of date /time
 */
public enum DateType {
    /**
     * The date type long Timestamp named "Timestamp".
     */
    Timestamp,
    /**
     * The date type java.sql.Timestamp named "SQLTimestamp".
     */
    SQLTimestamp,
    /**
     * The date type long Unix Timestamp named "UnixTimestamp".
     */
    UnixTimestamp,
    /**
     * The date type legacy java.util.Date named "Date".
     */
    Date,
    /**
     * The string date format for type legacy java.util.Date named "StringDate".
     */
    StringDate,
    /**
     * The LocalDate for type java.time.LocalDate named "LocalDate".
     */
    LocalDate,
    /**
     * The string date format for type java.time.LocalDate named "StringLocalDate".
     */
    StringLocalDate,
    /**
     * The date for type java.time.LocalDateTime named "LocalDateTime".
     */
    LocalDateTime,
    /**
     * The string date format for type java.time.LocalDateTime named "StringLocalDateTime".
     */
    StringLocalDateTime
}
