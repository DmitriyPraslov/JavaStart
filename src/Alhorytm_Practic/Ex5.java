package Alhorytm_Practic;

import java.util.ArrayList;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        Range r1 = new Range(1,6);
        Range r2 = new Range(4,11);
        Range r3 = new Range(6,15);
        System.out.println(r1.findCross(r1,r2,r3));
    }
}

class Range{
    List<Integer> list = new ArrayList<>();
    Range (int startRange, int endRange){
        for (int i=startRange;i<=endRange;i++){
            list.add(i);
        }
    }
    List<Integer> findCross(Range...rangesList){
        List<Integer> result = new ArrayList<>();
        boolean trigger;
        for (Integer temp : rangesList[0].list) {
            trigger = true;
            for (int i = 1; i<rangesList.length; i++) {
                if (findCommonElement(temp,rangesList[i])){
                    trigger = true;
                } else {
                    trigger = false;
                    break;
                }
            }
            if (trigger){
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Range{" +
                "list=" + list +
                '}';
    }

    boolean findCommonElement(Integer element, Range r2){
        boolean result = false;
        if (r2.list.contains(element)){
            result = true;
        }
        return result;
    }
}
