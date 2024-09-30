package org.example;

import java.io.InputStreamReader;

public interface UserType {
    public String typeName();
    public Object create();
    public Object clone();
    public Object readValue(InputStreamReader in);
    public Object parseValue(String ss);
    public Comparator getTypeComparator();
}
