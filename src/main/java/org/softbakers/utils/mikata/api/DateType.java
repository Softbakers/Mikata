package org.softbakers.utils.mikata.api;

/**
 * DateType ENUM representing different date/time types used in date conversion utilities.
 * Each value of this enum corresponds to a specific Java date/time representation type
 * that can be used with the DateConverterUtilAPI for conversion operations.
 *
 * @author Mohamed Lamine JELLAD from Softbakers
 * @version 1.0.0
 * @see DateConverterUtilAPI
 */
public enum DateType {

    /**
     * Represents java.sql.Timestamp type.
     * Used for database timestamp values with nanosecond precision.
     * Typically represents a specific instant in time with date and time components.
     */
    Timestamp,

    /**
     * Represents java.sql.Timestamp type (alias for Timestamp).
     * Provided for clarity when specifically dealing with SQL timestamp operations.
     * Note: This is functionally equivalent to {@link #Timestamp}.
     */
    SQLTimestamp,

    /**
     * Represents Unix timestamp as long primitive type.
     * Number of seconds elapsed since January 1, 1970, 00:00:00 UTC (Unix epoch).
     * Commonly used in Unix-based systems and various programming APIs.
     */
    UnixTimestamp,

    /**
     * Represents java.util.Date type.
     * Legacy date-time class representing a specific instant in time with millisecond precision.
     * Includes both date and time components.
     */
    Date,

    /**
     * Represents date/time as formatted String for java.util.Date conversions.
     * String representation that can be parsed into java.util.Date objects.
     * Format depends on the pattern and locale used for conversion.
     */
    StringDate,

    /**
     * Represents java.time.LocalDate type.
     * Date without time-zone in the ISO-8601 calendar system, such as 2007-12-03.
     * Represents only date components (year, month, day) without time information.
     */
    LocalDate,

    /**
     * Represents date as formatted String for LocalDate conversions.
     * String representation that can be parsed into LocalDate objects.
     * Typically contains only date components without time information.
     */
    StringLocalDate,

    /**
     * Represents java.time.LocalDateTime type.
     * Date-time without time-zone in the ISO-8601 calendar system,
     * such as 2007-12-03T10:15:30.
     * Combines date and time components but without timezone information.
     */
    LocalDateTime,

    /**
     * Represents date-time as formatted String for LocalDateTime conversions.
     * String representation that can be parsed into LocalDateTime objects.
     * Contains both date and time components in the specified format.
     */
    StringLocalDateTime
}