package org.example;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Random;

public class MyString implements UserType{
    String value;
    public MyString(){
    }
    public MyString(String value){
        this.value = value;
    }
    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }

    @Override
    public Object create() {
        Random rnd = new Random();
        value = Integer.toString(rnd.nextInt(20))+Integer.toString(rnd.nextInt(20))+" string";
        return new MyString(value);
    }

    @Override
    public Object clone() {
        MyString myClone = new MyString();
        myClone.setValue(this.value);
        return myClone;
    }

    @Override
    public Object readValue(InputStreamReader in) {
        return null;
    }

    @Override
    public Object parseValue(String ss) {
        return new MyString(ss);
    }

    @Override
    public Comparator<Object> getTypeComparator() {
        return new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((MyString)o1).value.length()-((MyString)o2).value.length();
            }
        };
    }
    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
