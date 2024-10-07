package org.example;

import java.io.InputStreamReader;
import java.util.Random;

public class MyFloat implements UserType{
    float value;
    public MyFloat(){
    }
    public MyFloat(float value){
        this.value = value;
    }
    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }
    @Override
    public Object create() {
        Random rnd = new Random();
        value = rnd.nextFloat();
        return new MyFloat(value);
    }
    @Override
    public Object clone() {
        MyFloat myClone = new MyFloat();
        myClone.setValue(this.value);
        return myClone;
    }
    @Override
    public Object readValue(InputStreamReader in) {
        return null;
    }
    @Override
    public Object parseValue(String ss) {
        return new MyFloat(Float.parseFloat(ss));
    }
    @Override
    public Comparator getTypeComparator() {
        return null;
    }
    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
