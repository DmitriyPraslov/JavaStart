package PrivatBank;

import java.util.LinkedList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
//        Animals animals = new Animals();
        Animals dog = new Dog("Barbossa");
        Animals cat = new Cat("Baaarsik");
        Frog frog = new Frog("Trog");
        List<Animals> animalsList = new LinkedList<>();
        animalsList.add(dog);
        animalsList.add(cat);
        animalsList.add(frog);
        for (Animals temp : animalsList){
            if (temp.getClass().equals(Frog.class)){
                System.out.print(((Frog) temp).getName() + " say ");
                temp.voice();
                continue;
            }
            temp.voice();
        }
    }
}

abstract class Animals{
    abstract void eat ();
    abstract void move ();
    abstract void voice ();
}

class Cat extends Animals{
    private String name;
    Cat (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void eat() {
        System.out.println("Cat was eating");
    }

    @Override
    void move() {
        System.out.println("Cat was running");
    }

    @Override
    void voice() {
        System.out.println("Miau");
    }
}

class Dog extends Animals{
    private String name;
    Dog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void eat() {
        System.out.println("Dog was eating");
    }

    @Override
    void move() {
        System.out.println("Dog was running");
    }

    @Override
    void voice() {
        System.out.println("Gav-gav");
    }
}

class Frog extends Animals{
    private String name;
    Frog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void eat() {
        System.out.println("Frog was eating");
    }

    @Override
    void move() {
        System.out.println("Frog was jumping");
    }

    @Override
    void voice() {
        System.out.println("Kva-kva");
    }
}
