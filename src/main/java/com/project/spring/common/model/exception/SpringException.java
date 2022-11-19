package com.project.spring.common.model.exception;

import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpringException extends Exception {
    private SpringErrorCodeEnum errorCode;

    public SpringException(String message, SpringErrorCodeEnum errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
