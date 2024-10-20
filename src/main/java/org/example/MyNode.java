package org.example;

import java.io.Serializable;

public class MyNode implements Serializable {
    private UserType value;
    private MyNode next;
    private MyNode prev;
    MyNode(MyNode prev, UserType value, MyNode next){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public MyNode getNext() {
        return next;
    }

    public MyNode getPrev() {
        return prev;
    }

    public UserType getValue() {
        return value;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public void setValue(UserType value) {
        this.value = value;
    }

    public Object printValue() {
        return value.getValue();
    }
}
