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

**Gradle**

gradle

implementation 'org.softbakers.utils:mikata:1.0.0'

**🚀 Quick Start**

**Basic Initialization**

java

_// Default constructor (system locale, "yyyy-MM-dd" pattern)_

Mikata mikata = new Mikata();

_// Custom locale and pattern_

Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");

Mikata mikataUS = new Mikata(Locale.US, "MM/dd/yyyy");

Mikata mikataJP = new Mikata(Locale.JAPANESE, "yyyy年MM月dd日 HH時mm分");

**📚 Core Components**

**1\. Date Operations (mikata.date)**

**Getting Current Date/Time**

java

_// Get current date/time in various formats_

LocalDateTime now = mikata.date.now();

Date legacyDate = mikata.date.date();

LocalDate today = mikata.date.localDate();

long timestamp = mikata.date.timestamp();

Timestamp sqlTimestamp = mikata.date.sqlTimestamp();

_// Formatted strings_

String defaultFormat = mikata.date.string();

String customFormat = mikata.date.string("yyyy-MM-dd HH:mm:ss");

_// Localized formatting_

String frenchDate = mikata.date.stringLocalDate(Locale.FRENCH);

String germanDateTime = mikata.date.stringLocalDateTime(Locale.GERMAN, "dd.MM.yyyy HH:mm");

**Date Comparison**

java

_// Compare various date types_

int result1 = mikata.date.compareTo(date1, date2);

int result2 = mikata.date.compareTo(localDate1, timestamp2);

int result3 = mikata.date.compareTo(localDateTime1, date2);

_// All combinations are supported:_

_// - Date vs Date, LocalDate, LocalDateTime, Timestamp, long_

_// - LocalDate vs Date, LocalDate, LocalDateTime, Timestamp, long_

_// - LocalDateTime vs Date, LocalDate, LocalDateTime, Timestamp, long_

_// - Timestamp vs Date, LocalDate, LocalDateTime, Timestamp, long_

_// - long vs Date, LocalDate, LocalDateTime, Timestamp, long_

**Date Differences**

java

_// Complete breakdown by time units_

Map&lt;TimeUnit, Long&gt; diff = mikata.date.diff(startDate, endDate);

_// Returns map with: DAYS, HOURS, MINUTES, SECONDS, MILLISECONDS, MICROSECONDS, NANOSECONDS_

_// Duration calculations_

long days = mikata.date.durationInDays(startDate, endDate);

long hours = mikata.date.durationInHours(startDateTime, endDateTime);

long minutes = mikata.date.durationInMinutes(startDate, endDate);

long seconds = mikata.date.durationInSeconds(startTimestamp, endTimestamp);

long milliseconds = mikata.date.durationInMillis(localDateTime1, localDateTime2);

_// Total durations (including fractional parts)_

long totalDays = mikata.date.totalDurationInDays(startDate, endDate);

long totalMonths = mikata.date.totalDurationInMonths(startDateTime, endDateTime);

long totalYears = mikata.date.totalDurationInYears(startDate, endDate);

_// Cross-type duration calculations_

long nanos = mikata.date.durationInNanos(timestamp, localDateTime);

long micros = mikata.date.durationInMicros(localDate, date);

**2\. Date Conversion (mikata.converter)**

**String Conversion**

java

_// Date to String_

String dateStr1 = mikata.converter.toString(new Date());

String dateStr2 = mikata.converter.toString(new Date(), "yyyy-MM-dd HH:mm:ss");

String dateStr3 = mikata.converter.toString(new Date(), Locale.FRENCH);

String dateStr4 = mikata.converter.toString(new Date(), Locale.JAPANESE, "yyyy年MM月dd日");

_// LocalDate to String_

String localDateStr1 = mikata.converter.toString(LocalDate.now());

String localDateStr2 = mikata.converter.toString(LocalDate.now(), "dd/MM/yyyy");

String localDateStr3 = mikata.converter.toString(LocalDate.now(), Locale.GERMAN);

_// LocalDateTime to String_

String localDateTimeStr = mikata.converter.toString(LocalDateTime.now(), Locale.US, "MM/dd/yyyy hh:mm a");

_// Timestamp to String_

String timestampStr = mikata.converter.toString(timestamp, "yyyy-MM-dd'T'HH:mm:ss.SSS");

