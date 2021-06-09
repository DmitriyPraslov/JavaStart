package RadioStation;

import java.util.LinkedList;
import java.util.List;

public class RadioStation {
    private List<Translation> translationList = new LinkedList<>();
    private List<RadioHost> radioHostList = new LinkedList<>();

    void addTranslation(Translation newTranslation){
        translationList.add(newTranslation);
    }

    void startAllTranslation(){
        for (Translation temp : translationList){
            temp.startTranslation();
        }
    }

    void addRadioHost(RadioHost newRadioHost){
        radioHostList.add(newRadioHost);
    }


    public static void main(String[] args) {
        RadioStation radioStationAustralia = new RadioStation();
        RadioHost radioHost1 = new RadioHost("Alex", 4.0, true);
        RadioHost radioHost2 = new RadioHost("Bob", 10.0, false);
        radioStationAustralia.addRadioHost(radioHost1);
        radioStationAustralia.addRadioHost(radioHost2);
        Translation translation1 = new Translation("translation1",2.00,radioHost1);
        Music track1 = new Music("AC/DC","Highway to Hell",04.21);
        Music track2 = new Music("Depeche Mode","Wrong",03.13);
        Music track3 = new Music("Disturbed","The Sound of Silence",04.08);
        Reclame reclame1 = new Reclame("Feta Cheese",5,10);
        Reclame reclame2 = new Reclame("Lecho",25,20);
        Interview interview1 = new Interview("Anton Ptushkin",30,10);
        System.out.println(translation1.addActivities(track1));
        System.out.println(translation1.addActivities(track2));
        System.out.println(translation1.addActivities(track3));
        System.out.println(translation1.addActivities(reclame1));
        System.out.println(translation1.addActivities(interview1));
        System.out.println(translation1.addActivities(reclame2));
        System.out.println("------------------------------------------------------");
        Translation translation2 = new Translation("translation2",1.40, radioHost2);
        Music track4 = new Music("Metallica","Orion",8.27);
        Music track5 = new Music("LP","Other People",4.04);
        Music track6 = new Music("Queen","Don't Stop Me Now",3.29);
        Music track7 = new Music("Scorpions","Lorelei",5.44);
        Interview interview2 = new Interview("Denis Villeneuve",30,100);
        System.out.println(translation2.addActivities(track4));
        System.out.println(translation2.addActivities(track5));
        System.out.println(translation2.addActivities(track6));
        System.out.println(translation2.addActivities(track7));
        System.out.println(translation2.addActivities(interview2));
        System.out.println("------------------------------------------------------");
        radioStationAustralia.addTranslation(translation1);
        translation1.showProfit();
        translation1.startTranslation();
        System.out.println(radioHost1.getWorkAgeHour());
    }
}
