package com.project.spring.common.util;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;

public final class ParamChecker {
    public static void isNotBlank(String s, String param, SpringErrorCodeEnum errorCode) throws SpringException {
        if (s == null || s.isEmpty()) {
            throwError(String.format("%s cannot be blank", param), errorCode);
        }
    }

    public static void isNotNull(Object o, String param, SpringErrorCodeEnum errorCode) throws SpringException {
        if (o == null) {
            throwError(String.format("%s cannot be null", param), errorCode);
        }
    }

    public static void isExpected(String s, String regex, String param, SpringErrorCodeEnum errorCode) throws SpringException {
        if (!s.matches(regex)) {
            throwError(String.format("%s is not expected", param), errorCode);
        }
    }

    public static void isExpected(boolean b, String param, SpringErrorCodeEnum errorCode) throws SpringException {
        if (!b) {
            throwError(String.format("%s is not expected", param), errorCode);
        }
    }

    private static void throwError(String message, SpringErrorCodeEnum errorCode) throws SpringException {
        throw new SpringException(message, errorCode);
    }
}
