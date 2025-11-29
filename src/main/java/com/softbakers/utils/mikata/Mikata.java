package com.softbakers.utils.mikata;

import com.softbakers.utils.mikata.helper.DateConverterUtil;
import com.softbakers.utils.mikata.helper.DateUtil;

import java.util.Locale;

/**
 * Mikata - Date conversion utility with localization and patterns support
 * @author Mohamed Lamine JELLAD
 * @version 1.0.0
 */
public class Mikata  {

    public DateUtil date;
    public DateConverterUtil converter;

    public Mikata() {
        // Utility class - prevent instantiation
        this.date = new DateUtil(Locale.getDefault(), "yyyy-MM-dd");
        this.converter = new DateConverterUtil(Locale.getDefault(), "yyyy-MM-dd");
    }
    public Mikata(Locale defaultLocale, String defaultPattern) {
        // Utility class - prevent instantiation
        this.date = new DateUtil(defaultLocale, defaultPattern);
        this.converter = new DateConverterUtil(defaultLocale, defaultPattern);
    }
}