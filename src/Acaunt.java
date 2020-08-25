public class Acaunt {
    String number;
    int suldo;

    private Acaunt(String number, int suldo) {
        this.number = number;
        this.suldo = suldo;
    }
    public static Acaunt createDepositAcaunt(int suldo){
        Acaunt result = new Acaunt("2933", suldo);
        return result;
    }
}
