package ThredLesson_12_01;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;

public class SynchroObjects {
    public static void main(String[] args) {
//        CountDownLatch countDownLatch = new CountDownLatch(3);  // 1
//        RandomThread rThread = new RandomThread("RandomThread",countDownLatch);
//        System.out.println("countDownLatch is wait");
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("countDownLatch end");


//        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,new StartBarrier());  // 2
//        BarrierElement b1 = new BarrierElement("Thread1", cyclicBarrier);
//        BarrierElement b2 = new BarrierElement("Thread2", cyclicBarrier);
//        BarrierElement b3 = new BarrierElement("Thread3", cyclicBarrier);
//        BarrierElement b4 = new BarrierElement("Thread4", cyclicBarrier);
//        BarrierElement b5 = new BarrierElement("Thread5", cyclicBarrier);

        Exchanger<Integer> exchanger = new Exchanger<>();  // 3
        OutputResult opt = new OutputResult(exchanger);
        WorkThread w1 = new WorkThread("WorkThread1",exchanger);
        WorkThread w2 = new WorkThread("WorkThread2",exchanger);
        WorkThread w3 = new WorkThread("WorkThread3",exchanger);
        WorkThread w4 = new WorkThread("WorkThread4",exchanger);
        WorkThread w5 = new WorkThread("WorkThread5",exchanger);
    }
}

class RandomThread implements Runnable{
    CountDownLatch countDownLatch;
    Random random = new Random();
    RandomThread(String name, CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int randomTry;
        int countTry = 0;
        while (countDownLatch.getCount()!=0){
            randomTry = random.nextInt(100);
            countTry++;
            if (randomTry>50&&randomTry<60){
                System.out.println(randomTry);
                countDownLatch.countDown();
                System.out.println(countDownLatch.getCount());
            }
        }
        System.out.println(countTry);
    }
}
 //----------------------------------------------------------------------------//
class StartBarrier implements  Runnable{
    @Override
    public void run() {
        System.out.println("Barrier is working!!!");
    }
}


class BarrierElement implements Runnable{
    String name;
    CyclicBarrier cyclicBarrier;
    Random random = new Random();
    int sumOfRandomNumber = 0;

    BarrierElement(String name, CyclicBarrier cyclicBarrier){
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (sumOfRandomNumber<10000){
            sumOfRandomNumber += random.nextInt(100);
        }
        System.out.println(sumOfRandomNumber);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
//-----------------------------------------------------------------------------//

class OutputResult implements  Runnable{
    Exchanger<Integer> ex;
    int result = 0;
    OutputResult (Exchanger<Integer> ex){
        new Thread(this).start();
        this.ex = ex;
    }
    @Override
    public void run() {
        for (int i=0;i<5;i++) {
            try {
                System.out.println(result = ex.exchange(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class WorkThread implements Runnable{
    String name;
    Exchanger<Integer> ex;
    Random random = new Random();
    int sumOfRandomNumber = 0;

    WorkThread(String name, Exchanger<Integer> ex){
        this.name = name;
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (sumOfRandomNumber<10000){
            sumOfRandomNumber += random.nextInt(100);
        }
        try {
            ex.exchange(sumOfRandomNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}