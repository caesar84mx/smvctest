package main.java.com.caesar_84.smvctest.ducktapes;

import java.util.Objects;

/**
 * Created by caesar-84 on 2/11/17.
 */
public class StringWrapper
{
    private String value;

    public StringWrapper() {}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringWrapper)) return false;
        StringWrapper that = (StringWrapper) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
