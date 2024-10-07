package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MyInt implements UserType {
    int value;

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
        value = rnd.nextInt();
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
    public Comparator getTypeComparator() {
        return null;
    }
    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
