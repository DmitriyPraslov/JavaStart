package PrivatBank;

public class Lesson2 {
    public static void main(String[] args) {              // Delegation pattern
        Human h1 = new Human("Alex",10);
        h1.showHumanState();
        h1.giveExperience(100);
        h1.showHumanState();
    }
}

class Human {
    private String name;
    private int age;
    private int humanExperience;
    private State state;
    Human (String name, int age){
        this.name = name;
        this.age = age;
        humanExperience = 0;
        state = new newBorn();
    }
    void giveExperience (int expTime){
        humanExperience+=expTime;
        switch (humanExperience){
            case 100: state = new Pupil();
            break;
            case 200: state = new Student();
            break;
            case 300: state = new Teacher();
            break;
        }
    }
    void showHumanState(){
        System.out.println(state);
    }
}

abstract class State {
    abstract  void toSpeak();
    abstract int getStateExp();
    abstract void setStateExp(int stateExp);
}

class newBorn extends State{
    int stateExp;
    public int getStateExp() {
        return stateExp;
    }

    public void setStateExp(int stateExp) {
        this.stateExp = stateExp;
    }

    @Override
    void toSpeak() {
        System.out.println("Aqu");
    }

    @Override
    public String toString() {
        return "New Born";
    }
}

class Pupil extends State{
    int stateExp;
    public int getStateExp() {
        return stateExp;
    }

    public void setStateExp(int stateExp) {
        this.stateExp = stateExp;
    }

    void toSpeak() {
        System.out.println("Hi! I am a pupil");
    }
    @Override
    public String toString() {
        return "Pupil";
    }
}

class Student extends State{
    int stateExp;
    public int getStateExp() {
        return stateExp;
    }

    public void setStateExp(int stateExp) {
        this.stateExp = stateExp;
    }

    void toSpeak() {
        System.out.println("Hi! I am a student");
    }
    @Override
    public String toString() {
        return "Student";
    }
}

class Teacher extends State{
    int stateExp;
    public int getStateExp() {
        return stateExp;
    }

    public void setStateExp(int stateExp) {
        this.stateExp = stateExp;
    }

    void toSpeak() {
        System.out.println("Hi! I am a teacher and lets start lesson");
    }
    @Override
    public String toString() {
        return "Teacher";
    }
}