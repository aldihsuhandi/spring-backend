package com.project.spring.common.model.enumeration;

import lombok.Getter;

@Getter
public enum ProcessTypeEnum {
    USER_CREATE("USER_CREATE", "7100001", "userCreateProcessor", "userCreateValidator"),

    USER_QUERY("USER_QUERY", "7100002", "userQueryProcessor", "userQueryValidator"),

    USER_UPDATE("USER_UPDATE", "7100003", "userUpdateProcessor", "userUpdateValidator"),

    USER_DELETE("USER_DELETE", "7100004", "userDeleteProcessor", "userDeleteValidator"),

    USER_LOGIN("USER_LOGIN", "7100005", "sessionLoginProcessor", "sessionLoginValidator"),

    USER_LOGOUT("USER_LOGOUT", "7100006", "sessionLogoutProcessor", "sessionLogoutValidator"),

    SESSION_REFRESH("SESSION_REFRESH", "7100007", "sessionRefreshProcessor", "sessionRefreshValidator"),

    SESSION_QUERY("SESSION_QUERY", "7100008", "sessionQueryProcessor", "sessionQueryValidator"),

    ADD_FRIEND("ADD_FRIEND", "7100009", "addFriendProcessor", "addFriendValidator"),

    ACCEPT_FRIEND("ACCEPT_FRIEND", "7100010", "acceptFriendProcessor", "acceptFriendValidator"),

    REJECT_FRIEND("REJECT_FRIEND", "7100011", "rejectFriendProcessor", "rejectFriendValidator"),

    QUERY_FRIEND_REQUEST("QUERY_FRIEND_REQUEST", "7100012", "queryFriendRequestProcessor", "queryFriendRequestValidator"),

    QUERY_FRIEND("QUERY_FRIEND", "7100013", "queryFriendProcessor", "queryFriendValidator");

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
