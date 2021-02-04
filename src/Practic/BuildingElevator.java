package Practic;

import java.util.*;
import java.util.concurrent.Semaphore;

public class BuildingElevator {
    Semaphore elevatorFreePlace;
    int floorCount;
    Map<Integer,List<Resident>> residentList = new TreeMap<>();

    BuildingElevator(int countPassenger, int floorCount ){
        this.elevatorFreePlace = new Semaphore(countPassenger);
        this.floorCount = floorCount;
    }

    public static void main(String[] args) {
        BuildingElevator elevator = new BuildingElevator(2,3);
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Resident resident1 = new Resident("Resident1", elevator.elevatorFreePlace, elevator.residentList,1, 3);
        Resident resident2 = new Resident("Resident2", elevator.elevatorFreePlace, elevator.residentList,1, 3);
        Resident resident3 = new Resident("Resident3", elevator.elevatorFreePlace, elevator.residentList,1, 3);
        floor1.residentOfLevel.add(resident1);
        floor1.residentOfLevel.add(resident2);
        floor1.residentOfLevel.add(resident3);
        Resident resident4 = new Resident("Resident4", elevator.elevatorFreePlace, elevator.residentList,2, 3);
        Resident resident5 = new Resident("Resident5", elevator.elevatorFreePlace, elevator.residentList,2, 3);
        floor2.residentOfLevel.add(resident4);
        floor2.residentOfLevel.add(resident5);
        Resident resident6 = new Resident("Resident6", elevator.elevatorFreePlace, elevator.residentList,3, 3);
        Resident resident7 = new Resident("Resident7", elevator.elevatorFreePlace, elevator.residentList,3, 3);
        Resident resident8 = new Resident("Resident8", elevator.elevatorFreePlace, elevator.residentList,3, 3);
        Resident resident9 = new Resident("Resident9", elevator.elevatorFreePlace, elevator.residentList,3, 3);
        floor3.residentOfLevel.add(resident6);
        floor3.residentOfLevel.add(resident7);
        floor3.residentOfLevel.add(resident8);
        floor3.residentOfLevel.add(resident9);
        elevator.residentList.put(1, floor1.residentOfLevel);
        elevator.residentList.put(2, floor2.residentOfLevel);
        elevator.residentList.put(3, floor3.residentOfLevel);
        floor1.go();
        floor2.go();
        floor3.go();
    }
}
class Resident {
    String name;
    Semaphore elevatorFreePlace;
    Random toGoOnFloor = new Random();
    int currentFloor;
    int floorCount;
    Map<Integer, List<Resident>> residentList;

    Resident(String name, Semaphore elevatorFreePlace, Map<Integer, List<Resident>> residentList, int currentFloor, int floorCount){
        this.name = name;
        this.elevatorFreePlace = elevatorFreePlace;
        this.currentFloor = currentFloor;
        this.floorCount = floorCount;
        this.residentList = residentList;
    }

    void callElevator(){
        int newFloor=currentFloor;

        while (newFloor==currentFloor){
            newFloor = toGoOnFloor.nextInt(floorCount-1)+1;  // Отправится на этаж (исключая возможность отправится на тот же этаж)
            setCurrentFloor(newFloor);
        }
        try {
            elevatorFreePlace.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (residentList) {  // Синхронизация по списку жителей
            for (Integer currentFlorTemp : residentList.keySet()) {  // Удаление с текущего этажа при перемещении
                if (currentFlorTemp.equals(currentFloor)) {
                    residentList.get(currentFlorTemp).remove(this);
                }
            }
            for (Integer goOnFloorTemp : residentList.keySet()) {  // Добавление пасажира в конец очереди в пункте назначения
                if (goOnFloorTemp.equals(newFloor)) {
                    residentList.get(goOnFloorTemp).add(this);
                }
            }
        }
        elevatorFreePlace.release();
    }
    void setCurrentFloor(int newFloor){
        currentFloor = newFloor;
    }
}
class Floor implements Runnable{
    List<Resident> residentOfLevel = new LinkedList<>();
    Thread t;
    Floor(){
        t = new Thread(this);
    }
    // Каждый этаж это поток, так как люди могут желать переместится паралельно
    // Каждый этаж имеет свою очередь (коллекция) которая переберается последовательно в порядке очереди
    // Коллекция переберается бесконечно так как на этаж могут приехать новые люди которые станут в конец очереди
    void go(){
        t.start();
    }
    @Override
    public void run() {
        while (true) {
            if (residentOfLevel.size()>0){
                for (Resident rTemp : residentOfLevel) {
                    rTemp.callElevator();
                }
            }
        }
    }
}