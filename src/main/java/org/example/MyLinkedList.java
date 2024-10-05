package org.example;

public class MyLinkedList {
    private MyNode first;
    private MyNode last;
    private int size;
    public MyLinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    public void add(UserType value){
        MyNode newNode = new MyNode(null, value, null);
        if(size==0){
            last = newNode;
            first = newNode;
        }else{
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }
    public void print(){
        MyNode prev = first;
        for (int i = 0; i<size; i++) {
            System.out.print(prev.getValue());
            prev = prev.getNext();
        }
    }
}
