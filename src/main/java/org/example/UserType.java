package org.example;

import java.io.InputStreamReader;
import java.io.Serializable;

public interface UserType extends Serializable {
    public String typeName();
    public Object create();
    public Object clone();
    public Object readValue(InputStreamReader in);
    public Object parseValue(String ss);
    public Comparator getTypeComparator();
    public Object getValue();
}
