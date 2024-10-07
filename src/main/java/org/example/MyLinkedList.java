package org.example;

import java.io.Serializable;

public class MyLinkedList implements Serializable {
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
    public MyNode get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Invalid index "+index);
        }
        MyNode cur;
        if(index<size/2){
            cur = first;
            for(int i = 0; i < index; i++){
                cur = cur.getNext();
            }
        }else{
            cur = last;
            for(int i = size-1; i > index; i--){
                cur = cur.getPrev();
            }
        }
        return cur;
    }
    public Object remove(int index){
        MyNode cur = this.get(index);
        if(cur.getPrev()!=null){
            cur.getPrev().setNext(cur.getNext());
        }else{
            this.first=cur.getNext();
        }
        if(cur.getNext()!=null){
            cur.getNext().setPrev(cur.getPrev());
        }else{
            this.last=cur.getPrev();
        }
        Object value = cur.getValue();
        cur.setValue(null);
        cur.setNext(null);
        cur.setPrev(null);
        size--;
        return value;
    }
    public void addNum(UserType value, int index){
        if(index==size){
            this.add(value);
        }else {
            MyNode myNode = new MyNode(null, value, null);
            MyNode cur = this.get(index);
            myNode.setNext(cur);
            if (cur.getPrev() != null) {
                cur.getPrev().setNext(myNode);
                myNode.setPrev(cur.getPrev());
            } else {
                first = myNode;
            }
            cur.setPrev(myNode);
            size++;
        }


    }
    public int size(){
        return size;
    }
    public MyNode getFirst(){
        return first;
    }

    public MyNode getLast() {
        return last;
    }

    public void print(){
        MyNode prev = first;
        for (int i = 0; i<size; i++) {
            System.out.print(" "+prev.printValue()+" ");
            prev = prev.getNext();
        }
    }
}
