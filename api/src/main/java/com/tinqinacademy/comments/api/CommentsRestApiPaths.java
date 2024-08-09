package com.tinqinacademy.comments.api;

public final class CommentsRestApiPaths {
    public static final String BASIC = "/api/v1";
    public static final String HOTEL = BASIC + "/hotel";
    public static final String SYSTEM = BASIC + "/system";

    public static final String COMMENT = "/comment";
    public static final String COMMENT_ID = "/{commentId}";

    public static final String HOTEL_ROOMID = HOTEL + "/{roomId}";
    public static final String HOTEL_COMMENT = HOTEL + COMMENT;

    public static final String SYSTEM_COMMENT = SYSTEM + COMMENT;

    public static final String GET_COMMENT = HOTEL_ROOMID + COMMENT;
    public static final String CREATE_COMMENT = HOTEL_ROOMID + COMMENT;
    public static final String USER_EDIT_COMMENT = HOTEL_COMMENT + COMMENT_ID;
    public final static String ADMIN_EDIT_COMMENT = SYSTEM_COMMENT + COMMENT_ID;
    public final static String DELETE_COMMENT = SYSTEM_COMMENT + COMMENT_ID;
}
