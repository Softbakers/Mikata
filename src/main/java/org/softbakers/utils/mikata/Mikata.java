 package org.softbakers.utils.mikata;

import org.softbakers.utils.mikata.helper.DateConverterUtil;
import org.softbakers.utils.mikata.helper.DateUtil;

import java.util.Locale;

/**
 * Mikata - Comprehensive date and time utility library with localization support
 *
 * <p>Mikata provides a unified interface for date manipulation, conversion, and calculation
 * operations across different date and time types (LocalDate, LocalDateTime, Date, Timestamp, etc.)
 * with full localization support.</p>
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Date and time conversion between different types</li>
 *   <li>Date comparison and difference calculations</li>
 *   <li>Duration calculations in various time units</li>
 *   <li>Localized date formatting and parsing</li>
 *   <li>Support for multiple date patterns and locales</li>
 * </ul>
 *
 * <h2>Usage Examples:</h2>
 *
 * <h3>Basic Initialization:</h3>
 * <pre>
 * {@code
 * // Default constructor (system locale, "yyyy-MM-dd" pattern)
 * Mikata mikata = new Mikata();
 *
 * // Custom locale and pattern
 * Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");
 * Mikata mikataUS = new Mikata(Locale.US, "MM/dd/yyyy");
 * }
 * </pre>
 *
 * <h3>Date Operations:</h3>
 * <pre>
 * {@code
 * // Get current date in different formats
 * LocalDateTime now = mikata.date.now();
 * Date legacyDate = mikata.date.date();
 * String dateString = mikata.date.string();
 *
 * // Format dates with specific patterns
 * String formattedDate = mikata.date.string("yyyy-MM-dd HH:mm:ss");
 * String localizedDate = mikata.date.stringLocalDate(Locale.FRENCH);
 * }
 * </pre>
 *
 * <h3>Date Conversion:</h3>
 * <pre>
 * {@code
 * // Convert between date types
 * LocalDate localDate = mikata.converter.toLocalDate(new Date());
 * LocalDateTime localDateTime = mikata.converter.toLocalDateTime(timestamp);
 * Date utilDate = mikata.converter.toDate(localDateTime);
 *
 * // Convert with specific patterns
 * String dateStr = mikata.converter.toString(localDate, "dd/MM/yyyy");
 * LocalDate parsedDate = mikata.converter.toLocalDate("2023-12-25", "yyyy-MM-dd");
 * }
 * </pre>
 *
 * <h3>Date Comparison and Differences:</h3>
 * <pre>
 * {@code
 * // Compare dates
 * int result = mikata.date.compareTo(date1, date2);
 *
 * // Calculate differences
 * Map<TimeUnit, Long> diff = mikata.date.diff(startDate, endDate);
 * long daysBetween = mikata.date.totalDurationInDays(startDate, endDate);
 * long hoursBetween = mikata.date.durationInHours(startDateTime, endDateTime);
 * }
 * </pre>
 *
 * <h3>Localized Operations:</h3>
 * <pre>
 * {@code
 * // Get localized date strings
 * String frenchDate = mikata.date.stringLocalDate(Locale.FRENCH);
 * String germanDateTime = mikata.date.stringLocalDateTime(Locale.GERMAN, "dd.MM.yyyy HH:mm");
 *
 * // Pattern-based formatting with locale
 * String customFormat = mikata.date.stringLocalDate(Locale.JAPANESE, "yyyy年MM月dd日");
 * }
 * </pre>
 *
 * @author Mohamed Lamine JELLAD from Softbakers
 * @version 1.0.0
 * @see DateUtil
 * @see DateConverterUtil
 * @see java.time.LocalDate
 * @see java.time.LocalDateTime
 * @see java.util.Date
 * @see java.sql.Timestamp
 */
public class Mikata {

    /**
     * Date utility instance for date operations and calculations
     *
     * <p>Provides methods for:
     * <ul>
     *   <li>Getting current date/time in various formats</li>
     *   <li>Date comparison operations</li>
     *   <li>Duration calculations between dates</li>
     *   <li>Localized date formatting</li>
     * </ul>
     *
     * <p><b>Example usage:</b>
     * <pre>
     * {@code
     * Mikata mikata = new Mikata();
     *
     * // Get current date/time
     * LocalDateTime now = mikata.date.now();
     * Date currentDate = mikata.date.date();
     *
     * // Calculate duration
     * long days = mikata.date.totalDurationInDays(startDate, endDate);
     *
     * // Compare dates
     * int comparison = mikata.date.compareTo(date1, date2);
     * }
     * </pre>
     */
    public DateUtil date;

    /**
     * Date converter utility for converting between different date types and formats
     *
     * <p>Provides conversion methods between:
     * <ul>
     *   <li>java.util.Date and java.time types</li>
     *   <li>String representations and date objects</li>
     *   <li>Different timestamp formats</li>
     *   <li>Various date patterns with localization</li>
     * </ul>
     *
     * <p><b>Example usage:</b>
     * <pre>
     * {@code
     * Mikata mikata = new Mikata();
     *
     * // Convert between types
     * LocalDate localDate = mikata.converter.toLocalDate(new Date());
     * Date utilDate = mikata.converter.toDate(localDateTime);
     *
     * // String conversion
     * String dateStr = mikata.converter.toString(localDate, "yyyy-MM-dd");
     * LocalDate parsed = mikata.converter.toLocalDate("25/12/2023", "dd/MM/yyyy");
     * }
     * </pre>
     */
    public DateConverterUtil converter;

    /**
     * Default constructor initializes with system default locale and "yyyy-MM-dd" pattern
     *
     * <p><b>Example:</b>
     * <pre>
     * {@code
     * // Uses system locale and "yyyy-MM-dd" pattern
     * Mikata mikata = new Mikata();
     * }
     * </pre>
     */
    public Mikata() {
        this.date = new DateUtil(Locale.getDefault(), "yyyy-MM-dd");
        this.converter = new DateConverterUtil(Locale.getDefault(), "yyyy-MM-dd");
    }

    /**
     * Parameterized constructor with custom locale and date pattern
     *
     * @param defaultLocale the locale to use for date formatting and parsing
     * @param defaultPattern the date pattern to use (e.g., "yyyy-MM-dd", "dd/MM/yyyy")
     *
     * <p><b>Example:</b>
     * <pre>
     * {@code
     * // French locale with European date format
     * Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");
     *
     * // US locale with standard format
     * Mikata mikataUS = new Mikata(Locale.US, "MM/dd/yyyy");
     *
     * // Japanese locale with full date-time format
     * Mikata mikataJP = new Mikata(Locale.JAPANESE, "yyyy年MM月dd日 HH時mm分");
     * }
     * </pre>
     */
    public Mikata(Locale defaultLocale, String defaultPattern) {
        this.date = new DateUtil(defaultLocale, defaultPattern);
        this.converter = new DateConverterUtil(defaultLocale, defaultPattern);
    }
}