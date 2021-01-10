package LamdaHome;

import java.security.Key;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentGroup {
    Set<Student> studentList = new HashSet<>();

    void addLessonForStudent(String lessons){
        for (Student temp : studentList){
            temp.table.put(lessons, new ArrayList<>());
        }
    }

    void addGradeForLesson (String lessonName, String studentName, int grade){
        for (Student temp : studentList){
            if (temp.name.equals(studentName)){
                for (String lessonTemp : temp.table.keySet()){
                    if (lessonTemp.equals(lessonName)){
                        temp.table.get(lessonTemp).add(grade);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        StudentGroup group1 = new StudentGroup();
        group1.studentList.add(new Student("Ivanov", 20));
        group1.studentList.add(new Student("Petrov", 20));
        group1.studentList.add(new Student("Pavlov", 20));
        group1.studentList.add(new Student("Sidorov", 20));

        group1.addLessonForStudent("Math");
        group1.addLessonForStudent("Physics");
        group1.addLessonForStudent("Psychology");

        group1.addGradeForLesson("Math","Ivanov",76);
        group1.addGradeForLesson("Math","Ivanov",81);
        group1.addGradeForLesson("Math","Ivanov",61);
        group1.addGradeForLesson("Math","Ivanov",90);
        group1.addGradeForLesson("Math","Petrov",61);
        group1.addGradeForLesson("Math","Petrov",70);
        group1.addGradeForLesson("Math","Petrov",75);
        group1.addGradeForLesson("Math","Petrov",80);
        group1.addGradeForLesson("Math","Pavlov",65);
        group1.addGradeForLesson("Math","Pavlov",90);
        group1.addGradeForLesson("Math","Pavlov",92);
        group1.addGradeForLesson("Math","Pavlov",76);
        group1.addGradeForLesson("Math","Sidorov",91);
        group1.addGradeForLesson("Math","Sidorov",95);
        group1.addGradeForLesson("Math","Sidorov",90);
        group1.addGradeForLesson("Math","Sidorov",87);
        group1.addGradeForLesson("Physics","Ivanov",76);
        group1.addGradeForLesson("Physics","Ivanov",81);
        group1.addGradeForLesson("Physics","Ivanov",61);
        group1.addGradeForLesson("Physics","Ivanov",90);
        group1.addGradeForLesson("Physics","Petrov",61);
        group1.addGradeForLesson("Physics","Petrov",70);
        group1.addGradeForLesson("Physics","Petrov",75);
        group1.addGradeForLesson("Physics","Petrov",80);
        group1.addGradeForLesson("Physics","Pavlov",65);
        group1.addGradeForLesson("Physics","Pavlov",90);
        group1.addGradeForLesson("Physics","Pavlov",92);
        group1.addGradeForLesson("Physics","Pavlov",76);
        group1.addGradeForLesson("Physics","Sidorov",91);
        group1.addGradeForLesson("Physics","Sidorov",95);
        group1.addGradeForLesson("Physics","Sidorov",90);
        group1.addGradeForLesson("Physics","Sidorov",87);




//        group1.studentList.stream().forEach(w->System.out.println(w.getName()+" "+w.filterSubject("Math"))); // Средний бал по выбранной дисциплине в разрезе студента
//        int middleGrade = (group1.studentList.stream().map(w->w.filterSubject("Math")).mapToInt(w->w.intValue()).sum())/group1.studentList.size(); // Средний бал по одной дисциплине по всем студентам
//        System.out.println(middleGrade);
//        group1.studentList.stream().forEach(w->w.allSubject()); // Средний бал по всем дисциплинам для каждого студента


        List<String> towns = new LinkedList<>(Arrays.asList("Zhytomyr", "Kyiv", "Rivne", "Chernivtsi", "Odessa", "Nikolaev", "Kishinev"));
//        Filter filt = (w,z)->Character.toString(w.charAt(0)).equals(z);
//
//        townsFilter(towns, filt);  // Фильтрация коллекции по одному параметру

        Predicate<String> firstPredicate = w->w.startsWith("K");
        Predicate<String> secondPredicate = w->w.length()>5;

        List<Predicate> predicateList = new LinkedList<>();
        predicateList.add(firstPredicate);
        predicateList.add(secondPredicate);

        System.out.println(massFilter(towns, predicateList));  // Фильтрация коллекции по множеству параметров

    }
    public static List<String> massFilter (List<String> townsList, List<Predicate> predicateList){
        List<String> result = townsList;
        Stream<String> buffer;
        for (Predicate temp : predicateList) {
            buffer = result.stream().filter(w->temp.test(w));
            result = buffer.collect(Collectors.toList());
        }
        return result;
    }

    public static void townsFilter (List<String> townsList, Filter filter){
        for (String temp : townsList){
            if (filter.filterFunction(Character.toString(temp.charAt(0)),"K")){
                System.out.println(temp);
            }
        }
    }
}

class Student{
    Map<String, List<Integer>> table = new TreeMap<>();
    String name;
    int age;
    Student (String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    long filterSubject (String lessonName){
        long[] result = {0};
        IntStream resultStream;
        if (!table.get(lessonName).isEmpty()) {
//        table.entrySet().stream().filter(v->v.getKey().equals(lessonName)).map(w->w.getValue().stream().mapToInt(i->i.intValue()).sum()).forEach(w->System.out.println(name+" "+lessonName+" "+w/(4)));
//        table.entrySet().stream().filter(v->v.getKey().equals(lessonName)).map(w->w.getValue().stream().mapToInt(i->i.intValue()).sum()).forEach(w->System.out.println(name+" "+lessonName+" "+w/(table.get(lessonName).size())));
            resultStream = table.entrySet().stream().filter(v -> v.getKey().equals(lessonName)).map(w -> w.getValue().stream().mapToInt(i -> i.intValue()).sum()).mapToInt(w -> w / (table.get(lessonName).size()));
            OptionalInt opt = resultStream.findFirst();
            result[0] = opt.getAsInt();
        }
        return result[0];
    }

    long allSubject () {
        long[] result = {0};
        for (String temp : table.keySet()) {
            if (!table.get(temp).isEmpty()) {
                System.out.print(name+" "+temp+" ");
                IntStream resultStream = table.entrySet().stream().map(w -> w.getValue().stream().mapToInt(i -> i.intValue()).sum()).mapToInt(w->w/table.get(temp).size());
                OptionalInt opt = resultStream.findFirst();
                result[0] = opt.getAsInt();
                System.out.println(result[0]);
            }
        }
        return result[0];
    }



    List<Integer> getGradeList (String lessonName){
        List<Integer> result = new ArrayList<>();
        for (String temp : table.keySet()){
            if (temp.equals(lessonName)){
                result = table.get(temp);
            }
        }
        return result;
    }

    int calcMidlGrade(){
        int result = 0;
        int counter;
        String lessonName;
        for (String lessonTemp : table.keySet()){
            if (!table.get(lessonTemp).isEmpty()) {
                counter = 0;
                result = 0;
                lessonName=lessonTemp;
                for (Integer temp : table.get(lessonTemp)) {
                    result = result + temp;
                    counter++;
                }
            System.out.println(name + " " + lessonName + " " + (result = result/counter));
            }
        }
        return result;
    }

    int calcMidlGrade(String lessonName){
        int result = 0;
        int counter;
        for (String lessonTemp : table.keySet()){
            if (lessonTemp.equals(lessonName)) {
                counter = 0;
                result = 0;
                lessonName=lessonTemp;
                for (Integer temp : table.get(lessonTemp)) {
                    result = result + temp;
                    counter++;
                }
                System.out.println(name + " " + lessonName + " " + (result = result/counter));
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@FunctionalInterface
interface Filter {
    boolean filterFunction(String word, String letter);
}