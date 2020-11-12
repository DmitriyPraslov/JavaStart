package E_Olimp;

import java.util.*;

public class CollectionStudent {
    public static void main(String[] args) {
        University university = new University();
        university.addStudent("Vitaliy", 22, "qmaggsolit@nieciaco.ml", "+38(094)8424337", "Vitaliy22", "qwerty");
        university.addStudent("Bob", 21, "mwaelhachmi2@stiesy.com", "+38(093)5672345", "Licarin", "qwerty");
        university.addStudent("Bob", 21, "mwaelhachmi2@stiesy.com", "+38(093)5672345", "Licarin", "qwerty");
        university.addStudent("Larry", 19, "4ashemasalahs@ramurop.tk", "+38(096)1289654", "Licarin", "qwerty");
//        university.addStudent("Barry", 23, "jsivaprasadmadas8@brandly.tech", "+38(074)2374907", "Reemic", "qwerty");
//        university.addStudent("Ric", 24, "bufiddapuki-6211@yopmail.com", "+38(066)2163942", "Rydorip", "qwerty");
//        university.addStudent("Karl", 20, "ojadejovi-1867@yopmail.com", "+38(061)8424337", "Zudeled", "qwerty");
//        university.addStudent("Vitaliy", 21, "ettadezaw-1212@yopmail.com", "+38(098)5424337", "Phoritws", "qwerty");
//        university.addStudent("Alex", 18, "anykettorr-3595@yopmail.com", "+38(094)6933792", "Menos", "qwerty");
//        university.addStudent("Dmitriy", 19, "dimkin.08@gmail.com", "+38(093)0905632", "Qushari", "qwerty");
//        university.addStudent("Jack", 22, "gorradikemm-5591@yopmail.com", "+38(096)2155037", "Conennnn", "qwerty");
//        university.addStudent("Lili", 23, "hepaheppe-5907@yopmail.com", "+38(099)7125737", "Isaila", "qwerty");
        System.out.println("Hello! " + university.authorization("Vitaliy22", "qwerty"));
        university.showCollection();

    }
}


class University {
    Collection<Student> studentList = new HashSet<>();
    void addStudent (String name, int age, String eMail, String phoneNumber, String login, String password){
        if (authorization(login, password)==null) {
            if (!checkeMailAndName(name, eMail)) {
                studentList.add(new Student(name, age, eMail, phoneNumber, login, password));
            }
        }
    }

    Student authorization (String login, String password){
        Student result = null;
        for (Student temp : studentList){
            if (temp.login.equals(login)&&temp.password.equals(password)){
                result = temp;
                break;
            }
        }
        return result;
    }

    boolean checkeMailAndName(String name, String eMail){
        boolean result = false;
        for (Student temp : studentList) {
            if (temp.name.equals(name)&&temp.eMail.equals(eMail)){
                result = true;
            }
        }
        return result;
    }

    void showCollection (){
        for (Student temp : studentList){
            System.out.println(temp);
        }
    }
}


class Student {
    String name;
    int age;
    String eMail;
    String phoneNumber;
    String login;
    String password;

    Student(String name, int age, String eMail, String phoneNumber, String login, String password) {
        this.name = name;
        this.age = age;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    void setName (String name){
        this.name = name;
    }
    void setAge (int age){
        this.age = age;
    }
    void seteMail (String eMail){
        this.eMail = eMail;
    }
    void setPhoneNumber (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    void setLogin (String login){
        this.login = login;
    }
    void setPassword (String password){
        this.password = password;
    }

    String getName (){ return name;}
    int getAge (){ return age;}
    String geteMail (){ return eMail;}
    String getPhoneNumber (){ return phoneNumber;}
    String getLogin (){ return login;}
    String getPassword (){ return password;}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (eMail != null ? !eMail.equals(student.eMail) : student.eMail != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(student.phoneNumber) : student.phoneNumber != null) return false;
        if (login != null ? !login.equals(student.login) : student.login != null) return false;
        return password != null ? password.equals(student.password) : student.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}