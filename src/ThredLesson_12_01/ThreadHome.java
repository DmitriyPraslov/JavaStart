package ThredLesson_12_01;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadHome {
    public static void main(String[] args) {
//        NewThread sleepTest = new NewThread();
//        sleepTest.setName("SleepTest");
//        System.out.println(sleepTest);
//        sleepTest.start();
//
//
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(1);
        Semaphore semaphore3 = new Semaphore(1);
        Semaphore semaphore4 = new Semaphore(1);
        Semaphore semaphore5 = new Semaphore(1);
        try {
            semaphore1.acquire();
            semaphore2.acquire();
            semaphore4.acquire();
            semaphore5.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Semaphore> semaphoreList = Collections.synchronizedList(Arrays.asList(semaphore1,semaphore2,semaphore3,semaphore4,semaphore5));

//        Thread first = new Thread(new ThirdThread(list,10));
//
//        try {
//            sleepTest.join();
//        } catch (InterruptedException e) {
//        }
//
//        first.start();
//
//        try {
//            first.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
        int x =0;
        while (x<30){
            list.add(x);
            x++;
        }

        Thread additionThread = new Thread(new AdditionThread(list, semaphoreList,"Addition1", 3,0));
        Thread additionThread1 = new Thread(new AdditionThread(list,semaphoreList, "Addition2", 3,1));
        Thread additionThread2 = new Thread(new AdditionThread(list,semaphoreList, "Addition3", 3,2));
        Thread additionThread3 = new Thread(new AdditionThread(list, semaphoreList,"Addition4", 3,3));
        Thread additionThread4 = new Thread(new AdditionThread(list, semaphoreList,"Addition5", 3,4));


        additionThread.start();
        additionThread1.start();
        additionThread2.start();
        additionThread3.start();
        additionThread4.start();


        try {
            additionThread.join();
            additionThread1.join();
            additionThread2.join();
            additionThread3.join();
            additionThread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);

    }
}

class NewThread extends Thread{              // ------------------------- 2
    Thread runThread;
    @Override
    public void run() {
        System.out.println("I am start Sleeping.....");
        runThread = new Thread(new SecondThread());
        runThread.start();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            this.runThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am finished Sleeping!");

    }
}

class SecondThread implements Runnable{   // --------------------- 3
    @Override
    public void run() {
        for (int i=0;i<=5;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThirdThread implements Runnable{ // ---------------------- 1
    List<Integer> list;
    int count;
    ThirdThread (List<Integer> list, int count){
        this.list = list;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i=0;i<count;i++){
            list.add(i);
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}