_// long timestamp to String_

String longTimestampStr = mikata.converter.toString(System.currentTimeMillis(), Locale.UK);

**Type Conversion**

java

_// To java.util.Date_

Date date1 = mikata.converter.toDate(LocalDate.now());

Date date2 = mikata.converter.toDate(LocalDateTime.now());

Date date3 = mikata.converter.toDate(timestamp);

Date date4 = mikata.converter.toDate(1704067200000L);

Date date5 = mikata.converter.toDate("2024-01-01");

Date date6 = mikata.converter.toDate("01/01/2024", "dd/MM/yyyy");

Date date7 = mikata.converter.toDate("2024年1月1日", Locale.JAPANESE, "yyyy年M月d日");

_// To LocalDate_

LocalDate localDate1 = mikata.converter.toLocalDate(new Date());

LocalDate localDate2 = mikata.converter.toLocalDate(LocalDateTime.now());

LocalDate localDate3 = mikata.converter.toLocalDate(timestamp);

LocalDate localDate4 = mikata.converter.toLocalDate("2024-12-25");

LocalDate localDate5 = mikata.converter.toLocalDate("25/12/2024", "dd/MM/yyyy", Locale.FRENCH);

_// To LocalDateTime_

LocalDateTime localDateTime1 = mikata.converter.toLocalDateTime(new Date());

LocalDateTime localDateTime2 = mikata.converter.toLocalDateTime(LocalDate.now());

LocalDateTime localDateTime3 = mikata.converter.toLocalDateTime(timestamp);

LocalDateTime localDateTime4 = mikata.converter.toLocalDateTime("2024-01-01T10:30:00");

_// To Timestamp_

Timestamp timestamp1 = mikata.converter.toSqlTimestamp(new Date());

Timestamp timestamp2 = mikata.converter.toSqlTimestamp(LocalDate.now());

Timestamp timestamp3 = mikata.converter.toSqlTimestamp(LocalDateTime.now());

Timestamp timestamp4 = mikata.converter.toSqlTimestamp("2024-01-01 10:30:45");

_// To long timestamp_

long ts1 = mikata.converter.toTimestamp(new Date());

long ts2 = mikata.converter.toTimestamp(LocalDate.now());

long ts3 = mikata.converter.toTimestamp(LocalDateTime.now());

long ts4 = mikata.converter.toTimestamp("2024-01-01");

_// To Unix timestamp (seconds)_

long unix1 = mikata.converter.toUnixTimestamp(new Date());

long unix2 = mikata.converter.toUnixTimestamp(LocalDateTime.now());

long unix3 = mikata.converter.toUnixTimestamp("2024-01-01T00:00:00");

**🎯 Advanced Usage**

**Configuration**

java

_// Get current configuration_

Locale currentLocale = mikata.date.getDefaultLocale();

String currentPattern = mikata.date.getDefaultPattern();

Locale converterLocale = mikata.converter.getDefaultLocale();

String converterPattern = mikata.converter.getDefaultPattern();

_// Update configuration_

mikata.date.setDefaultLocale(Locale.GERMAN);

mikata.date.setDefaultPattern("dd.MM.yyyy HH:mm:ss");

mikata.converter.setDefaultLocale(Locale.FRENCH);

mikata.converter.setDefaultPattern("dd/MM/yyyy");

**Validation**

java

_// Check if a timestamp is a valid Unix timestamp_

boolean isValid = mikata.date.isUnixTimestamp(1704067200L); _// true for seconds_

boolean isInvalid = mikata.date.isUnixTimestamp(1704067200000L); _// false for milliseconds_

**DateType Enum Usage**

java

_// Get current date/time in specific type_

Object nowAsDate = mikata.date.now(DateType.Date); _// Returns java.util.Date_

Object nowAsLocalDate = mikata.date.now(DateType.LocalDate); _// Returns LocalDate_

Object nowAsTimestamp = mikata.date.now(DateType.Timestamp); _// Returns Timestamp_

Object nowAsString = mikata.date.now(DateType.StringLocalDateTime); _// Returns String_

**📋 API Reference**

**Mikata Class**

