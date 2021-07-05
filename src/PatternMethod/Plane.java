package PatternMethod;

public class Plane extends Transport{

    @Override
    void preparedTransport() {
        System.out.println("Disabled Trap");
    }

    @Override
    void startEngine() {
        System.out.println("Start Engine");
    }

    @Override
    void startMoving() {
        System.out.println("Plane Take Off");
    }

    @Override
    void stopTransport() {
        System.out.println("Plane landed");
    }

    @Override
    void stopEngine() {
        System.out.println("Stop Engine");
    }

    @Override
    void parkTransport() {
        System.out.println("Trap Add");
    }
}
