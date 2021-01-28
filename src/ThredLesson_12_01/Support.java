package ThredLesson_12_01;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Support {

    public static void main(String[] args) {
        Semaphore countWorker = new Semaphore(2);
        Quest q1 = new Quest(1,"quest1","name1");
        Quest q2 = new Quest(2,"quest2","name2");
        Quest q3 = new Quest(3,"quest3","name3");
        Quest q4 = new Quest(4,"quest4","name4");
        q1.go(countWorker);
        q2.go(countWorker);
        q3.go(countWorker);
        q4.go(countWorker);
    }
}
class Quest implements Runnable{
    Semaphore workers;
    int number;
    String discription;
    String name;
    Thread t;
    Random random = new Random();
    Quest (int id, String discription, String name){
        number = id;
        this.discription=discription;
        this.name = name;
        t = new Thread(this, name);
    }

    void go(Semaphore workers){
        this.workers = workers;
        t.start();
    }

    @Override
    public void run() {
        try {
            workers.acquire();
            System.out.println("Работает задача "+ number+" клиента: "+name);
            t.sleep(random.nextInt(10000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Задача "+number +" клиента: "+name+" выполнена!");
        workers.release();
    }
}