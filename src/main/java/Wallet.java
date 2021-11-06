public class Wallet {
    private final double DOLLARTORUPEES = 74.85;

    public double rupeesToDollars(double rupees) {
        return rupees / DOLLARTORUPEES;
    }
}
