package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        MyLinkedList linkedList = null;
        int myType = -1;
        Scanner scanner = new Scanner(System.in);
        PrintStream printStream = new PrintStream(System.out, true, "UTF-8");
        try{
        while(true){
            printStream.println("Введите номер действия: \n" +
                    "1. Создать новый двусвязный список\n"+
                    "2. Добавить значение в конец списка\n"+
                    "3. Добавить значение в список по индексу\n"+
                    "4. Удалить значение из списка\n"+
                    "5. Заменить значение в списке\n"+
                    "6. Вывести длину списка\n"+
                    "7. Отсортировать список\n"+
                    "8. Вывести список\n"+
                    "9. Сериализовать список в файл\n"+
                    "10. Десериализовать список из файла\n"+
                    "11. Выйти\n");
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    printStream.println("Введите номер поддействия:\n"+
                            "1. Создать двусвязный список Int\n"+
                            "2. Создать двусвязный список Float\n"+
                            "3. Создать двусвязный список String\n"+
                            "4. Создать двусвязный список Point\n");
                    int podNum = scanner.nextInt();
                    switch (podNum){
                        case 1 :
                            linkedList = new MyLinkedList();
                            myType = 1;
                            break;
                        case 2 :
                            linkedList = new MyLinkedList();
                            myType = 2;
                            break;
                        case 3 :
                            linkedList = new MyLinkedList();
                            myType = 3;
                            break;
                        case 4:
                            linkedList = new MyLinkedList();
                            myType = 4;
                            break;
                        default : break;
                    }
                    break;
                case 2:
                    String str;
                    switch (myType){
                        case -1 :
                            printStream.println("Нельзя добавить значение, список не создан");
                            break;
                        case 1:
                            try{
                            printStream.println("Введите целочисленное значение:");
                            str = scanner.nextLine();
                            str = scanner.nextLine();
                            linkedList.add((MyInt)(new MyInt().parseValue(str)));
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 2:
                            printStream.println("Введите значение типа float:");
                            try{
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                linkedList.add((MyFloat)(new MyFloat().parseValue(str)));
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 3:
                            printStream.println("Введите строковое значение:");
                            try {
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                linkedList.add((MyString) (new MyString().parseValue(str)));
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 4:
                            double x=0,y=0;
                            try {
                                printStream.println("Введите координату точки X:");
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                x = Double.parseDouble(str);
                                printStream.println("Введите координату точки Y:");
                                str = scanner.nextLine();
                                y = Double.parseDouble(str);
                                linkedList.add(new Point(x,y));
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        default: break;
                    }
                    break;
                case 3:
                    switch (myType){
                        case -1 :
                            printStream.println("Нельзя добавить значение, список не создан");
                            break;
                        case 1:
                            try{
                                printStream.println("Введите целочисленное значение:");
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                int idx = scanner.nextInt();
                                linkedList.addNum((MyInt)(new MyInt().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 2:
                            printStream.println("Введите значение типа float:");
                            try{
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                int idx = scanner.nextInt();
                                linkedList.addNum((MyFloat)(new MyFloat().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 3:
                            printStream.println("Введите строковое значение:");
                            try {
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                int idx = scanner.nextInt();
                                linkedList.addNum((MyString) (new MyString().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 4:
                            double x=0,y=0;
                            try {
                                printStream.println("Введите координату точки X:");
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                x = Double.parseDouble(str);
                                printStream.println("Введите координату точки Y:");
                                str = scanner.nextLine();
                                y = Double.parseDouble(str);
                                printStream.println("Введите индекс:");
                                int idx = scanner.nextInt();
                                linkedList.addNum(new Point(x,y),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        default: break;
                    }
                    break;
                case 4:
                    printStream.println("Введите индекс значения, которое хотите удалить:");
                    int idx = scanner.nextInt();
                    if(linkedList!=null) {
                        linkedList.remove(idx);
                    }else{
                        printStream.println("Списка несуществует");
                    }
                    break;
                case 5:
                    switch (myType){
                        case -1 :
                            printStream.println("Нельзя изменить значение, список не создан");
                            break;
                        case 1:
                            try{
                                printStream.println("Введите целочисленное значение:");
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                idx = scanner.nextInt();
                                linkedList.set((MyInt)(new MyInt().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 2:
                            printStream.println("Введите значение типа float:");
                            try{
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                idx = scanner.nextInt();
                                linkedList.set((MyFloat)(new MyFloat().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 3:
                            printStream.println("Введите строковое значение:");
                            try {
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                printStream.println("Введите индекс:");
                                idx = scanner.nextInt();
                                linkedList.set((MyString) (new MyString().parseValue(str)),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 4:
                            double x=0,y=0;
                            try {
                                printStream.println("Введите координату точки X:");
                                str = scanner.nextLine();
                                str = scanner.nextLine();
                                x = Double.parseDouble(str);
                                printStream.println("Введите координату точки Y:");
                                str = scanner.nextLine();
                                y = Double.parseDouble(str);
                                printStream.println("Введите индекс:");
                                idx = scanner.nextInt();
                                linkedList.set(new Point(x,y),idx);
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        default: break;
                    }
                    break;
                case 6:
                    if(linkedList!=null){
                        printStream.println("Длина списка: "+linkedList.size());
                    }else{
                        printStream.println("Списка несуществует");
                    }
                    break;
                case 7:
                    switch (myType){
                        case -1 :
                            printStream.println("Нельзя сортировать значения, список не создан");
                            break;
                        case 1:
                            try{
                                printStream.println("Список до сортировки: ");
                                linkedList.print();
                                printStream.println("Список после сортировки: ");
                                linkedList.quickSort(linkedList,0, linkedList.size(),
                                        (new MyInt().getTypeComparator()));
                                linkedList.print();
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 2:
                            try{
                                printStream.println("Список до сортировки: ");
                                linkedList.print();
                                printStream.println("Список после сортировки: ");
                                linkedList.quickSort(linkedList,0, linkedList.size(),
                                        (new MyFloat().getTypeComparator()));
                                linkedList.print();
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 3:
                            try {
                                printStream.println("Список до сортировки: ");
                                linkedList.print();
                                printStream.println("Список после сортировки: ");
                                linkedList.quickSort(linkedList,0, linkedList.size(),
                                        (new MyString().getTypeComparator()));
                                linkedList.print();
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        case 4:
                            try {
                                printStream.println("Список до сортировки: ");
                                linkedList.print();
                                printStream.println("Список после сортировки: ");
                                linkedList.quickSort(linkedList,0, linkedList.size(),
                                        (new Point().getTypeComparator()));
                                linkedList.print();
                            }catch (NumberFormatException nfe){
                                printStream.println("Неправильно введённый тип данных");
                            }
                            break;
                        default: break;
                    }
                    break;
                case 8:
                    if(linkedList!=null){
                        linkedList.print();
                    }else{
                        printStream.println("Списка несуществует");
                    }
                    break;
                case 9:
                    try {
                        printStream.println("Список сохраняется: ");
                        if(linkedList!=null){
                            linkedList.print();
                        }else{
                            printStream.println("Списка несуществует");
                        }
                        MyLinkedList.serializeToBinary(linkedList);
                    }catch (IOException ioe){
                        printStream.println("Неудалось сериализовать список");
                    }
                    break;
                case 10:
                    try{
                    linkedList = MyLinkedList.deserializeFromBinary();
                    printStream.println("Загрузка из сохранения: ");
                        if(linkedList!=null){
                            linkedList.print();
                        }else{
                            printStream.println("Списка несуществует");
                        }
                    }catch (ClassNotFoundException cnfe){
                        printStream.println("Не удалось найти класс");
                    }
                    if(linkedList!=null&&linkedList.size()!=0){
                        MyNode myNode = linkedList.getFirst();
                        Class cl = myNode.getValue().getClass();
                        if(cl.equals(new MyInt().getClass())){
                            myType = 1;
                        }
                        if(cl.equals(new MyFloat().getClass())){
                            myType = 2;
                        }
                        if(cl.equals(new MyString().getClass())){
                            myType = 3;
                        }
                        if(cl.equals(new Point().getClass())){
                            myType = 4;
                        }
                    }
                    break;
                case 11: return;
                default : break;
            }
        }
        }catch (InputMismatchException ime){
            printStream.println("Неправильно введённый тип данных");
        }
    }
}