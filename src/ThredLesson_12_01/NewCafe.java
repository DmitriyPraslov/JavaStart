package ThredLesson_12_01;

import java.util.concurrent.Semaphore;

public class NewCafe {
    Semaphore freePlace;
    String name;
    NewCafe(String name, int freePlace){
        this.name = name;
        this.freePlace = new Semaphore(freePlace);
    }
    void toServe(int countClient){
        for (int i=1;i<=countClient;i++){
            Person person = new Person("Client"+i,freePlace);
            person.thread.start();
        }
    }

    public static void main(String[] args) {
        NewCafe myCafe = new NewCafe("Cafe1",2);
        myCafe.toServe(10);
    }
}

class Person implements Runnable{
    Semaphore table;
    String clientName;
    Thread thread;
    Person (String clientName, Semaphore table){
        this.clientName = clientName;
        this.table = table;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            table.acquire();
            System.out.println("I am Start Eating");
            Thread.sleep(1000);
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am Finish Eating!");
    }
}