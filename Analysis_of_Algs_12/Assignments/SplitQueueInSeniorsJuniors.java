package Analysis_of_Algs_12.Assignments;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.*;

/*
 * Implement a program to split a given queue of patients based on their age and return a list of queues with the split queues. The first element of the list should contain a queue with all the patients having age greater than or equal to 60. The second element of the list should contain a queue with all the remaining patients. Implement the logic inside splitQueue() method.

The Patient class has been implemented and provided to you.

Test the functionalities using the main() method of the Tester class.
 */

class Patient {

    private String name;
    private String gender;
    private int age;

    public Patient(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Gender: " + this.gender + ", Age: " + this.age;
    }
}

public class SplitQueueInSeniorsJuniors {
    public static List<Deque<Patient>> splitQueue(Deque<Patient> patientsQueue) {

        List<Deque<Patient>> result = new ArrayList<Deque<Patient>>();
        Deque<Patient> seniors = new ArrayDeque<Patient>();
        Deque<Patient> juniors = new ArrayDeque<Patient>();

        for (Patient p : patientsQueue) {
            if (p.getAge() > 60) {
                seniors.add(p);
            } else {
                juniors.add(p);
            }
        }

        result.add(seniors);
        result.add(juniors);

        return result;
    }

    public static void main(String[] args) {

        Patient patient1 = new Patient("Jack", "Male", 25);
        Patient patient2 = new Patient("Tom", "Male", 64);
        Patient patient3 = new Patient("Simona", "Female", 24);

        Deque<Patient> patientsQueue = new ArrayDeque<Patient>();
        patientsQueue.add(patient1);
        patientsQueue.add(patient2);
        patientsQueue.add(patient3);

        List<Deque<Patient>> queuesList = splitQueue(patientsQueue);

        int counter = 0;
        for (Deque<Patient> queue : queuesList) {
            if (counter == 0)
                System.out.println("Patients in the senior queue\n============================");
            else
                System.out.println("Patients in the normal queue\n============================");

            for (Patient patient : queue) {
                System.out.println("Name : " + patient.getName());
                System.out.println("Age : " + patient.getAge());
                System.out.println();
            }
            counter++;
        }
    }
}