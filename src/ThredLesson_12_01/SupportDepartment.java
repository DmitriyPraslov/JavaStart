package ThredLesson_12_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SupportDepartment {
    BlockingQueue<Task> taskList;

    SupportDepartment(int countWorker){
        taskList = new ArrayBlockingQueue<>(countWorker);
    }

    void addAndGo (List<Task> todoList){
        for (Task temp : todoList) {
            try {
                taskList.put(temp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp.go(taskList);
        }
    }

//    static class CheckingThread implements Runnable{
//        Thread thread;
//        CheckingThread(){
//            thread = new Thread(this);
//            thread.start();
//        }
//        @Override
//        public void run() {
//            while (true){
//                for (Task temp : taskList) {
//                    if (!temp.t.isAlive()) {
//                        taskList.remove(temp);
//                        break;
//                    }
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        SupportDepartment support = new SupportDepartment(2);
        Task t1 = new Task(1,"task1","name1");
        Task t2 = new Task(2,"task2","name2");
        Task t3 = new Task(3,"task3","name3");
        Task t4 = new Task(4,"task4","name4");
        Task t5 = new Task(5,"task5","name5");
        Task t6 = new Task(6,"task6","name6");
        Task t7 = new Task(7,"task7","name7");
        Task t8 = new Task(8,"task8","name8");
        List<Task> todoList = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8);
        support.addAndGo(todoList);

        try {
            t8.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(support.taskList);
    }
}
class Task implements Runnable{
    BlockingQueue<Task> list;
    int number;
    String discription;
    String name;
    Thread t;
    Random random = new Random();
    Task (int id, String discription, String name){
        number = id;
        this.discription=discription;
        this.name = name;
        t = new Thread(this, name);
    }

    void go(BlockingQueue<Task> list){
        this.list = list;
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Работает задача "+ number+" клиента: "+name);
        try {
            t.sleep(random.nextInt(10000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Задача "+number +" клиента: "+name+" выполнена!");
        list.remove(this);
    }
}