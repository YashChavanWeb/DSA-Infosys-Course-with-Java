package LinkedList_07.Exercises;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class ConcatenateAndReverse {
    public static List<Object> concatenateLists(List<Object> listOne, List<Object> listTwo) {
        List<Object> concatenatedList = new LinkedList<>();

        // Add elements from listOne to concatenatedList
        concatenatedList.addAll(listOne);

        // Add elements from listTwo in reverse order to concatenatedList
        ListIterator<Object> listIterator = listTwo.listIterator(listTwo.size());
        while (listIterator.hasPrevious()) {
            concatenatedList.add(listIterator.previous());
        }

        return concatenatedList;
    }

    public static void main(String args[]) {
        List<Object> listOne = new LinkedList<>();
        listOne.add("Hello");
        listOne.add(102);
        listOne.add(25);
        listOne.add(38.5);

        List<Object> listTwo = new LinkedList<>();
        listTwo.add(150);
        listTwo.add(200);
        listTwo.add('A');
        listTwo.add("Welcome");

        List<Object> concatenatedList = concatenateLists(listOne, listTwo);

        System.out.println("Concatenated linked list:");
        for (Object value : concatenatedList) {
            System.out.print(value + " -> ");
        }
    }
}
