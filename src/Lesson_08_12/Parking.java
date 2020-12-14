package Lesson_08_12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.BiConsumer;

public class Parking {
    String adress;
    Set<Owner> owners=new HashSet<>();
    int maxCountPlace;
    int freePlace=maxCountPlace;
    int price;

    public Parking(String adress, int maxCountPlace, int price) {
        this.adress = adress;
        this.maxCountPlace = maxCountPlace;
        this.price = price;
    }


    public static void main(String[] args) {
        Owner owner1 = new Owner("Bill");
        owner1.myCars.add(new Car("145620"));
        owner1.myCars.add(new Car("851370"));
        owner1.zaehatInParking("145620", LocalDateTime.of(2020,11,11,16,20));
        owner1.viehatFromParking("145620", LocalDateTime.of(2020,11,11,18,20));
        owner1.zaehatInParking("851370", LocalDateTime.of(2020,10,12,8,20));
        owner1.viehatFromParking("851370", LocalDateTime.of(2020,10,12,17,20));

        Owner owner2 = new Owner("Alex");
        owner2.myCars.add(new Car("97JR14"));
        owner2.zaehatInParking("97JR14", LocalDateTime.of(2020,9,12,8,20));
        owner2.viehatFromParking("97JR14", LocalDateTime.of(2020,10,12,16,20));

        Owner owner3 = new Owner("Ron");
        owner3.myCars.add(new Car("12H560"));
        owner3.zaehatInParking("12H560", LocalDateTime.of(2020,12,27,8,20));
        owner3.viehatFromParking("12H560", LocalDateTime.of(2020,12,28,8,20));

        Owner owner4 = new Owner("Ric");
        owner4.myCars.add(new Car("12653L"));
        owner4.myCars.add(new Car("4765D6"));
        owner4.zaehatInParking("12653L", LocalDateTime.of(2020,12,1,10,20));
        owner4.viehatFromParking("12653L", LocalDateTime.of(2020,12,2,11,20));
        owner4.zaehatInParking("4765D6", LocalDateTime.of(2020,12,4,8,20));
        owner4.viehatFromParking("4765D6", LocalDateTime.of(2020,12,6,17,20));

        Owner owner5 = new Owner("Lili");
        owner5.myCars.add(new Car("7312X5"));
        owner5.zaehatInParking("7312X5", LocalDateTime.of(2020,12,3,8,20));
        owner5.viehatFromParking("7312X5", LocalDateTime.of(2020,12,5,11,20));


        Owner newOwner = new Owner("124d");
        Parking parking1 = new Parking("Street1", 20, 30);
        parking1.owners.add(owner1);
        parking1.owners.add(owner2);
        Parking parking2 = new Parking("Street2", 30, 28);
        parking2.owners.add(owner3);
        parking2.owners.add(owner4);
        parking2.owners.add(owner5);


        System.out.println(parking1.billingByOwner("Alex", LocalDateTime.of(2020,9,12,0,0),LocalDateTime.of(2020,9,13,0,0)));
        System.out.println(parking1.billingByAvto("97JR14",LocalDateTime.of(2020,9,12,0,0),LocalDateTime.of(2020,9,13,0,0)));
        System.out.println(parking1.billingByAvto("145620",LocalDateTime.of(2020,11,11,16,20),LocalDateTime.of(2020,11,11,18,20)));
    }


    long billingByOwner(String nameOwner, LocalDateTime startPeriod, LocalDateTime endPeriod){
        if (endPeriod.isBefore(startPeriod)){
            return 0;
        }
        long countHours = 0;
        for (Owner ownerTemp : owners){
            if (ownerTemp.name.equals(nameOwner)){
                for (Car carTemp : ownerTemp.myCars){
                    countHours += carTemp.countHours(startPeriod,endPeriod);
                }
            }
        }
        return countHours*price;
    }

    long billingByAvto(String numberCar, LocalDateTime startPeriod, LocalDateTime endPeriod){
        if (endPeriod.isBefore(startPeriod)){
            return 0;
        }
        long countHours = 0;
        for (Owner ownerTemp : owners){
            for (Car carTemp : ownerTemp.myCars){
                if (carTemp.number.equals(numberCar)){
                    countHours += carTemp.countHours(startPeriod, endPeriod);
                }
            }
        }
        return countHours*price;
    }
}

class Car {
    String number;
    Map<LocalDateTime, LocalDateTime> jurnal=new TreeMap<>();
    Car (String number){
        this.number = number;
    }

    long countHours (LocalDateTime startPeriod, LocalDateTime endPeriod){
        long result = 0;
        for (LocalDateTime timeTemp : jurnal.keySet()){
            if (startPeriod.isAfter(timeTemp)&&endPeriod.isBefore(jurnal.get(timeTemp))){
                continue;
            }
            LocalDateTime tempTimeStart = startPeriod.isAfter(timeTemp)?startPeriod:timeTemp;
            LocalDateTime tempTimeEnd = endPeriod.isBefore(jurnal.get(timeTemp))?endPeriod:jurnal.get(timeTemp);
            System.out.println(result += ChronoUnit.HOURS.between(tempTimeStart, tempTimeEnd));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                '}';
    }
}

class Owner {
    String name;
    Set<Car> myCars=new HashSet<Car>();
    Owner (String name){
        this.name = name;
    }

    boolean zaehatInParking(String numberAvto, LocalDateTime date){
        boolean result = false;
        for (Car temp : myCars){
            if (temp.number.equals(numberAvto)){
                temp.jurnal.put(date,null);
                result = true;
                break;
            }
        }
        return result;
    }

    boolean  viehatFromParking(String numberAvto, LocalDateTime date){
        for (Car temp : myCars){
            if (temp.number.equals(numberAvto)){
               for (LocalDateTime tempTime : temp.jurnal.keySet()) {
                   if (temp.jurnal.get(tempTime)==(null)){
                        temp.jurnal.put((tempTime),date);
                        return true;
                   }
               }
            }
        }
        return false;
    }

    boolean  viehatFromParking1(String numberAvto, LocalDateTime date){
        for (Car temp : myCars){
            if (temp.number.equals(numberAvto)){
                for ( Map.Entry<LocalDateTime, LocalDateTime> tempTime: temp.jurnal.entrySet()){
                    if (tempTime.getValue()==(null)){
//                         temp.jurnal.put(tempTime.getKey(),date);
                         tempTime.setValue(date);
                         break;
                    }
                }
            }
        }
        return false;
    }

    boolean  viehatFromParking3(String numberAvto, LocalDateTime date){
        for (Car temp : myCars){
            if (temp.number.equals(numberAvto)){
                temp.jurnal.forEach(new BiConsumer<LocalDateTime, LocalDateTime>() {
                    @Override
                    public void accept(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
                        if (localDateTime2==(null)){
                            temp.jurnal.put(localDateTime, date);
                        }
                    }
                });
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;

        Owner owner = (Owner) o;

        return name.equals(owner.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}


