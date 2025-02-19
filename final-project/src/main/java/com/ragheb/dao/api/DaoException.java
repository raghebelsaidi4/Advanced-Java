package com.ragheb.dao.api;

/**
 * Custom exception class for handling DAO-related errors.
 * This exception is meant to wrap lower-level database exceptions
 * and provide meaningful error messages for debugging.
 */
public class DaoException extends Exception {

    private static final long serialVersionUID = -481271377780096016L;

    /**
     * Default constructor for DaoException.
     */
    public DaoException() {
        super();
    }

    /**
     * Constructs a DaoException with a specific error message.
     *
     * @param message the detail message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructs a DaoException with a cause.
     *
     * @param cause the cause of the exception
     */
    public DaoException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a DaoException with a message and a cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
