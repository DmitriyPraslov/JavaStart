package Lesson_18_08;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example_Exception {
    public static void main(String[] args) {
        try {
            int a = 5 / 1;
            System.out.println("Message 3");
            String str = null;
            System.out.println(str.length());
            Connection connect = DriverManager.getConnection("");
            one();
        }
//        catch (ArithmeticException par1){
//            System.out.println("Massage 1");
//        }
//        catch (IndexOutOfBoundsException par2){
//            System.out.println("Message 2");
//        }
//        catch (NullPointerException par3){
//            System.out.println("Message with String");
//        }
        catch (Exception par3) {
            System.out.println("Message 5");
            System.exit(1);  // перерывание catch
        } finally {
            System.out.println("Message finally");
        }

    }

    static void one() throws SQLException {
        Student st1 = new Student(19.5f, "Petrov", "02.10.1990");
        float step = st1.getAge();
    }
}
class Student{
    private float age;
    private String name;
    private Date birthday;

    public Student(float age, String name, String birthday) {
        this.setAge(age);
        this.setName(name);
//        this.setBirthday(birthday);
        one();
    }
    private void one() {

    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}


