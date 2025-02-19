package com.ragheb.util.contanst;

public class UserConstant {

    //////////////
    // DB Query //
    //////////////
    public static final String DELETE_USER_BY_ID = "DELETE FROM users_table WHERE user_id = ?::BIGINT";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users_table WHERE user_id = ?::BIGINT";
    public static final String SELECT_ALL_USERS = "SELECT * FROM users_table";
    public static final String INSERT_USER = "INSERT INTO users_table (user_name, user_email, user_password, user_address, user_blocked, user_role)"
            + " VALUES(?, ?, ?, ?, ?::BOOL, ?)";
    public static final String UPDATE_USER = "UPDATE users_table SET user_name = ?, user_email = ?, user_password = ?, user_address = ?, user_blocked = ?::BOOL, user_role = ? WHERE user_id = ?::BIGINT";
    public static final String SELECT_USER_BY_USER_NAME_PASSWORD = "SELECT * FROM users_table WHERE user_name = ? AND user_password = ?";

    ///////////////
    // DB Column //
    ///////////////
    public static final String TABLE_USER_ID = "user_id";
    public static final String TABLE_USER_NAME = "user_name";
    public static final String TABLE_USER_PASSWORD = "user_password";
    public static final String TABLE_USER_EMAIL = "user_email";
    public static final String TABLE_USER_ADDRESS = "user_address";
    public static final String TABLE_USER_BLOCK_STATUS = "user_blocked";
    public static final String TABLE_USER_ROLE = "user_role";

    ///////////////
    ///// VIEW ////
    ///////////////
    public final static String USER_ATTRIBUTE = "user";
    public static final String USER_LOGIN = "userName";
    public static final String USER_PASSWORD = "password";

    public final static String BLOCK_MESSAGE = "blocked";
    public final static String INVALID_LOGIN = "invalidLogin";

    private UserConstant() {}
}
