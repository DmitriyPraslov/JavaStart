package Alhorytm_Practic;

import javax.swing.*;
import java.util.*;

public class Student {
    String lastName;
    List<Integer> studentPoint;

    Student (String lastName, List<Integer> studentPoint){
        this.lastName = lastName;
        this.studentPoint = studentPoint;
    }

    public static void main(String[] args) {
        Comparator<Student> comparator = new StudentPointsComparator().thenComparing(new StudentNameComparator());
        Set<Student> class1 = new TreeSet<>(comparator);
        Student student1 = new Student("Petrov", Arrays.asList(91,61,76,76,80));
        Student student6 = new Student("Angelov", Arrays.asList(91,61,76,76,80));
        Student student2 = new Student("Sidorov", Arrays.asList(61,61,76,76,80));
        Student student3 = new Student("Ivanov", Arrays.asList(73,61,76,76,78));
        Student student4 = new Student("Orlov", Arrays.asList(76,61,91,76,91));
        Student student5 = new Student("Zaytcev", Arrays.asList(76,61,91,76,91));
        class1.add(student1);
        class1.add(student2);
        class1.add(student3);
        class1.add(student4);
        class1.add(student5);
        class1.add(student6);
        System.out.println(class1);
    }

    public static int findAverage (List<Integer> studentPoint){
        int result = 0;
        for (Integer temp : studentPoint){
            result+=temp;
        }
        return result/studentPoint.size();
    }

    @Override
    public String toString() {
        return Student.findAverage(studentPoint) + " lastName = " + lastName;
    }
}

class StudentNameComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        return student1.lastName.compareTo(student2.lastName);
    }
}

class StudentPointsComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        if (Student.findAverage(student1.studentPoint)>Student.findAverage(student2.studentPoint)){
            return -1;
        } else if (Student.findAverage(student1.studentPoint)<Student.findAverage(student2.studentPoint)){
            return 1;
        } else {
            return 0;
        }
    }
}
