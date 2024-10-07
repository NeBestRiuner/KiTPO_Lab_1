package org.example;

import java.io.InputStreamReader;
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
        value = Double.toString(rnd.nextDouble())+" string";
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
    public Comparator getTypeComparator() {
        return null;
    }
    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
