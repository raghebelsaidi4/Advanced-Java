package com.ragheb.service.api;

/**
 * Custom exception class for handling service-layer errors.
 * This exception is used to encapsulate business logic failures
 * and service-related exceptions.
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 2119893329437972051L;

    /**
     * Default constructor for ServiceException.
     */
    public ServiceException() {
        super();
    }

    /**
     * Constructs a ServiceException with a specific error message.
     *
     * @param message the detail message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * Constructs a ServiceException with a cause.
     *
     * @param cause the cause of the exception
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a ServiceException with a message and a cause.
     *
     * @param message the detail message
     * @param cause   the cause of the exception
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
