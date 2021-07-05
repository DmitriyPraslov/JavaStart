package PatternMethod;

public class PatternMethod {
    public static void main(String[] args) {
        final KindOfTransport kindOfTransport = KindOfTransport.CAR;
        Transport transport;

        switch (kindOfTransport){
            case CAR :
                transport = new Car();
                break;
            case LINER:
                transport = new Liner();
                break;
            case PLANE:
                transport = new Plane();
                break;
            default :
                throw new IllegalStateException();
        }
        transport.toTravel(5);
    }

    public enum KindOfTransport {
        CAR,
        LINER,
        PLANE
    }
}
