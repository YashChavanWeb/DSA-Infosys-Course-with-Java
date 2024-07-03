package HashMap_08;

import java.util.*;
import java.util.Map.Entry;

/*
 * Given a HashMap of type<String, Double> that stores names and corresponding average marks of students in a class, find out who scored the maximum and minimum marks. Implement the logic inside findMaxMinScorers() method. The method should return a HashMap<String, Double> which contains the maximum marks and the student(s) who scored the marks followed by minimum marks and the students(s) who scored it.

Test the functionalities using the main() method of the Tester class.
 */

class Student {

    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {

        Map<String, Double> minMaxStudents = new HashMap<String, Double>();

        double maxStudent = Double.MIN_VALUE;
        double minStudent = Double.MAX_VALUE;   

        for (Entry<String, Double> minMax : studentMarks.entrySet()) {
            if (maxStudent < minMax.getValue()) {
                maxStudent = minMax.getValue();
            }

            if (minStudent > minMax.getValue()) {
                minStudent = minMax.getValue();
            }
        }

        for (Entry<String, Double> marks : studentMarks.entrySet()) {
            if (maxStudent == marks.getValue()) {
                minMaxStudents.put(marks.getKey(), marks.getValue());
            }
            if (minStudent == marks.getValue()) {
                minMaxStudents.put(marks.getKey(), marks.getValue());
            }
        }

        return minMaxStudents;
    }

}

public class MaxAndMinMarks {
    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<String, Double>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);

        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);

        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

    }
}
