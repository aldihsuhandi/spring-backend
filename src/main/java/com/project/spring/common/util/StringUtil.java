package com.project.spring.common.util;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String defaultIfEmpty(String s, String def) {
        if (isEmpty(s)) {
            return def;
        }

        return s;
    }

    public static String defaultIfEmpty(String s) {
        return defaultIfEmpty(s, "");
    }
}
