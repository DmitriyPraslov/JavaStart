package PatternMethod;

public class Liner extends Transport{

    @Override
    void preparedTransport() {
        System.out.println("Raise Anchor");
    }

    @Override
    void startEngine() {
        System.out.println("Start Engine");
    }

    @Override
    void startMoving() {
        System.out.println("Start Moving");
    }

    @Override
    void stopTransport() {
        System.out.println("Stop Liner");
    }

    @Override
    void stopEngine() {
        System.out.println("Stop Engine");
    }

    @Override
    void parkTransport() {
        System.out.println("Put Down Anchor");
    }
}
