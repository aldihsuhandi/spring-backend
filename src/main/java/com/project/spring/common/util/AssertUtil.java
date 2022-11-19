package com.project.spring.common.util;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;

public class AssertUtil {
    public static void isExpected(int v1, int v2, String param) throws SpringException {
        if (v1 != v2) {
            throw new SpringException(String.format("%s value is not expected", param), SpringErrorCodeEnum.INSERT_FAILED);
        }
    }

    public static void isNotExpected(int v1, int v2, String param) throws SpringException {
        if (v1 == v2) {
            throw new SpringException(String.format("%s value is not expected", param), SpringErrorCodeEnum.INSERT_FAILED);
        }
    }

}