| Constructor | Description |
| --- | --- |
| Mikata() | Default constructor with system locale and "yyyy-MM-dd" pattern |
| Mikata(Locale, String) | Constructor with custom locale and date pattern |

**DateUtilAPI Interface**

The mikata.date object implements DateUtilAPI with methods organized into categories:

**Current Date/Time Methods**

- now() - Current LocalDateTime
- date() - Current java.util.Date
- localDate() - Current LocalDate
- timestamp() - Current timestamp in milliseconds
- unixTimestamp() - Current Unix timestamp in seconds
- string() - Formatted string with default settings

**Comparison Methods**

- compareTo() - 25 overloaded methods for all type combinations

**Difference Methods**

- diff() - 35+ methods for calculating differences between all date types

**Duration Methods**

- durationInXxx() - Methods for centuries, years, months, weeks, days, hours, minutes, seconds, milliseconds, microseconds, nanoseconds
- totalDurationInXxx() - Methods for total durations including fractional parts

**DateConverterUtilAPI Interface**

The mikata.converter object implements DateConverterUtilAPI with methods organized into categories:

**String Conversion**

- toString() - Convert any date type to string with various formatting options

**Type Conversion**

- toDate() - Convert to java.util.Date
- toLocalDate() - Convert to LocalDate
- toLocalDateTime() - Convert to LocalDateTime
- toSqlTimestamp() - Convert to Timestamp
- toTimestamp() - Convert to milliseconds since epoch
- toUnixTimestamp() - Convert to seconds since epoch

**🔧 Practical Examples**

**Example 1: Date Difference Calculation**

java

Mikata mikata = new Mikata(Locale.US, "MM/dd/yyyy");

LocalDate startDate = LocalDate.of(2024, 1, 1);

LocalDate endDate = LocalDate.of(2024, 12, 31);

_// Calculate complete difference_

Map&lt;TimeUnit, Long&gt; difference = mikata.date.diff(startDate, endDate);

System.out.println("Days: " + difference.get(TimeUnit.DAYS));

System.out.println("Hours: " + difference.get(TimeUnit.HOURS));

_// Calculate specific durations_

long totalDays = mikata.date.totalDurationInDays(startDate, endDate);

long months = mikata.date.durationInMonths(startDate, endDate);

long weeks = mikata.date.durationInWeeks(startDate, endDate);

**Example 2: Localized Date Formatting**

java

Mikata mikataFR = new Mikata(Locale.FRENCH, "dd/MM/yyyy");

Mikata mikataJP = new Mikata(Locale.JAPANESE, "yyyy年MM月dd日");

Mikata mikataDE = new Mikata(Locale.GERMAN, "dd.MM.yyyy HH:mm");

LocalDateTime now = LocalDateTime.now();

System.out.println("French: " + mikataFR.converter.toString(now));

System.out.println("Japanese: " + mikataJP.converter.toString(now));

System.out.println("German: " + mikataDE.converter.toString(now));

**Example 3: Database Integration**

java

Mikata mikata = new Mikata();

_// Convert database timestamp to various formats_

Timestamp dbTimestamp = resultSet.getTimestamp("created_at");

_// To LocalDateTime for business logic_

LocalDateTime created = mikata.converter.toLocalDateTime(dbTimestamp);

_// To formatted string for display_

String displayDate = mikata.converter.toString(dbTimestamp, "yyyy-MM-dd HH:mm:ss");

_// To java.util.Date for legacy code_

Date legacyDate = mikata.converter.toDate(dbTimestamp);

_// Calculate time since creation_

long hoursSinceCreation = mikata.date.durationInHours(created, LocalDateTime.now());

**Example 4: REST API Date Handling**

java

@RestController

public class UserController {

private final Mikata mikata = new Mikata();

@PostMapping("/users")

public ResponseEntity&lt;User&gt; createUser(@RequestBody UserRequest request) {

_// Parse string from JSON to LocalDate_

LocalDate birthDate = mikata.converter.toLocalDate(

request.getBirthDate(),

"yyyy-MM-dd"

);

_// Validate age_

LocalDate today = mikata.date.localDate();

long ageInYears = mikata.date.durationInYears(birthDate, today);

if (ageInYears < 18) {

throw new IllegalArgumentException("User must be at least 18 years old");

}

_// Format for response_

String formattedDate = mikata.converter.toString(

birthDate,

Locale.ENGLISH,

"MMMM dd, yyyy"

);

return ResponseEntity.ok(new User(formattedDate, ageInYears));

}

}

