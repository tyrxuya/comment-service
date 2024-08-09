package com.tinqinacademy.comments.api;

public final class CommentsFeignClientApiPaths {
    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String PATCH = "PATCH";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";

    private static final String SPACE_SYMBOL = " ";

    public static final String GET_COMMENTS = GET + SPACE_SYMBOL + CommentsRestApiPaths.GET_COMMENT;
    public static final String CREATE_COMMENT = POST + SPACE_SYMBOL + CommentsRestApiPaths.CREATE_COMMENT;
    public static final String USER_EDIT_COMMENT = PATCH + SPACE_SYMBOL + CommentsRestApiPaths.USER_EDIT_COMMENT;
    public static final String ADMIN_EDIT_COMMENT = PUT + SPACE_SYMBOL + CommentsRestApiPaths.ADMIN_EDIT_COMMENT;
    public static final String DELETE_COMMENT = DELETE + SPACE_SYMBOL + CommentsRestApiPaths.DELETE_COMMENT;
}
