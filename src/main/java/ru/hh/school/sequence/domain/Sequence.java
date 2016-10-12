package ru.hh.school.sequence.domain;

public class Sequence {

    private final String value;
    private final int length;

    public Sequence(String value) {
        this.value = value;
        this.length = value.length();
    }

    public String getValue() {
        return value;
    }

    public int getLength() {
        return length;
    }

    public String getValuePart(int index) {
        return value.substring(index);
    }

    public String getValuePart(int index, int length) {
        return value.substring(index, index + length);
    }

    public boolean isValuePartAvailable(int index, int length) {
        return value.length() >= index + length;
    }

    @Override
    public String toString() {
        return value;
    }
}
