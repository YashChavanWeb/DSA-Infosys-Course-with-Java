package Linked_List_06;

import java.util.*;

/*
 * 
Given a linked list that stores integer values, remove the duplicate values and return a list containing unique values. Implement the logic inside removeDuplicates() method.

Test the functionalities using the main() method of the Tester class
 */

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {

        Set<Integer> duplicate = new HashSet<>();
        List<Integer> temp = new ArrayList<>();

        for (Integer element : list) {

            if (duplicate.add(element)) {
                temp.add(element);
            }

        }

        return temp;
    }

    public static void main(String args[]) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);

        List<Integer> updatedList = removeDuplicates(list);

        System.out.println("Linked list without duplicates");
        for (Integer value : updatedList) {
            System.out.print(value + " ");
        }
    }
}