package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class RadioHost {
    private String name;
    private double workAge;
    private boolean isNewRadioHost;
    private List<Translation> translationList = new LinkedList<>();

    void addTranslation (Translation translation){
        translationList.add(translation);
        workAge+=translation.getTranslationTime();
    }
}
