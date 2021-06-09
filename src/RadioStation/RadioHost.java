package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class RadioHost {
    private String name;
    private double workAgeHour;
    private boolean isInvitedRadioHost;
    private List<Translation> translationList = new LinkedList<>();

    RadioHost (String name, double workAge, boolean isInvitedRadioHost){
        this.name = name;
        this.workAgeHour = workAge;
        this.isInvitedRadioHost = isInvitedRadioHost;
    }

    void addTranslation (Translation translation){
        translationList.add(translation);
        workAgeHour+=(translation.getTranslationTime()/60)/60;
    }

    double getWorkAgeHour (){
        return workAgeHour;
    }

    @Override
    public String toString() {
        return "RadioHost{" +
                "name='" + name + '\'' +
                ", workAgeHour=" + workAgeHour +
                ", isInvitedRadioHost=" + isInvitedRadioHost +
                ", translationList=" + translationList +
                '}';
    }
}
