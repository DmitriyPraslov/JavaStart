package Practic;

import java.util.*;

public class Pupils {
    public static void main(String[] args) {
        Class class1 = new Class();
        Class class2 = new Class();
        Class class3 = new Class();
        Class class4 = new Class();
        class1.addPupil(new Pupil("Bob", 7));
        class1.addPupil(new Pupil("Harry", 10));
        class1.addPupil(new Pupil("Barry", 9));
        class1.addPupil(new Pupil("Bob", 8));
        class1.addPupil(new Pupil("Ric", 10));

        class2.addPupil(new Pupil("Bob", 7));
        class2.addPupil(new Pupil("Barry", 9));
        class2.addPupil(new Pupil("Bob", 10));
        class2.addPupil(new Pupil("Karl", 9));
        class2.addPupil(new Pupil("Karl", 11));

        class4.addPupil(new Pupil("Huan", 11));
        class4.addPupil(new Pupil("Bob", 7));

        class3.pupilsList.addAll(class1.pupilsList);
        class3.pupilsList.addAll(class2.pupilsList);
        class3.showPupilList();                                                    //   3 - все без дублей
        System.out.println(compareClass(class1.pupilsList, class2.pupilsList));    //   1.1 - в обе группы 1.2 / 1.3
        System.out.println(compareClass1(class1.pupilsList, class2.pupilsList));   //   1.1 - в обе группы
        List<Class> shool = new LinkedList<>();
        shool.add(class1);
        shool.add(class2);
        shool.add(class4);
        System.out.println(findPupils(shool));                                     // 2 которые ходят во все группы
//        class1.pupilsList.retainAll(class2.pupilsList);
//        System.out.println(class1.pupilsList);                                     //  1.1 - в обе группы
        class1.pupilsList.removeAll(class2.pupilsList);                              //  1.2 / 1.3
        System.out.println(class1.pupilsList);



    }

    public static Collection<Pupil> compareClass (Collection<Pupil> class1, Collection<Pupil> class2){
        Collection<Pupil> result = new LinkedList<>();
        for (Pupil temp : class1){
            if (class2.contains(temp)){
                result.add(temp);
            }
        }
        return result;
    }

    public static Collection<Pupil> compareClass1 (Collection<Pupil> class1, Collection<Pupil> class2){
        Collection<Pupil> result = new HashSet<>();
        for (Pupil temp1 : class1){
            for (Pupil temp2 : class2){
                if (temp1.equals(temp2)){
                    result.add(temp1);
                }
            }
        }
        return result;
    }

    public static Collection<Pupil> findPupils (List<Class> shool){
        Collection<Pupil> result = shool.get(0).pupilsList;
        for (int i=1;i<shool.size();i++){
            result = compareClass(result, shool.get(i).pupilsList);
        }
        return result;
    }
}

class Class{
    Collection<Pupil> pupilsList = new HashSet<>();
    void addPupil (Pupil pupil){
        pupilsList.add(pupil);
    }
    void showPupilList (){
        for (Pupil temp : pupilsList){
            System.out.println(temp);
        }
        System.out.println();
    }
}

class Pupil{
    String name;
    int age;
    Pupil(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;

        Pupil pupil = (Pupil) o;

        if (age != pupil.age) return false;
        return name != null ? name.equals(pupil.name) : pupil.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
