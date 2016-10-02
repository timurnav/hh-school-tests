package ru.hh.school.utils.exceptions;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class BaseApplicationException extends RuntimeException {

    public BaseApplicationException() {
    }

    public BaseApplicationException(String message) {
        super(message);
    }

    public BaseApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseApplicationException(Throwable cause) {
        super(cause);
    }
}
