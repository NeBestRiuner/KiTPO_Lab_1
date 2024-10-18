package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Comparator;

public class MyInt implements UserType {
    Integer value;

    public MyInt(){
    }
    public MyInt(int value){
        this.value = value;
    }
    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }

    @Override
    public Object create() {
        Random rnd = new Random();
        value = rnd.nextInt(100);
        return new MyInt(value);
    }

    @Override
    public Object clone() {
        MyInt myClone = new MyInt();
        myClone.setValue(this.value);
        return myClone;
    }

    @Override
    public Object readValue(InputStreamReader in) {
        return null;
    }

    @Override
    public Object parseValue(String ss) {
        return new MyInt(Integer.parseInt(ss));
    }

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    @Override
    public Comparator<Object>getTypeComparator(){
        return new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                //System.out.println( ((MyInt)o2).value.intValue());
                return (((MyInt)o1).value.intValue() - ((MyInt)o2).value.intValue());
            }
        };
    }
}
