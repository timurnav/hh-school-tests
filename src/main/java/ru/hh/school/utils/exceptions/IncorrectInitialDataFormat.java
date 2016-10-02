package ru.hh.school.utils.exceptions;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class IncorrectInitialDataFormat extends BaseApplicationException {

    public static final String MESSAGE_PREFIX = "Incorrect initial data format. ";

    public IncorrectInitialDataFormat(String appendix) {
        super(getMessage(appendix));
    }

    public IncorrectInitialDataFormat(String appendix, NumberFormatException e) {
        super(getMessage(appendix), e);
    }

    private static String getMessage(String appendix) {
        return MESSAGE_PREFIX + appendix;
    }
}
