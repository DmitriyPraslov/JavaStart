package ThredLesson_12_01;

import java.util.*;
import java.util.concurrent.*;

public class Cafe{
    String name;
    BlockingQueue<Client> peopleCanToServe;
    List<Table> tableList = new ArrayList<>();

    Cafe(String name, int countTable, int countPlace){
        int sumFreeePlace = 0;
        this.name = name;
        for (int i=0;i<countTable;i++){
            tableList.add(new Table(countPlace));
        }
        for (Table temp : tableList){
            sumFreeePlace +=temp.freePlace;
        }
        peopleCanToServe = new ArrayBlockingQueue(sumFreeePlace,true);
    }

    void serve(List<Client> clientList){
        for (Client client : clientList) {
            try {
                peopleCanToServe.put(client);
                ServeThread thread = new ServeThread(peopleCanToServe, client);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Cafe cafe1 = new Cafe("Cafe1",1,2);
        List<Client> clientList = List.of(new Client("Client1"), new Client("Client2"), new Client("Client3"), new Client("Client4"), new Client("Client5"));
        cafe1.serve(clientList);

    }
}

class ServeThread implements Runnable{
    Thread t;
    Client tempClient;
    BlockingQueue<Client> peopleCanToServe;
    ServeThread(BlockingQueue<Client> peopleCanToServe, Client client){
        t = new Thread(this);
        this.peopleCanToServe = peopleCanToServe;
        this.tempClient = client;
        t.start();
    }

    @Override
    public void run() {
        tempClient.eat();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tempClient.finish();
        peopleCanToServe.remove(tempClient);
    }
}


class Table{
    int freePlace;
    Table(int freePlace){
        this.freePlace = freePlace;
    }
}

class Client{
    String name;
    Client(String name){
        this.name = name;
    }

    void eat(){
        System.out.println("I am Eating");
    }

    void finish(){
        System.out.println("I am Finish Eating");
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
