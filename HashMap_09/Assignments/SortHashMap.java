package HashMap_09.Assignments;

import java.util.Map.Entry;
import java.util.*;

/*
 * A Sales company is conducting its month end reviews. The Sales department head decides to meet the employees based on the order of their sales. The person with maximum number of sales will have the meeting first followed by the person having second highest sales and so on. Implement the logic in sortSales() method to sort a HashMap containing the names of the employees and their corresponding sales and return a List<String> containing the names of the employees based on the decreasing order of their sales.
 */

public class SortHashMap {

    public static List<String> sortSales(Map<String, Integer> sales) {
        // Convert the HashMap entries to a list of Map.Entry
        List<Entry<String, Integer>> entryList = new ArrayList<>(sales.entrySet());

        // Perform a simple bubble sort on the entryList based on the values (sales) in
        // descending order
        int n = entryList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (entryList.get(j).getValue() < entryList.get(j + 1).getValue()) {
                    // Swap entries
                    Entry<String, Integer> temp = entryList.get(j);
                    entryList.set(j, entryList.get(j + 1));
                    entryList.set(j + 1, temp);
                }
            }
        }

        // Prepare a list to hold the sorted employee names
        List<String> sortedEmployees = new ArrayList<>();

        // Extract the employee names from the sorted entries
        for (Entry<String, Integer> entry : entryList) {
            sortedEmployees.add(entry.getKey());
        }

        return sortedEmployees;
    }

    public static void main(String args[]) {
        Map<String, Integer> sales = new HashMap<String, Integer>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);

        List<String> employees = sortSales(sales);

        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }
}
