package org.example;

import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Random;

public class Point implements UserType{
    double x;
    double y;
    public Point(){
    }
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String typeName() {
        return String.valueOf(this.getClass());
    }

    @Override
    public Object create() {
        Random rnd = new Random();
        x = rnd.nextDouble();
        y = rnd.nextDouble();
        return new Point(x,y);
    }

    @Override
    public Object clone() {
        Point myClone = new Point();
        myClone.setX(this.x);
        myClone.setY(this.y);
        return myClone;
    }

    @Override
    public Object readValue(InputStreamReader in) {
        return null;
    }

    @Override
    public Object parseValue(String ss) {
        String[] words = ss.split(" ");
        double x = Double.parseDouble(words[0]);
        double y = Double.parseDouble(words[1]);
        return new Point(x,y);
    }

    @Override
    public Comparator<Object> getTypeComparator() {
        return new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                var diff = Math.sqrt(Math.pow(((Point)o2).x,2)
                        +Math.pow(((Point)o2).y,2))-Math.sqrt(Math.pow(((Point)o1).x,2)
                        +Math.pow(((Point)o1).y,2));
                if(diff>0){
                    if(diff<1){
                        return 1;
                    }
                    return (int)Math.round(diff);
                }else{
                    if(diff==0){
                        return 0;
                    }else{
                        if(diff>-1){
                            return -1;
                        }
                    }
                    return (int)Math.round(diff);

                }
            }
        };
    }

    @Override
    public Object getValue() {
        return x+" "+y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
