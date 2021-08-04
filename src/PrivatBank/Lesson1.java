package PrivatBank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lesson1 {
    public static void main(String[] args) {
//        Animal Animal = new Animal();
        Animal dog = new Dog("Barbossa");
        Animal cat = new Cat("Baaarsik");
        Frog frog = new Frog("Trog");
        List<Animal> AnimalList = new ArrayList<>();
        AnimalList.add(dog);
        AnimalList.add(cat);
        AnimalList.add(frog);
        for (Animal temp : AnimalList){
            if (temp.getClass().equals(Frog.class)){
                System.out.print(((Frog) temp).getName() + " say ");
                temp.voice();
                continue;
            }
            temp.voice();
        }
    }
}

abstract class Animal{
    abstract void eat ();
    abstract void move ();
    abstract void voice ();
}

class Cat extends Animal{
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

class Dog extends Animal{
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

class Frog extends Animal{
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
