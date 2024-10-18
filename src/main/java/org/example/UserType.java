package org.example;

import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Comparator;
public interface UserType extends Serializable {
    public String typeName();
    public Object create();
    public Object clone();
    public Object readValue(InputStreamReader in);
    public Object parseValue(String ss);
    public Object getValue();
    public Comparator<Object> getTypeComparator();
}
