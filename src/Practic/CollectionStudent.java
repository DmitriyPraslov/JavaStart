package Practic;

import java.util.*;

public class CollectionStudent {
    public static void main(String[] args) {
        CompareStudentAge compareStudent = new CompareStudentAge();
        Collection<Student> studentsCollection = new ArrayList<>();
        Student st1 = new Student("Bob", 22);
        Student st2 = new Student("Larry", 20);
        Student st3 = new Student("Barry", 19);
        Student st4 = new Student("Bob", 23);
        Student st5 = new Student("Ric", 18);
        Student st6 = new Student("Bob", 24);
        Student st7 = new Student("Ashan", 20);
        Student st8 = new Student("Bob", 21);
        Student st9 = new Student("Karl", 20);
        Student st10 = new Student("Karl", 21);
        studentsCollection.add(st1);
        studentsCollection.add(st2);
        studentsCollection.add(st3);
        studentsCollection.add(st4);
        studentsCollection.add(st5);
        studentsCollection.add(st6);
        studentsCollection.add(st7);
        studentsCollection.add(st8);
        studentsCollection.add(st9);
        studentsCollection.add(st10);
        System.out.println(findNameCoincidence(studentsCollection, "Bob"));
        studentsCollection = sort(studentsCollection);
        System.out.println(studentsCollection);
    }

    public static int findNameCoincidence (Collection<Student> students, String name){
        int result = 0;
        for (Student temp : students){
            if (temp.name.equals(name)){
                result++;
            }
        }
        return result;
    }
    public static Collection sort (Collection<Student> students){// після сорта колекція стартова буде вже отсортована, ви повертаєте нову колекцію та її ж і сортуєте Чому?
        List<Student> list = new ArrayList<>();
        list.addAll(students);
        Collections.sort(list);
        return list;
    }
}

class CompareStudentAge implements Comparator<Student>{ //не знайшов де ви використовуєте цей клас
    @Override
    public int compare(Student s1, Student s2){
        return s1.age - s2.age;
    }
}

class Student implements Comparable<Student>{// для чого реалізуєте цей інтерфейс ?
    String name;
    int age;
    String eMail;
    String phoneNumber;
    String login;
    String password;
    Student (String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Student s){
        return this.age - s.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
