// Разработать программу, имитирующую поведение коллекции HashSet. 
// В программе содать метод add добавляющий элемент, 
// метод toString возвращающий строку с элементами множества и 
// метод позволяющий читать элементы по индексу.
// *Реализовать все методы из семинара.
// Формат данных Integer.

import java.util.HashMap;
import java.util.Iterator;

public class task6 {
    public static void main(String[] args) {

        SetSimulator unrealSet = new SetSimulator();
        System.out.println(unrealSet.addElem(20));
        System.out.println(unrealSet.addElem(10));
        System.out.println(unrealSet.addElem(30));
        System.out.println(unrealSet.addElem(30));

        System.out.println(unrealSet.setToString());
        unrealSet.readElem(2);
        System.out.println(unrealSet.delElem(30));
        System.out.println(unrealSet.isEmpty());
        System.out.println(unrealSet.containsElem(20));
        System.out.println(unrealSet.getElem(1));
        System.out.println();

        Iterator<Integer> iterator = unrealSet.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            System.out.println(i);
        }
    }

}

class SetSimulator {

    private HashMap<Integer, Object> newSet = new HashMap<>();
    private static final Object NEWOBJECT = new Object();

    // Метод, добавляющий элемент в множество
    public boolean addElem (int elem){
        return newSet.put(elem, NEWOBJECT)==null;
    }

    // Метод, возвращающий строку с элементами множества
    public StringBuilder setToString (){
        StringBuilder str = new StringBuilder();
        Iterator<Integer> iter = newSet.keySet().iterator();
        while (iter.hasNext()){
            str.append(iter.next());
            if (iter.hasNext()) str.append(", ");
        }
        return str;
    }

    // Метод, позволяющий читать элементы по индексу
    public void readElem (int index){
        Object[] arr = newSet.keySet().toArray();
        System.out.println("The element at index " + index + " is " + arr[index].toString());
    }

    // Реализовать все методы из семинара

    public boolean delElem(int elem){ // метод, который удаляет заданный элемент
        return newSet.remove(elem)==NEWOBJECT;
    }

    public boolean isEmpty (){ // метод, который вернет true, если сет пустой, и false, если есть элементы
        return newSet.isEmpty();
    }

    public boolean containsElem (int elem){ // метод для проверки наличия элемента 
        return newSet.containsKey(elem);
    }

    public int getElem (int index){ // метод, чтобы вернуть значение по индексу
        Object[] arr = newSet.keySet().toArray();
        return (int) arr[index];
    }

    public Iterator<Integer> iterator(){ // метод для создания итератора
        return newSet.keySet().iterator();
    }

}