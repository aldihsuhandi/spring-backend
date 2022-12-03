package com.project.spring.common.constant;

import java.io.Serializable;

public class DatabaseConst implements Serializable {

    private static final long serialVersionUID = -3332001555392065725L;

    public static String STATEMENT_UPDATE = "update";
    public static String STATEMENT_DELETE = "delete";
    public static String STATEMENT_INSERT = "insert";
    public static String STATEMENT_SELECT = "select";
    public static String DATABASE_SELECT_ALL = "*";
    public static String COMPARATOR_EQUAL = "=";
    public static String COMPARATOR_GREATER = ">";
    public static String COMPARATOR_LESSER = "<";
    public static String COMPARATOR_GREATER_THAN = ">=";
    public static String COMPARATOR_LESSER_THAN = "<=";
    public static String APPEND_OPERATOR_AND = "and";
    public static String APPEND_OPERATOR_OR = "or";

    public static final String TABLE_USER = "users";
    public static final String TABLE_SESSION = "sessions";
    public static final String TABLE_FRIEND_REQUEST = "friend_requests";

    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";
    public static final String PROFILE_PICTURE = "profile_picture";
    public static final String STATUS = "status";
    public static final String BANNER = "banner";
    public static final String PASSWORD = "password";
    public static final String IS_ACTIVE = "is_active";
    public static final String IS_REMEMBERED = "is_remembered";
    public static final String GMT_CREATE = "gmt_create";
    public static final String GMT_MODIFIED = "gmt_modified";
    public static final String SESSION_ID = "session_id";
    public static final String SESSION_DT = "session_dt";
    public static final String REQUESTER_ID = "requester_id";
    public static final String RECEIVER_ID = "receiver_id";
    public static final String IS_ACCEPTED = "is_accepted";
    public static final String IS_DELETED = "is_deleted";
}
