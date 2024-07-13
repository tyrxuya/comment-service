package com.tinqinacademy.comments.rest;

public final class Endpoint {
    public static final String GET_COMMENT = "hotel/{roomId}/comment";
    public static final String CREATE_COMMENT = "hotel/{roomId}/comment";
    public static final String USER_EDIT_COMMENT = "hotel/comment/{commentId}";
    public final static String ADMIN_EDIT_COMMENT = "system/comment/{commentId}";
    public final static String DELETE_COMMENT = "system/comment/{commentId}";
}
