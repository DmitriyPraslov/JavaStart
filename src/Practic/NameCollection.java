package Practic;

import java.util.ArrayList;

public class NameCollection {
    public static void main(String[] args) {
        ArrayList<String> nameCollection = new ArrayList<>();
        nameCollection.add("Bob");
        nameCollection.add("Stiv");
        nameCollection.add("Ris");
        nameCollection.add("John");
        nameCollection.add("Bob");
        nameCollection.add("Bob");
        System.out.println(findNameCoincidence(nameCollection, "Bob"));
    }

    public static int findNameCoincidence (ArrayList<String> nameCol, String name){
        int result = 0;
        for (String temp : nameCol){
            if (temp==name){
                result++;
            }
        }
        return result;
    }
}
