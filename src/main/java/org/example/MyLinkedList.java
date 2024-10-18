package org.example;

import java.io.*;
import java.util.Comparator;

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
    public void set(UserType value, int index){
        MyNode cur = this.get(index);
        cur.setValue(value);
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
    public void quickSort(MyLinkedList linkedList, int low, int high, Comparator comparator){
        if (linkedList.size() == 0 || low >= high) return;

        //выбираем опорный элемент  - средний
        int middle = low + (high - low) / 2;
        UserType border = linkedList.get(middle).getValue();
        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            MyNode valueI = linkedList.get(i);
            while (comparator.compare(valueI.getValue(), border)<0){
                i++;
                valueI = valueI.getNext();
            }
            MyNode valueJ = linkedList.get(j);
            while (comparator.compare(valueJ.getValue(), border)>0){
                j--;
                valueJ = valueJ.getPrev();
            }
            if (i <= j) { // улучшение, вместо get valueI и valueJ
                /*
                UserType swap = linkedList.get(i).getValue();
                linkedList.set(linkedList.get(j).getValue(),i);
                linkedList.set(swap,j);*/
                UserType swap = valueI.getValue();
                valueI.setValue(valueJ.getValue());
                valueJ.setValue(swap);
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(linkedList, low, j, comparator);
        if (high > i) quickSort(linkedList, i, high, comparator);
    }
    public void forEach(ForEach forEach){
        MyNode cur = first;
        while(cur!=null){
            forEach.toDo(cur.getValue());
            cur = cur.getNext();
        }
    }
    public static void serializeToBinary(MyLinkedList myLinkedList)throws IOException {
        File file = new File("file.out");
        FileOutputStream fos = new FileOutputStream("file.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(myLinkedList);
        oos.flush();
        oos.close();
    }

    public static MyLinkedList deserializeFromBinary() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("file.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (MyLinkedList) oin.readObject();
    }
}
