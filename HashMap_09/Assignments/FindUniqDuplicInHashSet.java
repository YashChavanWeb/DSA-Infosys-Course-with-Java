package HashMap_09.Assignments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * HTech college has organized a cultural festival. The nominations are invited for dance and music. The students are allowed to nominate themselves only for one of the events.  Since the data was stored in a list, the management observed that some of the students have been able to apply for both the events. 

You need to implement the following functionalities:

Fetch and return the details(studentId, studentName and emailId) of the unique students who have submitted nominations using a HashSet. Implement the logic in findUnique() method of Tester class.

Fetch and return the details of the students(studentId, studentName and emailId) who have nominated for both the events using a HashSet. Implement the logic in findDuplicates() method of Tester class.

The Student class has been implemented and provided to you.

Note: Two students are considered to be the same if their emailIds are the same.
 */

class Student {
    private int studentId;
    private String studentName;
    private String emailId;
    private String event;

    public Student(int studentId, String studentName, String emailId, String event) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.emailId = emailId;
        this.event = event;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object student) {
        Student otherStudent = (Student) student;
        if (this.emailId.equals(otherStudent.emailId))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return emailId.hashCode();
    }

    @Override
    public String toString() {
        return "Student Id: " + studentId + ", Student Name: " + studentName + ", Email Id: " + emailId;
    }
}

public class FindUniqDuplicInHashSet {
    public static Set<Student> findUnique(List<Student> students) {

        Set<Student> uniqStudents = new HashSet<>();

        for (Student std : students) {
            if (uniqStudents.add(std)) {
                uniqStudents.add(std);
            }
        }

        return uniqStudents;
    }

    public static Set<Student> findDuplicates(List<Student> students) {
        Set<Student> duplicateStudents = new HashSet<>();
        Set<String> seenEmails = new HashSet<>();

        for (Student std : students) {
            if (!seenEmails.add(std.getEmailId())) {
                duplicateStudents.add(std);
            }
        }

        return duplicateStudents;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student(5004, "Wyatt", "Wyatt@example.com", "Dance"));
        students.add(new Student(5010, "Lucy", "Lucy@example.com", "Dance"));
        students.add(new Student(5550, "Aaron", "Aaron@example.com", "Dance"));
        students.add(new Student(5560, "Ruby", "Ruby@example.com", "Dance"));
        students.add(new Student(5015, "Sophie", "Sophie@example.com", "Music"));
        students.add(new Student(5013, "Clara", "Clara@example.com", "Music"));
        students.add(new Student(5010, "Lucy", "Lucy@example.com", "Music"));
        students.add(new Student(5011, "Ivan", "Ivan@example.com", "Music"));
        students.add(new Student(5550, "Aaron", "Aaron@example.com", "Music"));

        Set<Student> studentNominations = findUnique(students);
        System.out.println("Students who have submitted nominations");
        for (Student student : studentNominations)
            System.out.println(student);

        Set<Student> duplicateStudents = findDuplicates(students);
        System.out.println("Students who have submitted nominations for both the events");
        for (Student student : duplicateStudents)
            System.out.println(student);
    }
}
