package com.project.spring.common.model.enumeration;

import lombok.Getter;

@Getter
public enum ProcessTypeEnum {
    USER_CREATE("USER_CREATE", "7100001", "userCreateProcessor", "userCreateValidator"),

    USER_QUERY("USER_QUERY", "7100002", "userQueryProcessor", "userQueryValidator"),

    USER_UPDATE("USER_UPDATE", "7100002", "userUpdateProcessor", "userUpdateValidator");

    private final String processName;
    private final String processId;
    private final String processorName;
    private final String validatorName;

    ProcessTypeEnum(String processName, String processId, String processorName, String validatorName) {
        this.processName = processName;
        this.processId = processId;
        this.processorName = processorName;
        this.validatorName = validatorName;
    }
}
