package PatternMethod;

public class Car extends Transport{

    @Override
    void preparedTransport() {
        System.out.println("Disabled Break");
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
        System.out.println("Stop Car");
    }

    @Override
    void stopEngine() {
        System.out.println("Stop Engine");
    }

    @Override
    void parkTransport() {
        System.out.println("Turn-on Break");
    }
}
