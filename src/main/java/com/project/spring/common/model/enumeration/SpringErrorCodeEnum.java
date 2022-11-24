package com.project.spring.common.model.enumeration;

import lombok.Getter;

@Getter
public enum SpringErrorCodeEnum {
    SYSTEM_BUSY("SYSTEM_BUSY", "System is busy, please try again latter", "16000001"),
    INSERT_FAILED("INSERT_FAILED", "Failed to insert data to database", "16000002"),
    PARAM_ILLEGAL("PARAM_ILLEGAL", "param illegal", "16000003"),
    USER_NOT_FOUND("USER_NOT_FOUND", "user not found", "16000004"),
    UPDATE_FAILED("UPDATE_FAILED", "failed when updating user", "16000005"),
    SESSION_NOT_FOUND("SESSION_NOT_FOUND", "sesion not found", "16000006");

    private final String errorCode;
    private final String errorMsg;
    private final String scenario;

    SpringErrorCodeEnum(String errorCode, String errorMsg, String scenario) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.scenario = scenario;
    }
}
