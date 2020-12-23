package Lesson_12_18;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    int id;
    String name;
    User (String name){
        this.name = name;
    }

    int getId (){
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
