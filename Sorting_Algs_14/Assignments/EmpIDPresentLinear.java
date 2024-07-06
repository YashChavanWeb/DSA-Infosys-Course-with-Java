package Sorting_Algs_14.Assignments;

/*
 * Given a list of Employee Ids, check whether an Employee Id is present or not using Linear Search algorithm. If the Employee Id is found, return the number of iterations used for searching the Employee Id, else return -1. Implement the logic in searchEmployeeId() method.
 */

public class EmpIDPresentLinear {

    public static int searchEmployeeId(int[] employeeIds, int employeeIdToBeSearched) {
        for (int i = 0; i < employeeIds.length; i++) {
            if (employeeIds[i] == employeeIdToBeSearched) {
                return i + 1; // Return number of iterations (1-based index)
            }
        }
        return -1; // Employee Id not found
    }

    public static void main(String a[]) {
        int[] employeeIds = { 8011, 8012, 8015, 8016, 8020, 8022, 8025 };
        int employeeIdToBeSearched = 8022;

        int numberOfIterations = searchEmployeeId(employeeIds, employeeIdToBeSearched);

        if (numberOfIterations == -1)
            System.out.println("Employee Id " + employeeIdToBeSearched + " is not found!");
        else
            System.out.println("Employee Id " + employeeIdToBeSearched + " is found! Number of iterations : "
                    + numberOfIterations);
    }
}