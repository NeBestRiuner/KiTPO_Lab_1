import org.example.*;
import org.junit.jupiter.api.Test;


public class MyTest {
    @Test
    public void testCreateIntList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.

            myLinkedList.add((MyInt)new MyInt().create());
        }
        myLinkedList.print();
        System.out.println("");
    }
    @Test
    public void testIntTypeName(){
        System.out.println(new MyInt(3).typeName());
    }
    @Test
    public void testIntParseValue(){
        String ss = "1107";
        MyInt myInt = new MyInt();
        MyInt send = (MyInt)myInt.parseValue(ss);
        System.out.println(send.getValue());
    }
    @Test
    public void testCreateFloatList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add((MyFloat)new MyFloat().create());
        }
        myLinkedList.print();
        System.out.println("");
    }
    @Test
    public void testFloatTypeName(){
        System.out.println(new MyFloat((float)3.3).typeName());
    }
    @Test
    public void testFloatParseValue(){
        String ss = "1107.06";
        MyFloat myFloat = new MyFloat();
        MyFloat send = (MyFloat)myFloat.parseValue(ss);
        System.out.println(send.getValue());
    }
    @Test
    public void testCreateStringList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add((MyString)new MyString().create());
        }
        myLinkedList.print();
        System.out.println("");
    }
    @Test
    public void testStringTypeName(){
        System.out.println(new MyString("String").typeName());
    }
    @Test
    public void testStringParseValue(){
        String ss = "String Node";
        MyString myString = new MyString();
        MyString send = (MyString)myString.parseValue(ss);
        System.out.println(send.getValue());
    }
    @Test
    public void testGetValue(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add(new MyInt(i));
        }
        System.out.println("Третье значение в списке: "+myLinkedList.get(2).getValue().getValue());
    }
    @Test
    public void testRemoveValue(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add(new MyInt(i));
        }
        myLinkedList.remove(0);
        myLinkedList.print();
        System.out.println("Первое значение: "+myLinkedList.getFirst().getValue().getValue());
        System.out.println("Последнее значение: "+myLinkedList.getLast().getValue().getValue());
        System.out.println("Размер "+myLinkedList.size());
    }
    @Test
    public void testAddNumValue(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add(new MyInt(i));
        }
        myLinkedList.addNum(new MyInt(99),4);
        myLinkedList.print();
        System.out.println("Первое значение: "+myLinkedList.getFirst().getValue().getValue());
        System.out.println("Последнее значение: "+myLinkedList.getLast().getValue().getValue());
        System.out.println("Размер "+myLinkedList.size());
    }
    @Test
    public void testCreatePointList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        for (int i = 1; i <= 5; i++) {
            myLinkedList.add((Point)new Point().create());
        }
        myLinkedList.print();
        System.out.println("");
    }
    @Test
    public void testStringPointName(){
        System.out.println(new Point(33,1).typeName());
    }
    @Test
    public void testStringPointValue(){
        String ss = "33 2";
        Point point = new Point();
        Point send = (Point)point.parseValue(ss);
        System.out.println(send.getValue());
    }
}
