package org.example;

public class MyNode {
    private int value;
    private MyNode next;
    private MyNode prev;
    MyNode(MyNode prev, int value, MyNode next){
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

    public int getValue() {
        return value;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
