package ru.hh.school.utils.exceptions;

public class IncorrectInitialDataFormat extends BaseApplicationException {

    public static final String MESSAGE_PREFIX = "Incorrect initial data format. ";

    public IncorrectInitialDataFormat(String appendix) {
        super(getMessage(appendix));
    }

    public IncorrectInitialDataFormat(String appendix, Throwable e) {
        super(getMessage(appendix), e);
    }

    private static String getMessage(String appendix) {
        return MESSAGE_PREFIX + appendix;
    }
}
