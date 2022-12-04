package com.project.spring.common.util;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;

import java.util.List;

public class AssertUtil {
    public static void isExpected(int v1, int v2, String param, SpringErrorCodeEnum errorCodeEnum) throws SpringException {
        if (v1 != v2) {
            throwException(String.format("%s value is not expected", param), errorCodeEnum);
        }
    }

    public static void isNotExpected(int v1, int v2, String param, SpringErrorCodeEnum errorCodeEnum) throws SpringException {
        if (v1 == v2) {
            throwException(String.format("%s value is not expected", param), errorCodeEnum);
        }
    }

    public static void isNotNull(Object o, String param, SpringErrorCodeEnum errorCode) throws SpringException {
        if (o == null) {
            throwException(String.format("%s value is null", param), errorCode);
        }
    }

    public static void isNotEmpty(Object o, String param, SpringErrorCodeEnum errorCode) throws SpringException {

        isNotNull(o, param, errorCode);

        if (o instanceof List && ((List<?>) o).isEmpty()) {
            throwException(String.format("%s value is empty", param), errorCode);
        } else if (o instanceof String && ((String) o).isEmpty()) {
            throwException(String.format("%s value is empty", param), errorCode);
        }
    }

    private static void throwException(String msg, SpringErrorCodeEnum errorCode) throws SpringException {
        throw new SpringException(msg, errorCode);
    }
}
