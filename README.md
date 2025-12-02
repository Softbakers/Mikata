# Mikata - Comprehensive Date and Time Utility Library

[![Java Version](https://img.shields.io/badge/Java-8+-blue.svg)](https://www.java.com)
[![Maven Central](https://img.shields.io/maven-central/v/org.softbakers.utils/mikata.svg)](https://mvnrepository.com/artifact/org.softbakers.utils/mikata)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## 📖 Overview

Mikata is a comprehensive Java date and time utility library that provides a unified interface for date manipulation, conversion, and calculation operations across different date and time types (LocalDate, LocalDateTime, Date, Timestamp, etc.) with full localization support.

The library aims to simplify date/time operations in Java applications by providing a clean, intuitive API that handles all common date/time use cases with extensive type conversion capabilities.

## ✨ Features

- **📅 Multi-format Support**: Handle all major Java date/time types
- **🌍 Localization**: Full support for locale-specific formatting and parsing
- **🔁 Type Conversion**: Seamless conversion between all date/time representations
- **📊 Date Calculations**: Comprehensive duration and difference calculations
- **⚡ Performance**: Optimized implementations for common operations
- **🧩 Easy Integration**: Simple API design with minimal learning curve

## 📦 Installation

### Maven
```xml
<dependency>
    <groupId>org.softbakers.utils</groupId>
    <artifactId>mikata</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Gradle**

```gradle

implementation 'org.softbakers.utils:mikata:1.0.0'
```

**🚀 Quick Start**

**Basic Initialization**

```java

// Default constructor (system locale, "yyyy-MM-dd" pattern)*

Mikata mikata = new Mikata();

// Custom locale and pattern*

Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");

Mikata mikataUS = new Mikata(Locale.US, "MM/dd/yyyy");

Mikata mikataJP = new Mikata(Locale.JAPANESE, "yyyy年MM月dd日 HH時mm分");
```

**📚 Core Components**

**1. Date Operations (mikata.date)**

**Getting Current Date/Time**

```java

// Get current date/time in various formats*

LocalDateTime now = mikata.date.now();

Date legacyDate = mikata.date.date();

LocalDate today = mikata.date.localDate();

long timestamp = mikata.date.timestamp();

Timestamp sqlTimestamp = mikata.date.sqlTimestamp();

// Formatted strings*

String defaultFormat = mikata.date.string();

String customFormat = mikata.date.string("yyyy-MM-dd HH:mm:ss");

// Localized formatting*

String frenchDate = mikata.date.stringLocalDate(Locale.FRENCH);

String germanDateTime = mikata.date.stringLocalDateTime(Locale.GERMAN, "dd.MM.yyyy HH:mm");
```

**Date Comparison**

```java

// Compare various date types*

int result1 = mikata.date.compareTo(date1, date2);

int result2 = mikata.date.compareTo(localDate1, timestamp2);

int result3 = mikata.date.compareTo(localDateTime1, date2);

// All combinations are supported:*

// - Date vs Date, LocalDate, LocalDateTime, Timestamp, long*

// - LocalDate vs Date, LocalDate, LocalDateTime, Timestamp, long*

// - LocalDateTime vs Date, LocalDate, LocalDateTime, Timestamp, long*

// - Timestamp vs Date, LocalDate, LocalDateTime, Timestamp, long*

// - long vs Date, LocalDate, LocalDateTime, Timestamp, long*
```

**Date Differences**

```java

// Complete breakdown by time units*

Map<TimeUnit, Long> diff = mikata.date.diff(startDate, endDate);

// Returns map with: DAYS, HOURS, MINUTES, SECONDS, MILLISECONDS, MICROSECONDS, NANOSECONDS*

// Duration calculations*

long days = mikata.date.durationInDays(startDate, endDate);

long hours = mikata.date.durationInHours(startDateTime, endDateTime);

long minutes = mikata.date.durationInMinutes(startDate, endDate);

long seconds = mikata.date.durationInSeconds(startTimestamp, endTimestamp);

long milliseconds = mikata.date.durationInMillis(localDateTime1, localDateTime2);

// Total durations (including fractional parts)*

long totalDays = mikata.date.totalDurationInDays(startDate, endDate);

long totalMonths = mikata.date.totalDurationInMonths(startDateTime, endDateTime);

long totalYears = mikata.date.totalDurationInYears(startDate, endDate);

// Cross-type duration calculations*

long nanos = mikata.date.durationInNanos(timestamp, localDateTime);

long micros = mikata.date.durationInMicros(localDate, date);
```

**2. Date Conversion (mikata.converter)**

**String Conversion**

```java

// Date to String*

String dateStr1 = mikata.converter.toString(new Date());

String dateStr2 = mikata.converter.toString(new Date(), "yyyy-MM-dd HH:mm:ss");

String dateStr3 = mikata.converter.toString(new Date(), Locale.FRENCH);

String dateStr4 = mikata.converter.toString(new Date(), Locale.JAPANESE, "yyyy年MM月dd日");

// LocalDate to String*

String localDateStr1 = mikata.converter.toString(LocalDate.now());

String localDateStr2 = mikata.converter.toString(LocalDate.now(), "dd/MM/yyyy");

String localDateStr3 = mikata.converter.toString(LocalDate.now(), Locale.GERMAN);

// LocalDateTime to String*

String localDateTimeStr = mikata.converter.toString(LocalDateTime.now(), Locale.US, "MM/dd/yyyy hh:mm a");

// Timestamp to String*

String timestampStr = mikata.converter.toString(timestamp, "yyyy-MM-dd'T'HH:mm:ss.SSS");

// long timestamp to String*

String longTimestampStr = mikata.converter.toString(System.currentTimeMillis(), Locale.UK);
```
**Type Conversion**

```java

// To java.util.Date*

Date date1 = mikata.converter.toDate(LocalDate.now());

Date date2 = mikata.converter.toDate(LocalDateTime.now());

Date date3 = mikata.converter.toDate(timestamp);

Date date4 = mikata.converter.toDate(1704067200000L);

Date date5 = mikata.converter.toDate("2024-01-01");

Date date6 = mikata.converter.toDate("01/01/2024", "dd/MM/yyyy");

Date date7 = mikata.converter.toDate("2024年1月1日", Locale.JAPANESE, "yyyy年M月d日");

// To LocalDate*

LocalDate localDate1 = mikata.converter.toLocalDate(new Date());

LocalDate localDate2 = mikata.converter.toLocalDate(LocalDateTime.now());

LocalDate localDate3 = mikata.converter.toLocalDate(timestamp);

LocalDate localDate4 = mikata.converter.toLocalDate("2024-12-25");

LocalDate localDate5 = mikata.converter.toLocalDate("25/12/2024", "dd/MM/yyyy", Locale.FRENCH);

// To LocalDateTime*

LocalDateTime localDateTime1 = mikata.converter.toLocalDateTime(new Date());

LocalDateTime localDateTime2 = mikata.converter.toLocalDateTime(LocalDate.now());

LocalDateTime localDateTime3 = mikata.converter.toLocalDateTime(timestamp);

LocalDateTime localDateTime4 = mikata.converter.toLocalDateTime("2024-01-01T10:30:00");

// To Timestamp*

Timestamp timestamp1 = mikata.converter.toSqlTimestamp(new Date());

Timestamp timestamp2 = mikata.converter.toSqlTimestamp(LocalDate.now());

Timestamp timestamp3 = mikata.converter.toSqlTimestamp(LocalDateTime.now());

Timestamp timestamp4 = mikata.converter.toSqlTimestamp("2024-01-01 10:30:45");

// To long timestamp*

long ts1 = mikata.converter.toTimestamp(new Date());

long ts2 = mikata.converter.toTimestamp(LocalDate.now());

long ts3 = mikata.converter.toTimestamp(LocalDateTime.now());

long ts4 = mikata.converter.toTimestamp("2024-01-01");

// To Unix timestamp (seconds)*

long unix1 = mikata.converter.toUnixTimestamp(new Date());

long unix2 = mikata.converter.toUnixTimestamp(LocalDateTime.now());

long unix3 = mikata.converter.toUnixTimestamp("2024-01-01T00:00:00");
```

**🎯 Advanced Usage**

**Configuration**

```java

// Get current configuration*

Locale currentLocale = mikata.date.getDefaultLocale();

String currentPattern = mikata.date.getDefaultPattern();

Locale converterLocale = mikata.converter.getDefaultLocale();

String converterPattern = mikata.converter.getDefaultPattern();

// Update configuration*

mikata.date.setDefaultLocale(Locale.GERMAN);

mikata.date.setDefaultPattern("dd.MM.yyyy HH:mm:ss");

mikata.converter.setDefaultLocale(Locale.FRENCH);

mikata.converter.setDefaultPattern("dd/MM/yyyy");
```

**Validation**

```java

// Check if a timestamp is a valid Unix timestamp*

boolean isValid = mikata.date.isUnixTimestamp(1704067200L); // true for seconds*

boolean isInvalid = mikata.date.isUnixTimestamp(1704067200000L); // false for milliseconds*
```

**DateType Enum Usage**

```java

// Get current date/time in specific type*

Object nowAsDate = mikata.date.now(DateType.Date); // Returns java.util.Date*

Object nowAsLocalDate = mikata.date.now(DateType.LocalDate); // Returns LocalDate*

Object nowAsTimestamp = mikata.date.now(DateType.Timestamp); // Returns Timestamp*

Object nowAsString = mikata.date.now(DateType.StringLocalDateTime); // Returns String*
```

**📋 API Reference**

**Mikata Class**

| Constructor            | Description                                                     |
|------------------------|-----------------------------------------------------------------|
| Mikata()               | Default constructor with system locale and "yyyy-MM-dd" pattern |
| Mikata(Locale, String) | Constructor with custom locale and date pattern                 |

**DateUtilAPI Interface**

The mikata.date object implements DateUtilAPI with methods organized into categories:

**Current Date/Time Methods**

-   now() - Current LocalDateTime
-   date() - Current java.util.Date
-   localDate() - Current LocalDate
-   timestamp() - Current timestamp in milliseconds
-   unixTimestamp() - Current Unix timestamp in seconds
-   string() - Formatted string with default settings

**Comparison Methods**

-   compareTo() - 25 overloaded methods for all type combinations

**Difference Methods**

-   diff() - 35+ methods for calculating differences between all date types

**Duration Methods**

-   durationInXxx() - Methods for centuries, years, months, weeks, days, hours, minutes, seconds, milliseconds, microseconds, nanoseconds
-   totalDurationInXxx() - Methods for total durations including fractional parts

**DateConverterUtilAPI Interface**

The mikata.converter object implements DateConverterUtilAPI with methods organized into categories:

**String Conversion**

-   toString() - Convert any date type to string with various formatting options

**Type Conversion**

-   toDate() - Convert to java.util.Date
-   toLocalDate() - Convert to LocalDate
-   toLocalDateTime() - Convert to LocalDateTime
-   toSqlTimestamp() - Convert to Timestamp
-   toTimestamp() - Convert to milliseconds since epoch
-   toUnixTimestamp() - Convert to seconds since epoch

**🔧 Practical Examples**

**Example 1: Date Difference Calculation**

```java

Mikata mikata = new Mikata(Locale.US, "MM/dd/yyyy");

LocalDate startDate = LocalDate.of(2024, 1, 1);

LocalDate endDate = LocalDate.of(2024, 12, 31);

// Calculate complete difference*

Map<TimeUnit, Long> difference = mikata.date.diff(startDate, endDate);

System.out.println("Days: " + difference.get(TimeUnit.DAYS));

System.out.println("Hours: " + difference.get(TimeUnit.HOURS));

// Calculate specific durations*

long totalDays = mikata.date.totalDurationInDays(startDate, endDate);

long months = mikata.date.durationInMonths(startDate, endDate);

long weeks = mikata.date.durationInWeeks(startDate, endDate);
```

**Example 2: Localized Date Formatting**

```java

Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");

Mikata mikataJP = new Mikata(Locale.JAPANESE, "yyyy年MM月dd日");

Mikata mikataDE = new Mikata(Locale.GERMAN, "dd.MM.yyyy HH:mm");

LocalDateTime now = LocalDateTime.now();

System.out.println("French: " + mikataFR.converter.toString(now));

System.out.println("Japanese: " + mikataJP.converter.toString(now));

System.out.println("German: " + mikataDE.converter.toString(now));
```

**Example 3: Database Integration**

```java

Mikata mikata = new Mikata();

// Convert database timestamp to various formats*

Timestamp dbTimestamp = resultSet.getTimestamp("created_at");

// To LocalDateTime for business logic*

LocalDateTime created = mikata.converter.toLocalDateTime(dbTimestamp);

// To formatted string for display*

String displayDate = mikata.converter.toString(dbTimestamp, "yyyy-MM-dd HH:mm:ss");

// To java.util.Date for legacy code*

Date legacyDate = mikata.converter.toDate(dbTimestamp);

// Calculate time since creation*

long hoursSinceCreation = mikata.date.durationInHours(created, LocalDateTime.now());
```

**Example 4: REST API Date Handling**

```java

@RestController

public class UserController {

private final Mikata mikata = new Mikata();

@PostMapping("/users")

public ResponseEntity<User> createUser(@RequestBody UserRequest request) {

// Parse string from JSON to LocalDate*

LocalDate birthDate = mikata.converter.toLocalDate(

request.getBirthDate(),

"yyyy-MM-dd"

);

// Validate age*

LocalDate today = mikata.date.localDate();

long ageInYears = mikata.date.durationInYears(birthDate, today);

if (ageInYears < 18) {

throw new IllegalArgumentException("User must be at least 18 years old");

}

// Format for response*

String formattedDate = mikata.converter.toString(

birthDate,

Locale.ENGLISH,

"MMMM dd, yyyy"

);

return ResponseEntity.ok(new User(formattedDate, ageInYears));

}

}
```

**🛠️ Best Practices**

**1. Singleton Pattern**

Consider creating a single instance of Mikata with your application's default locale:

```java

public class DateUtils {

private static final Mikata INSTANCE = new Mikata(Locale.US, "MM/dd/yyyy");

public static Mikata getInstance() {

return INSTANCE;

}

}
```
**2. Thread Safety**

Mikata instances are thread-safe for read operations. For configuration changes, synchronize access or use separate instances.

**3. Performance Optimization**

-   Reuse Mikata instances instead of creating new ones
-   Cache frequently used date conversions
-   Use appropriate duration methods (e.g., durationInDays vs totalDurationInDays)

**4. Error Handling**

```java

try {

Date date = mikata.converter.toDate(invalidDateString);

} catch (DateTimeParseException e) {

// Handle parsing errors*

logger.error("Failed to parse date: " + invalidDateString, e);

}
```
**📊 Supported Date Patterns**

Mikata uses Java's DateTimeFormatter patterns. Common patterns include:

| Pattern                   | Example                 | Description                |
|---------------------------|-------------------------|----------------------------|
| yyyy-MM-dd                | 2024-01-01              | ISO date format            |
| dd/MM/yyyy                | 01/01/2024              | European date format       |
| MM/dd/yyyy                | 01/01/2024              | US date format             |
| yyyy-MM-dd HH:mm:ss       | 2024-01-01 10:30:45     | Date with time             |
| yyyy-MM-dd'T'HH:mm:ss.SSS | 2024-01-01T10:30:45.123 | ISO 8601 with milliseconds |
| EEE, MMM d, yyyy          | Mon, Jan 1, 2024        | Textual date               |
| h:mm a                    | 10:30 AM                | 12-hour time with AM/PM    |

**🌐 Locale Support**

Mikata supports all Java locales. Common ones include:

-   Locale.US - United States
-   Locale.UK - United Kingdom
-   Locale.FRENCH - French
-   Locale.GERMAN - German
-   Locale.JAPANESE - Japanese
-   Locale.CHINESE - Chinese
-   Locale.KOREAN - Korean
-   Locale.ITALIAN - Italian
-   Locale.SPANISH - Spanish

**🔍 Troubleshooting**

**Common Issues**

1.  **Parsing Failures**
    -   Ensure pattern matches the date string format
    -   Check locale compatibility
    -   Validate input string is not null or empty
2.  **Time Zone Issues**
    -   Mikata uses system default time zone
    -   For specific time zones, convert dates before passing to Mikata
3.  **Performance Issues**
    -   Avoid creating new Mikata instances in loops
    -   Cache frequently used conversions

**Debug Tips**

```java

// Enable debug logging for date operations*

Mikata mikata = new Mikata();

System.out.println("Default Locale: " + mikata.date.getDefaultLocale());

System.out.println("Default Pattern: " + mikata.date.getDefaultPattern());
```

**🤝 Contributing**

We welcome contributions! Please see our [Contributing Guidelines](https://contributing.md/) for details.

1.  Fork the repository
2.  Create a feature branch
3.  Commit your changes
4.  Push to the branch
5.  Create a Pull Request

**📄 License**

This project is licensed under the Apache License 2.0 - see the [LICENSE](https://license/) file for details.

**👥 Authors**

-   **Mohamed Lamine JELLAD** - *Initial work* - [Softbakers](https://softbakers.com/)

**🙏 Acknowledgments**

-   Thanks to all contributors who have helped shape Mikata
-   Inspired by the need for a comprehensive date/time utility in Java projects
-   Built with ❤️ by the Softbakers team

**📞 Support**

For support, please:

1.  Check the [documentation](https://github.com/softbakers/mikata/docs)
2.  Search existing [issues](https://github.com/softbakers/mikata/issues)
3.  Create a new issue with detailed description

**🔗 Links**

-   [GitHub Repository](https://github.com/softbakers/mikata)
-   [Issue Tracker](https://github.com/softbakers/mikata/issues)
-   [Maven Central](https://mvnrepository.com/artifact/org.softbakers.utils/mikata)
-   [API Documentation](https://softbakers.github.io/mikata/)

⭐ **If you find Mikata useful, please give it a star on GitHub!** ⭐

Built with ❤️ by [Softbakers](https://softbakers.com/)
