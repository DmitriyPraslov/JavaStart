package RadioStation;

public class Music extends Activities{
    String artistName;
    String trackName;

    Music (String artistName, String trackName, double time){
        this.artistName = artistName;
        this.trackName = trackName;
        this.time = ((int) time * 60) + ((int) time*100)%100;
        isPaymentActivities = false;
        price = 0;
    }

    @Override
    public String toString() {
        return "Music{" +
                "artistName='" + artistName + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }
}
