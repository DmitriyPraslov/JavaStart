package RadioStation;

public class Music extends Activities{
    String artistName;
    String trackName;

    Music (String artistName, String trackName, double time){
        this.artistName = artistName;
        this.trackName = trackName;
        this.time = time;
        isPaymentActivities = false;
        price = 0;
    }
}
