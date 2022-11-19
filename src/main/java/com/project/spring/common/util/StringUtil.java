package com.project.spring.common.util;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