**🛠️ Best Practices**

**1. Singleton Pattern**

Consider creating a single instance of Mikata with your application's default locale:

java

public class DateUtils {

private static final Mikata INSTANCE = new Mikata(Locale.US, "MM/dd/yyyy");

public static Mikata getInstance() {

return INSTANCE;

}

}

**2. Thread Safety**

Mikata instances are thread-safe for read operations. For configuration changes, synchronize access or use separate instances.

**3. Performance Optimization**

- Reuse Mikata instances instead of creating new ones
- Cache frequently used date conversions
- Use appropriate duration methods (e.g., durationInDays vs totalDurationInDays)

**4. Error Handling**

java

try {

Date date = mikata.converter.toDate(invalidDateString);

} catch (DateTimeParseException e) {

_// Handle parsing errors_

logger.error("Failed to parse date: " + invalidDateString, e);

}

**📊 Supported Date Patterns**

Mikata uses Java's DateTimeFormatter patterns. Common patterns include:

| Pattern | Example | Description |
| --- | --- | --- |
| yyyy-MM-dd | 2024-01-01 | ISO date format |
| dd/MM/yyyy | 01/01/2024 | European date format |
| MM/dd/yyyy | 01/01/2024 | US date format |
| yyyy-MM-dd HH:mm:ss | 2024-01-01 10:30:45 | Date with time |
| yyyy-MM-dd'T'HH:mm:ss.SSS | 2024-01-01T10:30:45.123 | ISO 8601 with milliseconds |
| EEE, MMM d, yyyy | Mon, Jan 1, 2024 | Textual date |
| h:mm a | 10:30 AM | 12-hour time with AM/PM |

**🌐 Locale Support**

Mikata supports all Java locales. Common ones include:

- Locale.US - United States
- Locale.UK - United Kingdom
- Locale.FRENCH - French
- Locale.GERMAN - German
- Locale.JAPANESE - Japanese
- Locale.CHINESE - Chinese
- Locale.KOREAN - Korean
- Locale.ITALIAN - Italian
- Locale.SPANISH - Spanish

**🔍 Troubleshooting**

**Common Issues**

- **Parsing Failures**
  - Ensure pattern matches the date string format
  - Check locale compatibility
  - Validate input string is not null or empty
- **Time Zone Issues**
  - Mikata uses system default time zone
  - For specific time zones, convert dates before passing to Mikata
- **Performance Issues**
  - Avoid creating new Mikata instances in loops
  - Cache frequently used conversions

**Debug Tips**

java

_// Enable debug logging for date operations_

Mikata mikata = new Mikata();

System.out.println("Default Locale: " + mikata.date.getDefaultLocale());

System.out.println("Default Pattern: " + mikata.date.getDefaultPattern());

**🤝 Contributing**

We welcome contributions! Please see our [Contributing Guidelines](https://contributing.md/) for details.

- Fork the repository
- Create a feature branch
- Commit your changes
- Push to the branch
- Create a Pull Request

**📄 License**

This project is licensed under the Apache License 2.0 - see the [LICENSE](https://license/) file for details.

**👥 Authors**

- **Mohamed Lamine JELLAD** - _Initial work_ - [Softbakers](https://softbakers.com/)

**🙏 Acknowledgments**

- Thanks to all contributors who have helped shape Mikata
- Inspired by the need for a comprehensive date/time utility in Java projects
- Built with ❤️ by the Softbakers team

**📞 Support**

For support, please:

- Check the [documentation](https://github.com/softbakers/mikata/docs)
- Search existing [issues](https://github.com/softbakers/mikata/issues)
- Create a new issue with detailed description

**🔗 Links**

- [GitHub Repository](https://github.com/softbakers/mikata)
- [Issue Tracker](https://github.com/softbakers/mikata/issues)
- [Maven Central](https://mvnrepository.com/artifact/org.softbakers.utils/mikata)
- [API Documentation](https://softbakers.github.io/mikata/)

⭐ **If you find Mikata useful, please give it a star on GitHub!** ⭐

Built with ❤️ by [Softbakers](https://softbakers.com/)
