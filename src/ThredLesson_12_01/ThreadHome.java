package ThredLesson_12_01;

import java.util.ArrayList;
import java.util.List;

public class ThreadHome {
    public static void main(String[] args) {
        NewThread sleepTest = new NewThread();
        sleepTest.setName("SleepTest");
        System.out.println(sleepTest);
        sleepTest.start();


        List<Integer> list = new ArrayList<>();
        Thread first = new Thread(new ThirdTHread(list,10));

        try {
            sleepTest.join();
        } catch (InterruptedException e) {
        }

        first.start();

        try {
            first.join();
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

class ThirdTHread implements Runnable{ // ---------------------- 1
    List<Integer> list;
    int count;
    ThirdTHread (List<Integer> list, int count){
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