package org.example;

import java.io.InputStreamReader;

public class MyFloat implements UserType{
    @Override
    public String typeName() {
        return "";
    }

    @Override
    public Object create() {
        return null;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public Object readValue(InputStreamReader in) {
        return null;
    }

    @Override
    public Object parseValue(String ss) {
        return null;
    }

    @Override
    public Comparator getTypeComparator() {
        return null;
    }
}
