package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class RadioStation {
    String name;
    List<Translation> translationList = new LinkedList<>();

    void addTranslation(Translation newTranslation){
        translationList.add(newTranslation);
    }



    public static void main(String[] args) {

    }
}
