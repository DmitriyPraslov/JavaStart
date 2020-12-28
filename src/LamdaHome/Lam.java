package LamdaHome;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lam {
    public static void main(String[] args) {
        LamdaTry try1 = (w,r) -> (w.startsWith("q") || r>20);
        System.out.println(try1.fun1("qgsejhgud",19));

        List<String> stringList = new LinkedList<>();
        List<String> resultSort = new LinkedList<>();
        stringList.add("Bob");
        stringList.add("Arry");
        stringList.add("Barry");
        stringList.add("Garry");
        stringList.add("Ron");
        stringList.add("Karl");
        stringList.stream().sorted(Comparator.comparingInt(String::length)).forEach(resultSort::add);
        System.out.println(resultSort);


        List<Person> personList = new LinkedList<>();
        List<Person> resultSort1 = new LinkedList<>();
//        personList.sort((o1, o2) -> o1.name.compareTo(o2.name));
        personList.add(new Person("Bob"));
        personList.add(new Person("Arry"));
        personList.add(new Person("Barry"));
        personList.add(new Person("Garry"));
        personList.add(new Person("Ron"));
        personList.add(new Person("Karl"));
        personList.stream().sorted(Comparator.comparing(Person::getFirstChar)).forEach(resultSort1::add);
        System.out.println(resultSort1);


        List<Person> resultSort2 = new LinkedList<>();
        personList.stream().sorted(Comparator.comparingInt(Person::countVowelsChar)).forEach(resultSort2::add);
        System.out.println(resultSort2);

        int[] arr = {2,3,7,9,7,10,5,1};
        Arrays.stream(arr).filter(w->w%2==0).forEach(System.out::println);

        Function fun12 = (w,z)->w%z==0;
        arrFilter(arr,fun12);
    }
    public static void arrFilter (int[] arr, Function fun){
        for (int i=0;i<arr.length;i++){
            if (fun.function(arr[i],2)){
                System.out.println(arr[i]);
            }
        }
    }
}

@FunctionalInterface
interface LamdaTry{
    boolean fun1 (String a, int b);
}

interface Function{
    boolean function (int element, int divider);
}

class Person {
    String name;

    Person(String name){
        this.name = name;
    }

    String getFirstChar (){
        String result;
        return result = Character.toString(name.charAt(0));
    }

    int countVowelsChar (){
        int result = 0;
        List<Character> vovelChars = List.of('A','E','I','O','U','Y','a','e','i','o','u','y');
        for (int i=0;i<name.length();i++) {
            for (int j=0;j<vovelChars.size();j++) {
                if (name.charAt(i)==vovelChars.get(j)){
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
