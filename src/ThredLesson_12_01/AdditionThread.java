package ThredLesson_12_01;

import java.util.*;
import java.util.concurrent.Semaphore;

public class AdditionThread implements Runnable{
        String name;
        List<Integer> list;
        int count;
        int number;
        List<Semaphore> semaphoreList;

        AdditionThread (List<Integer> list,List<Semaphore> semaphoreList,String name, int count, int number){
            this.name = name;
            this.list = list;
            this.count = count;
            this.number = number;
            this.semaphoreList = semaphoreList;
        }

        @Override
        public void run() {
            Semaphore s1 = semaphoreList.get(number);
            for (int i=0;i<count;i++){
                try {
                    s1.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(this.name+" "+list.get(0));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.remove(0);

                if (number<4){
                    semaphoreList.get(number+1).release();
                } else
                    semaphoreList.get(0).release();
                }
            }
        }
