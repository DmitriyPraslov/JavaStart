package PatternMethod;

public abstract class Transport {
    abstract void preparedTransport();
    abstract void startEngine();
    abstract void startMoving();
    abstract void stopTransport();
    abstract void stopEngine();
    abstract void parkTransport();

    public final void toTravel(int countOfPassenger){
        addPassengerAboard(countOfPassenger);
        preparedTransport();
        startEngine();
        startMoving();
        stopTransport();
        stopEngine();
        parkTransport();
        letGoPassenger(countOfPassenger);
    }

    public void addPassengerAboard(int countOfPassenger){
        System.out.println("Passenger Came In...");
    }
    public void letGoPassenger(int countOfPassenger){
        System.out.println("Passenger Left Transport...");
    }
}
